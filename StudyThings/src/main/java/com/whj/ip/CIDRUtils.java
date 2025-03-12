package com.whj.ip;

import com.alibaba.fastjson.JSONObject;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CiZhong
 * @date 2024-11-18
 */
public class CIDRUtils {
    // 方法：通过CIDR获取网段内的所有IP地址
    public static List<String> getIPAddressesFromCIDR(String cidr) throws Exception {
        List<String> ipAddresses = new ArrayList<>();
        String[] parts = cidr.split("/");
        String ip = parts[0];
        int prefixLength = Integer.parseInt(parts[1]);

        // 将IP地址转换为长整型
        long ipLong = ipToLong(InetAddress.getByName(ip).getAddress());

        // 计算子网掩码的长度（前缀长度）
        long subnetMask = (0xFFFFFFFFFFFFFFFFL << (32 - prefixLength)) & 0xFFFFFFFFFFFFFFFFL;

        // 子网开始地址
        long startIP = ipLong & subnetMask;

        // 子网结束地址
        long endIP = startIP | (~subnetMask & 0xFFFFFFFFL);

        // 获取网段内所有IP地址
        for (long i = startIP; i <= endIP; i++) {
            ipAddresses.add(longToIp(i));
        }

        return ipAddresses;
    }

    // 将IP地址转换为长整型
    private static long ipToLong(byte[] address) {
        long result = 0;
        for (int i = 0; i < address.length; i++) {
            result |= ((address[i] & 0xFF) << ((3 - i) * 8));
        }
        return result;
    }

    // 将长整型转换为IP地址
    private static String longToIp(long longIp) {
        return ((longIp >> 24) & 0xFF) + "." +
                ((longIp >> 16) & 0xFF) + "." +
                ((longIp >> 8) & 0xFF) + "." +
                (longIp & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        // 示例CIDR
        String cidr1 = "10.10.52.0/24";

        String cidr2 = "10.1.0.0/16";

        // 获取该网段内的所有IP地址
        List<String> ipAddresses1 = getIPAddressesFromCIDR(cidr1);
        List<String> ipAddresses2 = getIPAddressesFromCIDR(cidr2);

        // 输出所有IP地址

        System.out.println(JSONObject.toJSONString(ipAddresses1));
        System.out.println("---------------------------------------");
        System.out.println(JSONObject.toJSONString(ipAddresses2));
    }
}
