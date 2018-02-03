<%@page import="project.dto.Project"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

td{
	width: 500px;
	text-align: left;
}
</style>
<script>
	$(function(){
		$("a").eq(1).click(function(){
			var check = confirm("정말로 삭제하시겠습니까?");
			if(!check){
				return false;
			}
		})
	})
</script>
</head>
<body>
<jsp:include page="/WEB-INF/view/include/Header.jsp"></jsp:include>
	<div id="wrap">
		<div id="main">
			<table>
				<%
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					Project p = (Project) request.getAttribute("selectProject");
						out.print("<tr>");
						out.print("<th>프로젝트 이름</th>");
						out.print("<td>"+ p.getProjectName() + "</td>");
						out.print("</tr>");
						out.print("<tr>");
						out.print("<th>프로젝트 내용</th>");
						out.print("<td>"+ p.getProjectContent() + "</td>");
						out.print("</tr>");
						out.print("<tr>");
						out.print("<th>시작날짜</th>");
						out.print("<td>"+ date.format(p.getProjectStart()) + "</td>");
						out.print("</tr>");
						out.print("<tr>");
						out.print("<th>종료날짜</th>");
						out.print("<td>"+ date.format(p.getProjectEnd()) + "</td>");
						out.print("</tr>");
						out.print("<tr>");
						out.print("<th>종료날짜</th>");
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
					%>
			</table>
			<div>
				<a href="update.do?no=<%= p.getProjectNum() %>">[수정]</a>
				<a href="delete.do?no=<%= p.getProjectNum() %>">[삭제]</a>
				<a href="list.do">[돌아가기]</a>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/view/include/Footer.jsp"></jsp:include>
</body>
</html>