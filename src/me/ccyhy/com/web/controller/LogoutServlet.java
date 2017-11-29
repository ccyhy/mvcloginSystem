package me.ccyhy.com.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销登录，即将user从session中移除，然后再跳转到指定页面
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中移除user，实现注销功能
        request.getSession().removeAttribute("user");
        //注销成功消息
        String message=String.format("注销成功，3秒后自动跳转到登录页面!<meta http-equiv='refresh' content='3;url=%s'>",
                "LoginUIServlet");
        request.setAttribute("message",message);
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
