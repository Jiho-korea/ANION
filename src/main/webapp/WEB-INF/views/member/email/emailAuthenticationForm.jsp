<!-- 
========================================================================
파    일    명 : emailAuthenticationForm.jsp
========================================================================
작    성    자 : 송찬영
작    성    일 : 2020.11.17
작  성  내  용 : 회원가입후 안내 페이지
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.03.20
수  정  내  용 : 회원가입, 이메일 변경 후 emailcode 확인 페이지
========================================================================
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
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
</style>
<script defer src="https://code.jquery.com/jquery-3.1.1.min.js"
	charset="utf-8"></script>
<script defer
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"
	charset="utf-8"></script>
<title><spring:message code="home.title" /></title>
</head>
<body>
	<c:import url="../../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container text-center" id="main">
		<div class="jumbotron">
			<h1 class="display-4">
				<spring:message code="valid.email" />
			</h1>

			<br> <br>

			<form:form action="${pageContext.request.contextPath}/email/valid"
				method="post" cssClass="form-signin" modelAttribute="emailcode">


				<br>
				<br>

				<input type="hidden" name="memberId" value="${memberId}" />
				<label> <form:input path="emailCode" cssClass="single-input"
						placeholder="Write Emailcode..." onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Write Emailcode...'" /> <form:errors
						path="emailCode" /> <form:errors />
				</label>

				<br>
				<br>

				<button id="btn_submit" class="btn btn-info pull-right" type="submit">
					<spring:message code="valid.email" />
				</button>

				<p class="mt-5 mb-3 text-muted">
					<spring:message code="company.name" />
				</p>
			</form:form>


			<%-- <spring:message code="valid.email.confirm">
					<c:choose>
						<c:when test="${!empty register }">
							<spring:argument value="${memberRegisterRequest.memberId}" />
						</c:when>
						<c:when test="${!empty update }">
							<spring:argument value="${changeIdCommand.memberId}" />
						</c:when>
					</c:choose>
				</spring:message> --%>

			<br class="mb-4" />
			<hr class="mb-4" />
			<div class="row"></div>
		</div>
	</div>

	<c:import url="../../included/bottom.jsp">
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
<script defer type="text/javascript" charset="utf-8">
	$("#btn_submit").click(function() {

		if ($("#emailCode").val() == "") {
			setTimeout(function() {
				alert("인증코드를 입력해주세요.");

			}, 100);
			return false;
		} 

		target.form.submit();
	});
</script>
</html>