<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie List</title>
</head>
<body>

<div style="text-align: right; padding: 10px;">
    <a href="/dashboard">Dashboard</a> |
    <a href="/logout">Logout</a>
</div>

<h1>Movie List</h1>
<c:choose>
    <c:when test="${empty movies}">
        <p>No movies found</p>
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>Movie ID</th>
                <th>Movie Name</th>
                <th>Movie Collection</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${movies}" var="movie">
                <tr>
                    <td>${movie.movieId}</td>
                    <td>${movie.movieName}</td>
                    <td>${movie.movieCollection}</td>
                    <td><a href="updateMovie?id=${movie.movieId}">Edit</a></td>
                    <td><a href="deleteMovie?id=${movie.movieId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
</body>
</html>
