package com.whj.test.tree;

import com.whj.test.tree.domain.vo.Zone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author WHJ
 * @Date 2024/5/8 14:13
 * @Description: TODO
 * @Version 1.0
 */
public class ZoneUtils {
    /**
     * 第一种方法：递归
     * @param zoneList
     * @return
     */
    public static List<Zone> buildTree1(List<Zone> zoneList) {
        List<Zone> result = new ArrayList<>();
        for (Zone zone : zoneList) {
            if (zone.getParentId().equals("0")) {
                result.add(zone);
                setChildren(zoneList, zone);
            }
        }
        return result;
    }

    public static void setChildren(List<Zone> list, Zone parent) {
        for (Zone zone : list) {
            if (parent.getId().equals(zone.getParentId())) {
                List<Zone> children = parent.getChildren();
                if (children == null) {
                    children = new ArrayList<>();
                    parent.setChildren(children);
                }
                children.add(zone);
            }
        }
        if (parent.getChildren() == null || parent.getChildren().isEmpty()) {
            return;
        }
        for (Zone zone : parent.getChildren()) {
            setChildren(list, zone);
        }
    }

    /**
     * 第二种方法：两层循环
     * @param zoneList
     * @return
     */
    public static List<Zone> buildTree2(List<Zone> zoneList) {
        List<Zone> result = new ArrayList<>();
        for (Zone zone : zoneList) {
            if (zone.getParentId().equals("0")) {
                result.add(zone);
            }
            for (Zone child : zoneList) {
                if (child.getParentId().equals(zone.getId())) {
                    List<Zone> children = zone.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                        zone.setChildren(children);
                    }
                    children.add(child);
                }
            }
        }
        return result;
    }

    /**
     * 第三种方法：两次遍历
     * @param zoneList
     * @return
     */
    public static List<Zone> buildTree3(List<Zone> zoneList) {
        Map<String, List<Zone>> zoneByParentIdMap = new HashMap<>();
        zoneList.forEach(zone -> {
            List<Zone> children = zoneByParentIdMap.getOrDefault(zone.getParentId(), new ArrayList<>());
            children.add(zone);
            zoneByParentIdMap.put(zone.getParentId(), children);
        });
        zoneList.forEach(zone -> zone.setChildren(zoneByParentIdMap.get(zone.getId())));
        return zoneList.stream()
                .filter(v -> v.getParentId().equals("0"))
                .collect(Collectors.toList());
    }


}
