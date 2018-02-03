<%@page import="project.dto.Project"%>
<%@page import="project.dto.ProjectIng"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/basic.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
div#wrap{
	width: 90%;
	margin: 0 auto;

}

div#main{
	margin: 0 auto;
	text-align: center;
	min-height: 300px !important;
}

table {
	border-collapse: collapse;
	text-align: center;
	margin: 10% auto 0;
	
}

th, tr, td {
	border: 1px solid black;
	width: 150px;
}

</style>
</head>
<body>
	<c:if test="${param.insertResult != null }">
		<script>
			alert("프로젝트를 추가하였습니다.");
		</script>
	</c:if>
	
	<c:if test="${param.delteReulst != null }">
		<script>
			alert("프로젝트를 삭제하였습니다.");
		</script>
	</c:if>
	
	<c:if test="${param.updateResult != null }">
		<script>
			alert("프로젝트를 수정하였습니다.");
		</script>
	</c:if>
		
	<jsp:include page="/WEB-INF/view/include/Header.jsp"></jsp:include>
	<div id="wrap">
		<div id="main">
			<c:if test="${ProjectList != null }">
				<table>
					<caption><a href="write.do">새 프로젝트 등록</a></caption>
					
					<tr>
						<th>프로젝트 이름</th>
						<th>시작날짜</th>
						<th>종료날짜</th>
						<th>상태</th>
					</tr>
	
	
					<%
						SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
							List<Project> list = (List<Project>) request.getAttribute("ProjectList");
	
							for (Project p : list) {
								out.print("<tr>");
								out.print("<td><a href='read.do?no="+ p.getProjectNum() + "'>" + p.getProjectName() + "</a></td>");
								out.print("<td>" + date.format(p.getProjectStart()) + "</td>");
								out.print("<td>" + date.format(p.getProjectEnd()) + "</td>");
	
								switch (p.getProjectIng()) {
								case READY:
									out.print("<td>준비</td>");
									break;
								case ING:
									out.print("<td>진행</td>");
									break;
								case END:
									out.print("<td>종료</td>");
									break;
								case HOLD:
									out.print("<td>보류</td>");
									break;
	
								}
	
								out.print("</tr>");
							}
					%>
				</table>
			</c:if>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/include/Footer.jsp"></jsp:include>
</body>
</html>