<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<core:url value ="/newCompany" var="linkServletNewCompany"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Company Form</title>
</head>
<body>
	<!-- 
		POST method hides parameters 
		If not defined, method="get"
	-->
	<form action="${linkServletNewCompany}" method="POST">
		Name: <input type="text" name="name" /> 
		Opening Date: <input type="text" name="date" /> 
		<input type="submit" />
	</form>
</body>
</html>