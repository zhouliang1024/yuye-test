package com.example.yuye.domain.user;

import com.example.yuye.dal.dto.UserDO;

/**
 * @author zhouliang
 * @date 2022/7/21 2:28 PM
 */
public class UserDomain {

    private UserDO userDO;

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    /**
     * 通过uid获取名称
     *
     * @param
     * @return
     */
    public String getName() {
        assert userDO!= null;
        return userDO.getName();
    }

    /**
     * 初始化用户
     *
     * @return
     */
    public static UserDomain initUser() {
        UserDO user = new UserDO();
        user.setUid("1");
        user.setName("小明");
        UserDomain userDomain = new UserDomain();
        userDomain.setUserDO(user);
        return userDomain;
    }


}
