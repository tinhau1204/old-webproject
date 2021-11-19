package com.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.item.Item;
import com.item.ItemDAO;
import com.tree.Tree;
import com.tree.TreeDAO;
@WebServlet("/salingProduct")
public class listProductServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException
    {
        String action = req.getParameter("action");
        String url = "/product.jsp";
        if(action == null)
        {
            action = "loadItems";
        }
        if(action.equals("loadItems"))
        {
            List<Item> listItems = new ArrayList<Item>();
            listItems = ItemDAO.SelectAllTheProduct();
            List<Tree> listTrees = new ArrayList<Tree>();
            listTrees = TreeDAO.SelectAllTree();
            req.setAttribute("listTrees", listTrees);
            req.setAttribute("listItems", listItems);
        }

    getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
}
