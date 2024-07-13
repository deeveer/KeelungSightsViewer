package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class KeelungSightsCrawler {
    public Sight[] getItems(String Str) throws IOException {
        ArrayList<Sight> sights = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").userAgent("Mozilla").get();
        Element part = doc.getElementById("guide-point");
        assert part != null;
        Elements districts = part.getElementsByTag("h4");
        for(Element district : districts){
//            System.out.println(district.text());
            if(district.text().contains(Str)){
                Elements points = Objects.requireNonNull(district.nextElementSibling()).select("li a");
                for(Element point : points){
                    String realUrl = "https://www.travelking.com.tw" + point.attr("href");
                    sights.add(RealSight(realUrl));
                }
            }
        }
        return sights.toArray(new Sight[0]);
    }
    public Sight RealSight(String realUrl) throws IOException {
        Sight sight = new Sight();
        Document doc = Jsoup.connect(realUrl).userAgent("Mozilla").get();
        Element part = doc.getElementById("point_area");
        assert part != null;
        sight.setSightName(part.select("meta[itemprop=name]").attr("content"));
        sight.setZone(doc.selectXpath("//*[@id=\"content\"]/div/ol/li[5]/a").text());
        sight.setAddress(part.select("meta[itemprop=address]").attr("content"));
        sight.setPhotoURL(part.select("meta[itemprop=image]").attr("content"));
        sight.setCategory(doc.select("cite .point_type strong").text());
        sight.setDescription(doc.select("[itemprop=description]").attr("content"));
        return sight;
    }
}
