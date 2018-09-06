package com.sh.vertx.client;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;

public class WebSocketClient {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpClient httpClient = vertx.createHttpClient();
        httpClient.websocket(8080, "127.0.0.1", "/myapp", webocket -> {
           webocket.handler(data -> {
               System.out.println("receive data " + data.toString("UTF-8"));
           });
           webocket.writeBinaryMessage(Buffer.buffer("Hello Word"));
        });
    }
}
