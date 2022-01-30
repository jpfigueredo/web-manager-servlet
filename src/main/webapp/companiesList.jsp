<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.webManagerServlet.servlet.Company" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Companies list: <br/>
	<ul>
		<core:forEach items="${companies}" var="companies">
			<li>
				${company.name} <fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy"/>
				<a href="/webmanagerServlet/showCompany?id=${company.id}">Edit</a>
				<a href="/webmanagerServlet/removeCompany?id=${company.id}">Remove</a>
			</li>
		</core:forEach>
	</ul>
		
</body>
</html>