package com.example.yuye.biz.component;

import com.example.yuye.biz.BaseTest;
import com.example.yuye.dal.mapper.UserMapper;
import com.example.yuye.dal.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhouliang
 * @date 2022/10/14 3:04 PM
 */
@Slf4j
public class IdTest extends BaseTest {

    @Resource
    private IdGenerator idGenerator;

    @Test
    void testMybatisPlus() {

    }

    public static void main(String[] args) {
        String generate = IdGenerator.generate();
        System.out.println(generate);
    }


}
