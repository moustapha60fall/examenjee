<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Adhérents</title>
</head>
<body>
    <h1>Liste des Adhérents</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="adherent" items="${listAdherent}">
            <tr>
                <td>${adherent.id}</td>
                <td>${adherent.emailetudiant}</td>
                <td>
                    <a href="adherent?action=edit&id=${adherent.id}">Modifier</a>
                    <a href="adherent?action=delete&id=${adherent.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="AdherentServlet?action=new">Ajouter un nouvel adhérent</a>
    
</body>
</html>
