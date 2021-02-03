<%--
========================================================================
파    일    명 : pet.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.11.09
작  성  내  용 : 반려견 세부 정보 페이지
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.11.20
수  정  내  용 : 모델에서 견종이름을 받을 수 있도록 수정
========================================================================
수    정    자 : 강지호
수    정    일 : 2021.01.25
수  정  내  용 : 견명 변경 폼 완성
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
<!-- 기존의 폰트 사용해라 -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">

<style>
#main {
	width: 100%;
	margin-top: 50px;
}
</style>
<title><spring:message code="home.title" /></title>
</head>
<body class="text-center">
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div class="container" id="main" style="width: 70%">
		<h1 class="display-4">
			<spring:message code="info.pet.banner" />
		</h1>
		<br>
		<div style="background: transparent !important"
			class="jumbotron border">
			<h2 style="text-align: left">
				<b><spring:message code="info.pet.profile" /></b>
			</h2>
			<br> <br>
			<h4 style="text-align: left">
				<c:choose>
					<c:when test="${empty updatePname}">
						<spring:message code="info.pet.name">
							<spring:argument value="${pet.petName}" />
						</spring:message>

						<a
							href="${pageContext.request.contextPath}/info/pet/updatePname?petRegistrationNumber=${pet.petRegistrationNumber}"
							style="color: lightgray;" class="ml-10"><i
							class="far fa-edit"></i></a>

					</c:when>
					<c:when test="${updatePname}">
						<form:form
							action="${pageContext.request.contextPath}/info/pet/updatePname?petRegistrationNumber=${pet.petRegistrationNumber}"
							method="post" cssClass="form-signin"
							modelAttribute="petNameUpdateRequest"
							enctype="multipart/form-data">
							<spring:message code="info.pet.name">
								<spring:argument value="" />
							</spring:message>
							<form:input path="petName" placeholder="변경할 이름"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = '변경할 이름'" value="${pet.petName}" />

							<input type="hidden" name="petRegistrationNumber"
								value="${pet.petRegistrationNumber}" />
							<input type="submit" name="btn_modify" id="btn_modify" value="수정" />

							<a
								href="${pageContext.request.contextPath}/info/pet?petRegistrationNumber=${pet.petRegistrationNumber}"><input
								type="button" name="btn_modify_cancle" id="btn_modify_cancle"
								value="취소" /> </a>
							<form:errors path="petName" />
						</form:form>
					</c:when>

				</c:choose>


			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.kind">
					<spring:argument value="${pet.kindcode.petKind}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.birthday">
					<spring:argument value="${pet.petBirthday}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.sex">
					<spring:argument value="${pet.petSex}" />
				</spring:message>
			</h4>
		</div>

		<div style="background: transparent !important"
			class="jumbotron border">
			<h2 style="text-align: left">
				<b><spring:message code="info.pet.parent" /></b>
			</h2>
			<br> <br>

			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.mothername">
					<spring:argument value="${pet.petMothername}" />
				</spring:message>
				<a href="#" style="color: lightgray;" class="ml-10"><i
					class="far fa-edit"></i></a>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.fathername">
					<spring:argument value="${pet.petFathername}" />
				</spring:message>
				<a href="#" style="color: lightgray;" class="ml-10"><i
					class="far fa-edit"></i></a>
			</h4>
		</div>

		<div style="background: transparent !important"
			class="jumbotron border">
			<h2 style="text-align: left">
				<b><spring:message code="info.pet.registration" /></b>
			</h2>
			<br> <br>
			<h4 style="text-align: left">
				<spring:message code="info.pet.microchip">
					<spring:argument value="${pet.petMicrochip}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.registration.date">
					<spring:argument value="${pet.petRegistrationDate}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.pet.image.count">
					<spring:argument value="${pet.imageCount}" />
				</spring:message>
			</h4>
		</div>

		<a href="#">
			<button id="btn_modification" class="btn btn-info pull-right">
				<spring:message code="go.agree" />
			</button>
		</a> <br> <br>
	</div>

	<c:import url="../included/bottom.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<!-- Scroll Up -->
	<div id="back-top">
		<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>

	<!-- JS here -->
	<script defer type="text/javascript" charset="utf-8">
		/*
			$('#updatePname').on('click', function() {
				alert("테스트");
			});
		 */
	</script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		charset="utf-8"></script>
	<script defer
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"
		charset="utf-8"></script>
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
	<script defer
		src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<!-- Jquery Plugins, main Jquery -->
	<script defer src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>