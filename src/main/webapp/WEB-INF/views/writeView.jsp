<%@ page language="java" contentType="text/html; charset=UTF-8"		
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>									 
 	table, tr, td{											/* 한글 깨져서 UTF-8로 바꿈 */
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
	<form action="write">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName"></td>
			</tr>

			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle"></td>		
			</tr>
			
			<tr>
				<td>내용</td>
				<td><input type="text" name="bContent"></td>		
			</tr>			
		
			<tr>
				<td colspan="5">
					<input type="button" value="글 작성 완료">  <!-- submit ? -->
					<a href="list">목록 보기</a>				
				</td>								
			</tr>
	</table>
	</form>
</body>
</html>