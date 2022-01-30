<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<core:if test="${not empty company}">
		Company ${company} successfully registered.
	</core:if>
	<core:if test="${empty company}">
		Company has not been registered.
	</core:if>
	<core:forEach var="i" begin="1" end="10" step="2">
	  ${i} <br />
	</core:forEach>
	
</body>
</html>