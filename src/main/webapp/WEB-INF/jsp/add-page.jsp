<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Movie Page</title>
</head>
<body>

<div style="text-align: right; padding: 10px;">
    <a href="/dashboard">Dashboard</a> |
    <a href="/logout">Logout</a>
</div>

<h1>Add Movie</h1>
<form action="/add-movie" method="post">
    <label for="movieId">Enter Movie ID:</label>
    <input type="text" id="movieId" name="movieId" placeholder="Enter in the format M001" required>
    <br>

    <label for="movieName">Enter Movie Name:</label>
    <input type="text" id="movieName" name="movieName" required>
    <br>

    <label for="movieCollection">Enter Movie Collection:</label>
    <input type="number" id="movieCollection" name="movieCollection"  min="50000" required>
    <br>

    <input type="submit" value="Add">
</form>
</body>
</html>
