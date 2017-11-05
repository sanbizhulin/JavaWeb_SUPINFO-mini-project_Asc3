<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add Category</title>
<jsp:include page="/jsp/header.jsp" />
</head>
<body>
	<form name="input" method="post">
		Name: <input type="text" name="name">
		<input type="submit" value="Add Category">
	</form>
	
<jsp:include page="/jsp/footer.jsp" />
</body>


</html>