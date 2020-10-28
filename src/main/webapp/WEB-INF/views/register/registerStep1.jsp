<%--
========================================================================
파    일    명 : registerStep1.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.10.10
작  성  내  용 : 정보등록
========================================================================
수    정    자 : 배준철
수    정    일 : 2020.10.19
수  정  내  용 : 파일찾기주석
========================================================================
--%>
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

<title><spring:message code="register.pet.title" /></title>
</head>
<body class="text-center">
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container" id="main">
		<div class="jumbotron">
			<h4 class="mb-4">
				<spring:message code="register.pet" />
			</h4>
			<form:form action="${pageContext.request.contextPath}/register/step2"
				method="post" cssClass="form-signin"
				modelAttribute="petRegisterRequest" onsubmit="return clickEvent()"
				enctype="multipart/form-data">
				<div class="row" style="display: none;">
					<label><input type="file" name="file"></label>
				</div>
				<div class="row">
					<div class="col-md-6 mb-1">
						<label> <spring:message code="pet.name" /> <form:input
								path="petName" cssClass="form-control" /> <form:errors
								path="petName" />
						</label>
					</div>
					<div class="col-md-6 mb-1">
						<label> <spring:message code="pet.kind" /><br
							class="mb-4" /> <form:select path="petKind">
								<form:option cssClass="form-control" value="동경이" />
								<form:option cssClass="form-control" value="진돗개" />
								<form:option cssClass="form-control" value="기타" />
							</form:select> <form:errors path="petKind" />
						</label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 mb-1">
						<label> <spring:message code="pet.mothername" /> <form:input
								path="petMothername" cssClass="form-control" /> <form:errors
								path="petMothername" />
						</label>
					</div>
					<div class="col-md-6 mb-1">
						<label> <spring:message code="pet.father" /> <form:input
								path="petFathername" cssClass="form-control" /> <form:errors
								path="petFathername" />
						</label>
					</div>
				</div>

				<label><spring:message code="pet.sex" /> <br class="mb-4" />
					<!-- <input type="text" name="petSex" value="1">--> <form:radiobutton
						path="petSex" value="수컷" /> <spring:message code="pet.male" />&nbsp;&nbsp;&nbsp;&nbsp;<form:radiobutton
						path="petSex" value="암컷" /> <spring:message code="pet.female" />
					<br class="mb-4" /> <form:errors path="petSex" /></label>

				<br class="mb-4" />
				<label> <spring:message code="pet.microchip" /> <form:input
						path="petMicrochip" cssClass="form-control" /> <form:errors
						path="petMicrochip" />
				</label>
				<br class="mb-4" />
				<br class="mb-4" />
				<label> <spring:message code="pet.birthday" /> <input
					type="date" name="petBirthday" /><br class="mb-4" /> <form:errors
						path="petBirthday" />
				</label>
				<br class="mb-4" />
				<br class="mb-4" />
				<hr class="mb-4" />
				<button id="btn_register" class="btn btn-info pull-right"
					type="submit">
					<spring:message code="go.pet.register" />
				</button>
			</form:form>
		</div>
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