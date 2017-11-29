package me.ccyhy.com.exception;

import java.awt.*;

public class UserExistException extends  Exception
{
    //无参构造函数
    public UserExistException()
    {

    }
    //含有错误消息构造参数
    public UserExistException(String message)
    {
        super(message);
    }
    public UserExistException(Throwable cause)
    {
        super(cause);
    }
    public UserExistException(String message,Throwable cause)
    {
        super(message,cause);
    }
}
