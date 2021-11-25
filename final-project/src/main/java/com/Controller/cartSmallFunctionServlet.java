package com.Controller;

import java.io.IOException;
import java.text.spi.NumberFormatProvider;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.Cart;
import com.cart.CartDAO;
import com.item.Item;
import com.item.ItemDAO;
import com.tree.Tree;
import com.user.User;


@WebServlet("/smallCartFuct")
public class cartSmallFunctionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "Cartlist";
        if(action == null)
        {
            action = "deleteItem";
        }
        if(action.equals("deleteItem"))
        {
            Integer itemId = null;
            try{
                itemId = Integer.parseInt(req.getParameter("itemId"));
    
            }
            catch(NumberFormatException nfe)
            {
    
            }
            ItemDAO.deleteItemById(itemId);
            
        }
        else if(action.equals("plus"))
        {
            Integer itemId = null;
            try{
                itemId = Integer.parseInt(req.getParameter("inputvalue"));
    
            }
            catch(NumberFormatException nfe)
            {
    
            }
            Item item = ItemDAO.getItemById(itemId);
            item.setQuality(item.getQuality() + 1);
            Tree tree = item.getTree();
            item.setPrice(item.getQuality() * tree.getPrice());
            ItemDAO.updateItem(item);
        }
        else if (action.equals("minus"))
        {
            Integer itemId = null;
            try{
                itemId = Integer.parseInt(req.getParameter("inputvalue"));
    
            }
            catch(NumberFormatException nfe)
            {
    
            }
            Item item = ItemDAO.getItemById(itemId);
            if(item.getQuality() == 1)
            {
                ItemDAO.deleteItemById(itemId);
            }
            else 
            {
                item.setQuality(item.getQuality() - 1);
                Tree tree = item.getTree();
                item.setPrice(item.getQuality() * tree.getPrice());
                ItemDAO.updateItem(item);
            }
        }
        else if (action.equals("clearCart"))
        {
            HttpSession session = req.getSession();
            User user = (User)session.getAttribute("user");
            Cart cart = CartDAO.selectCartByUid(user.getId());
            ItemDAO.deleteAllUnpaidItems(cart.getId());
        }
        req.getRequestDispatcher(url).forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
