<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
	<form action="modify.do" method="post">
	<input type="hidden" name="bId" value="${content_view.bId}">			<!-- Q. NumberFormatException: For input string: "bId" ���� �߻� -->	
		<table>
			<tr>
				<td>��ȣ</td>
				<td>${content_view.bId}</td>
			</tr>
			
			<tr>
				<td>��Ʈ</td>
				<td>${content_view.bHit}</td>
			</tr>					
		
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bName" value="${content_view.bName}" /></td>
			</tr>
			
			<tr>
				<td>����</td>
				<td><input type="text" name="bTitle" value="${content_view.bTitle}"/></td>
			</tr>
			
			<tr>
				<td>����</td>
				<td><textarea name="bContent" rows="50" cols="30">${content_view.bContent}</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="����" />
					&nbsp;<a href="list.do">��� ����</a>
					&nbsp;<a href="delete.do?bId=${content_view.bId}">����</a>
					&nbsp;<a href="reply_view.do?bId=${content_view.bId}">�亯</a>
				</td>
			</tr>		
		</table>
	</form>
</body>
</html>