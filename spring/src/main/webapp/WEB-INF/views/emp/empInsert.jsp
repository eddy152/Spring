<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function () {
		$("#btn").on("click", function () {
			window.open('empSearch', '사원검색', 'width=700px,height=800px,scrollbars=yes');		
		});
		
		$("#btnEmail").on("click", function () {
			$.ajax({
				url : "emailCheck",
				data : "email=" + $("input[name=email]").val(),
				success : function (result) {
					/*//JSON
					if(result.email == true) {
						$("#emailResult").html("<font color='blue'>사용가능</font>");
					} else {
						$("#emailResult").html("<font color='blue'>사용 불가능</font>");
						$("input[name=email]").val("");
					}
					*/
					//XML
					$("#emailResult").html($(result).find("email").text());
				},
		        dataType : "xml"
			});
		});
	});
</script>
</head>
<body>
	<h3 id="top">사원등록</h3>
	<c:set var="url" value="empInsert"></c:set>
	<c:if test="${not empty empVO.employee_id }">
	<c:set var="url" value="empUpdate"></c:set>
	</c:if>
	<form action="${url }" method="post" name="frm">
		employee_id 
		<input type="number" name="employee_id"
			<c:if test="${not empty empVO.employee_id }">readonly="readonly"</c:if>><br>
		first_name
		<input name="first_name" value="${empVO.first_name }"><br>
		last_name
		<input name="last_name" value="${empVO.last_name }"><br>
		email
		<input type="email" name="email" value="${empVO.email }">
		<button type="button" id="btnEmail">중복체크</button>
		<span id="emailResult"></span><br>
		phone_number
		<input type="text" name="phone_number" value="${empVO.phone_number }"><br>
		hire_date
		<input type="date" name="hire_date" value="${empVO.hire_date }"><br>
		job_id
		<select name="job_id">
		    <option value="">직업선택</option>
		    <c:forEach items="${jobList }" var="job">
		    	<option value="${job.job_id }">${job.job_title }</option>
		    </c:forEach>
		</select><br>
		department_id 
		<c:forEach items="${deptList }" var="dept">
			<input type="radio" name="department_id" value="${dept.department_id }"
				<c:if test="${dept.department_id == empVO.department_id }">checked="checked"</c:if>>
				${dept.department_name }
		</c:forEach><br>
		manager_id
		<input type="radio" name="mng_id" value=""
			<c:if test="${empVO.manager_id eq null}">checked="checked"</c:if>>None
		<c:forEach items="${deptList }" var="dept">
			<c:if test="${dept.manager_id ne 0}">
				<input type="radio" name="mng_id" value="${dept.manager_id }">
				${dept.manager_id }
			</c:if>
		</c:forEach><br>
		<input type="text" name="manager_id">
		<input type="text" name="name">
		<button type="button" id="btn">사원검색</button><br>	
		<button type="submit">등록</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>
