<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
<link rel="stylesheet" href="./css/searchIdResult.css">
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" /> 
    <div class="container">
            <img src="<%=contextPath %>/views/login/img/logo_1.png" alt="로고">
            <h1>당신의 아이디는</h1><br>
            <input type="text" placeholder="${searchId}" name="email" readonly><p>입니다.</p>
            <button><a onclick="location.href='views/login/login.jsp'">로그인 하기</a></button>
    </div>
</body>
</html>