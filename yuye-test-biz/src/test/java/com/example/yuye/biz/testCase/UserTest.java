package com.example.yuye.biz.testCase;

import com.example.yuye.biz.BaseTest;
import com.example.yuye.dal.mapper.UserMapper;
import com.example.yuye.dal.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhouliang
 * @date 2022/7/25 2:29 PM
 */
@Slf4j
public class UserTest extends BaseTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void testMybatisPlus() {
        for (int i = 18; i < 20; i++) {
            User user = new User("王小波" + i, i);
            int insert = userMapper.insert(user);
            log.info(insert+"");
        }
    }

    public static void main(String[] args) {
        System.out.println("test455".hashCode()%64);
    }
}
