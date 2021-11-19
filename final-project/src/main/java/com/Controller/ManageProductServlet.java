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
@WebServlet("/productManagement")
public class ManageProductServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = null;
        String message = null;
    if(action == null)
    {
        action = "goToManageProduct";
        url = "/productManage.jsp";
    }
    if(action.equals("goToManageProduct"))
    {
        List<Item> listItems = new ArrayList<Item>();
        listItems = ItemDAO.SelectAllTheProduct();
        List<Tree> listTrees = new ArrayList<Tree>();
        listTrees = TreeDAO.SelectAllTree();
        req.setAttribute("listTrees", listTrees);
        req.setAttribute("listItems", listItems);
    }
    else if( action.equals("addItems"))
    {
        url = "/productManage.jsp";
        String name = req.getParameter("nameAdd");
        String img = req.getParameter("imageAdd");
       Integer quality = 0;
       try{
         quality =Integer.parseInt(req.getParameter("qualityAdd"));
       }
       catch(NumberFormatException nfe)
       {
        
        System.out.println("not a number"); 
       }

       Integer price = 0;
       try{
        price = Integer.parseInt(req.getParameter("PriceAdd"));
       }
       catch(NumberFormatException nfe)
       {
        
        System.out.println("not a long number"); 
       }
       String description = req.getParameter("DescriptionAdd");
       String kind = req.getParameter("KindAdd");
       String brand = req.getParameter("BrandAdd");

        Tree tree = new Tree();
        tree.setTreeBrand(brand);
        tree.setTreeDescription(description);
        tree.setTreeImg(img);
        tree.setTreeKind(kind);
        tree.setTreeName(name);
        Item item = new Item();
        item.setPrice(price);
        item.setQuality(quality);
        item.setTree(tree);

        if(TreeDAO.existTree(name,brand))
        {
            message = "This tree have already exist";
        }
        else
        {
            TreeDAO.addTree(tree);
            ItemDAO.addItem(item);
            message = "Input complete!!!";
            List<Item> listItems = new ArrayList<Item>();
            listItems = ItemDAO.SelectAllTheProduct();
            List<Tree> listTrees = new ArrayList<Tree>();
            listTrees = TreeDAO.SelectAllTree();
            req.setAttribute("listTrees", listTrees);
            req.setAttribute("listItems", listItems);
        }
        req.setAttribute("message", message);
        
    }


    getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void loadProduct()
    {
        
    }
}
