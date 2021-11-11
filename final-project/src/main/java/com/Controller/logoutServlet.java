package com.Controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.user.*;

@WebServlet("/logout")
public class logoutServlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String url = "";
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        resp.sendRedirect("./index.jsp");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
