package com.department.aul.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.department.aul.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/"}, name = "LoginServlet", description = "LoginServlet return Login Page.")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginService loginService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		this.loginService = new LoginService();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");

		boolean login = loginService.isLogin(userID, password);
		if (login) {
            HttpSession session = request.getSession();
            session.setAttribute("nama", "Aul");
            response.sendRedirect("student"); // Redirect to a welcome page.
        } else {
            response.sendRedirect("login.jsp?error=true"); // Redirect back to login with an error parameter.
        }
	}

}
