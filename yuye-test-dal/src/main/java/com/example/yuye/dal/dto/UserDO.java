package com.example.yuye.dal.dto;

/**
 * @author zhouliang
 * @date 2022/7/21 2:25 PM
 */
public class UserDO {
    private String uid;
    private String name;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 初始化用户
     *
     * @return
     */
    public static UserDO initUser() {
        UserDO user = new UserDO();
        user.setUid("1");
        user.setName("小明");
        return user;
    }
}
