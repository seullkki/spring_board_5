<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, td{
		border:1px solid black;
	}
	
	table{
		width:500px;
	}
</style>
</head>
<body>
	<form action="reply">
	<input type="hidden" name="bId" value="${reply_view.bId}">	
	<input type="hidden" name="bGroup" value="${reply_view.bGroup}">	
	<input type="hidden" name="bStep" value="${reply_view.bStep}">
	<input type="hidden" name="bIndent" value="${reply_view.bIndent}">		
		<table>
			<tr>
				<td>번호</td>
				<td>${reply_view.bId}</td>
			</tr>
			
 			<tr>
				<td>히트</td>
				<td>${reply_view.bHit}</td>
			</tr> 				
		
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value="${reply_view.bName}" /></td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${reply_view.bTitle}"/></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea name="bContent" rows="50" cols="30">${reply_view.bContent}</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="답변 완료" />
					&nbsp;<a href="list">목록 보기</a>
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>