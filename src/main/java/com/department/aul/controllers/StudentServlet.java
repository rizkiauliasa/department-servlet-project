package com.department.aul.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.department.aul.models.Data;
import com.department.aul.models.Student;
import com.department.aul.services.StudentService;
import com.google.gson.Gson;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(urlPatterns = { "/student " }, name = "StudentServlet", description = "StudentServlet return Welcome Page.")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		this.studentService = new StudentService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nama = (String) session.getAttribute("nama");

		if (nama != null) {
			request.setAttribute("nama", nama);

			String json = new Gson().toJson(studentService.getData());

			request.setAttribute("dataList", json);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("student.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
