package com.lordbao.validation.service;


import com.lordbao.validation.domain.dto.RequestUser;
import com.lordbao.validation.domain.dto.RequestUserInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2025/4/4 11:19
 * @Version 1.0
 */
public class UserService {



    public Long registerUser(@NotNull @NotBlank @Size(min = 4)String username,
                             @NotNull @NotBlank @Size(min = 8)String password){
        //其他逻辑
        return 1L;
    }

    public Long registerUser(@NotNull @NotBlank @Size(min = 4)String username,
                             @NotNull @NotBlank @Size(min = 8)String password,
                             @NotNull @NotBlank @Size(min = 8)String checkPassword){
        //其他逻辑
        return 1L;
    }

    public Long registerUser(@NotNull @Valid RequestUser user){
        //其他逻辑
        return 1L;
    }


    public void addUserInfo(@NotNull @Valid RequestUserInfo userInfo){
        //其他逻辑
    }

    public void updateUserInfo(@NotNull @Valid RequestUserInfo userInfo){
        //其他逻辑
    }

    //批量添加用户信息
    public void addUserInfoList(List<@NotNull @Valid RequestUserInfo> userInfoList){
        //其他逻辑
    }

}
