package com.nexusy.ip.location;

import com.nexusy.ip.location.impl.IP2LocationFreeGeo;
import com.nexusy.ip.location.impl.IP2LocationXL;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lanhuidong
 * @since 2017-09-05
 */
public class IP2LocationFreeGeoTest {

    private IP2Location ip2Location;

    @Before
    public void setup() {
        ip2Location = new IP2LocationFreeGeo();
    }

    @Test
    public void test() {
        String result = ip2Location.ip2Location("23.59.157.15");
        System.out.println(result);
    }
}
