<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>List Todos Page</title>
</head>
<body>
<div class="conatiner">
	<h1>Your ToDos are</h1>
	<table class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetdate}</td>
					<td>${todo.done}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
			<a href="add-todo" class="btn btn-success">Add</a> your todos.

	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"
		type="text/javascript"></script>
</body>
</html>