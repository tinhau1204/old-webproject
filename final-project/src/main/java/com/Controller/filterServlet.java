package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tree.Tree;
import com.tree.TreeDAO;

@WebServlet("/filter")
public class filterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String brand = req.getParameter("brand");
        String filter = "filtering";
        String url = "/product.jsp";
        String queryString = "FROM Tree t WHERE";
        List<String> listKinds = TreeDAO.loadListTreeKinds();
        List<String>listBrands = TreeDAO.loadListTreeBrands();
        if(type.equals("All") && brand.equals("All"))
        {
            url = "/salingProduct?action=loadProduct";
        }
        else
        {

            if(!type.equals("All"))
            {
                queryString += " t.kind = '" + type +"'";
            }
            if(!type.equals("All") && !brand.equals("All"))
            {
                queryString += " AND ";
            }
            if(!brand.equals("All"))
            {
                queryString += " t.brand = '" + brand + "'";
            }
            List<Tree> listTrees = TreeDAO.selectTreeByFilter(queryString);
            req.setAttribute("listTrees", listTrees);
            req.setAttribute("listBrands", listBrands);
            req.setAttribute("listKinds", listKinds);
            req.setAttribute("filtering", filter);
        }
    getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
