package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tree.Tree;
import com.tree.TreeDAO;


@WebServlet("/home")
public class homeControlerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Tree> listTrees = new ArrayList<Tree>();
		listTrees = TreeDAO.loadFiveFirstTree();
		req.setAttribute("listTrees", listTrees);
		getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
