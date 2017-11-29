package me.ccyhy.com.web.UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginUIServlet")
public class LoginUIServlet extends javax.servlet.http.HttpServlet {
    public void init() throws ServletException{
        super.init();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //转发到注册页面
        System.out.println("---hahhahahah");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
