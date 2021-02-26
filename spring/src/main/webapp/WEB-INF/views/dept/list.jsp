<%@page import="emp.dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var="emp">
	${emp.first_name}
	${emp.last_name }
	${emp.salary }
	<fmt:formatDate value="${emp.hire_date }" pattern="yyyy-MM"/>
	<br> 
</c:forEach>

	<my:paging/>
	<my:login/>
	이름 : <%= ((ArrayList<EmpVO>)request.getAttribute("list")).get(0).getFirst_name() %>
	<hr>
	이름2 : ${requestScope.list[0].last_name }
	<hr>
	컨텍스트(어플이름) : ${pageContext.request.contextPath }
	<hr>
	<%= request.getHeader("User-Agent") %>
	<br>
	${header["User-Agent"] }
</body>
</html>