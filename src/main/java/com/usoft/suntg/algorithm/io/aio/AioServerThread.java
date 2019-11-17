package com.usoft.suntg.algorithm.io.aio;

import com.usoft.suntg.algorithm.io.utils.ServerInfo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ConcaSun on 2019/5/1.
 */
public class AioServerThread implements Runnable {

    private AsynchronousServerSocketChannel serverSocketChannel;
    private CountDownLatch latch;

    public AioServerThread() throws IOException {
        this.serverSocketChannel = AsynchronousServerSocketChannel.open();
        this.serverSocketChannel.bind(new InetSocketAddress(ServerInfo.HOST_PORT));
        latch = new CountDownLatch(1);
        System.out.println("AIO Server started, listening port: " + ServerInfo.HOST_PORT);
    }

    public AsynchronousServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    @Override
    public void run() {
        this.serverSocketChannel.accept(this, new ServerAcceptHandler());
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
