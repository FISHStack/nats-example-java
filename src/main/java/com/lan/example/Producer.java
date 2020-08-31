package com.lan.example;

import io.nats.client.Connection;
import io.nats.client.Nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Classname Producer
 * @Description TODO
 * @Date 2020/8/31 13:35
 */
public class Producer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection nc = Nats.connect("nats://192.168.3.123:4222");
        nc.publish("subject", "hello world".getBytes(StandardCharsets.UTF_8));
        nc.close();
    }
}
