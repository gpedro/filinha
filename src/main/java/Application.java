import java.nio.file.Paths;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		// The port that we should run on can be set into an environment
		// variable
		// Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}

		System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
		Server server = new Server(Integer.valueOf(webPort));

		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/");
		webapp.setWar("./target/tilinha-0.0.1.war");
		
		
		server.setHandler(webapp);
		server.join();
	}
}
