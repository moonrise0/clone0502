package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxImplController {

    @Autowired
    MarkerService markerService;
    @Autowired
    CustService custService;

    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        return date;
    }
    @RequestMapping("/checkid")
    public Object checkid(String id) throws Exception{
        int result = 0;
        Cust cust = null;
        cust = custService.get(id);

        if(cust != null) {
            result=1;
        }

        return result;
    }
    @RequestMapping("/getdata")
    public Object getdata() {

        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pwd01", "james1"));
        list.add(new Cust("id02", "pwd02", "james2"));
        list.add(new Cust("id03", "pwd03", "james3"));
        list.add(new Cust("id04", "pwd04", "james4"));
        list.add(new Cust("id05", "pwd05", "james5"));

        JSONArray ja = new JSONArray();
        JSONObject jo = new JSONObject();

        for(Cust obj:list) {
            Random r = new Random();
            int i = r.nextInt(100)+1;
            jo.put("id",obj.getId());
            jo.put("pwd",obj.getPwd());
            jo.put("name",obj.getName()+i);
            ja.add(jo);
        }

        return ja;
    }

    @RequestMapping("/markers")
    public Object markers(String loc) throws Exception {
        List<Marker> list;
        try {
            list = markerService.getLoc(loc);
        } catch (Exception e) {
            throw new Exception("시스템오류 ER 머시기");
        }

        JSONArray ja = new JSONArray();
        for(Marker obj:list){
            JSONObject jo = new JSONObject();
            jo.put("id", obj.getId());
            jo.put("title", obj.getTitle());
            jo.put("target", obj.getTarget());
            jo.put("lat", obj.getLat());
            jo.put("lng", obj.getLng());
            jo.put("img", obj.getImg());
            jo.put("loc", obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }
    @RequestMapping("/chart05")
    public Object chart05(String year) {
        JSONArray ja = new JSONArray();
        for(int i=1;i<=12;i++) {
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja.add(num);
        }
        return ja;
    }
}