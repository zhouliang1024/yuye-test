package com.example.yuye.biz.controller;

import com.example.yuye.domain.user.UserDomain;
import com.example.yuye.dal.dto.User;
import com.example.yuye.dal.dto.UserDTO;
import com.example.yuye.biz.mapping.UserMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouliang
 * @date 2022/7/21 2:29 PM
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/name")
    public String getUserName( @RequestParam String uId){
        log.info(uId);
        UserDomain userDomain = UserDomain.initUser();
        String name = userDomain.getName();
        log.info(name);
        return name;
    }
    @GetMapping("/doctor")
    public String convert( ){
        User user = new User();
        user.setId(1);
        user.setName("test");
        UserDTO userDTO = UserMapping.INSTANCE.toDto(user);
        return userDTO.toString();
    }

}
