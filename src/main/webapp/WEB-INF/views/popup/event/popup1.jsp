<!-- 
========================================================================
파    일    명 : popup1.jsp
========================================================================
작    성    자 : 임원석
작    성    일 : 2021.04.30
작  성  내  용 : 교육 대상자를 위한 팝업페이지
========================================================================
수    정    자 : 임원석,정세진
수    정    일 : 2021.05.03
수  정  내  용 : 팝업창 하루동안 보지않기 기능 추가
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
<title>ANION popup1</title>
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
body {
	background-repeat: no-repeat;
	background-position: left top;
	background-attachment: fixed;
}

.jumbotron {
	opacity: 0.8;
}

.image-box {
	text-align: center;
	border-bottom: 2px solid lightgray;
}

.main_title {
	width: 100%;
	height: 40px;
	background-color: #7bb47b;
	border-bottom-width: thin;
	font-weight: bold;
}
</style>

<!-- 
<body
	background="${pageContext.request.contextPath}/img/popupBack/pop_back.png">
-->
<body>
	<div class="main_title pt-4 pl-4 mb-3 d-flex align-items-center">
		<p style="color: white;">
			<spring:message code="event.nose" />
		</p>
	</div>
	<!-- 
	<div
		style="font-size: 1.5em; font-weight: bold; text-align: center; color: green; position: absolute; left: 50px; top: 35px; width: 400px">
		교육 이벤트 및 참석 제목</div>
	<div
		style="text-align: center; color: white; position: absolute; left: 50px; top: 70px; width: 400px">
		교육 및 설명</div>
	 -->
	<div class="image-box">

		<%-- 
	<a
			href="javascript:opener.document.location.href='${pageContext.request.contextPath}/popup/1/click';window.close();">
			<img
			src="${pageContext.request.contextPath}/img/popupBack/popup_event.jpg"
			style="height: 500px; width: 400px; margin-bottom: 5px;">

		</a>
	--%>

		<a href="javascript:window.close();"
			onclick="window.open('https://www.facebook.com/groups/3017696248465936')">
			<img
			src="${pageContext.request.contextPath}/img/popupBack/popup_event.jpg"
			style="height: 500px; width: 400px; margin-bottom: 5px;">
		</a>

	</div>
	<%--  
	<div class="container d-flex justify-content-center mt-5">
		<a
			href="javascript:opener.document.location.href='${pageContext.request.contextPath}/popup/1/click';window.close();"
			class="btn header-btn d-flex justify-content-center"
			style="position: fixed; left: 180px; top: 460px; width: 140px; text-align: center;">등록하러가기</a>
	</div>
	--%>

	<div style="position: fixed; right: 5px; bottom: 4px;">
		<form name="frm" class="d-flex align-items-center">
			<input id="closeCheck" type="checkbox" name="Notice"
				onclick="check()"> <a style="font-size: 13px">하루동안 열지 않음</a>
			&nbsp;<input type=button value="닫기" onclick="closeWin()"
				style="width: 30pt; height: 20pt; font-size: 13px"
				class="d-flex align-items-center">

		</form>
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
	var width = window.outerWidth;
	var height = window.outerHeight;
	function popResizer() {

		window.resizeTo(width, height);
	};

	popResizer();
	$(window).resize(popResizer);

	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ todayDate.toGMTString() + ";"
	}

	function closeWin() {
		self.close();
	}

	function check() {
		setCookie("Notice", "done", 1);
		self.close();
	}
</script>


</html>