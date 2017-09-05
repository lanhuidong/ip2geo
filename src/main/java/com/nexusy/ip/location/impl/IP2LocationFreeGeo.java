package com.nexusy.ip.location.impl;

import com.google.gson.Gson;
import com.nexusy.ip.location.IP2Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author lanhuidong
 * @since 2017-09-05
 */
public class IP2LocationFreeGeo implements IP2Location {

    @Override
    public String ip2Location(String ip) {
        String result = "";
        try {
            URLConnection connection = new URL("http://freegeoip.net/json/" + ip).openConnection();
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
        FreeGeoResponse response = gson.fromJson(result, FreeGeoResponse.class);
        return response.country_name + " " + response.region_name + " " + response.city;
    }

    @Override
    public void addIP2Location(IP2Location ip2Location) {
        throw new UnsupportedOperationException();
    }

    private class FreeGeoResponse {
        public String country_name;
        public String region_name;
        public String city;
    }

}
