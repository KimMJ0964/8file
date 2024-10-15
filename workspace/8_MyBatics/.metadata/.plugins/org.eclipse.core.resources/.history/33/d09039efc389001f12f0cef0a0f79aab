<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3643b6hh5b"></script>
<link rel="stylesheet"
	href="<%=contextPath%>/views/course/css/sub_course_detail.css?after">
<link rel="stylesheet"
	href="<%=contextPath%>/views/course/css/index.css?after">
	
</head>
<body>
<jsp:include page="/views/common/menubar.jsp" />
<br><br><br><br><br><br>
	<div class="info-con">
		<div id="map-con">
			<p>코스 이름</p>
			<div id="map"></div>
		</div>
		<div id="course-info">
			<div id="course_line1"></div>
			<ul>
				<c:forEach var="course" items="${courseList}">
            <li>
                <div class="dot-con first-dot">
                    <div class="dot"></div>

                    <!-- TOUR_NAME 또는 FS_NAME 출력 -->
                    <p class="click">
                        <c:choose>
                            <c:when test="${course.tourName != null}">
                                ${course.tourName} <!-- TOUR_NAME 출력 -->
                            </c:when>
                            <c:when test="${course.fsName != null}">
                                ${course.fsName} <!-- FS_NAME 출력 -->
                            </c:when>
                        </c:choose>
                    </p>

                    <!-- 이미지 출력 -->
                    <div class="text-desc">
                        <c:choose>
                            <c:when test="${course.tourImg != null}">
                                <img src="<%=contextPath%>/resource/tourThumb/${course.tourImg}" alt="Tour Image" style="width: 200px;"/>
                            </c:when>
                            <c:when test="${course.fsImg != null}">
                                <img src="<%=contextPath%>/resource/festival/${course.fsImg}" alt="Festival Image" style="height: 200px;"/>
                            </c:when>
                        </c:choose>
                    </div>

                    <!-- 위도와 경도 출력 -->
                    <p>Latitude: 
                        <c:choose>
                            <c:when test="${course.tourLat != 0.0}">
                                ${course.tourLat} <!-- TOUR_LAT 출력 -->
                            </c:when>
                            <c:when test="${course.fsLat != 0.0}">
                                ${course.fsLat} <!-- FS_LAT 출력 -->
                            </c:when>
                        </c:choose>
                    </p>

                    <p>Longitude: 
                        <c:choose>
                            <c:when test="${course.tourLong != 0.0}">
                                ${course.tourLong} <!-- TOUR_LONG 출력 -->
                            </c:when>
                            <c:when test="${course.fsLong != 0.0}">
                                ${course.fsLong} <!-- FS_LONG 출력 -->
                            </c:when>
                        </c:choose>
                    </p>
                </div>
            </li>
        </c:forEach>


				<!--    <li>
                    <div class="dot-con">
                        <div class="dot first-dot"></div>
                        <p class="click">웨스턴 라이프 호텔</p>
                        <div class="text-desc">
                            <img src="<%=contextPath%>/views/sub_course/img/museum.png">
                        </div>
                    </div>
                </li> -->
			</ul>
		</div>
	</div>
	<div id="like-btn">
		<button>+ 관심등록 하기</button>
	</div>
<br><br><br><br><br><br>
<jsp:include page="/views/common/footer.jsp" />

	<script>
	var map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(37.5665, 126.9780),  // 초기 좌표 (서울)
        zoom: 15
    });

    var markers = []; // 마커 배열
    var coordinates = []; // 좌표 배열

    // JSP에서 전달된 위도와 경도를 반복하여 마커와 폴리라인 좌표 추가
    <c:forEach var="course" items="${courseList}" varStatus="status">
        <c:choose>
            <c:when test="${course.tourLat != 0.0}">
                var marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(${course.tourLat}, ${course.tourLong}),
                    map: map,
                    label: {
                        content: String(${status.index + 1}), // 숫자 표시
                        color: '#000', // 텍스트 색상
                        fontSize: '14px', // 텍스트 크기
                        backgroundColor: '#fff', // 배경색
                        borderRadius: '50%', // 둥근 배경
                        padding: '4px' // 패딩
                    }
                });
                markers.push(marker);  // 마커 저장
                coordinates.push(new naver.maps.LatLng(${course.tourLat}, ${course.tourLong}));  // 좌표 저장
            </c:when>
            <c:when test="${course.fsLat != 0.0}">
                var marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(${course.fsLat}, ${course.fsLong}),
                    map: map,
                    label: {
                        content: String(${status.index + 1}), // 숫자 표시
                        color: '#000', // 텍스트 색상
                        fontSize: '14px', // 텍스트 크기
                        backgroundColor: '#fff', // 배경색
                        borderRadius: '50%', // 둥근 배경
                        padding: '4px' // 패딩
                    }
                });
                markers.push(marker);  // 마커 저장
                coordinates.push(new naver.maps.LatLng(${course.fsLat}, ${course.fsLong}));  // 좌표 저장
            </c:when>
        </c:choose>
    </c:forEach>

    // 마커를 이어주는 폴리라인 추가
    var polyline = new naver.maps.Polyline({
        path: coordinates, // 좌표 배열을 경로로 설정
        strokeColor: '#5347AA', // 선 색깔
        strokeWeight: 3, // 선 두께
        map: map
    });

    // 지도 중심을 첫번째 마커로 설정
    if (markers.length > 0) {
        map.setCenter(markers[0].getPosition());
    }
	</script>
</body>
</html>