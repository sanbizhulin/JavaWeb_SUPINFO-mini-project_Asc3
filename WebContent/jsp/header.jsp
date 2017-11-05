<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% boolean isConnected = false;
	if(request.getSession().getAttribute("username")!= null)
		isConnected = true;
%>
<a href="${pageContext.request.contextPath}/listProduct">List
	Product</a>
<c:choose>
	<c:when test="${empty sessionScope.username}">
		<a href="${pageContext.request.contextPath}/jsp/login.html">Login</a>
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/auth/basicInsert">Add Product</a>
		<a href="${pageContext.request.contextPath}/auth/addCategory">Add Category</a>
		<a href="${pageContext.request.contextPath}/logout">Logout</a>
	</c:otherwise>
</c:choose>

<br />