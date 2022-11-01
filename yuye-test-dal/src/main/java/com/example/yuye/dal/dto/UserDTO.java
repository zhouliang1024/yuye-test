package com.example.yuye.dal.dto;

/**
 * @author zhouliang
 * @date 2022/7/21 3:51 PM
 */
public class UserDTO {
    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
