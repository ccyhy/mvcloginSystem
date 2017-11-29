package me.ccyhy.com.service;

import me.ccyhy.com.domain.User;
import me.ccyhy.com.exception.UserExistException;

public interface IUserService
{
    /**
     *提供注册服务
     * @param user
     * @throws UserExistException
     */
    void registerUser(User user) throws UserExistException;

    /**
     * 提供登录服务
     * @param userNaem
     * @param userPwd
     */
    User loginUser(String userNaem,String userPwd);
}
