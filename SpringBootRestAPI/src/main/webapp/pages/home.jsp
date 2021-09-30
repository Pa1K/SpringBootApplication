<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home Page JSP
<br>Welcome ${name}
<br>object details ${employee.id},${employee.name},${employee.tech}
<br>
	<form action="addEmployee">
		<input type="text" name="id"><br>
		<input type="text" name="name"><br>
		<input type="text" name="tech"><br>
		<input type="submit">
	</form>
	
	<h4>getEmployeeDetailsById</h4>
	<form action="getEmployee">
		<input type="text" name="id">
		<input type="submit">
	</form>
	
	<h4>updateEmployeeDetails</h4>
	<form action="updateEmployee">
		<input type="text" name="id">
		<input type="text" name="name">
		<input type="text" name="tech">
		<input type="submit">
	</form>
</body>
</html>