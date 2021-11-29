package com.Controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.user.*;

@WebServlet(urlPatterns = "/login")
public class loginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url = "/login.jsp";
		String action = req.getParameter("action");
		String message = "";
		if (action == null) {
			action = "join";
		}
		if (action.equals("join")) {
			url = "/login.jsp";
			String email = req.getParameter("email");
			String pass = req.getParameter("password");
			User user = new User();
			user.setEmail(email);
			user.setPass(pass);
			System.out.println(email);
			System.out.println(pass);

			if (UserDAO.emailExists(user.getEmail())) {
				if (UserDAO.checkLoginUser(email, pass)) {
					url = "/index.jsp";
					user = UserDAO.selectUser(email);
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(-1);
				} else {
					url = "/login.jsp";
					message = "Wrong email or password please try again";
				}
			} else {
				message = "Wrong email or password please try again";

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
