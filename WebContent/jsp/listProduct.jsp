<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<jsp:include page="/jsp/header.jsp" />
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Content</th>
			<th>Price</th>
			<c:if test="${not empty sessionScope.username}">
				<th>Remove</th>
			</c:if>
		</tr>
		<c:choose>
			<c:when test="${empty requestScope.products}">
				There is no product yet !
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.products}" var="product">
					<tr>
						<td><c:out value="${product.name}" /></td>
						<td><c:out value="${product.content}" /></td>
						<td><c:out value="${product.price}" /></td>
						<c:if test="${not empty sessionScope.username}">
							<td>
							<a href="${pageContext.request.contextPath}/auth/removeProduct?id=${product.id}">Remove</a>
							</td>
						</c:if>

					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>
	<jsp:include page="/jsp/footer.jsp" />
</body>
</html>