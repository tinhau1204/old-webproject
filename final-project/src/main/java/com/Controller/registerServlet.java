package com.Controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.data.hiddenData;
import com.user.*;

@WebServlet(urlPatterns = "/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String url = "/register.jsp";
        String action = req.getParameter("action");
        String message = "";
        if(action == null)
        {
            action = "register";
        }
        if(action.equals("register"))
        {
            String email = req.getParameter("email");
            String pass = req.getParameter("password");
            String secondpass = req.getParameter("2password");
            User user = new User();
            if(pass.equals(secondpass))
            {
                user.setEmail(email);
                user.setPass(pass);
                user.setAdmin(0);
                System.out.println(user.getEmail());
                if(UserDAO.emailExists(user.getEmail()))
                {
                    url = "/register.jsp";
                    message = "email have already exist";

                }
                else
                {
                    System.out.println(UserDAO.emailExists(user.getEmail()));
                    UserDAO.addUser(user);
                    message ="login";
                }
            }
            else
            {
                message = "Password does not match!!!";
                url = "/register.jsp";
                
            }

            req.setAttribute("message", message);
            
        }
        else if(action.equals("backtologin"))
            {
                url= "/login.jsp";
            }
        getServletContext().getRequestDispatcher(url).forward(req, resp);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
