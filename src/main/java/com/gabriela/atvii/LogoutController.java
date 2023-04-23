package com.gabriela.atvii;

import com.gabriela.atvii.Service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("isLoggedIn", false);
        boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn == false) {
            response.sendRedirect("http://localhost:8080/login/index.jsp");
        }
    }
}
