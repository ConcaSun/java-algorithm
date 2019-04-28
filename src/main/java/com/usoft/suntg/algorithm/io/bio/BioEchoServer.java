package com.usoft.suntg.algorithm.io.bio;

import com.usoft.suntg.algorithm.io.utils.ServerInfo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ConcaSun on 2019/4/28.
 */
public class BioEchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ServerInfo.HOST_PORT);
        System.out.println("服务端启动成功，监听端口：" + ServerInfo.HOST_PORT);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        boolean flag = true;
        while (flag) {
            Socket client = serverSocket.accept();
            executorService.submit(new EchoClientHandler(client));
        }
        executorService.shutdown();
        serverSocket.close();
    }

    private static class EchoClientHandler implements Runnable {

        private Socket client;
        private Scanner scanner;
        private PrintStream printStream;
        private boolean flag = true;


        public EchoClientHandler(Socket client) {
            this.client = client;
            try {
                this.scanner = new Scanner(client.getInputStream());
                scanner.useDelimiter("\n");
                this.printStream = new PrintStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (this.flag) {
                if (scanner.hasNext()) {
                    String inputString = scanner.next().trim();
                    System.out.println("服务端接收的值：" + inputString);
                    if ("byebye".equalsIgnoreCase(inputString)) {
                        this.printStream.println("再见...");
                        this.flag = false;
                    } else {
                        printStream.println("[EchoServer] " + inputString);
                    }
                }
            }
            scanner.close();
            printStream.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
