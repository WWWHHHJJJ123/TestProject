package com.whj.test.tree;

import com.alibaba.fastjson2.JSONObject;
import com.whj.test.tree.domain.vo.Zone;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WHJ
 * @Date 2024/5/8 14:10
 * @Description: TODO
 * @Version 1.0
 */
public class TestTreeStructure {
    public static void main(String[] args) {
        List<Zone> zoneList = new ArrayList<>();
        zoneList.add(new Zone("1", "上海", "0"));
        zoneList.add(new Zone("2", "北京", "0"));
        zoneList.add(new Zone("3", "河南", "0"));
        zoneList.add(new Zone("31", "郑州", "3"));
        zoneList.add(new Zone("32", "洛阳", "3"));
        zoneList.add(new Zone("321", "洛龙", "32"));
        zoneList.add(new Zone("11", "松江", "1"));
        zoneList.add(new Zone("111", "泗泾", "11"));
        // 测试第一种方法
        List<Zone> rootZone1 = ZoneUtils.buildTree1(zoneList);
        System.out.println(JSONObject.toJSONString(rootZone1));
        // 测试第二种方法
        List<Zone> rootZone2 = ZoneUtils.buildTree2(zoneList);
        System.out.println(JSONObject.toJSONString(rootZone2));
        // 测试第三种方法
        List<Zone> rootZone3 = ZoneUtils.buildTree3(zoneList);
        System.out.println(JSONObject.toJSONString(rootZone3));
    }

}
