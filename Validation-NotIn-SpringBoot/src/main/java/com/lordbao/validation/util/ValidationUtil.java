package com.lordbao.validation.util;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.executable.ExecutableValidator;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author Lord_Bao
 * @Date 2025/2/23 14:00
 * @Version 1.0
 */
public class ValidationUtil {
    //单例,类加载时创建
    private static final Validator validator;

    private static final ExecutableValidator executableValidator;
    static {
        try {
            validator = Validation.buildDefaultValidatorFactory().getValidator();
            executableValidator=Validation.buildDefaultValidatorFactory().getValidator().forExecutables();
        } catch (Exception e) {
            throw new RuntimeException("Validator 初始化失败，请检查依赖或配置", e);
        }
    }

    //不允许通过构造器创建ValidationUtil对象
    private ValidationUtil() {
    }

    //对对象t进行校验
    //list 会记录 t 所有校验不通过的属性,并给出解释
    public static <T> List<String> valid(T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> set = validator.validate(t,groups);


        //类型T的  属性 {属性} 的值 {属性值} 校验失败: {校验失败原因}
        List<String> list = set.stream().map(v -> String.format("属性 %s 的值 %s 校验失败: %s",
                v.getPropertyPath(),
                v.getInvalidValue(),
                v.getMessage())
        ).collect(Collectors.toList());

        return list;
    }


    //对方法参数进行校验
    public static <T> List<String> validateParameters(T object,
                                      Method method,
                                      Object[] parameterValues,
                                      Class<?>... groups){
        Set<ConstraintViolation<T>> set = executableValidator.validateParameters(object, method, parameterValues, groups);


        //方法 {第几个参数,比如arg0} 的值 {值} 校验失败: {校验失败原因}
        List<String> list = set.stream().map(v -> String.format("方法 %s 的值 %s 校验失败: %s",
                v.getPropertyPath(),
                v.getInvalidValue(),
                v.getMessage())
        ).collect(Collectors.toList());


        return list;
    }
}
