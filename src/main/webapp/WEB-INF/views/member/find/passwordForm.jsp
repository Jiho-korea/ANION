<!-- 
========================================================================
파    일    명 : passwordForm.jsp
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.3
작  성  내  용 : 비밀번호를 찾기 위한 ID 입력폼
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

.div-map {
	position: relative;
	align-items: center;
	margin-bottom: 3rem;
	display: inline-block;
	display: flex;
	margin-left: auto;
	margin-right: auto;
	max-width: 100%;
}

.input-map {
	line-height: 40px;
	border: none;
	outline: none;
	background: #f9f9ff;
	padding: 0 20px;
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

	<div class="container text-center" id="main" style="width: 70%">
		<h1 class="display-4">
			<spring:message code="edit.member.password.refresh" />
		</h1>

		<br>
		<div style="background: transparent !important"
			class="jumbotron border">
			<h2 style="text-align: left">
				<b><spring:message code="temp.send.email.password" /></b>
			</h2>
			<br> <br>

			<form:errors />

			<form:form
				action="${pageContext.request.contextPath}/member/find/password"
				method="post" cssClass="form-signin" style="display:inline;"
				modelAttribute="memberProfileRequest">

				<div class="div-map">
					<form:input path="memberId" cssClass="input-map" type="email"
						placeholder="이메일 / Email" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '이메일 / Email'" style="width:350px" />
					<button id="btn_send" class="btn btn-info pull-right" type="submit">
						<spring:message code="send" />
					</button>
				</div>
				<form:errors path="memberId" />

				<hr class="my-4">
				<h4 style="text-align: left">
					<a href="${pageContext.request.contextPath}/login"
						style="color: blue;"><spring:message code="go.login" /></a> | <a
						href="${pageContext.request.contextPath}/signup/step1"
						style="color: blue;"><spring:message code="go.register" /></a>
				</h4>
			</form:form>
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
	<script defer type="text/javascript">
		function CheckEmail(str) {
			var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
			if (!reg_email.test(str)) {
				return false;
			} else {
				return true;
			}
		}
	</script>

	<script defer
		src="${pageContext.request.contextPath}/js/vendor/modernizr-3.5.0.min.js">
		
	</script>
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
	 $("#btn_send").click(function() {
		if ($("#memberId").val() == "") {
			alert("이메일을 입력해주세요.");
			return false;
		} else if (!CheckEmail($("#memberId").val())) {
			alert("이메일의 형식이 아닙니다.");
			return false;
		}
	});
</script>
</html>