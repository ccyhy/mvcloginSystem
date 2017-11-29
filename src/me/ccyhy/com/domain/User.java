package me.ccyhy.com.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zqh
 * 用户实体类 bean
 * @date 2017年11月28日15:22:48
 */
public class User implements Serializable
{
    //用户id
    private String id;
    private String userName;
    private String userPwd;
    //邮箱
    private String email;
    private Date birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
