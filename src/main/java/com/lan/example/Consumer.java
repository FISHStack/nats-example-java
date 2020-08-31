package com.lan.example;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Subscription;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * @Classname Consumer
 * @Description TODO
 * @Date 2020/8/31 13:35
 */
public class Consumer {
    public static void main(String[] args) throws IOException, InterruptedException {

        Connection nc = Nats.connect("nats://192.168.3.123:4222");
//        nc.publish("subject", "hello world".getBytes(StandardCharsets.UTF_8));

        System.out.println("begin listener message");
        Subscription sub = nc.subscribe("subject");
        Message msg = sub.nextMessage(Duration.ofMillis(50000));

        if(msg!=null) {
            String response = new String(msg.getData(), StandardCharsets.UTF_8);
            System.out.println("response:" + response);
        }
        nc.close();
    }
}
