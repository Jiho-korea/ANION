<!-- 
========================================================================
파    일    명 : petLocationPopup.jsp
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.20
작  성  내  용 : 위치를 등록하는 지도(카카오맵) 팝업창
========================================================================
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ANION locationPopup</title>
<!-- CSS here -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/slicknav.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/flaticon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/progressbar_barfiller.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/gijgo.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animated-headline.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fontawesome-all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/slick.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/nice-select.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<style>
a {
	color: black;
}

a:hover {
	color: green;
	font-weight: bold;
}

.map_wrap {
	position: relative;
	width: 100%;
	height: 100%;
}

.title {
	font-weight: bold;
	display: block;
}

.hAddr {
	position: absolute;
	left: 2%;
	top: 2%;
	border-radius: 2px;
	background: #fff;
	background: rgba(255, 255, 255, 0.8);
	z-index: 1;
	padding: 5px;
}

.fAddr {
	position: absolute;
	left: 50%;
	bottom: 15%;
	border-radius: 2px;
	background: #fff;
	background: rgba(255, 255, 255, 0.8);
	z-index: 1;
	padding: 5px;
	transform: translate(-50%, -5%);
	left: 50%;
}

#centerAddr {
	display: block;
	margin-top: 2px;
	font-weight: normal;
}

.bAddr {
	padding: 5px;
	padding-right: 12px;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
<body>

	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 720px; position: relative; overflow: hidden;"></div>
		<div class="hAddr">
			<span class="title"><spring:message code="address.administrative.map.center"/></span> <span id="centerAddr"></span>
		</div>

		<c:if test="${!empty address }">
			<div class="fAddr">
				<span class="title" style="text-align: center;">${address } <span
					id="centerAddr"
					style="position: absolute; left: 50%; transform: translate(-50%, 0%);"><br>
						<button type="button" class="btn header-btn"
							onclick="popupClose()">OK</button></span>
				</span>
			</div>
		</c:if>
	</div>

	<!-- JS here -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c4a5940f28fdb6cd085930c272e5ed6c&libraries=services"></script>

	<script defer
		src="${pageContext.request.contextPath}/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script defer
		src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script defer
		src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/slick.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script defer src="${pageContext.request.contextPath}/js/wow.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/animated.headline.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.magnific-popup.js"></script>

	<!-- Date Picker -->
	<script defer src="${pageContext.request.contextPath}/js/gijgo.min.js"></script>
	<!-- Nice-select, sticky -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.nice-select.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
	<!-- Progress -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.barfiller.js"></script>

	<!-- counter , waypoint,Hover Direction -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.counterup.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/waypoints.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/hover-direction-snake.min.js"></script>

	<!-- contact js -->
	<script defer src="${pageContext.request.contextPath}/js/contact.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/mail-script.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script defer src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
<script defer type="text/javascript">
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 6
	// 지도의 확대 레벨 
	};
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	var latdata = "${lat}";
	var londata = "${lon}";

	//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {
		// GeoLocation을 이용해서 접속 위치를 얻어옵니다
		navigator.geolocation.getCurrentPosition(function(position) {

			var lat = position.coords.latitude, // 위도
			lon = position.coords.longitude; // 경도
			
			if (latdata != "" & londata != "") {
				lat = latdata;
				lon = londata;
			}

			var locPosition = new kakao.maps.LatLng(lat, lon); // 인포윈도우에 표시될 내용입니다

			// 마커와 인포윈도우를 표시합니다
			displayMarker(locPosition);
		});
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
		var locPosition = new kakao.maps.LatLng(33.450701, 126.570667);
		displayMarker(locPosition);
	}
	//지도에 마커와 인포윈도우를 표시하는 함수
	function displayMarker(locPosition) {
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position : locPosition
		});
		infowindow = new kakao.maps.InfoWindow({
			zindex : 1
		}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다

		// 지도 중심좌표를 접속위치로 변경합니다
		map.setCenter(locPosition);
		marker.setClickable(true);
		marker.setMap(map);
		
		searchDetailAddrFromCoords(locPosition,function(result, status) {
			if (status === kakao.maps.services.Status.OK) {
				var detailAddr = '<div><spring:message code="address.lot" />: '
					+ '<a href="${pageContext.request.contextPath}/pet/location/' 
					+ ${petRegistrationNumber} + '/' + result[0].address.address_name + '?lat=' + locPosition.getLat() + '&lon=' + locPosition.getLng() + '">'
					+ result[0].address.address_name + '</a></div>';
				var content = '<div class="bAddr">'
					+ '<span class="title"><spring:message code="address.legal" /></span>'
					+ detailAddr + '</div>';
				// 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
				infowindow.setContent(content);
				infowindow.open(map, marker);
			}
		});

		searchAddrFromCoords(map.getCenter(), displayCenterInfo);

		kakao.maps.event.addListener(map,'click',function(mouseEvent) {
			searchDetailAddrFromCoords(mouseEvent.latLng,function(result, status) {
				if (status === kakao.maps.services.Status.OK) {
					var detailAddr = '<div><spring:message code="address.lot" />: '
						+ '<a href="${pageContext.request.contextPath}/pet/location/' 
						+ ${petRegistrationNumber} + '/' + result[0].address.address_name + '?lat=' + mouseEvent.latLng.getLat() + '&lon=' + mouseEvent.latLng.getLng() + '">'
						+ result[0].address.address_name + '</a></div>';
					var content = '<div class="bAddr">'
						+ '<span class="title"><spring:message code="address.legal" /></span>'
						+ detailAddr + '</div>';
					// 마커를 클릭한 위치에 표시합니다 
					marker.setPosition(mouseEvent.latLng);
					marker.setMap(map);
					// 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
					infowindow.setContent(content);
					infowindow.open(map, marker);
				}
			});
		});

		kakao.maps.event.addListener(map, 'idle', function() {
			searchAddrFromCoords(map.getCenter(), displayCenterInfo);
		});

	}
	function searchAddrFromCoords(coords, callback) {
		// 좌표로 행정동 주소 정보를 요청합니다
		geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
	}
	function searchDetailAddrFromCoords(coords, callback) {
		// 좌표로 법정동 상세 주소 정보를 요청합니다
		geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
	}
	function displayCenterInfo(result, status) {
		if (status === kakao.maps.services.Status.OK) {
			var infoDiv = document.getElementById('centerAddr');

			for (var i = 0; i < result.length; i++) {
				// 행정동의 region_type 값은 'H' 이므로
				if (result[i].region_type === 'H') {
					infoDiv.innerHTML = result[i].address_name;
					break;
				}
			}
		}
	}

	function popupClose(petRegistrationNumber) {
		var formData = new FormData(); //formData 객체 생성

		formData.append("petRegistrationNumber", "${petRegistrationNumber}");
		formData.append("address", "${address}");

		$.ajax({
			url : "${pageContext.request.contextPath}/pet/location/register",
			type : "post",
			dataType : "text",
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				opener.parent.location.reload();
				window.close();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("register error");
			}
		});
	}
</script>
</html>