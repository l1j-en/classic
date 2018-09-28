package l1j.server.ssh.command;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSHCommand implements Command, Runnable {
	  private OutputStream outputStream;
	  private OutputStream errorStream;
	  private ExitCallback exitCallback;
	  private Environment environment;
	  private Thread thread;
	  private Commands command;
	  private String args;
	  private static Logger _log = LoggerFactory.getLogger(SSHCommand.class.getName());

	  public SSHCommand(Commands command, String args)
	  {
		  this.command = command;
		  this.args = args;
	  }

	  public void setInputStream(final InputStream inputStream) { }

	  public void setOutputStream(final OutputStream outputStream)
	  {
	    this.outputStream = outputStream;
	  }
	  
	  public Environment getEnvironment() {
	      return environment;
	  }

	  public void setErrorStream(OutputStream errorStream)
	  {
	    this.errorStream = errorStream;
	  }
	  
	  public OutputStream getErrorStream()
	  {
	    return this.errorStream;
	  }

	  public void setExitCallback(ExitCallback exitCallback)
	  {
	    this.exitCallback = exitCallback;
	  }

	  public void start(Environment environment) throws IOException
	  {
	    try
	    {
	      this.environment = environment;
	      thread = new Thread(this, command.getClass().getName());
	      thread.start();
	    }
	    catch (final Exception e)
	    {
	      _log.error("",e);
	    }
	  }
	  
	  public void run() {
		try {
			String user = this.environment.getEnv().get(Environment.ENV_USER);
			_log.info(user + " ran command " + this.command.formatMessage(this.args));
			
			final PrintWriter writer = new PrintWriter(this.outputStream, true);
			writer.println(this.command.execute(this.args));
			writer.flush();
		} catch (Exception e) {
			_log.error("",e);
		} finally {
			this.exitCallback.onExit(0);
		}
	  }

	  public void destroy()
	  {
	    thread.interrupt();
	    // client or server closed connection, clean up resources here
	  }
}
