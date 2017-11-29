package me.ccyhy.com.web.controller;

import me.ccyhy.com.bean.RegisterFormBean;
import me.ccyhy.com.dao.IUserDao;
import me.ccyhy.com.domain.User;
import me.ccyhy.com.exception.UserExistException;
import me.ccyhy.com.service.IUserService;
import me.ccyhy.com.service.impl.UserServiceImpl;
import me.ccyhy.com.util.SopUtils;
import me.ccyhy.com.util.WebUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将用户提交的数据封装到formBean中
        RegisterFormBean bean= WebUtils.request2Bean(request,RegisterFormBean.class);
        //校验表单,如果校验失败，将bean封装到reques中，并且通知注册jsp进行数据回显
        if(bean.validate()==false)
        {
            //将封装表单数据的frombean对象返回给register.jsp
            request.setAttribute("bean",bean);
            //重新转发到register页面
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
            //返回
            return;
        }
        //验证通过，则调用业务逻辑层，开始注册服务
        User user=new User();
        try
        {
            //注册字符串到日期转换器
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            //利用BeanUtils将一个bean中的数据copy到另外一个bean中
            BeanUtils.copyProperties(user,bean);
            user.setId(WebUtils.makeId());
            //开始注册，首先创建注册服务对象
            IUserService service=new UserServiceImpl();
            //注册
            service.registerUser(user);
            //注册成功消息
            String message=String.format("注册成功!3秒后自动跳转到登录界面!<meta http-equiv='refresh' content='3;url=%s'/>",
                    "LoginUIServlet");
            SopUtils.sop(request.getContextPath());
            request.setAttribute("message",message);
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }

        catch (UserExistException e)
        {
            bean.getErrors().put("userName","用户名已经存在");
            //将封装表单数据的frombean对象返回给register.jsp
            request.setAttribute("bean",bean);
            //重新转发到register页面
            request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //注册失败
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
