<%--
========================================================================
파    일    명 : directions.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.10.30
작  성  내  용 : 오시는길
========================================================================
수    정    자 : 
수    정    일 : 
수  정  내  용 : 
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="home.title" /></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">

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
<body>

	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<main> <!--? Hero Start -->
	<div class="slider-area2">
		<div class="slider-height2 d-flex align-items-center">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="hero-cap hero-cap2 pt-70">
							<h2><spring:message code="company.directions.title" /></h2>
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.html"><spring:message code="company.introduction.title" /></a></li>
									<li class="breadcrumb-item"><a href="#"><spring:message code="company.directions.title" /></a></li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Hero End --> <!--? Visit Our Tailor Start -->
	<div class="visit-tailor-area fix">
		<!--Right Contents  -->
		<%--div class="tailor-offers"></div--%>
		<!-- left Contents -->
		<div class="tailor-details">
			<span><spring:message code="company.directions.inquiry" /></span>
			<p><spring:message code="company.directions.address" /></p>
			<p><spring:message code="company.directions.email" /></p>
			<div style="font:normal normal 400 12px/normal dotum, sans-serif; width:400px; height:432px; color:#333; position:relative"><div style="height: 400px;"><a href="https://map.kakao.com/?urlX=1021335.0&amp;urlY=711293.0&amp;name=%EA%B2%BD%EB%B6%81%20%ED%8F%AC%ED%95%AD%EC%8B%9C%20%EB%82%A8%EA%B5%AC%20%EC%A7%80%EA%B3%A1%EB%A1%9C%20394&amp;map_type=TYPE_MAP&amp;from=roughmap" target="_blank"><img class="map" src="//t1.daumcdn.net/roughmap/imgmap/29fbeba495bd2a869dd7a6adef27fca472ea2ced096050e0d7e32fc25c6862be" width="398px" height="398px" style="border:1px solid #ccc;"></a></div><div style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);"><a href="https://map.kakao.com" target="_blank" style="float: left;"><img src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png" width="72" height="16" alt="카카오맵" style="display:block;width:72px;height:16px"></a><div style="float: right; position: relative; top: 1px; font-size: 11px;"><a target="_blank" href="https://map.kakao.com/?from=roughmap&amp;eName=%EA%B2%BD%EB%B6%81%20%ED%8F%AC%ED%95%AD%EC%8B%9C%20%EB%82%A8%EA%B5%AC%20%EC%A7%80%EA%B3%A1%EB%A1%9C%20394&amp;eX=1021335.0&amp;eY=711293.0" style="float:left;height:15px;padding-top:1px;line-height:15px;color:#000;text-decoration: none;">길찾기</a></div></div></div>
			<!--
			<p class="pera-bottom">Interdum nulla, ut commodo diam libero
				vitae erat. Aenean faucibus nibh et justo cursus id rutrum lorem
				imperdiet. Nunc ut sem vitae risus tristique posuere.</p>
			<div class="footer-tittles">
				<p>CEO, Consulto</p>
				<h2>Capcilena Hanry</h2>
			</div>  -->
		</div>
	</div>
	<!-- Visit Our Tailor End --> 
	
	</main>
	<c:import url="../included/bottom.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<!-- Scroll Up -->
	<div id="back-top">
		<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>

	<!-- JS here -->

	<script defer
		src="${pageContext.request.contextPath}/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script defer
		src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script defer src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
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
	<script defer src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
	<!-- Progress -->
	<script defer src="${pageContext.request.contextPath}/js/jquery.barfiller.js"></script>

	<!-- counter , waypoint,Hover Direction -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.counterup.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/waypoints.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/hover-direction-snake.min.js"></script>

	<!-- contact js -->
	<script defer src="${pageContext.request.contextPath}/js/contact.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/mail-script.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script defer src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>