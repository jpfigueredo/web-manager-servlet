<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<core:url value ="/alterCompany" var="linkServletNewCompany"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alter Company Form</title>
</head>
<body>
	<form action="${linkServletNewCompany}" method="post">
		Name: <input type="text" name="name" value="${company.name}" /> 
		Opening Date: <input type="text" name="data"  value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${company.id}">
		<input type="submit" />
	</form>
</body>
</html>