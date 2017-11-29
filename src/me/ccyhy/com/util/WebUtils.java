package me.ccyhy.com.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.UUID;

public class WebUtils
{
    //将request对象携带的参数全部赋值给一个指定Bean对象的参数中
    public  static <T> T request2Bean(HttpServletRequest request,Class<T> clazz)
    {
        //反射的方式获取类的实例对象
        try {
            T bean=clazz.newInstance();
            //取出参数
            Enumeration<String> enumeration=request.getParameterNames();
            while (enumeration.hasMoreElements())
            {
                String name=enumeration.nextElement();
                String value=request.getParameter(name);
                BeanUtils.setProperty(bean,name,value);
            }
            return bean;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * 生成UUID
     */
    public static String makeId()
    {
        return UUID.randomUUID().toString();
    }
}
