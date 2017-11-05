<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<jsp:include page="/jsp/header.jsp" />
</head>
<body>
	<form name="input" method="post">
		Name: <input type="text" name="name"> <br>
		Content: <input type="text" name="content"> <br>
		Price: <input type="text" name="price"> <br>
		Category: <select id="category" name="category">
                    <c:forEach items="${categories}" var="catategory">
                        <option value="${catategory.id}">
                            <c:out value="${catategory.name}"/>
                        </option>
                    </c:forEach>
                </select>
		<input type="submit" value="Add Product">
	</form>
	
<jsp:include page="/jsp/footer.jsp" />
</body>
</html>