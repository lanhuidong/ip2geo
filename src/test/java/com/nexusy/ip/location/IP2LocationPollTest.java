package com.nexusy.ip.location;

import com.nexusy.ip.location.impl.IP2LocationPoll;
import com.nexusy.ip.location.impl.IP2LocationTB;
import com.nexusy.ip.location.impl.IP2LocationXL;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lan
 * @since 2014-11-15
 */
public class IP2LocationPollTest {

    private IP2Location ip2Location;

    @Before
    public void setup() {
        ip2Location = new IP2LocationPoll();
        ip2Location.addIP2Location(new IP2LocationXL());
        ip2Location.addIP2Location(new IP2LocationTB());
    }

    @Test
    public void test() {
        String result = ip2Location.ip2Location("23.59.157.15");
        System.out.println(result);
        result = ip2Location.ip2Location("42.121.57.127");
        System.out.println(result);
    }
}
