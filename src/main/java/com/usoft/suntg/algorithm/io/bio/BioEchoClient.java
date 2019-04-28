package com.usoft.suntg.algorithm.io.bio;

import com.usoft.suntg.algorithm.io.utils.InputUtil;
import com.usoft.suntg.algorithm.io.utils.ServerInfo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ConcaSun on 2019/4/28.
 */
public class BioEchoClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(ServerInfo.HOST_NAME, ServerInfo.HOST_PORT);
        Scanner scanner = new Scanner(client.getInputStream());
        scanner.useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            String inputString = InputUtil.getString("请输入要发送的内容").trim();
            // 将数据发送到服务端上
            out.println(inputString);
            // 通过scanner接收服务端返回的内容
            if (scanner.hasNext()) {
                String responseString = scanner.next().trim();
                System.out.println(responseString);
            }
            if ("byebye".equalsIgnoreCase(inputString)) {
                flag = false;
            }
        }

        scanner.close();
        out.close();
        client.close();
    }

}
