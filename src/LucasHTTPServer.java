import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class LucasHTTPServer {
    public final int seriesOf;
    public final int port;


    LucasHTTPServer (int seriesOf, int port) {
        this.seriesOf = seriesOf;
        this.port = port;
    }

    public int getPort () {
        return this.port;
    }

    public int getSeriesOf () {
        return seriesOf;
    }

    public void createServer () throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
        server.createContext("/", new RequestHandler(this.seriesOf));
        server.setExecutor(null);
        server.start();
    }
}
