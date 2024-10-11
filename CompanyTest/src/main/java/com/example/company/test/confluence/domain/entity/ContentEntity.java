package com.example.company.test.confluence.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author whj
 * @since 2024-09-04 11:55:46
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("content")
@ApiModel(value = "ContentEntity对象", description = "")
public class ContentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CONTENTID", type = IdType.ASSIGN_UUID)
    private Long contentid;

    @TableField("HIBERNATEVERSION")
    private Integer hibernateversion;

    @TableField("CONTENTTYPE")
    private String contenttype;

    @TableField("TITLE")
    private String title;

    @TableField("LOWERTITLE")
    private String lowertitle;

    @TableField("VERSION")
    private Integer version;

    @TableField("CREATOR")
    private String creator;

    @TableField("CREATIONDATE")
    private LocalDateTime creationdate;

    @TableField("LASTMODIFIER")
    private String lastmodifier;

    @TableField("LASTMODDATE")
    private LocalDateTime lastmoddate;

    @TableField("VERSIONCOMMENT")
    private String versioncomment;

    @TableField("PREVVER")
    private Long prevver;

    @TableField("CONTENT_STATUS")
    private String contentStatus;

    @TableField("PAGEID")
    private Long pageid;

    @TableField("SPACEID")
    private Long spaceid;

    @TableField("CHILD_POSITION")
    private Integer childPosition;

    @TableField("PARENTID")
    private Long parentid;

    @TableField("PLUGINKEY")
    private String pluginkey;

    @TableField("PLUGINVER")
    private String pluginver;

    @TableField("PARENTCCID")
    private Long parentccid;

    @TableField("DRAFTPAGEID")
    private String draftpageid;

    @TableField("DRAFTSPACEKEY")
    private String draftspacekey;

    @TableField("DRAFTTYPE")
    private String drafttype;

    @TableField("DRAFTPAGEVERSION")
    private Integer draftpageversion;

    @TableField("PARENTCOMMENTID")
    private Long parentcommentid;

    @TableField("USERNAME")
    private String username;


}
