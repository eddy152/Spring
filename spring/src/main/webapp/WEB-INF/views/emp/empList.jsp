<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>FIRST_NAME</th>
			<th>LAST_NAME</th>
			<th>EMAIL</th>
			<th>SALARY</th>
		</tr>
		<c:forEach items="${list }" var="emp">
			<tr>
				<td>${emp.first_name }</td>
				<td>${emp.last_name }</td>
				<td>${emp.email }</td>
				<td>${emp.salary }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>