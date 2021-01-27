<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>									 
 	table, tr, td{
		border:1px solid black;
		border-collapse:collapse;
		border-width:3px;
	}
	
	table{
		width:600px;
	} 
</style>


</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>			
			<td>조회</td>
		</tr>
		
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId }</td>
				<td>${dto.bName }</td>
				<td>
					<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach> 								
					<a href="ContentView?bId=${dto.bId }">&nbsp;&nbsp;${dto.bTitle }</a>
				</td>														
				<td>${dto.bDate }</td>
				<td>${dto.bHit }</td>			
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"><a href="writeView">글 작성</a></td>							
		</tr>
	</table>

</body>
</html>