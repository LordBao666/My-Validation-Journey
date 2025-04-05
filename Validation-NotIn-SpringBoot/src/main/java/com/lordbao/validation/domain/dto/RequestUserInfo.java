package com.lordbao.validation.domain.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Lord_Bao
 * @Date 2025/4/4 12:12
 * @Version 1.0
 *
 * 添加或更新用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserInfo {

    //标记接口Add
    public interface Add extends Default {
    }
    //标记接口Update
    public interface Update extends Default{
    }

    @Null(groups = Add.class)
    @NotNull(groups = Update.class)
    private Long id;


    @NotNull
    @NotBlank
    @Size(min = 4,message = "username 长度至少为{min}")
    private String username;

    //...
}
