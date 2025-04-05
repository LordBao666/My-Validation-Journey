package com.lordbao.validation.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Lord_Bao
 * @Date 2025/4/4 9:51
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    //不能为空,不能是空白字符,字符数至少为2
    @NotNull
    @NotBlank
    @Size(min = 2)
    private String name;

}
