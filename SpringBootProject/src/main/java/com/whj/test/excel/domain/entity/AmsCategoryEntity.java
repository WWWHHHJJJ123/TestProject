package com.whj.test.excel.domain.entity;

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
 * @since 2023-11-30 16:18:22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("ams_category")
@ApiModel(value = "AmsCategoryEntity对象", description = "")
public class AmsCategoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("对应的父id")
    @TableField("pid")
    private Long pid;

    @ApiModelProperty("租户id（供应商id、品牌商id）")
    @TableField("tenant_id")
    private Long tenantId;

    @ApiModelProperty("排序需要的字段")
    @TableField("sort")
    private Long sort;

    @ApiModelProperty("尺码组")
    @TableField("size_group")
    private String sizeGroup;

    @ApiModelProperty("尺码组id")
    @TableField("size_group_id")
    private Long sizeGroupId;

    @ApiModelProperty("1.一级分类  2.二级分类  3.三级分类")
    @TableField("assort_level")
    private String assortLevel;

    @ApiModelProperty("分类名称：例如童装，女装")
    @TableField("assort_name")
    private String assortName;

    @ApiModelProperty("生产号型id")
    @TableField("product_size_id")
    private Long productSizeId;

    @ApiModelProperty("商品号型")
    @TableField("product_size")
    private String productSize;

    @ApiModelProperty("主销分组id")
    @TableField("main_sales_group_id")
    private Long mainSalesGroupId;

    @ApiModelProperty("主销分组")
    @TableField("main_sales_group")
    private String mainSalesGroup;

    @ApiModelProperty("生产分类")
    @TableField("product_sort")
    private String productSort;

    @ApiModelProperty("分类id层级 例如：1/2/3")
    @TableField("category_id_path")
    private String categoryIdPath;

    @ApiModelProperty("分类名称层级 例如：女装/上装/衬衫")
    @TableField("category_name_path")
    private String categoryNamePath;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty("启用状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建者id")
    @TableField("create_by")
    private Long createBy;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改者id")
    @TableField("update_by")
    private Long updateBy;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("系统时间")
    @TableField("rep_time")
    private LocalDateTime repTime;


}
