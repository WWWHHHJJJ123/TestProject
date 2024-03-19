package com.whj.common_structures.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TreeNode {

    /** 节点ID */
    private Integer id;

    /** 父节点ID：顶级节点为0 */
    private Integer parentId;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    private List<TreeNode> children;

    public TreeNode(Integer id, Integer parentId, String label) {
        this.id = id;
        this.parentId = parentId;
        this.label = label;
    }
}
