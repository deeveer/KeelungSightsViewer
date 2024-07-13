package com.example.demo;

import java.io.IOException;

public class KeelungSightsCrawlerTest {
    public static void main(String[] args) throws IOException {
//        System.out.println("hello world");
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight [] sights = crawler.getItems("七堵");
        for (Sight s: sights) {
            System.out.println(s);
        }
    }
}
