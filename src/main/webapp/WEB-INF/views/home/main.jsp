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
수    정    자 : 임원석,정세진
수    정    일 : 2021.05.03
수  정  내  용 : 팝업창 하루동안 보지않기 기능 추가
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
<script src="https://code.jquery.com/jquery-latest.js"></script>

<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}

.map_wrap {
	position: relative;
	width: 100%;
	height: 350px;
}

.title {
	font-weight: bold;
	display: block;
}

.hAddr {
	position: absolute;
	left: 10px;
	top: 10px;
	border-radius: 2px;
	background: #fff;
	background: rgba(255, 255, 255, 0.8);
	z-index: 1;
	padding: 5px;
}

#centerAddr {
	display: block;
	margin-top: 2px;
	font-weight: normal;
}

.bAddr {
	padding: 5px;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}
</style>


<body onload="doPopupopen();">
	<div id="myModal" class="modal">
		<!--
	
		<div
			class="modal-content d-flex justify-content-center align-items-center"
			style="background-image: URL(${pageContext.request.contextPath}/img/popupBack/pop_back.png); height: 550px">

			<div
				style="font-size: 1.5em; font-weight: bold; text-align: center; color: green; width: 300px"
				class="d-flex justify-content-center mt-3">교육 이벤트 및 참석 제목</div>
			<p style="text-align: center; line-height: 1.5;">
				<span style="font-size: 14pt; color: white;">교육 및 설명</span>
			</p>

			<div
				class="jumbotron d-flex justify-content-center align-items-center"
				style="height: 300px; width: 300px; opacity: 0.8;">참고 이미지, 그림
				등</div>

			<div class="container d-flex justify-content-center mt-3">
				<a href="${pageContext.request.contextPath}/popup/1/click"
					class="btn header-btn d-flex justify-content-center"
					style="border: none; padding: 5px 15px; text-transform: capitalize; border-radius: 10px; cursor: pointer; color: #fff; display: inline-block; font-size: 10px; transition: 0.6s; box-shadow: 0px 7px 21px 0px rgba(0, 0, 0, 0.12); background-image: linear-gradient(to left, #46C0BE, #6DD56F, #46C0BE); background-position: right; background-size: 200% margin-bottom:100px; margin-top: 12px;">등록하러가기</a>
			</div>
			 -->
		<div class="d-flex justify-content-center ml-5 mt-5">
			<!--  <a href="${pageContext.request.contextPath}/popup/1/click">-->
			<a href="javascript:window.close();"
				onclick="window.open('https://www.facebook.com/groups/3017696248465936')">
				<img
				src="${pageContext.request.contextPath}/img/popupBack/popup_event.jpg"
				style="width: 90%;">
			</a>
		</div>

		<div class="container d-flex justify-content-end mt-5"
			style="margin-right: -10px">
			<form name="frm" class="d-flex align-items-center">
				<input id="closeCheck" type="checkbox" name="Notice"
					onclick="check()"> <a style="font-size: 13px;"><spring:message
						code="event.popup.decide" /></a> &nbsp;<input type=button
					value="<spring:message code="close" />" onclick="closeWin()"
					style="width: 30pt; height: 20pt; font-size: 13px"
					class="d-flex align-items-center">

			</form>
		</div>

	</div>



	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container d-flex justify-content-center mt-5">
		<a href="${pageContext.request.contextPath}/register/step1"
			class="btn header-btn"><spring:message
				code="pet.registration.title" /></a>

	</div>
	<div class="container d-flex justify-content-center mt-5">
		<a href="${pageContext.request.contextPath}/pet/list"
			class="btn header-btn"><spring:message code="pet.list.title" /></a>
	</div>
	<div class="map_wrap">
		<div id="map" style="width: 700px; height: 700px;"></div>
		<div id="clickLatlng"></div>
		<div class="hAddr">
			<span class="title">지도중심기준 행정동 주소정보</span> <span id="centerAddr"></span>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
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
            <h2>이동훈 / 李 東 訓 /<br>Dong-Hoon Lee</h2>
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
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

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

	//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
	if (navigator.geolocation) {
		// GeoLocation을 이용해서 접속 위치를 얻어옵니다
		navigator.geolocation.getCurrentPosition(function(position) {

			var lat = position.coords.latitude, // 위도
			lon = position.coords.longitude; // 경도

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

		var message = '위도 : ' + locPosition.getLat() + ', ';
		message += '경도 : ' + locPosition.getLng();

		var resultDiv = document.getElementById('clickLatlng');
		resultDiv.innerHTML = message;

		searchAddrFromCoords(map.getCenter(), displayCenterInfo);

		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
			searchDetailAddrFromCoords(mouseEvent.latLng, function(result,
					status) {
				if (status === kakao.maps.services.Status.OK) {
					var detailAddr = !!result[0].road_address ? '<div>도로명주소 : '
							+ result[0].road_address.address_name + '</div>'
							: '';
					detailAddr += '<div>지번 주소 : '
							+ result[0].address.address_name + '</div>';
					var content = '<div class="bAddr">'
							+ '<span class="title">법정동 주소정보</span>'
							+ detailAddr + '</div>';
					// 마커를 클릭한 위치에 표시합니다 
					marker.setPosition(mouseEvent.latLng);
					marker.setMap(map);
					// 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
					infowindow.setContent(content);
					infowindow.open(map, marker);

					var message = '위도 : ' + mouseEvent.latLng.getLat() + ', ';
					message += '경도 : ' + mouseEvent.latLng.getLng();

					var resultDiv = document.getElementById('clickLatlng');
					resultDiv.innerHTML = message;
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

	function setCookie(name, value, expiredays) {
		var todayDate = new Date();
		todayDate.setDate(todayDate.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ todayDate.toGMTString() + ";"
	}

	function getCookie(name) {
		var nameOfCookie = name + "=";
		var x = 0;
		while (x <= document.cookie.length) {
			var y = (x + nameOfCookie.length);
			if (document.cookie.substring(x, y) == nameOfCookie) {
				if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
					endOfCookie = document.cookie.length;
				return unescape(document.cookie.substring(y, endOfCookie));
			}
			x = document.cookie.indexOf(" ", x) + 1;
			if (x == 0)
				break;
		}
		return "";
	}

	var ratio = window.devicePixelRatio;

	if (getCookie("Notice") != "done") {
		if (ratio >= 2) {
			jQuery(document).ready(function() {
				$('#myModal').show();
			});

		} else {
			function doPopupopen() {
				window
						.open(
								"${pageContext.request.contextPath}/popup/1",
								"popup1_parent",
								"width=430, height=580, scrollbars=no, resizable=0, toolbar=no, location=no, directories=no, status=no, menubar=no");
			}

		}
	}

	function closeWin() {
		$('#myModal').hide();
	}

	function check() {
		setCookie("Notice", "done", 1);
		$('#myModal').hide();
	}
</script>
</html>