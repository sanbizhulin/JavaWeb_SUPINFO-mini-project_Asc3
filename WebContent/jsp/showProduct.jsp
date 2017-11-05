<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product number <c:out value="${requestScope.product.name }"/></title>
<jsp:include page="/jsp/header.jsp" />
</head>
<body>
	<u>Product Id :${requestScope.product.id }</u> 
	<b> Product Name :</b>${requestScope.product.name }
	<i> Product category :</i>${requestScope.product.category.name }<br/>
	<i> Product price :</i>${requestScope.product.price }<br/>
	
	
<jsp:include page="/jsp/footer.jsp" />
</body>
</html>