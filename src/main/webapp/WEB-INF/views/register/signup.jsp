<!-- 
========================================================================
작    성    자 : 정세진, 임원석
작    성    일 : 2020.11.09
작  정  내  용 : 회원가입 폼 jsp
========================================================================
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width , initial-scale=1" />
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

<title><spring:message code="home.title" /></title>
</head>
<body>
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div class="container text-center" id="main">
		<div class="jumbotron"
			style="background: transparent !important; text-align: left">
			<form:form action="${pageContext.request.contextPath}/signup/step2"
				method="post" cssClass="form-signin"
				modelAttribute="ownerRegisterRequest">
				<h1 class="h1 mb-3 font-weight-bold">
					<spring:message code="go.register" />
				</h1>
				<br>

				<label> 
				<c:if test="${not empty duplicate}">
					<form:input path="ownerId" cssClass="single-input"
						placeholder="아이디" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '아이디'" readonly="true" />
				</c:if>
				<c:if test="${empty duplicate}">
					<form:input path="ownerId" cssClass="single-input"
						placeholder="아이디" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '아이디'" />
			
				</c:if>
				</label>
				<label>
				<c:if test="${not empty duplicate}">
					<button type="submit"
						formaction="${pageContext.request.contextPath}/signup/check/duplicate"
						formmethod="post" disabled="disabled" class="btn btn-secondary">
						<spring:message code="signup.check.duplicate" />
					</button> <form:errors /> <form:errors path="ownerId"  />
				</c:if>
				<c:if test="${empty duplicate}">
					<button type="submit"
						formaction="${pageContext.request.contextPath}/signup/check/duplicate"
						formmethod="post" class="btn btn-secondary">
						<spring:message code="signup.check.duplicate" />
					</button> <form:errors /> <form:errors path="ownerId" />
			
				</c:if>
					
				</label>
				<Br>
				<label> <form:password path="ownerPassword"
						cssClass="single-input" placeholder="비밀번호"
						onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호'" />

				</label>
				<label> <form:errors path="ownerPassword" />
				</label>
				<br>
				<label> <form:input path="ownerName" cssClass="single-input"
						placeholder="이름" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '이름'" />
				</label>
				<label> <form:errors path="ownerName" />
				</label>
				<br>
				<label> <form:input path="ownerPhoneNumber"
						cssClass="single-input" placeholder="전화번호"
						onfocus="this.placeholder = ''" onblur="this.placeholder = '전화번호'" />

				</label>
				<label> <form:errors path="ownerPhoneNumber" />
				</label>
				<br>
				<br>


				<c:if test="${not empty duplicate}">
					<input type="hidden" name="dupCheck" value="true">
				</c:if>
				<button class="btn btn-info pull-right" type="submit">
					<spring:message code="go.register" />
				</button>
				<br>
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
	
</script>
</html>