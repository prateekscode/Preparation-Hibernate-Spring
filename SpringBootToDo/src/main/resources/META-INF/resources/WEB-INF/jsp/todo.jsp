<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Add Todos Page</title>
</head>
<body>
	<div class="conatiner">
		<h1>Enter Your ToDo Details</h1>
		<form method="post">
		Description <input type="text" name="description" required="required">
		<input type="submit" class="btn btn-success">
		</form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
</body>
</html>