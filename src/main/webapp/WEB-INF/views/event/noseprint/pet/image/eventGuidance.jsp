<%--
========================================================================
파    일    명 : eventGuidance.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.03
작  성  내  용 : 비문 등록 예시 안내 페이지
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

<meta name="viewport" content="width=device-width, initial-scale=1" />
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
<style>
#main {
	width: 100%;
	margin-top: 50px;
}

#petName:hover {
	font-size: 1.2em;
}

.btn_download, .btn_gallery {
	border: none;
	cursor: pointer;
	background-color: transparent;
}
</style>

<title><spring:message code="home.title" /></title>
</head>
<body>
	<c:import url="../../../../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>


	<div class="container text-center">
		<div id="main">
			<h1 class="display-4">비문 등록 안내</h1>
		</div>
		<div class="text-left mb-10">

			<!-- 비문 이벤트 -->
			<a href="${pageContext.request.contextPath}/pet/list/npevent"
				class="mb-30"><button type="submit"
					class="btn btn-info pull-right">뒤로</button></a>
		</div>
		<div class="row" id="main">
			<div class="col-lg-5 col-md-12 mb-5">
				<!--Section: Content-->
				<section class="text-center">
					<h4 class="mb-5">
						<strong style="color: #DF6464">잘못된 비문 사진 예</strong>
					</h4>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_1.jpg" target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_1.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title">Bad_1</h5>
									<p class="card-text">코가 안 보임</p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_2.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_2.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Bad_2</h5>
									<p class="card-text">좌·우측 균등하지 않은 조명, 이미지가 흐려서 비문이 정확히 보이지
										않음</p>

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_3.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_3.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Bad_3</h5>
									<p class="card-text">코 양쪽이 다 보이지 않음</p>

								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_4.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_4.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Bad_4</h5>
									<p class="card-text">좌·우측 균등하지 않은 조명</p>

								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_5.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_5.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title">Bad_5</h5>
									<p class="card-text">코의 아랫부분이 잘림</p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_6.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_6.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Bad_6</h5>
									<p class="card-text">이미지가 흐려서 비문이 정확히 보이지 않음</p>

								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_7.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_7.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title">Bad_7</h5>
									<p class="card-text">좌·우측 균등하지 않은 조명, 이미지가 흐려서 비문이 정확히 보이지
										않음</p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_8.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_8.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Bad_8</h5>
									<p class="card-text">코의 상단 부분만 촬영</p>

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_9.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_9.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title">Bad_9</h5>
									<p class="card-text">이미지가 흐려서 비문이 정확히 보이지 않음</p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_10.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_10.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Bad_10</h5>
									<p class="card-text">코에 이물질, 코 양쪽이 다 보이지 않음</p>

								</div>
							</div>
						</div>
					</div>
				</section>
			</div>

			<div class="col-lg-2 col-md-12 mb-5"></div>

			<div class="col-lg-5 col-md-12 mb-5">
				<!--Section: Content-->
				<section class="text-center">
					<h4 class="mb-5">
						<strong style="color: #6495DF">올바른 비문 사진 예</strong>
					</h4>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_1.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_1.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_1</h5>
								
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_2.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_2.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_2</h5>
								
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_3.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_3.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_3</h5>
									

								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_4.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_4.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_4</h5>
									
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_5.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_5.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_5</h5>
									
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_6.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_6.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_6</h5>
									
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_7.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_7.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_7</h5>
									
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_8.jpg" target="_blank">
									<img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_8.jpg"
										class="img-fluid" /> <a href="#!">
										<div class="mask"
											style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title">Good_8</h5>
								
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>

	<c:import url="../../../../included/bottom.jsp">
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