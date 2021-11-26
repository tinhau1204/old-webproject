package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tree.Tree;
import com.tree.TreeDAO;

@WebServlet(name = "moreProduct", urlPatterns = "/moreProduct")
public class loadMoreProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tree> listTrees = new ArrayList<Tree>();
        listTrees = TreeDAO.SelectAllTree();
        req.setAttribute("listTrees", listTrees);
        PrintWriter out = resp.getWriter();
        for(Tree p : listTrees)
        {
                out.println(" <div class=\"products-board-container\">\n"
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
