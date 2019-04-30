package com.usoft.suntg.algorithm.io.nio;

import com.usoft.suntg.algorithm.io.utils.ServerInfo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ConcaSun on 2019/4/30.
 */
public class NioEchoServer {

    public static void main(String[] args) throws IOException {
        // 开启serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置非阻塞
        serverSocketChannel.configureBlocking(false);
        // 绑定网络监听地址
        serverSocketChannel.bind(new InetSocketAddress(ServerInfo.HOST_PORT));

        // 开启一个selector
        Selector selector = Selector.open();
        // 将channel 注册到selector中
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("NioEchoServer started, listening post: " + ServerInfo.HOST_PORT);

        // 创建线程池，负责处理接收的请求
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int selectKey = 0;
        while ((selectKey = selector.select()) > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeyIterator.next();
                selectionKeyIterator.remove();
                // 如果是连接模式
                if (selectionKey.isAcceptable()) {
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    if (clientChannel != null) {
                        executorService.submit(new ClientChannelHandler(clientChannel));
                    }
                }

            }
        }
        executorService.shutdown();
        serverSocketChannel.close();
    }

    private static class ClientChannelHandler implements Runnable {

        private SocketChannel clientChannel;

        public ClientChannelHandler(SocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(50);
            boolean flag = true;
            while (flag) {
                try {
                    buffer.clear();
                    int readCount = clientChannel.read(buffer);
                    String readMessage = new String(buffer.array(), 0, readCount).trim();
                    String writeMessage = "[NioEcho] " + readMessage + "\n";
                    if ("byebye".equalsIgnoreCase(readMessage)) {
                        writeMessage = "[NioEcho Exit] Bye Bye!";
                        flag = false;
                    }
                    buffer.clear();
                    buffer.put(writeMessage.getBytes());
                    buffer.flip();
                    this.clientChannel.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                this.clientChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
