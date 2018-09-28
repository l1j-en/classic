package l1j.server.ssh;

import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sshd.common.config.keys.AuthorizedKeyEntry;
import org.apache.sshd.common.config.keys.KeyUtils;
import org.apache.sshd.common.config.keys.PublicKeyEntryResolver;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import l1j.server.Config;
import l1j.server.ssh.command.SSHCommandFactory;


public class SSHServer {
	private static SSHServer _instance;
	private static Logger _log = LoggerFactory.getLogger(SSHServer.class.getName());
	
	private class ServerThread extends Thread {
		@Override
		public void run() {
			SshServer sshd = SshServer.setUpDefaultServer();
			
		    sshd.setPort(Config.SSH_PORT);
		    SimpleGeneratorHostKeyProvider hostKeyGenerator
		    	= new SimpleGeneratorHostKeyProvider(new File(Config.SSH_HOST_KEY));
		    hostKeyGenerator.setAlgorithm(KeyUtils.RSA_ALGORITHM);
		    sshd.setKeyPairProvider(hostKeyGenerator);
		    
		    Map<String, List<PublicKey>> userKeysMap = new HashMap<>();
		    
		    List<String> users = Arrays.asList(Config.SSH_ALLOWED_USERNAMES);
		    
		    // map all keys saved in the keys directory as valid keys
		    for(String user : users){
		        List<PublicKey> usersKeys = new ArrayList<>();
		        try {
					for(AuthorizedKeyEntry ake : 
						AuthorizedKeyEntry.readAuthorizedKeys(new File(Config.SSH_KEY_FILES_DIRECTORY + user))){
					    PublicKey publicKey = ake.resolvePublicKey(PublicKeyEntryResolver.IGNORING);
					    
					    if(publicKey != null){
					        usersKeys.add(publicKey);
					    }
					}
				} catch (Exception e) {
					_log.error(e.getLocalizedMessage());
				} 
		        
		        userKeysMap.put(user, usersKeys);
		    }
		    
		    sshd.setPublickeyAuthenticator(new UserKeySetPublickeyAuthenticator(userKeysMap));
		    sshd.setCommandFactory(new SSHCommandFactory());

		    try {
				sshd.start();
			} catch (Exception e) {
				_log.error(e.getLocalizedMessage());
			}
		}
	}
	
	private SSHServer() {
	}

	public void start() {
		new ServerThread().start();
	}

	public static SSHServer getInstance() {
		if (_instance == null) {
			_instance = new SSHServer();
		}
		return _instance;
	}
}
