<%--
========================================================================
파    일    명 : pet.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.09
작  성  내  용 : 반려견 세부 정보 페이지
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.11.20
수  정  내  용 : 모델에서 견종이름을 받을 수 있도록 수정
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 기존의 폰트 사용해라 -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
<style>
#main {
	width: 100%;
	margin-top: 50px;
}
</style>
<script defer src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script defer src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<title><spring:message code="home.title" /></title>
</head>
<body class="text-center">
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div class="container" id="main" style="width: 70%">
		<h1 class="display-4">
			<spring:message code="info.pet.banner" />
		</h1>
		<br>
		<div style="background: transparent !important"
			class="jumbotron border">
			<h2 style="text-align: left">
				<b><spring:message code="info.pet.profile" /></b>
			</h2>
			<br> <br>
			<h4 style="text-align: left">
				<spring:message code="info.pet.name">
					<spring:argument value="${authInfo.memberId}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.kind">
					<spring:argument value="${authInfo.memberName}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.birthday">
					<spring:argument value="${authInfo.memberRegisterDate}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.sex">
					<spring:argument
						value="${authInfo.memberlevel.memberLevelDescription}" />
				</spring:message>
			</h4>
			
			<hr class="my-4">
			<h4 style="text-align: left">
			<a href="${pageContext.request.contextPath}/edit">회원정보 수정</a>
			</h4>
		</div>


		<c:import url="../included/bottom.jsp">
			<c:param value="main" name="type" />
		</c:import>

		<!-- Scroll Up -->
		<div id="back-top">
			<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
		</div>

		<!-- JS here -->

		<script
			src="${pageContext.request.contextPath}/js/vendor/modernizr-3.5.0.min.js"></script>
		<!-- Jquery, Popper, Bootstrap -->
		<script
			src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		<!-- Jquery Mobile Menu -->
		<script
			src="${pageContext.request.contextPath}/js/jquery.slicknav.min.js"></script>

		<!-- Jquery Slick , Owl-Carousel Plugins -->
		<script
			src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/slick.min.js"></script>
		<!-- One Page, Animated-HeadLin -->
		<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/js/animated.headline.js"></script>
		<script
			src="${pageContext.request.contextPath}/js/jquery.magnific-popup.js"></script>

		<!-- Date Picker -->
		<script src="${pageContext.request.contextPath}/js/gijgo.min.js"></script>
		<!-- Nice-select, sticky -->
		<script
			src="${pageContext.request.contextPath}/js/jquery.nice-select.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
		<!-- Progress -->
		<script
			src="${pageContext.request.contextPath}/js/jquery.barfiller.js"></script>

		<!-- counter , waypoint,Hover Direction -->
		<script
			src="${pageContext.request.contextPath}/js/jquery.counterup.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/waypoints.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/js/hover-direction-snake.min.js"></script>

		<!-- contact js -->
		<script src="${pageContext.request.contextPath}/js/contact.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
		<script
			src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/mail-script.js"></script>
		<script
			src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>

		<!-- Jquery Plugins, main Jquery -->
		<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
		<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>