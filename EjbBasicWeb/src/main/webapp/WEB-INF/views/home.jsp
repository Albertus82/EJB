<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home Page</title>
	</head>
	<body style="font-family: verdana, sans-serif;">
		<h1>
			Benvenuto ${utente.nome}!
		</h1>
		
		<c:if test="${not empty sessionScope.utente}">
			<h3>
				Utente &quot;${sessionScope.utente.username}&quot; in sessione:
			</h3>
			<ul style="line-height: 175%;">
				<li>Username: <strong>${sessionScope.utente.username}</strong></li>
				<li>Nome: <strong>${sessionScope.utente.nome}</strong></li>
				<li>Cognome: <strong>${sessionScope.utente.cognome}</strong></li>
				<fmt:formatDate value="${sessionScope.utente.dataNascita}" var="dataNascita" type="date" pattern="dd/MM/yyyy" />
				<li>Data di nascita: <strong>${not empty dataNascita ? dataNascita : "n.d."}</strong></li>
			</ul>
		</c:if>

		<form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form>

	</body>
</html>
