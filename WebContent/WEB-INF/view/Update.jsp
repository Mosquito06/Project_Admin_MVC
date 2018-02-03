<%@page import="java.text.SimpleDateFormat"%>
<%@page import="project.dto.Project"%>
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
div#main{
	margin: 30px auto;
	min-height: 300px !important;
	width: 30%;
	padding: 10px;
}

div#main input[type='submit']{
	margin-top: 30px;
	background-color: #6799FF;
	color: white;
}

div#main input[value='저장']{
	margin-left: 150px;
}

label{
	margin-top: 10px;
	float: left;
	width: 150px;
}

input, textarea, select{
	margin-top: 10px;
}


</style>
</head>
<body>
<jsp:include page="/WEB-INF/view/include/Header.jsp"></jsp:include>
	<div id="wrap">
		<div id="main">
			<form action="update.do?no=${selectProject.projectNum }" method="post">
				<label>프로젝트 이름</label>
				<input type="text" name="title" value="${selectProject.projectName }"><br>
				<label>프로젝트 내용</label>
				<textarea rows="10" cols="40" name="content">${selectProject.projectContent }</textarea><br>
				
				<%
					Project project = (Project) request.getAttribute("selectProject");
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					out.print("<label>시작날짜</label>");
					out.print("<input type='date' name='sDate' value='" + date.format(project.getProjectStart()) +"'><br>");
					out.print("<label>종료날짜</label>");
					out.print("<input type='date' name='eDate' value='" + date.format(project.getProjectEnd()) +"'><br>");
											
				%>

				<label>상태</label>
				<select name="status">
									
					<option>준비</option>
					<option>진행중</option>
					<option>종료</option>
					<option>보류</option>
				</select><br>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/include/Footer.jsp"></jsp:include>
</body>
</html>