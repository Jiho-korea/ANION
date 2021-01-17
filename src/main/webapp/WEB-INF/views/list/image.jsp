<%--
========================================================================
파    일    명 : image.jsp
========================================================================
작    성    자 : 배준철
작    성    일 : 2020.10.20
작  성  내  용 : 이미지갤러리 참고용
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.10.22
수  정  내  용 : C를 거쳐 뷰페이지 보이도록 수정
========================================================================
* 파일선택하면 자동으로 비동기식으로 업로드 되도록 처리하면 될듯
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title><spring:message code="home.title" /></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%--link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script--%>
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

/* 파일찾기 디자인 */
.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #fff;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #5cb85c;
	cursor: pointer;
	border: 1px solid #4cae4c;
	border-radius: .25em;
	-webkit-transition: background-color 0.2s;
	transition: background-color 0.2s;
}

.filebox label:hover {
	background-color: #6ed36e;
}

.filebox label:active {
	background-color: #367c36;
}

.filebox input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}
</style>
</head>
<body>


	<c:import url="../included/top.jsp" />
	<div class="container">
		<%--div class="jumbotron">
			<h4 class="mb-4"></h4>
			<form action="${pageContext.request.contextPath}/register/step2" method="post" cssClass="form-signin" modelAttribute="petRegisterRequest" onsubmit="return clickEvent()" enctype="multipart/form-data">
				<button id="btn_register" class="btn btn-primary btn-lg btn-block" type="submit">
					<spring:message code="go.pet.register" />
				</button>
			</form>
		</div--%>
		<div class="row">
			<div class="filebox">
				<form action="${pageContext.request.contextPath}/info/list/image"
					id="form" method="post" class="form-signin"
					enctype="multipart/form-data">
					<label for="ex_file"><spring:message code="image.face" /></label>

					<input type="file" name="file" id="ex_file" /> <input
						type="hidden" name=petRegistrationNumber id="prn"
						value="${petRegistrationNumber}" />
				</form>
			</div>
		</div>
		<h2>
			<spring:message code="image.list" />
		</h2>
		<div class="row">
			<c:forEach var="image" items="${imageList}" varStatus="status">
				<div class="col-md-4 text-center">
					<a
						href="${pageContext.request.contextPath}/upload/${image.imagePath}">
						<%--p>시티이미지3</p--%> <img
						src="${pageContext.request.contextPath}/upload/${image.imagePath}"
						alt="초롱3" style="width: 180px; height: 180px"
						class="img-thumbnail" />
					</a>
				</div>
			</c:forEach>
			<%--
			<div class="col-md-4 text-center">
				<a
					href="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg">
					<img
					src="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg"
					alt="초롱1" style="width: 180px; height: 180px" class="img-thumbnail" />
				</a>
			</div>
			<div class="col-md-4 text-center">
				<a
					href="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg">
					 <img
					src="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg"
					alt="초롱2" style="width: 180px; height: 180px" class="img-thumbnail" />
				</a>
			</div>
			<div class="col-md-4 text-center">
				<a
					href="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg">
					<img
					src="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg"
					alt="초롱3" style="width: 180px; height: 180px" class="img-thumbnail" />
				</a>
			</div>
			<div class="col-md-4 text-center">
				<a
					href="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg">
					<img
					src="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg"
					alt="초롱4" style="width: 180px; height: 180px" class="img-thumbnail" />
				</a>
			</div>
			<div class="col-md-4 text-center">
				<a
					href="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg">
					 <img
					src="${pageContext.request.contextPath}/upload/0fa2235d-4157-49af-87c9-00bb7e6b8edc.jpg"
					alt="초롱5" style="width: 180px; height: 180px" class="img-thumbnail" />
				</a>
			</div>
			 --%>
		</div>
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

<script defer type="text/javascript">
	document.getElementById("ex_file").onchange = function() {
		document.getElementById("form").submit();
	};
</script>
</html>