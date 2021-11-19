package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item.Item;
import com.item.ItemDAO;
import com.tree.Tree;
import com.tree.TreeDAO;

@WebServlet("/deleteItem")
public class deleteItemsProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pid = null;
        try{
            pid =Integer.parseInt(req.getParameter("pid")) ;
        }
        catch(NumberFormatException nfe)
        {
            
        }
        Item items = new Item();
        items = ItemDAO.getItemById(pid);
        Tree tree = items.getTree();
        ItemDAO.deleteItemById(pid);
        TreeDAO.deleteTreeById(tree.getTreeid());
        req.getRequestDispatcher("productManagement").forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
