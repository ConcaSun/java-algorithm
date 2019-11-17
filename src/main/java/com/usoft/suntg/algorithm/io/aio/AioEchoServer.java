package com.usoft.suntg.algorithm.io.aio;

import java.io.IOException;

/**
 * Created by ConcaSun on 2019/5/1.
 */
public class AioEchoServer {

    public static void main(String[] args) throws IOException {
        new Thread(new AioServerThread()).start();
    }

}
