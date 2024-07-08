<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adherent Form</title>
</head>
<body>
    <h1>${adherent == null ? "Add New Adherent" : "Edit Adherent"}</h1>
    <form action="AdherentServlet?action=${adherent == null ? 'insert' : 'update'}" method="post">
        <c:if test="${adherent != null}">
            <input type="hidden" name="idAdherent" value="${adherent.idAdherent}" />
        </c:if>
        <div>
            <label for="emailetudiant">Email:</label>
            <input type="text" name="emailetudiant" value="${adherent != null ? adherent.emailetudiant : ''}" required />
        </div>
        <div>
            <label for="numerocarteetudiant">Numero Carte Etudiant:</label>
            <input type="text" name="numerocarteetudiant" value="${adherent != null ? adherent.numerocarteetudiant : ''}" required />
        </div>
        <div>
            <input type="submit" value="${adherent == null ? 'Add' : 'Update'}" />
            <a href="AdherentServlet?action=list">Cancel</a>
        </div>
    </form>
</body>
</html>
