package com.nexusy.ip.location.impl;

import com.google.gson.Gson;
import com.nexusy.ip.location.IP2Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * @author lan
 * @since 2014-11-15
 */
public class IP2LocationBD implements IP2Location {

    private String ak = "kyL9Mp2jKvTBxFWENHq6fp78";

    public void setAk(String ak) {
        this.ak = ak;
    }

    @Override
    public String ip2Location(String ip) {
        String result = "";
        try {
            URLConnection connection = new URL("http://api.map.baidu.com/location/ip?ak=" + ak + "&coor=bd09ll&ip=" + ip).openConnection();
            connection.getInputStream();
            connection.setConnectTimeout(5000);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String s;
                while ((s = br.readLine()) != null) {
                    result += s;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        BDResponse response = gson.fromJson(result, BDResponse.class);
        String location = "";
        if ("0".equals(response.status)) {
            location = response.content.address;
        }
        return location;
    }

    @Override
    public void addIP2Location(IP2Location ip2Location) {
        throw new UnsupportedOperationException();
    }

    private class BDResponse {
        public String address;
        public String status;
        public Content content;

        public class Content {
            public String address;
            public Map<String, String> address_detail;
        }
    }

}
