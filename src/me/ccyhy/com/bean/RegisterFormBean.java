package me.ccyhy.com.bean;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zqh
 * @date 2017年11月29日11:40:48
 * 封装用户注册表单数据的bean，用来接收register.jsp表单的各个字段值
 * 同时负责对表单输入项的合法性进行判断
 * 然后记录不合法原因，并且存入map，以便于数据回显给注册客户端浏览器
 */
public class RegisterFormBean
{
    //<input type="text" name="userName">
    private String userName;
    //<input type="password" name="userPwd">
    private String userPwd;
    //<input type="password" name="confirmPwd">
    private String confirmPwd;
    //<input type="text" name="email">
    private String email;
    //<input type="text" name="birthday">
    private String birthday;

    /**
     * 存储校验不通过时给用户的提示信息，key就是字段值
     */
    private Map<String,String > errors=new HashMap<String,String>();

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

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    /**
     * validate方法负责验证表单输入项
     *
     * 表单验证输入规则
     * 1,userName ,不为null或者空字符串，而且为3-8位的字母，不区分大小写，正则为[a-zA-Z]{3,8}
     * 2,password，不为null或者空字符串，且为3-8位的数字 \d{3,8}
     * 3,confirmPwd,两次密码要一致
     * 4，email，可以为null，但是如果不为空，需要是一个合法的邮箱地址，正则:
     * 5，birthday，可以空，但是如果不为空，需要一个合法的日期,用日期转换器验证即可
     */
    public boolean validate()
    {
        boolean isOk=true;
        //验证用户名
        if(userName==null||userName.trim().equals(""))
        {
            isOk=false;
            errors.put("userName","用户名不能为空!");
        }
        else
        {
            //判断是否为3-8位字母
            if(!this.userName.matches("[a-zA-Z]{3,8}"))
            {
                isOk=false;
                errors.put("userName","用户名必须为3-8位字母!!");
            }
        }
        //验证密码
        if(userPwd==null||userPwd.trim().equals(""))
        {
            isOk=false;
            errors.put("userPwd","用户名不能为空!");
        }
        else
        {
            //判断是否为3-8位字母
            if(!this.userPwd.matches("\\d{3,8}"))
            {
                isOk=false;
                errors.put("userPwd","用户名必须为3-8位字母!!");
            }
        }

        //确认密码
        if(this.confirmPwd!=null)
        {
            if(!this.confirmPwd.equals(this.userPwd))
            {
                //设置isok为false，代表验证不通过
                isOk=false;
                errors.put("confirmPwd","两次输入密码不一致!");
            }
        }
        //验证邮箱
        if(this.email!=null&&!this.email.trim().equals(""))
        {
            //正则表达式验证
            if(!this.email.matches("\\w+@\\w+(\\.\\w+)+"))
            {
                isOk=false;
                errors.put("email","输入邮箱地址不合法!");
            }
        }
        //验证生日
        if(this.birthday!=null&&!birthday.trim().equals(""))
        {
            //利用日期转换器判断是否是日期类型
            try {
                DateLocaleConverter converter=new DateLocaleConverter();
                converter.convert(this.birthday);
            }
            catch (Exception e)
            {
                //捕获异常，代表日期格式不正确
                isOk=false;
                errors.put("birthday","生日需要是一个合法的日期格式");
            }
        }
        return isOk;
    }
}
