package com.whj.test.tree.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author WHJ
 * @Date 2024/5/8 14:06
 * @Description: TODO
 * @Version 1.0
 */

public class Zone {

    private String id;
    private String name;
    private String parentId;
    private List<Zone> children;
    public Zone(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
    public void addChildren(Zone zone){
        if(children == null) {
            children = new ArrayList<>();
        }
        children.add(zone);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Zone> getChildren() {
        return children;
    }

    public void setChildren(List<Zone> children) {
        this.children = children;
    }

}
