package com.example.company.test.confluence.domain.ao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: CiZhong
 * 创建日期: 2024/8/30
 * 创建时间: 9:43
 */
@Data
public class SpacePermissionAO {

    @ApiModelProperty("从这个ldap")
    private String valueLdap;

    @ApiModelProperty("到这个ldap")
    private String targetLdap;
}
