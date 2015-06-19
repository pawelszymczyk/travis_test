package pl.pawel;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class Main {

    static Undertow server;

    public static void main(String... args) {
        server = Undertow.builder()
                .addHttpListener(8080, "localhost", new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.getRequestHeaders().add(new HttpString("test_port"), 8080);
                        System.err.println("HELLLO WORLD from 8080!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                })
                .addHttpListener(14192, "localhost", new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.getRequestHeaders().add(new HttpString("test_port"), 14192);
                        System.err.println("HELLLO WORLD from 14192!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                })
                .build();
        server.start();

//        server = Undertow.builder()
//                .addHttpListener(8080, "localhost")
//                .setHandler(new HttpHandler() {
//                    @Override
//                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
//                        System.err.println("HELLLO WORLD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    }
//                }).build();
//        server.start();
    }

    public static void close() {
        server.stop();
    }
}
