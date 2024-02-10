package com.benz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.serviet.encapsulatedclass.mcdBenz;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Carservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public Carservlet() {
		super();
	}
	protected void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("carobject");

		mcdBenz car = null;
		if(obj!=null) {
			car = (mcdBenz) obj;
		}
		PrintWriter out = response.getWriter();
		out.print("<html><body><table>");
		out.print("<tr><th>modelid:</th><th>modelname :</th><th>fultype :</th><th>price :</th></tr>");
		out.print("<td>"+car.getModelid()+"</td>");
		out.print("<td>"+car.getModelname()+"</td>");
		out.print("<td>"+car.getFultype()+"</td>");
		out.print("<td>"+car.getPrice()+"</td></tr>");   
		out.print("<tr><td><button><a href = 'index.html'>Back To Home Page</a></button>");
		out.print("</table></body></html>");

	}

}
