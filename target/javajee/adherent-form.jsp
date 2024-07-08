<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adherent Form</title>
</head>
<body>
<form action="AdherentServlet?action=insert" method="post">
    <input type="hidden" name="id" value="${adherent.idAdherent}" />
    <label>Email:</label>
    <input type="text" name="emailetudiant" value="${adherent.emailetudiant}" />
    <label>Carte:</label>
    <input type="text" name="numerocarteetudiant" value="${adherent.numerocarteetudiant}" />
    <input type="submit" value="Update" />
</form>

    <a href="AdherentServlet?action=list">Back to List</a>
</body>
</html>
