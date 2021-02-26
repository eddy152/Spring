<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		$(".btn").on("click", function () {
			var mngId = $(this).parent().find("span").first().text();
			var firstName = $(this).parent().find("span").eq(1).text();
			$(opener.document).find('[name=manager_id]').val(mngId);
			$(opener.document).find('[name=name]').val(firstName);
			window.close();
		})
	})
</script>
</head>
<body>
	<c:forEach items="${empList }" var="emp">
		<div class="row">
			사번 : <span>${emp.employee_id }</span> 
			/ 이름 : <span>${emp.first_name }</span> 
			/ 부서 : <span>${emp.job_id }</span> 
			<button type="button" class="btn">선택</button><p>
		</div>
	</c:forEach>
	<br>
</body>
</html>