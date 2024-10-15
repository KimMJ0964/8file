<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관광지 세부페이지</title>
<link rel="stylesheet"
	href="./views/sub2_TF/css/TourFestivalDetail.css?after">
<script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=3643b6hh5b"></script>
<style>
#map {
	width: 750px;
	height: 400px;
	border: 5px solid #6FBAFF;
	border-radius: 10px;
}

 body {
 	margin 0;
 	overflow-x: hidden;
 }
 
 .btn-interest {
            background-color: #87CEEB; /* 하늘색 */
            color: white;
            border: none; /* 테두리 없음 */
            border-radius: 25px; /* 둥근 모서리 */
            padding: 10px 20px; /* 버튼 안쪽 여백 */
            font-size: 16px;
            cursor: pointer;
        }

        .btn-interest:hover {
            background-color: #00BFFF; /* 마우스 오버 시 더 진한 하늘색 */
        }
</style>
</head>
<body>
    <jsp:include page="/views/common/menubar.jsp" />
    <div class="container">
        <div class="banner">
            <img src="./resource/tour/${t.tourThumbnail}" alt="Tour Thumbnail">
        </div>

        <div class="second-content">
            <img src="./resource/tourThumb/${t.tourImg}" alt="${t.tourName} Image"> 
            <span>
                <h3>${t.tourName}</h3>
                <p>${t.tourArea}</p>
                <h4>#${t.tourTema}</h4>
                <br>
                <h4>#${t.tourSeason}</h4>
            </span>
        </div>
        
        <!-- 관심등록 버튼 추가 -->
        <div class="interest-button" align="center">
            <form action="tourInterested.ft" method="post">
                <input type="hidden" name="tourNo" value="${t.tourNo}" />
                <button type="submit" class="btn-interest">관심등록</button>
            </form>
        </div>
        <br><br>
        <div id="map"></div>
    </div>
    <br><br><br>
    <jsp:include page="/views/common/footer.jsp" />
    <script>
        var mapOptions = {
            center: new naver.maps.LatLng(${t.tourLat}, ${t.tourLong}),
            zoom: 18
        };

        var map = new naver.maps.Map('map', mapOptions);

        // 마크 추가
        var marker = new naver.maps.Marker({
            position: new naver.maps.LatLng(${t.tourLat}, ${t.tourLong}),
            map: map,
            title: '${t.tourName}' // 마우스 오버 시 표시될 제목
        });
    </script>
</body>
</html>