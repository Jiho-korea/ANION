<!-- 
========================================================================
파    일    명 : main.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 메인 페이지
========================================================================
수    정    자 : 임원석
수    정    일 : 2021.04.30
수  정  내  용 : 팝업창 생성
========================================================================
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="UTF-8">
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

<body onload="doPopupopen();">
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container d-flex justify-content-center mt-5">
		<a href="${pageContext.request.contextPath}/register/step1"
			class="btn header-btn"><spring:message
				code="pet.registration.title" /></a>

	</div>
	<div class="container d-flex justify-content-center mt-5">
		<a href="${pageContext.request.contextPath}/main/list"
			class="btn header-btn"><spring:message code="pet.list.title" /></a>
	</div>

	<%-- 대문짝
	 <!-- slider Area Start-->
	<div class="slider-area position-relative">
		<div class="slider-active dot-style">
			<!-- Single Slider -->
			<div
				class="single-slider hero-overly slider-height slider-bg1 d-flex align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xl-8 col-lg-8 col-md-8 col-sm-10">
							<div class="hero__caption">
								<h1 data-animation="fadeInUp" data-delay=".2s">
									<spring:message code="company.name" />
								</h1>
								<P data-animation="fadeInUp" data-delay=".4s">
									<spring:message code="company.introduction" />
								</P>
								<!-- Hero-btn -->
								<div class="hero__btn">
									<a href="industries.html" class="hero-btn mb-10" data-animation="fadeInUp" data-delay=".8s"><spring:message code="company.link" /></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Single Slider -->
			<div
				class="single-slider hero-overly slider-height slider-bg1 d-flex align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xl-8 col-lg-8 col-md-8 col-sm-10">
							<div class="hero__caption">
								<h1 data-animation="fadeInUp" data-delay=".2s">
									<spring:message code="company.name" />
								</h1>
								<P data-animation="fadeInUp" data-delay=".4s">
									<spring:message code="company.introduction" />
								</P>
								<!-- Hero-btn -->
								<div class="hero__btn">
									<a href="industries.html" class="hero-btn mb-10" data-animation="fadeInUp" data-delay=".8s"><spring:message code="company.link" /></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Single Slider -->
			<div
				class="single-slider hero-overly slider-height slider-bg1 d-flex align-items-center">
				<div class="container">
					<div class="row">
						<div class="col-xl-8 col-lg-8 col-md-8 col-sm-10">
							<div class="hero__caption">
								<h1 data-animation="fadeInUp" data-delay=".2s">
									<spring:message code="company.name" />
								</h1>
								<P data-animation="fadeInUp" data-delay=".4s">
									<spring:message code="company.introduction" />
								</P>
								<!-- Hero-btn -->
								<div class="hero__btn">
									<a href="industries.html" class="hero-btn mb-10" data-animation="fadeInUp" data-delay=".8s"><spring:message code="company.link" /></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--? video_start -->
		<div
			class="video-area d-flex align-items-center justify-content-center">
			<div class="video-wrap position-relative">
				<div class="video-icon">
					<a class="popup-video btn-icon" href="https://youtube.com/watch?v=MG0Ly1h3Z24"><i class="fas fa-play"></i></a>
				</div>
			</div>
		</div>
		<!-- video_end -->
	</div>
	 --%>

	<%--
	<!-- slider Area End--> <!--? Visit Our Tailor Start -->
	<div class="visit-tailor-area fix">
		<!--Right Contents  -->
		<div class="tailor-offers"></div>
		<!-- left Contents -->
		<div class="tailor-details">
			<span><spring:message code="company.introduction.title" /></span>
			<p>
				<spring:message code="company.introduction" />
			</p>
			<br />
			<span><spring:message code="anion.introduction.title" /></span>
			<p>
			
			
				<img src="${pageContext.request.contextPath}/img/logo/anion.png" alt="">
				<spring:message code="anion.introduction.1" /><br />
				<img src="${pageContext.request.contextPath}/img/logo/postech.png" style="max-width: 100%; height: auto;" alt="">
				<spring:message code="anion.introduction.2" />
				<img src="${pageContext.request.contextPath}/img/logo/postechholdings.png" alt="">
				<spring:message code="anion.introduction.3" />
				<img src="${pageContext.request.contextPath}/img/logo/pohangtecnopark.png" alt="">
				<spring:message code="anion.introduction.4" />
				
			</p>
			<!--
			<p>................(추후 추가)</p>
			<p class="pera-bottom">................(추후 추가)</p>
		
			<div class="footer-tittles">
				<p>주)애니온 대표이사 </p>
				<h2>이동훈 / 李 東 訓 /<br>Dong-Hoon Lee</h2>
			</div>
			--!>
		</div>
	</div>
	 --%>
	<%-- 
	<!-- Visit Our Tailor End --> <!--? Services Area Start -->
	<div class="service-area section-padding30">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6 col-sm-11">
					<div class="single-cat text-center mb-30">
						<div class="cat-icon">
							<img src="${pageContext.request.contextPath}/img/gallery/services1.png" alt="" />
						</div>
						<div class="cat-cap">
							<h5><a href="#"><spring:message code="pet.certification.title" /></a></h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-11">
					<div class="single-cat active text-center mb-30">
						<div class="cat-icon">
							<img src="${pageContext.request.contextPath}/img/gallery/services2.png" alt="" />
						</div>
						<div class="cat-cap">
							<h5><a href="#"><spring:message code="microbiome.title" /></a></h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-11">
					<div class="single-cat text-center mb-30">
						<div class="cat-icon">
							<img src="${pageContext.request.contextPath}/img/gallery/services3.png" alt="" />
						</div>
						<div class="cat-cap">
							<h5>
								<a href="#"><spring:message code="pet.food.title" /></a>
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Services Area End -->
	--%>
	<%--
	<!--? About Area Start -->
	<section class="support-company-area fix pt-10">
		<div class="support-wrapper align-items-center">
			<div class="left-content">
				<!-- section tittle -->
				<div class="section-tittle section-tittle2 mb-30">
					<span>Why You Should join us</span>
					<h2>A lot of animals need protection</h2>
				</div>
				<div class="support-caption">
					<p class="pera-top">Interdum nulla, ut commodo diam libero
						vitae erat. Aenean faucibus nibh et justo cursus id rutrum lorem
						imperdiet. Nunc ut sem vitae risus tristique posuere.</p>
					<a href="#" class="border-btn">Join Us Now</a>
				</div>
			</div>
			<div class="right-content">
				<!-- img -->
				<div class="right-img">
					<img
						src="${pageContext.request.contextPath}/img/gallery/safe_in.png"
						alt="">
				</div>
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
			</div>
		</div>
	</section>
	<!-- About Area End --> <!--? Our Cases Start -->
	<div class="our-cases-area section-padding30">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-10 col-lg-10 ">
					<!-- Section Tittle -->
					<div class="section-tittle text-center mb-80">
						<h2>Every day 6,000 beavers perished</h2>
						<p class="pl-20 pr-20">Interdum nulla, ut commodo diam libero
							vitae erat. Aenean faucibus nibh et justo cursus id rutrum lorem
							imperdiet. Nunc ut sem vitae risus tristique posuere.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="single-cases mb-40">
						<div class="cases-img">
							<img
								src="${pageContext.request.contextPath}/img/gallery/case1.png"
								alt="">
						</div>
						<div class="cases-caption">
							<h3>
								<a href="#">Wildlife in Danger</a>
							</h3>
							<p>Interdum nulla, ut commodo diam libero vitae erat. Aenean
								faucibus nibh et justo cursus rutrum.</p>
							<!-- Progress Bar -->
							<div class="single-skill mb-15">
								<div class="bar-progress">
									<div id="bar1" class="barfiller">
										<div class="tipWrap">
											<span class="tip"></span>
										</div>
										<span class="fill" data-percentage="70"></span>
									</div>
								</div>
							</div>
							<!-- / progress -->
							<div class="prices">
								<p>
									<span>47,589 of 74,574</span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="single-cases mb-40">
						<div class="cases-img">
							<img
								src="${pageContext.request.contextPath}/img/gallery/case2.png"
								alt="">
						</div>
						<div class="cases-caption">
							<h3>
								<a href="#">Our Green Projects</a>
							</h3>
							<p>Interdum nulla, ut commodo diam libero vitae erat. Aenean
								faucibus nibh et justo cursus rutrum.</p>
							<!-- Progress Bar -->
							<div class="single-skill mb-15">
								<div class="bar-progress">
									<div id="bar2" class="barfiller">
										<div class="tipWrap">
											<span class="tip"></span>
										</div>
										<span class="fill" data-percentage="25"></span>
									</div>
								</div>
							</div>
							<div class="prices">
								<p>
									<span>47,589 of 74,574</span>
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="single-cases">
						<div class="cases-img">
							<img
								src="${pageContext.request.contextPath}/img/gallery/case3.png"
								alt="">
						</div>
						<div class="cases-caption">
							<h3>
								<a href="#">Wildlife in Danger</a>
							</h3>
							<p>Interdum nulla, ut commodo diam libero vitae erat. Aenean
								faucibus nibh et justo cursus rutrum.</p>
							<!-- Progress Bar -->
							<div class="single-skill mb-15">
								<div class="bar-progress">
									<div id="bar3" class="barfiller">
										<div class="tipWrap">
											<span class="tip"></span>
										</div>
										<span class="fill" data-percentage="50"></span>
									</div>
								</div>
							</div>
							<div class="prices">
								<p>
									<span>47,589 of 74,574</span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Our Cases End --> <!--? Blog Area Start -->
	<section class="home-blog-area pb-padding">
		<div class="container">
			<!-- Section Tittle -->
			<div class="row justify-content-center">
				<div class="col-xl-8 col-lg-9 col-md-11">
					<div class="section-tittle text-center mb-90">
						<h2>Latest news</h2>
						<p>Interdum nulla, ut commodo diam libero vitae erat. Aenean
							faucibus nibh et justo cursus id rutrum lorem imperdiet. Nunc ut
							sem vitae risus tristique posuere.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xl-6 col-lg-6 col-md-6">
					<div class="home-blog-single mb-30">
						<div class="blog-img-cap">
							<div class="blog-img">
								<img
									src="${pageContext.request.contextPath}/img/gallery/home-blog1.png"
									alt="">
							</div>
							<div class="blog-cap">
								<h3>
									<a href="blog_details.html">Leverage agile frameworks to
										provide a robust synopsis</a>
								</h3>
								<p>The automated process starts as soon as your clothes go
									into the machine. Duis cursus, mi quis viverra ornare.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-6 col-lg-6 col-md-6">
					<div class="home-blog-single mb-30">
						<div class="blog-img-cap">
							<div class="blog-img">
								<img
									src="${pageContext.request.contextPath}/img/gallery/home-blog2.png"
									alt="">
							</div>
							<div class="blog-cap">
								<h3>
									<a href="blog_details.html">Leverage agile frameworks to
										provide a robust synopsis</a>
								</h3>
								<p>The automated process starts as soon as your clothes go
									into the machine. Duis cursus, mi quis viverra ornare.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<!-- Blog Area End -->
	</main>
--%>
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
<script type="text/javascript">
	function doPopupopen() {
		window.open("${pageContext.request.contextPath}/popup/1",
				"popup01", "width=300, height=360");
	}
</script>
</html>