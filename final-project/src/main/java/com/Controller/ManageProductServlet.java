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
        List<Tree> listTrees = new ArrayList<Tree>();
        listTrees = TreeDAO.SelectAllTree();
        req.setAttribute("listTrees", listTrees);
       
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
        tree.setTreeName(name);
        tree.setTreeKind(kind);
        tree.setTreeBrand(brand);
        tree.setTreeImg(img);
        tree.setTreeDescription(description);
        tree.setPrice(price);
        tree.setAmount(quality);

        if(TreeDAO.existTree(name,brand))
        {
            message = "This tree have already exist";
        }
        else
        {
            TreeDAO.addTree(tree);
            message = "Input complete!!!";
            List<Tree> listTrees = new ArrayList<Tree>();
            listTrees = TreeDAO.SelectAllTree();
            req.setAttribute("listTrees", listTrees);
        }
        req.setAttribute("message", message);
        
    }


    getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
