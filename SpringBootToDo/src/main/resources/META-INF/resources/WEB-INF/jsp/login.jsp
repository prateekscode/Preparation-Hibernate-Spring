<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Login</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to login page!</h1>
		<form method="post">
			<pre>${errorMsg}</pre>
			Enter your name:<input type="text" name="name"> Enter your
			password:<input type="password" name="password"> <input
				type="submit">
		</form>
	</div>
</body>
</html>