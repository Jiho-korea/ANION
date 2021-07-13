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
			<h1 class="display-4"><spring:message code="event.nose.example" /></h1>
		</div>
		<div class="text-left">
			<!-- 비문 이벤트 -->
			<c:choose>
				<c:when test="${empty first}">
					<a href="javascript:history.back();"><button type="button"
							class="btn btn-info pull-left mb-5" style="float: left;"><spring:message code="go.back" /></button></a>
				</c:when>
				<c:otherwise>
					<a
						href="${pageContext.request.contextPath}/info/list/npimage?petRegistrationNumber=${first}"><button
							type="button" class="btn btn-info pull-right mb-5"
							style="float: right;">
							<spring:message code="go.agree" />
						</button></a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row" id="main">
			<div class="col-lg-5 col-md-12 mb-5">
				<!--Section: Content-->
				<section class="text-center">
					<h4 class="mb-5">
						<strong style="color: #DF6464"><spring:message code="event.nose.bad" /></strong>
					</h4>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_1.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_1.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title"><spring:message code="event.nose.bad1" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail" /></p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_2.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_2.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.bad2" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail2" /></p>

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_3.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_3.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.bad3" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail3" /></p>

								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_4.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_4.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.bad4" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail4" /></p>

								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_5.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_5.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title"><spring:message code="event.nose.bad5" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail5" /></p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_6.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_6.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.bad6" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail6" /></p>

								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_7.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_7.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title"><spring:message code="event.nose.bad7" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail7" /></p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_8.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_8.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.bad8" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail8" /></p>

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_9.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_9.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<%-- --%>
									<h5 class="card-title"><spring:message code="event.nose.bad9" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail9" /></p>
								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_10.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/bad/Bad_10.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.bad10" /></h5>
									<p class="card-text"><spring:message code="event.nose.bad1.detail10" /></p>

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
						<strong style="color: #6495DF"><spring:message code="event.nose.good" /></strong>
					</h4>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_1.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_1.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good1" /></h5>

								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_2.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_2.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good2" /></h5>

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_3.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_3.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good3" /></h5>


								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_4.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_4.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good4" /></h5>

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_5.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_5.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good5" /></h5>

								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_6.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_6.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good6" /></h5>

								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_7.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_7.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good7" /></h5>

								</div>
							</div>
						</div>

						<div class="col-lg-6 mb-4">
							<div class="card">
								<div class="bg-image hover-overlay ripple"
									data-mdb-ripple-color="light">
									<a
										href="${pageContext.request.contextPath}/img/event/noseprint/good/Good_8.jpg"
										target="_blank"> <img
										src="${pageContext.request.contextPath}/img/event/noseprint/good/Good_8.jpg"
										class="img-fluid" /> <a href="#!">
											<div class="mask"
												style="background-color: rgba(251, 251, 251, 0.15);"></div>
									</a></a>
								</div>
								<div class="card-body">
									<h5 class="card-title"><spring:message code="event.nose.good8" /></h5>

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