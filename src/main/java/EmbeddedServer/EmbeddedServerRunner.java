package EmbeddedServer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class EmbeddedServerRunner {
    private int port;
    private String rootPath = "/*";
    private String packagePath = "resource";

    public EmbeddedServerRunner(int portNum) {
        port = portNum;
    }

    public void run() {
        ResourceConfig config = new ResourceConfig();
        config.register(org.glassfish.jersey.jackson.JacksonFeature.class);
        config.packages(packagePath);
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(server, rootPath);
        context.addServlet(servlet, rootPath);

        try {
            server.start();
            server.dumpStdErr();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
