package com.lordbao.validation.domain.dto;


import com.lordbao.validation.validations.constraints.PasswordMatches;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Lord_Bao
 * @Date 2025/4/4 11:41
 * @Version 1.0
 *
 * 用于注册用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class RequestUser {
    @NotNull
    @NotBlank
    @Size(min = 4,message = "username 长度至少为{min}")
    String username;

    @NotNull
    @NotBlank
    @Size(min = 8,message = "password 长度至少为{min}")
    String password;

    @NotNull
    @NotBlank
    @Size(min = 8,message = "checkPassword 长度至少为{min}")
    String checkPassword;
}
