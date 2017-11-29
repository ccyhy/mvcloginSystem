package me.ccyhy.com.service.impl;

import me.ccyhy.com.dao.IUserDao;
import me.ccyhy.com.dao.impl.UserDaoImpl;
import me.ccyhy.com.domain.User;
import me.ccyhy.com.exception.UserExistException;
import me.ccyhy.com.service.IUserService;

public class UserServiceImpl implements IUserService
{
    //注册和登录的原理
    /**
     * 注册，即用数据访问层对象的add方法，将user加入
     * 当然，加入前要首先根据用户名判断，这个用户是否存在，如果存在，抛出已存在异常
     *
     * 登录，利用数据访问层的对象的find方法，找到该用户，返回即可，如果为null，说明未注册
     */
    //数据访问层对象
    IUserDao userDao=new UserDaoImpl();
    /**
     * 注册
     * @param user
     * @throws UserExistException
     */
    @Override
    public void registerUser(User user) throws UserExistException
    {
        //判断用户名是否存在，如果不存在，则正常注册，通过数据访问层将新用户添加进xml文件
        //如果存在，则抛出用户名已经存在异常
       if(userDao.find(user.getUserName())!=null)
       {
           throw new UserExistException("用户名已经存在！");
       }
       //正常注册
       userDao.add(user);
    }

    /**
     * 登录
     * @param userNaem
     * @param userPwd
     * @return
     */
    @Override
    public User loginUser(String userNaem, String userPwd)
    {
        return userDao.find(userNaem,userPwd);
    }
}
