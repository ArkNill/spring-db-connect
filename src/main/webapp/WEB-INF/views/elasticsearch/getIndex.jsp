<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Elasticsearch 특정 인덱스 데이터 모두 불러오기</title>
</head>
<body>
<h2>Elasticsearch 특정 인덱스 데이터 모두 불러오기</h2>
<div>
	<c:forEach items="${result}" var="item">
		<li><c:out value="${item}"/></li>
	</c:forEach>
</div>
<a href="index.jsp">처음으로</a>
</body>
</html>