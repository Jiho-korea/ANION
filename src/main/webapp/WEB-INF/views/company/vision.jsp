<%--
========================================================================
파    일    명 : vision.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.10.30
작  성  내  용 : 회사비전
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
							<h2><spring:message code="company.vision.title" /></h2>
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.html"><spring:message code="company.introduction.title" /></a></li>
									<li class="breadcrumb-item"><a href="#"><spring:message code="company.vision.title" /></a></li>
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
			<span><spring:message code="company.vision.title" /></span>
			<h2><spring:message code="vision.1" /></h2>
			<img src="${pageContext.request.contextPath}/img/gallery/vision1.png" alt="">
			
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
	<!-- Visit Our Tailor End -->  <!--? About Area Start -->
	<section class="support-company-area fix pb-padding">
		<div class="support-wrapper align-items-center">
			<div class="left-content">
				<!-- section tittle -->
				<div class="section-tittle section-tittle2 mb-30">
					<h2><spring:message code="vision.2" /></h2>
				</div>
				<div class="support-caption">
					<p class="pera-top"><spring:message code="vision.3" /></p>
				</div>
				<img src="${pageContext.request.contextPath}/img/gallery/vision2.png" alt="">
			</div>
			<div class="right-content">
				<!-- img -->
				<div class="right-img">
					<img src="${pageContext.request.contextPath}/img/gallery/safe_in.png" alt="">
				</div>
				<!-- 
				<div class="support-img-cap text-center d-flex">
					<div class="single-one">
						<span>950</span>
						<p>Poaching cases</p>
					</div>
					<div class="single-two">
						<span>230</span>
						<p>Volunteers worldwide</p>
					</div>
				</div>
				 -->
			</div>
		</div>
	</section>
	<!-- About Area End --> 
	
	</main>
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
	<script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
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
	<script src="${pageContext.request.contextPath}/js/jquery.barfiller.js"></script>

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