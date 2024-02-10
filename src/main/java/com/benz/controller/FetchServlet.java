package com.benz.controller;

import java.io.IOException;
import java.util.List;

import com.benz.implementation.Implementation;
import com.serviet.encapsulatedclass.mcdBenz;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FetchServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
 public FetchServlet() {
	 super();
	  }
 protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("Get is triggered");
	 Implementation implementation=new Implementation();
	 List<mcdBenz>result=implementation.Fetch();
	 HttpSession session=request.getSession();
	 session.setAttribute("Details", result);
	 RequestDispatcher req = request.getRequestDispatcher("/Details.jsp");
	 req.forward(request, response); 
 }
}
