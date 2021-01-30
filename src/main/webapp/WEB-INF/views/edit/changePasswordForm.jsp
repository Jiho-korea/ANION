<%--
========================================================================
파    일    명 : changePasswordForm.jsp
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.15
작  성  내  용 : 비밀번호 변경 폼 페이지
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<style>
#main {
	width: 100%;
	margin-top: 50px;
}
</style>
<body class="text-center">
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div class="container text-center" id="main">
		<div class="jumbotron border">
			<h1 class="display-4">
				<spring:message code="edit.member.password.change" />
			</h1>
			<br> <br>

			<form:form
				action="${pageContext.request.contextPath}/edit/passwordChange"
				method="post" modelAttribute="changePasswordCommand">

				<p>
					<label> <form:password path="currentPassword"
							cssClass="single-input" placeholder="현재 비밀번호"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '현재 비밀번호'" /> <form:errors
							path="currentPassword" />
					</label>
				</p>

				<p>
					<label> <form:password path="newPassword"
							cssClass="single-input" placeholder="새 비밀번호"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '새 비밀번호'" /> <form:errors
							path="newPassword" />
					</label>

				</p>
				<p>
					<label> <form:password path="checkNewPassword"
							cssClass="single-input" placeholder="새 비밀번호 확인"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '새 비밀번호 확인'" /> <form:errors
							path="checkNewPassword" />
					</label>
				</p>

				<button id="btn_login" class="btn btn-info pull-right" type="submit">
					<spring:message code="go.agree" />
				</button>
			</form:form>
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
<script defer type="text/javascript" charset="utf-8">
	 $("#btn_login").click(function() {
		if ($("#currentPassword").val() == "") {
			alert("비밀번호을 입력해주세요.");
			return false;
		} else if ($("#newPassword").val() == "") {
			alert("새 비밀번호를 입력해주세요");
			return false;
		} else if ($("#checkNewPassword").val() == "") {
			alert("새 비밀번호를 다시 입력해주세요");
			return false;
		} else if ($("#currentPassword").val() == $("#newPassword").val()) {
			alert("현재 비밀번호와 새 비밀번호가 같습니다.");
			return false;
		} else if ($("#newPassword").val() != $("#checkNewPassword").val()) {
			alert("비밀번호와 비밀번호 확인란이 동일하지 않습니다.");
			return false;
		}
	});
</script>

</html>