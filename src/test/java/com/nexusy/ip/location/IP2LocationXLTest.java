package com.nexusy.ip.location;

import com.nexusy.ip.location.impl.IP2LocationXL;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lan
 * @since 2014-11-15
 */
public class IP2LocationXLTest {

    private IP2Location ip2Location;

    @Before
    public void setup() {
        ip2Location = new IP2LocationXL();
    }

    @Test
    public void test() {
        String result = ip2Location.ip2Location("23.59.157.15");
        System.out.println(result);
    }
}
