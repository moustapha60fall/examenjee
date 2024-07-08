<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>List of Adherents</title>
</head>
<body>
    <h1>List of Adherents</h1>
    <a href="AdherentServlet?action=new">Add New Adherent</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="adherent" items="${listAdherent}">
                <tr>
                    <td>${adherent.idAdherent}</td>
                    <td>${adherent.emailetudiant}</td>
                    <td>
                        <a href="AdherentServlet?action=edit&id=${adherent.idAdherent}">Edit</a>
                        <a href="AdherentServlet?action=delete&id=${adherent.idAdherent}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
