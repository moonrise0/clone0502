package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ChartImplController {
    @RequestMapping("/chart02")
    public Object chart02() {
        JSONObject jo = new JSONObject();

        JSONArray jaCnt = new JSONArray();
        for (int i = 0; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt(1000) + 1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for (int i = 2011; i <= 2023; i++) {
            jaYear.add(i);
        }

        jo.put("category", jaYear);
        jo.put("datas", jaCnt);

        //{ category:[], datas:[] }
        return jo;
    }

    ;

    @RequestMapping("/chart0301")
    public Object chart0301() {
        JSONArray ja2 = new JSONArray();
        for (int i = 0; i < 5; i++) {
            JSONArray ja1 = new JSONArray();
            String[] a = {"Korea", "USA", "German", "Italy", "Russia"};
            Random r = new Random();
            int num = r.nextInt(20) + 1;
            ja1.add(a[i]+" : "+num);
            ja1.add(num);
            ja2.add(ja1);
        }
        ;
        return ja2;
    }

    ;

    @RequestMapping("/chart0302")
    public Object chart0302() {
        JSONArray ja = new JSONArray();
        for (int i = 0; i < 17; i++) {
            Random r = new Random();
            double num = r.nextInt(1000) * 0.01;
            ja.add(num);
        }
        return ja;
    }

    ;

    @RequestMapping("/chart0303")
    public Object chart0303() {
        JSONArray ja = new JSONArray();
        String[] a = {"Chrome", "Edge", "Firefox", "Safari", "Internet Explorer", "Other"};
        for (int i = 0; i <= 5; i++) {
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int num = r.nextInt(10);
            jo.put("name", a[i]);
            jo.put("y", num);
            ja.add(jo);
        }
        return ja;
    };
}