<!-- 
========================================================================
파    일    명 : petKindPopup.jsp
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.03
작  성  내  용 : 대동견지도
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.09
수  정  내  용 : Select박스 List Page 기능 추가
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.05.23
수  정  내  용 : Select박스 다음 견종 목록을 AJAX 요청하는 스크립트 추가
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
<title><spring:message code="home.title" /></title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dogmap.css">
</head>
<style>
html {
	overflow: hidden;
}

body {
	background-repeat: no-repeat;
	background-position: left top;
	background-attachment: fixed;
	padding-bottom: -1000px;
}

.fixed {
	width: 100%;
	position: relative;
	margin-left: 300px;
	align-items: center;
	margin-bottom: 3rem;
	display: -ms-flexbox;
	display: flex;
}

a:hover {
	color: #000000;
	font-size: 1.1em;
}

#img_world_map {
	filter: invert(99%) sepia(9%) saturate(490%) hue-rotate(212deg)
		brightness(121%) contrast(100%);
}
</style>
<body style="overflow-y: auto; overflow-x: hidden;">

	<div class="fixed" id="kindcodeListSelect">
		<c:import url="kindcodeListAjax.jsp">

		</c:import>
	</div>

	<div class="map">

		<!-- svg 파일 코드 -->
		<object type="image/svg+xml"
			data="${pageContext.request.contextPath}/img/popupBack/world_map3.svg"
			id="img_world_map"></object>


		<ul class="map__markers">
			<li class="map__marker map__marker--america"><img width="30"
				height="30"
				src="${pageContext.request.contextPath}/img/button/dog_marker2.png" /><a
				href="#"></a>
				<div class="map__marker-info">
					<div class="map__marker-info-inner animate animate--bounce-in">
						<header class="map__marker-info-header">
							<span class="current">미국 / United States of America</span>
						</header>
						<main class="map__marker-info-main">
						<div class="row">
							<c:forEach var="kindcode" items="${kindcodeList}"
								varStatus="status">
								<c:if test="${kindcode.petKindHabitat eq 'US' }">
									<div class="col-md-6">
										<a
											href="${pageContext.request.contextPath}/popup/petKind/click/${kindcode.petKindcode}"><li
											data-value="${kindcode.petKind}" class="option">${kindcode.petKind}</li></a>
									</div>
								</c:if>
							</c:forEach>
						</div>
						</main>
					</div>
				</div></li>

			<li class="map__marker map__marker--africa"><img width="30"
				height="30"
				src="${pageContext.request.contextPath}/img/button/dog_marker2.png" /><a
				href="#"></a>
				<div class="map__marker-info">
					<div class="map__marker-info-inner animate animate--bounce-in">
						<header class="map__marker-info-header">
							<span class="current">아프리카 / Africa</span>
						</header>
						<main class="map__marker-info-main">
						<div class="row">
							<c:forEach var="kindcode" items="${kindcodeList}"
								varStatus="status">
								<c:if test="${kindcode.petKindHabitat eq 'AF'}">
									<div class="col-md-6">
										<a
											href="${pageContext.request.contextPath}/popup/petKind/click/${kindcode.petKindcode}"><li
											data-value="${kindcode.petKind}" class="option">${kindcode.petKind}</li></a>
									</div>
									<br>
								</c:if>
							</c:forEach>
						</div>
						</main>
					</div>
				</div></li>

			<li class="map__marker map__marker--korea"><img width="30"
				height="30"
				src="${pageContext.request.contextPath}/img/button/dog_marker2.png" /><a
				href="#"></a>
				<div class="map__marker-info">
					<div class="map__marker-info-inner animate animate--bounce-in">
						<header class="map__marker-info-header">
							<span class="current">한국 / Korea</span>
						</header>
						<main class="map__marker-info-main">
						<div class="row">
							<c:forEach var="kindcode" items="${kindcodeList}"
								varStatus="status">
								<c:if test="${kindcode.petKindHabitat eq 'KR' }">
									<div class="col-md-6">
										<a
											href="${pageContext.request.contextPath}/popup/petKind/click/${kindcode.petKindcode}"><li
											data-value="${kindcode.petKind}" class="option">${kindcode.petKind}</li></a>
									</div>
								</c:if>
							</c:forEach>
						</div>
						</main>
					</div>
				</div></li>

			<li class="map__marker map__marker--japan"><img width="30"
				height="30"
				src="${pageContext.request.contextPath}/img/button/dog_marker2.png" /><a
				href="#"></a>
				<div class="map__marker-info">
					<div class="map__marker-info-inner animate animate--bounce-in">
						<header class="map__marker-info-header">
							<span class="current">일본 / Japan</span>
						</header>
						<main class="map__marker-info-main">
						<div class="row">
							<c:forEach var="kindcode" items="${kindcodeList}"
								varStatus="status">
								<c:if test="${kindcode.petKindHabitat eq 'JP' }">
									<div class="col-md-6">
										<a
											href="${pageContext.request.contextPath}/popup/petKind/click/${kindcode.petKindcode}"><li
											data-value="${kindcode.petKind}" class="option">${kindcode.petKind}</li></a>
									</div>
								</c:if>
							</c:forEach>
						</div>
						</main>
					</div>
				</div></li>
		</ul>
	</div>

	<!-- JS here -->

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
	function dogSelect() {
		if ($("[name=childKind] > option:selected").val() == '') {
			alert("견종을 선택해주세요.");
			return false;
		}

		$("#petKind", opener.document).val(
				document.getElementById("childKind").value);
		window.close();
	}

	function pagingFunction(pageNumber) {
		var formData = new FormData(); //formData 객체 생성
		formData.append("pageNumber", pageNumber);
		$.ajax({
			url : "${pageContext.request.contextPath}/popup/petKind",
			type : "post",
			dataType : "text",
			data : formData,
			contentType : false,
			processData : false,
			cache : false
		}).done(function(result) {
			var html = jQuery('<div>').html(result);
			var contents = html.find("div#kindcodeListAjax").html();
			$("#kindcodeListSelect").html(contents);
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.log("에러");
			console.log(jqXHR);
			console.log(textStatus);
			console.log(errorThrown);
		});
	}

</script>
</html>
<!-- 
Copyright (c) 2021 by Marco Biedermann (https://codepen.io/marcobiedermann/pen/qEjQNz)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 -->
<!-- 
Copyright Dogtown Central, LLC. 
-->