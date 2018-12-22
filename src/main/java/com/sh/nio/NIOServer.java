package com.sh.nio;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NIOServer extends Thread {
    @Override
    public void run() {
        try {
            try(Selector selector = Selector.open();
                ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
                serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
                serverSocket.configureBlocking(false);
                serverSocket.register(selector, SelectionKey.OP_ACCEPT);
                while (true) {
                    // 阻塞等待就绪的Channel
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        sayHelloWord((ServerSocketChannel) key.channel());
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWord(ServerSocketChannel serverSocketChannel) throws IOException {
        try(SocketChannel client = serverSocketChannel.accept()) {
            client.write(Charset.defaultCharset().encode(new String("Hello world".getBytes(), "UTF-8")));
        }
    }

    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.start();
        try (SocketChannel client = SocketChannel.open(new InetSocketAddress(InetAddress.getLocalHost(), 8888))) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len;
            while ((len = client.read(buffer)) > 0) {
                System.out.println(new String(buffer.array(), 0, len));
            }
        }
    }
}
