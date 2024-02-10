package com.benz.controller;


import java.io.IOException;
import java.sql.SQLException;

import com.benz.implementation.Implementation;
import com.serviet.encapsulatedclass.mcdBenz;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MBenz extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public MBenz(){
		super();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("post method triggered");
				
		 String modelid = request.getParameter("modelid");
		 int frontendid =0;
		 try {
		 frontendid = Integer.parseInt(modelid);
		 }catch(Exception e) {
		 frontendid=0;
	}
		 String modelname=request.getParameter("modelname");
		 String fultype = request.getParameter("fultype");
		 int frontendfultype = 0;
		 try {
			 frontendfultype = Integer.parseInt(fultype);
		 }catch(Exception e) {
			 frontendfultype = 0;
		 }
			 String price = request.getParameter("price");
		 int frontendprice =0;
		 try {
		 frontendprice = Integer.parseInt(price);
		 }catch(Exception e) {
		 frontendprice=0;
	}
		 
			mcdBenz benz = new mcdBenz();
			benz.setModelid(frontendid);
			benz.setModelname(modelname);
			benz.setFultype(frontendfultype);
			benz.setPrice(frontendprice);
		 
		 Implementation imp = new Implementation();
		int result = 0;
		result = imp.Insertmethod(benz);
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("MercedesInsert", benz);
		 
		 RequestDispatcher success = request.getRequestDispatcher("/success.html");
		 RequestDispatcher failed = request.getRequestDispatcher("failure.html");
		 
		 if(result>0) {
			 success.forward(request, response);
			 
		 }
		 else {
			 failed.forward(request, response);
		 }
	}
		 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			 System.out.println("Get method triggered");
					
			 String modelid = request.getParameter("modelid");
			 int frontendid =0;
			 try {
			 frontendid = Integer.parseInt(modelid);
			 }catch(Exception e) {
			 frontendid=0;
			 }
			 mcdBenz b = new mcdBenz();
			 b.setModelid(frontendid);
			 Implementation imp=new Implementation();
		        mcdBenz entity=imp.Search(frontendid);
				HttpSession session=request.getSession();
				session.setAttribute("carobject", entity);
				RequestDispatcher success=request.getRequestDispatcher("/Carservlet");
				RequestDispatcher failed=request.getRequestDispatcher("/Failure.html");
				if(entity!=null) {
					success.forward(request, response);
				}
				else {
					failed.forward(request, response);
				}
			 
		 }}
			 
			 
			 
			


