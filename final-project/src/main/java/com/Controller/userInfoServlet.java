package com.Controller;
import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.user.User;
import com.userInfo.UserInfo;
import com.userInfo.UserInfoDAO;


@WebServlet(urlPatterns = "/userInfo")
public class userInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/userInfo.jsp";
        String message = "";
        String action = req.getParameter("action");
        if(action == null)
        {
            action = "goToInfo";
        }
        if(action.equals("goToInfo"))
        {
            UserInfo userInfo = new UserInfo();
            HttpSession session = req.getSession(); 
            User user = (User)session.getAttribute("user");
            userInfo = UserInfoDAO.selectUserInfoById(user.getId());
            System.out.print(userInfo.getId());
            req.setAttribute("userInformation", userInfo);
        }
        else if(action.equals("updateInfo"))
        {

            url = "/index.jsp";
            HttpSession session = req.getSession(); 
            User user = (User)session.getAttribute("user");
            
            String fName = req.getParameter("firstName");
            String lName = req.getParameter("lastName");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");


            UserInfo userInfo = new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setFirstName(fName);
            userInfo.setLastName(lName);
            userInfo.setPhone(phone);
            userInfo.setaddress(address);
      
            if(UserInfoDAO.checkUserInfo(user.getId()))
            {

                UserInfoDAO.updateUserInfo(userInfo);
                message = "update done";
            }
            else
            {
                UserInfoDAO.InsertUserInfo(userInfo);
                message = "update done";
            }
            req.setAttribute("message", message);
            req.setAttribute("userInfo", userInfo);
        
        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
