package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.tree.Tree;
import com.tree.TreeDAO;


@WebServlet("/itemsDetail")
public class itemDetailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/detail.jsp";
        Integer itemId = null;
        try
        {
            itemId = Integer.parseInt(req.getParameter("itemId"));
        }
        catch(NumberFormatException nfe)
        {

        }
       
            Tree tree = TreeDAO.selectTreeById(itemId);
            req.setAttribute("tree", tree);
    getServletContext().getRequestDispatcher(url).forward(req, resp);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        doPost(req, resp);

    }
}
