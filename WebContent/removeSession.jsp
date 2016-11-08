<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("user") != null){
		session.removeAttribute("user");
		response.sendRedirect("index.jsp");
		return;
	}
%>