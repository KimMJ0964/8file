<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
@font-face {
    font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
    font-weight: bolder;
    font-style: normal;
  }
  @font-face {
    font-family: 'nanumL';
    src: url('font/NanumSquareRoundL.ttf');
    font-weight: normal;
    font-style: normal;
  }
  @font-face {
    font-family: 'nanumR';
    src: url('font/NanumSquareRoundR.ttf');
    font-weight: normal;
    font-style: normal;
  }
  @font-face {
    font-family: 'nanumB';
    src: url('font/NanumSquareRoundB.ttf');
    font-weight: normal;
    font-style: normal;
  }
  @font-face {
    font-family: 'nanumEB';
    src: url('font/NanumSquareRoundEB.ttf');
    font-weight: normal;
    font-style: normal;
  }
  
<!-- 공통 css -->
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
   display: flex;
    justify-content: center;
    background-color: #DFF0FF;
    
}

.nav-wrap{
    width: 1440px;
    background-color: #DFF0FF;
}

/*menubar*/
#navi ul, li, ol {
    list-style: none;
    padding: 0px;
    margin: 0px;
}

#navi a {
    text-decoration: none;
    color: black;
}


#navigator {
    margin-top: 20px;
    margin-left: 80px;
    width: 1280px;
    height: 90px;
       
    
}

#navi {
    border: solid none;
    background-color: white;
    height: 100%;
    border-radius: 30px;
    display: flex;
    justify-content: center;
    align-items: center;
}

#navi > li {
    float: left;
    width: 19%;
    text-align: center;
    height: 100%;
}

#navi  a {
    font-size: 24px;
    font-weight: 900;
    width: 100%;
    height: 100%;
    display: block;
    line-height: 36px;
}



#nav-menu1 {
    border: solid none;
    width: 55px;
    height: 55px;
    border-radius: 50%;
    background-color: #D9D9D9;
    margin-bottom: 55px;
    margin-right: 28px;
}

#nav-menu2 {
    border: solid none;
    width: 55px;
    height: 55px;
    border-radius: 50%;
    background-color: #D9D9D9;
    margin-bottom: 55px;
    margin-right: 28px;
}

.nav-content{
    margin-top: 60px;
}

#navi img{
    width: 100px;  
    height: auto;
    margin-top: 10px;
    margin-left:10px;
}

#navi a:hover {
    color: #868686;
    scale: 1.08;
}

#navi a.nav-logo{
    scale: none;
}

#navi>.nav-content>ul {
    display: none;
    padding: 15px 0;
    margin-top: -20px;
    margin-left: 40px;
}

#navi>.nav-content>ul a {
    font-size: 20px;
}

#navi>.nav-content>a:hover+ul {
    display: block;
    width: 160px;
    text-align: center;
    border: solid #FFC2E2;
    background-color: white;
    position: relative;
    z-index: 1;
    border-radius: 40px;

}


#navi>.nav-content>ul:hover {
    display: block;
    text-align: center;
    width: 160px;
    border: solid #FFC2E2;
    background-color: white;
    position: relative;
    z-index: 1;
    border-radius: 40px;
}
 .nav-wrap  hr{
	margin:15px;
    width: 80%;
}

</style>
</head>
<body>
    <div class="nav-wrap">
        <div id="navigator">
            <ul id="navi">
                <li><a href="<%= request.getContextPath() %>/index.jsp" class="nav-logo">
                <img src="<%=contextPath %>/views/common/img/logo_1.png" alt="로고" onclick href="<%= request.getContextPath() %>/index.jsp"></a></li>
            
                <li class="nav-content">
                    <a href="">명소찾기</a>
                    <ul>
                        <li><a href="">지역별</a></li>
                        <hr>
                        <li><a href="">테마별</a></li>
                    </ul>
                
                </li>
                <li class="nav-content">
                    <a href="">축제</a>
                    <ul>
                        <li><a href="<%=contextPath %>/views/festival-test/sub_test.jsp">MBTI</a></li>
                        <hr>
                        <li><a href="">계절별</a></li>
                        <hr>
                        <li><a href="">지역별</a></li>
                        <hr>
                        <li><a href="">테마별</a></li>
                    </ul>
                </li>
                <li class="nav-content">
                    <a href="">여행코스</a>
                </li>
                <li class="nav-content">
                    <a href="">커뮤니티</a>
                </li>

                <c:choose>
             <c:when test="${ empty loginUser }">
              <!-- 로그인전 -->
            <div id="nav-menu1" class="nav-content">
            <a href=""></a>
              <ul>
                       <li><a href='<%=contextPath %>/views/login/login.jsp'">로그인</a></li>
                        <hr>
                        <li><a href="">회원가입</a></li>
                    </ul>
                 </div>
                  </c:when>
              <c:otherwise>
              <!-- 로그인후 -->
              <div id="nav-menu2" class="nav-content">
              <a href=""></a>
                    <ul>
                        <li><a href="">마이페이지</a></li>
                        <hr>
                        <li><a href="">장바구니</a></li>
                        <hr>
                        <li><a href="<%=contextPath %>/logout.me">로그아웃</a></li>
                    </ul>
                </div>
                </c:otherwise>
                </c:choose>
            </ul>
        </div>
</body>
</html>