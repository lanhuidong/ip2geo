package com.nexusy.ip.location.impl;

import com.nexusy.ip.location.IP2Location;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lan
 * @since 2014-11-15
 */
public class IP2LocationPoll implements IP2Location {

    private List<IP2Location> list = new ArrayList<>();

    private int index = 0;

    @Override
    public String ip2Location(String ip) {
        String location = list.get(index).ip2Location(ip);
        index++;
        return location;
    }

    public void addIP2Location(IP2Location ip2Location) {
        if (ip2Location instanceof IP2LocationPoll) {
            throw new IllegalArgumentException();
        } else {
            list.add(ip2Location);
        }
    }
}
