<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
      <%@ page import="java.util.*" %>
      <%@ page import="com.serviet.encapsulatedclass.mcdBenz" %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
body{
background-image: url("https://plus.unsplash.com/premium_photo-1672005478867-fdc78c10a900?q=80&w=1854&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3Dzd");
 background-repeat: no-repeat;
  background-position: center;
  background-size:100% 100%;
  background-attachment:fixed;
  background-color:black;
  color:white;
}
  table,th,td{
border:1px solid black;
color:black;
padding:10px;
}
 </style>
<h2> the car details</h2>
<table style="50%" align="center">
<%
Object obj=session.getAttribute("Details");
if(obj==null){
	out.print("No records found");
}else{
	List<mcdBenz>entity=(ArrayList<mcdBenz>)obj;
%>	
	<tr>
	<tr><th>modelid:</th><th>modelname :</th><th>fultype :</th><th>price :</th></tr>
	<%
	for(mcdBenz m:entity){
		%>
		<tr> 
		<td><%=m.getModelid() %></td>
		<td><%=m.getModelname() %></td>
		<td><%=m.getFultype() %></td>
		<td><%=m.getPrice() %></td>
<td><img src="https://fastly-production.24c.in/hello-ar/dev/uploads/65bce7c45dd7d86edebe6e23/41537ea5-0427-45b7-b944-4eb9ffbf4f52/slot/10027085755-d98f1dbdcfc14e4fa531c5bbeb73a4ed-Exterior-7.jpg?w=500&auto=format" width="75"/></td>
		</tr>
	<% }}%>

<tr><td><button>
			<a href="index.html">Back To Home Page</a>
		</button> </td></tr> 
		</table>
</body>
</html>