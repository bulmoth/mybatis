<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 목록 조회</h1>
	
	<table border="1">
		<tr>
			<td>제목</td>
			<td>내용</td>
			<td>작성일시</td>
			<td>삭제여부</td>
		</tr>
		
		<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.title}</td>
				<td>${b.content}</td>
				<td>${b.enrollDate}</td>
				<td>${b.deleteYn}</td>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>