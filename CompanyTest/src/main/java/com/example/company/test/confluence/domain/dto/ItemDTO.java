package com.example.company.test.confluence.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: CiZhong
 * 创建日期: 2024/8/30
 * 创建时间: 11:56
 */
@Data
public class ItemDTO {
    @JsonProperty("i18nKey")
    private String i18nKey;

    @JsonProperty("key")
    private String key;

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;
}
