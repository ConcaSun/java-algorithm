package com.usoft.suntg.algorithm.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by ConcaSun on 2019/5/1.
 */
public class ServerWriteHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel clientChannel;
    private boolean exit = false;

    public ServerWriteHandler(AsynchronousSocketChannel channel) {
        this.clientChannel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        buffer.flip();
        String readMessage = new String(buffer.array(), 0, buffer.remaining()).trim();
        System.out.println("服务端接收到信息：" + readMessage);
        String writeMessage = "[Aio Echo] " + readMessage + "\n";
        if ("exit".equalsIgnoreCase(readMessage)) {
            writeMessage = "[Aio Echo Exit] Bye Bye!";
            this.exit = true;
        }
        this.writeMessage(writeMessage);
    }

    private void writeMessage(String writeMessage) {
        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.put(writeMessage.getBytes());
        buffer.flip();
        this.clientChannel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()) {
                    ServerWriteHandler.this.clientChannel.write(attachment, attachment, this);
                } else {
                    // 不退出，需要继续交互
                    if (ServerWriteHandler.this.exit == false) {
                        ByteBuffer readBuffer = ByteBuffer.allocate(50);
                        ServerWriteHandler.this.clientChannel.read(readBuffer, readBuffer, new ServerWriteHandler(ServerWriteHandler.this.clientChannel));
                    }
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    ServerWriteHandler.this.clientChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        try {
            this.clientChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
