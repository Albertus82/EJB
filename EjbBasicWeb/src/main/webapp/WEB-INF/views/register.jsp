<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pagina di registrazione</title>
	</head>
	<body style="font-family: verdana, sans-serif;">
		<h1 style="text-align: center;">Registrazione</h1>

		<!-- Eventuali errori -->
		<c:if test="${not empty requestScope.errors}">
			<ul style="color:red; text-align:center; margin:1em;">
				<c:forEach items="${errors}" var="error">
					<li>${error.message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<form action="register" method="POST">
			<table style="margin: auto;" cellpadding="4">
				<tr>
					<td>Username*</td>
					<td><input type="text" name="username" value="${utente.username}" maxlength="50" /></td>
				</tr>
				<tr>
					<td>Password*</td>
					<td><input type="password" name="password" maxlength="50" /></td>
				</tr>
				<tr>
					<td>Nome*</td>
					<td><input type="text" name="nome"  value="${utente.nome}" maxlength="50" /></td>
				</tr>
				<tr>
					<td>Cognome*</td>
					<td><input type="text" name="cognome" value="${utente.cognome}" maxlength="50" /></td>
				</tr>
				<tr>
					<td>Data di nascita</td>
					<fmt:formatDate value="${utente.dataNascita}" var="dataNascita" type="date" pattern="dd/MM/yyyy" />
					<td><input type="text" name="dataNascita" value="${dataNascita}" maxlength="10" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="Conferma" style="width: 100%;" />
					</td>
				</tr>
			</table>
		</form>

	</body>
</html>
