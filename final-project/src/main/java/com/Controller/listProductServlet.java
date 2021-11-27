package com.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import com.tree.Tree;
import com.tree.TreeDAO;
@WebServlet("/salingProduct")
public class listProductServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException
    {
        String action = req.getParameter("action");
        String url = "/product.jsp";
        List<Tree> listTrees = new ArrayList<Tree>();
        req.setAttribute("listTrees", listTrees);
            if(action == null)
            {
                action = "loadProduct";
            }
            if(action.equals("loadProduct"))
            {
                List<String> listKinds = TreeDAO.loadListTreeKinds();
                List<String>listBrands = TreeDAO.loadListTreeBrands();
                listTrees = TreeDAO.load12FirstTree();
                req.setAttribute("listBrands", listBrands);
                req.setAttribute("listKinds", listKinds);
                req.setAttribute("listTrees", listTrees);
                getServletContext().getRequestDispatcher(url).forward(req, resp);
            }
            else if(action.equals("loadMore"))
            {
                String numberTree = req.getParameter("exist");
                Integer itemStart = null;
                try
                {
                    itemStart = Integer.parseInt(numberTree);
                }
                catch(NumberFormatException nfe)
                {

                }
                listTrees = TreeDAO.load12NextTree(itemStart);
                PrintWriter out = resp.getWriter();
                for(Tree p : listTrees)
                {
                    
                    out.println(" <div class=\"products-board-container tree\">\n"
                        +" <div class=\"items-box\">\n"
                        +    "<a href=\"itemsDetail?itemId="+ p.getTreeid() +" \" class=\"img-item-container\">\n"
                        +        "<img src=\""+p.getTreeImg()+"\" class=\"item-img\">\n"
                        +    "</a>\n"
                        +    "<div class=\"items-box-content\">\n"
                        +        "<h1 class=\"items-name\">"+p.getTreeName()+"</h1>\n"
                        +        "<div class=\"items-box-bottom\">\n"
                        +            "<span class=\"item-price\">" + p.getPrice() + " $</span>\n"
                        +            "<a href=\"addToCart?itemId="+p.getTreeid() +"\" class=\"btn-add-container\">\n"
                        +                "<img src=\"./icon_web/cart-plus-solid.svg\" class=\"btn-add-cart-logo\">\n"
                        +            "</a>\n"
                        +        "</div>\n"
                        +    "</div>\n"
                        +"</div>\n"
                        +"</div>\n");
                    }
            }
            else if(action.equals("searchByName"))
            {
                String searchName = req.getParameter("searchName");
                List<Tree> listSearchByName = TreeDAO.searchTreeByName(searchName);
                PrintWriter out = resp.getWriter();
                for(Tree p: listSearchByName)
                {
                    out.println(
                        "<option value=\""+p.getTreeName()+"\">\n"
                    );
                }

            }

            else if (action.equals("searchItem"))
            {
                String searchName = req.getParameter("searchName");
                List<Tree> listSearchByName = TreeDAO.searchTreeByName(searchName);
                List<String> listKinds = TreeDAO.loadListTreeKinds();
                List<String>listBrands = TreeDAO.loadListTreeBrands();
                req.setAttribute("listTrees", listSearchByName);
                req.setAttribute("listBrands", listBrands);
                req.setAttribute("listKinds", listKinds);
                getServletContext().getRequestDispatcher(url).forward(req, resp);
            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
}
