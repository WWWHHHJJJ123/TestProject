package com.example.company.test.confluence.common.enums;

import lombok.Getter;

/**
 * @author: CiZhong
 * 创建日期: 2024/8/30
 * 创建时间: 9:55
 */

@Getter
public enum SpacePemissionOperEnum {

    VIEW_SPACE("VIEWSPACE", "全部-查看");
//    REMOVE_OWN_CONTENT("REMOVEOWNCONTENT", "全部-删除自己的"),
//    EDIT_SPACE("EDITSPACE", "页面-添加"),
//    REMOVE_PAGE("REMOVEPAGE", "页面-删除"),
//    EDIT_BLOG("EDITBLOG", "博文-添加"),
//    REMOVE_BLOG("REMOVEBLOG", "博文-删除"),
//    CREATE_ATTACHMENT("CREATEATTACHMENT", "附件-添加"),
//    REMOVE_ATTACHMENT("REMOVEATTACHMENT", "附件-删除"),
//    COMMENT("COMMENT", "评论-添加"),
//    REMOVE_COMMENT("REMOVECOMMENT", "评论-删除"),
//    SET_PAGE_PERMISSIONS("SETPAGEPERMISSIONS", "权威-添加/删除"),
//    REMOVE_MAIL("REMOVEMAIL", "邮件-删除"),
//    EXPORT_SPACE("EXPORTSPACE", "空间-导出"),
//    SET_SPACE_PERMISSIONS("SETSPACEPERMISSIONS", "空间-管理");


    public String value;

    public String describe;


    SpacePemissionOperEnum(String value,String describe) {
        this.value = value;
        this.describe = describe;
    }
}
