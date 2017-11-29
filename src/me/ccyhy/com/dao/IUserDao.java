package me.ccyhy.com.dao;

import me.ccyhy.com.domain.User;

public interface IUserDao
{
    /**
     * 根据用户名和密码，查找用户
     * @param userName
     * @param userPwd
     * @return
     */
    User find(String userName,String userPwd);

    /**
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 根据用户名查找用户，防止用户名注册的时候重复
     * @param userName
     * @return
     */
    User find(String userName);
}
