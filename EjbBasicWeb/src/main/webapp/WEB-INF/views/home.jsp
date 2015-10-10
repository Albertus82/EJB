<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home Page</title>
	</head>
	<body>
		<h1>
			Benvenuto ${utente.nome}!
		</h1>
		
		<c:if test="${not empty sessionScope.utente}">
			<h2>
				Utente ${sessionScope.utente.nome}: sei in sessione!
			</h2>
		</c:if>
		
		<form action="logout" method="POST">
			<input type="submit" value="Logout" />
		</form>
		
	</body>
</html>
