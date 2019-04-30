package com.usoft.suntg.algorithm.io.nio;

import com.usoft.suntg.algorithm.io.utils.InputUtil;
import com.usoft.suntg.algorithm.io.utils.ServerInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by ConcaSun on 2019/4/30.
 */
public class NioEchoClient {

    public static void main(String[] args) throws IOException {
        SocketChannel clientChannel = SocketChannel.open();
        clientChannel.connect(new InetSocketAddress(ServerInfo.HOST_NAME, ServerInfo.HOST_PORT));

        ByteBuffer buffer = ByteBuffer.allocate(50);
        boolean flag = true;
        while (flag) {
            buffer.clear();
            String inputData = InputUtil.getString("请输入要发送的信息：");
            buffer.put(inputData.getBytes());
            buffer.flip();
            clientChannel.write(buffer);
            buffer.clear();
            int readCount = clientChannel.read(buffer);
            buffer.flip();
            String readMessage = new String(buffer.array(), 0, readCount);
            System.out.println(readMessage);
            if ("byebye".equalsIgnoreCase(inputData)) {
                flag = false;
            }
        }
        clientChannel.close();
    }

}
