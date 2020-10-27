<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostgreSQL 특정 컬렉션 가져오기</title>
</head>
<body>
<h2>PostgreSQL 특정 컬렉션 가져오기</h2><br/>
	<c:forEach items="${result}" var="item">
		<li>${item}</li>
	</c:forEach>
<a href="index.jsp">처음으로</a>
</body>
</html>