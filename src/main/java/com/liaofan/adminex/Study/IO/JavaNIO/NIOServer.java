package com.liaofan.adminex.Study.IO.JavaNIO;

import java.nio.channels.Selector;

public class NIOServer {
    private final int port;
    private Selector selector;

    private NIOServer(int port) {
        this.port = port;
    }

    // 初始化
    private void init() throws Exception {
        selector = Selector.open();
    }


}


