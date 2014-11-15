package com.nexusy.ip.location;

import com.nexusy.ip.location.impl.IP2LocationBD;
import com.nexusy.ip.location.impl.IP2LocationXL;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lan
 * @since 2014-11-15
 */
public class IP2LocationBDTest {

    private IP2Location ip2Location;

    @Before
    public void setup() {
        ip2Location = new IP2LocationBD();
    }

    @Test
    public void test() {
        String result = ip2Location.ip2Location("42.121.57.127");
        System.out.println(result);
    }
}
