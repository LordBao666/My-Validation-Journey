package com.lordabo.valiation.test;


import com.lordbao.validation.domain.Car;
import com.lordbao.validation.domain.OneHundredList;
import com.lordbao.validation.domain.Person;
import com.lordbao.validation.domain.dto.RequestUser;
import com.lordbao.validation.domain.dto.RequestUserInfo;
import com.lordbao.validation.service.UserService;
import com.lordbao.validation.util.ValidationUtil;
import jakarta.validation.groups.Default;
import org.junit.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2025/2/23 15:20
 * @Version 1.0
 */
public class TestValidation {





    //测试Bean对象的级联
    @Test
    public void testValidBeanCascade(){

        //级联校验测试
        Person p1 = new Person("    ");//不能为空
        Car car1 = new Car("红旗", "京8888", 6, p1);
        ValidationUtil.valid(car1).forEach(System.out::println);
        System.out.println(".........");

        //级联校验测试
        Person p2 = new Person("张");//字符长度至少为2
        Car car2 = new Car("红旗", "京8888", 6, p2);
        ValidationUtil.valid(car2).forEach(System.out::println);
        System.out.println(".........");
    }

    //测试容器元素校验
    @Test
    public void testValidContainerElement(){

        OneHundredList list = new OneHundredList();
        list.add(-1);
        list.add(101);
        ValidationUtil.valid(list).forEach(System.out::println);
    }



    //测试方法(参数)
    @Test
    public void testValidMethod() throws NoSuchMethodException {

        //方法参数测试
        UserService obj = new UserService();
        Method method = UserService.class.getMethod("registerUser", String.class, String.class);
        Object [] parameterValues = {"lee","lee55"};

        ValidationUtil.validateParameters(obj,method,parameterValues).forEach(System.out::println);
    }

    //测试方法级联
    @Test
    public void testValidMethodCascade() throws NoSuchMethodException {

        //方法参数测试
        UserService obj = new UserService();
        Method method = UserService.class.getMethod("registerUser", RequestUser.class);

        RequestUser requestUser = new RequestUser("lee", "lee55","lee55");
        Object [] parameterValues = {requestUser};

        ValidationUtil.validateParameters(obj,method,parameterValues).forEach(System.out::println);
    }

    //测试方法容器元素级联
    @Test
    public void testValidMethodContainerCascade() throws NoSuchMethodException {

        //方法参数测试
        UserService obj = new UserService();
        Method method = UserService.class.getMethod("addUserInfoList", List.class);


        List<RequestUserInfo> list = new ArrayList<>();
        RequestUserInfo userInfo1 = new RequestUserInfo();
        userInfo1.setUsername("     ");

        RequestUserInfo userInfo2 = new RequestUserInfo();
        userInfo2.setUsername("li");

        RequestUserInfo userInfo3 = new RequestUserInfo();
        userInfo3.setId(1L);

        list.add(userInfo1);
        list.add(userInfo2);
        list.add(userInfo3);

        Object [] parameterValues = {list};

        ValidationUtil.validateParameters(obj,method,parameterValues, RequestUserInfo.Add.class).forEach(System.out::println);
    }


    //测试分组校验
    @Test
    public void testValidGroup() throws NoSuchMethodException {


        UserService obj = new UserService();
        Method addUserInfoMethod = UserService.class.getMethod("addUserInfo", RequestUserInfo.class);

        RequestUserInfo addUserInfo = new RequestUserInfo();
        addUserInfo.setUsername("ja");
        Object [] parameterValues = {addUserInfo};

        //添加分组规则 RequestUserInfo.Add.class 和 DEFAULT.class
        ValidationUtil.validateParameters(obj,addUserInfoMethod,parameterValues, RequestUserInfo.Add.class, Default.class).forEach(System.out::println);

        //假若RequestUserInfo.Add 继承自DEFAULT,那么无需显式声明DEFAULT
//        ValidationUtil.validateParameters(obj,addUserInfoMethod,parameterValues, RequestUserInfo.Add.class).forEach(System.out::println);

    }

    //测试类级别的参数校验
    @Test
    public void testValidClassLevel(){
        RequestUser user = new RequestUser("jack","pwd11111","pwd22222");
        ValidationUtil.valid(user).forEach(System.out::println);
    }


    //测试复合校验注解
    @Test
    public void testValidComposite(){
        //级联校验测试
        Person p1 = new Person("jack");
        Car car1 = new Car("红旗", "a", 6, p1);
        ValidationUtil.valid(car1).forEach(System.out::println);
        System.out.println(".........");
    }
}
