<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search by Movie Collection</title>
</head>
<body>
<h1>Search by Movie Collection</h1>
<form action="/search-collection" method="post">
    <label for="min">Minimum Collection:</label>
    <input type="number" id="min" name="min">
    <label for="max">Maximum Collection:</label>
    <input type="number" id="max" name="max">
    <input type="submit" value="Search">
</form>

<!-- Search results will be displayed below -->
<c:if test="${not empty movies}">
    <h2>Search Results:</h2>
    <table>
        <tr>
            <th>Movie ID</th>
            <th>Movie Name</th>
            <th>Movie Collection</th>
        </tr>
        <c:forEach items="${movies}" var="movie">
            <tr>
                <td>${movie.movieId}</td>
                <td>${movie.movieName}</td>
                <td>${movie.movieCollection}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${movieNotFound}">
    <div>
        <h1>No Match Found!!</h1>
    </div>
</c:if>

<div>
    <a href="/"><h1>Home</h1></a>
</div>

</body>
</html>
