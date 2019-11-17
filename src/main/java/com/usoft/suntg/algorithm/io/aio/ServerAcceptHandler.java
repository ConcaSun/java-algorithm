package com.usoft.suntg.algorithm.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by ConcaSun on 2019/5/1.
 */
public class ServerAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AioServerThread> {
    @Override
    public void completed(AsynchronousSocketChannel channel, AioServerThread aioServerThread) {
        aioServerThread.getServerSocketChannel().accept(aioServerThread, this);
        ByteBuffer buffer = ByteBuffer.allocate(50);
        channel.read(buffer, buffer, new ServerWriteHandler(channel));

    }

    @Override
    public void failed(Throwable exc, AioServerThread aioServerThread) {
        System.out.println("服务端与客户端连接失败。。。");
        aioServerThread.getLatch().countDown();
    }
}
