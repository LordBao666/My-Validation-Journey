package com.lordbao.validation.domain;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2025/4/4 16:35
 * @Version 1.0
 *
 * 容器元素校验案例
 */

public class OneHundredList {

    private final List<@NotNull  @Min(value = 0) @Max(value = 100) Integer> list;

    public OneHundredList() {
        list = new ArrayList<>();
    }

    public void add(Integer ele){
        list.add(ele);
    }

}
