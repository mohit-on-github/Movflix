<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search by Movie ID</title>
</head>
<body>

<c:if test="${added}">
    <div>
        <h1>Movie added successfully!!</h1>
    </div>
</c:if>

<c:if test="${notAdded}">
    <div>
        <h1>Something went wrong!!</h1>
    </div>
</c:if>

<div >
    <a href="/dashboard"><h2>Dashboard</h2></a>
    <a href="/logout"><h2>Logout</h2></a>
</div>

</body>
</html>
