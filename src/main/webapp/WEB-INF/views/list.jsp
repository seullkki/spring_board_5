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
			<td>��ȣ</td>
			<td>�̸�</td>
			<td>����</td>
			<td>��¥</td>			
			<td>��ȸ</td>
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
			<td colspan="5"><a href="writeView">�� �ۼ�</a></td>							
		</tr>
	</table>

</body>
</html>