package com.gabriela.atvii;

import com.gabriela.atvii.Service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("field_user");
        String password = request.getParameter("field_password");

        LoginService service = new LoginService();

        try{
            service.validateLogin(user, password, request);
            response.sendRedirect("http://localhost:8080/login/pagina.jsp");
        } catch (Exception e) {
            String msg = e.getMessage();
            response.sendRedirect("http://localhost:8080/login/index.jsp?msg=" + msg);
        }
    }

}
