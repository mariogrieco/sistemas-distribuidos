import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LoadBalancer {
    private int initialPort;
    private int seriesToMemoize;
    private int numberOfServers;

    public List<LucasHTTPServer> servers = new ArrayList<>();

    LoadBalancer (int numberOfServers, int seriesToMemoize, int initialPort) {
        this.initialPort = initialPort;
        this.numberOfServers = numberOfServers;
        this.seriesToMemoize = seriesToMemoize;
    }

    void distribute () {
        // TODO on error go to closets available slot.
        // TODO A WAY TO DISTRIBUTE COMPUTED VALUE INTO X SERVERS.
        for (int machines = 0; machines <= this.numberOfServers; machines++) {
            this.servers.add(new LucasHTTPServer(this.seriesToMemoize-machines, this.initialPort+machines));
        }
    }

    void execute () {
        // TODO INIT START SERVERS AND COMPUTE VALUE.
        int errServerDownCcahe;

        this.servers.forEach((LucasHTTPServer server) -> {
            try {
                server.createServer();
                System.out.printf("Server running on port: %d %n", server.getPort());
            } catch (Exception e) {
                System.out.printf("Server down for: %d %n", server.getSeriesOf());
                System.out.println(e.toString());
            }
        });

    }
}
