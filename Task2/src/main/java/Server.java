import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class Server {
    public static void main(final String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8000, "localhost")
                .setHandler(new HttpHandler() {
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        exchange.getResponseSender().send("Krasavin Igor");
                    }
                }).build();
        server.start();
    }
}
