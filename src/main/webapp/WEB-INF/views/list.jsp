<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	
	#outter {
		display: block;
		width: 60%;
		margin: auto;
	}
</style>

<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="list?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
</script>


</head>
<body>

<div id="outter">
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> <!-- 옵션선택 끝 -->

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

	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="/board/list?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/board/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/board/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</div>

</body>
</html>