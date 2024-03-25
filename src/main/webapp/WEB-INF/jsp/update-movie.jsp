<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Movie Page</title>
</head>
<body>

<div style="text-align: right; padding: 10px;">
    <a href="/dashboard">Dashboard</a> |
    <a href="/logout">Logout</a>
</div>

<h1>Update Movie</h1>
<form action="/update" method="post">
    <label for="movieId">Movie ID:</label>
    <input type="text" id="movieId" name="movieId" value="${movie.movieId}" required readonly>
    <br>

    <label for="movieName">Enter Movie Name:</label>
    <input type="text" id="movieName" name="movieName"  value="${movie.movieName}" required>
    <br>

    <label for="movieCollection">Enter Movie Collection:</label>
    <input type="number" id="movieCollection" name="movieCollection" value="${movie.movieCollection}" min="50000" required>
    <br>

    <input type="submit" value="Update">
</form>
</body>
</html>
