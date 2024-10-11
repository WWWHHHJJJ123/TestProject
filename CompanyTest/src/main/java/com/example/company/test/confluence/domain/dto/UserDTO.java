package com.example.company.test.confluence.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: CiZhong
 * 创建日期: 2024/8/30
 * 创建时间: 18:04
 */
@Data
public class UserDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;

    @JsonProperty("id")
    private String id;
}
