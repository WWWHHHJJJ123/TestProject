package com.whj.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author WHJ
 * @Date 2024/4/19 15:37
 * @Description: TODO
 * @Version 1.0
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public  class SelectionVo<T> {
    private T value;
    private String label;
    private Long count;

    public static <T> SelectionVo<T> of(T value, String label) {
        SelectionVo<T> selectionVo = new SelectionVo<>();
        selectionVo.value = value;
        selectionVo.label = label;
        return selectionVo;
    }

    public static <T> SelectionVo<T> of(T value, String label, Long count) {
        SelectionVo<T> selectionVo = of(value, label);
        selectionVo.count = count;
        return selectionVo;
    }
}
