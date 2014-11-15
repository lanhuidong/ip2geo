package com.nexusy.ip.location;

/**
 * @author lan
 * @since 2014-11-15
 */
public interface IP2Location {

    /**
     * 传入IP，返回地理位置
     * @param ip ip地址
     * @return 地理位置
     */
    String ip2Location(String ip);

    void addIP2Location(IP2Location ip2Location);
}
