<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<div class="container">
		<div>Welcome ${name}!</div>
		<hr>
		<div>Your name is => ${name}</div>
		<div>
			<a href="list-todos">Manage</a> your todos.
		</div>
	</div>
</body>
</html>