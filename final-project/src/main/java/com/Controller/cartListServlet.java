package com.Controller;

import java.io.IOException;
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
import com.user.User;
import com.item.Item;
import com.item.ItemDAO;
import com.tree.Tree;

@WebServlet("/Cartlist")
public class cartListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/Cart.jsp";
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		Cart cart = CartDAO.selectCartByUid(user.getId());
		List<Item> listItems = new ArrayList<Item>();
		listItems = ItemDAO.SelectAllUserProducts(cart.getId());
		List<Tree> listTrees = new ArrayList<Tree>();
		int i = 0;
		int total = 0;
		while (i < listItems.size()) {
			Tree tree = listItems.get(i).getTree();
			listTrees.add(tree);
			total += listItems.get(i).getQuality() * tree.getPrice();
			i += 1;
		}
		req.setAttribute("total", total);
		req.setAttribute("listTrees", listTrees);
		req.setAttribute("listItems", listItems);
		getServletContext().getRequestDispatcher(url).forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
