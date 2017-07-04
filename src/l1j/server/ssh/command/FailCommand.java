package l1j.server.ssh.command;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;

public class FailCommand implements Command, Runnable  {
	private static Logger _log = Logger.getLogger(FailCommand.class.getName());
	private Thread thread;
	private OutputStream outputStream;
	private ExitCallback exitCallback;
	private Environment environment;
	private String command;
	
	public FailCommand(String command) {
		this.command = command;
	}
	
	@Override
	public void destroy() throws Exception { }

	@Override
	public void start(Environment environment) throws IOException {
		this.environment = environment;
		thread = new Thread(this, "FailCommand");
		thread.start();
	}

	@Override
	public void run() {
		try {
			String user = this.environment.getEnv().get(Environment.ENV_USER);
			_log.log(Level.INFO, user + " ran an unknown command: " + command);
			
			final PrintWriter writer = new PrintWriter(this.outputStream, true);
			writer.println("Unknown command");
			writer.flush();
	      } catch (Exception e) {
	          e.printStackTrace();
	      } finally {
	          this.exitCallback.onExit(0);
	      }
	}

	@Override
	public void setErrorStream(OutputStream outputStream) { }

	@Override
	public void setExitCallback(ExitCallback exitCallback) { 
		this.exitCallback = exitCallback;
	}

	@Override
	public void setInputStream(InputStream inputStream) { }

	@Override
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

}
