package me.ccyhy.com.web.controller;

import me.ccyhy.com.domain.User;
import me.ccyhy.com.service.IUserService;
import me.ccyhy.com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理登录请求，登陆成功自动跳转回首页
        //获取用户名和密码，调用业务逻辑层服务对象，根据用户名和密码处理登录请求
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        //业务逻辑层对象
        IUserService userService=new UserServiceImpl();
        //根据用户名和密码进行等哭，登录成功后返回用户对象
        User user=userService.loginUser(userName,password);
        //判断user，如果为null，则代表用户名或者密码错误
        if(user==null)
        {
            //通知消息错误页面，3秒后重新自动跳转回登录页面
            String message=String.format("对不起，用户名或者面错误，2秒后将为您重新跳转到登录页面！<meta http-equiv='refresh' content='2;url=%s'>",
                    "LoginUIServlet");
            //设置到request对象
            request.setAttribute("message",message);
            request.getRequestDispatcher("message.jsp").forward(request,response);
            //返回
            return;
        }
        //提示注册成功，并且将用户存入session对象中，以便于后期取出数据，跳转到首页
        request.getSession().setAttribute("user",user);
        //提示信息
        //通知消息错误页面，3秒后重新自动跳转回登录页面
        String message=String.format("恭喜:%s，登录成功,3秒后将为您跳转到首页！<meta http-equiv='refresh' content='2;url=%s'>",
                user.getUserName(),"index.jsp");
        //设置到request对象
        request.setAttribute("message",message);
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
