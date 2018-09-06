package com.sh.vertx.client;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class TCPClient {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        NetClient tcpClient = vertx.createNetClient();
        tcpClient.connect(8888, "127.0.0.1", result -> {
            if (result.succeeded()) {
                NetSocket socket = result.result();
                socket.write("hello word");
//                socket.close();
            } else {
                System.out.println(result.cause().getMessage());
            }
        });
    }
}
