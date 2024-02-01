import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

class RequestHandler implements HttpHandler {
    int seriesOfeOf;

    RequestHandler (int seriesOfeOf) {
        this.seriesOfeOf = seriesOfeOf;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        StringBuilder response = new StringBuilder();

        LucasSeries series = new LucasSeries(this.seriesOfeOf);
        series.calculateLucasSeries();
        response.append("seriesOf=");
        response.append(series.getSize());
        response.append(",result=");
        response.append(series.getResult());

        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
    }
}
