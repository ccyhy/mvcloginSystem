package me.ccyhy.com.web.UI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterUIServlet")
public class RegisterUIServlet extends HttpServlet {
    public void init() throws ServletException{
        super.init();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---hahhahahah");
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
    }
}
