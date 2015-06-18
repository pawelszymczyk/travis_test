package pl.pawel;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class Main {

    private static Undertow server;

    public static void main(String... args) {
        server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        System.out.println("HELLO WORLD!!!");
                    }
                }).build();
        server.start();
    }

    public static void stop() {
        server.stop();
    }
}
