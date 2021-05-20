<%--
========================================================================
파    일    명 : posting.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.05
작  성  내  용 : 사진 자랑 게시물 작성 페이지
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width , initial-scale=1" />
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
<title><spring:message code="home.title" /></title>

</head>
<body>
	<c:import url="../../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container" style="margin-top: 60px">
		<div class="row-col">

			<form:form action="${pageContext.request.contextPath}/posting/img"
				method="post" cssClass="form-signin"
				modelAttribute="imagePostingRequest"
				onsubmit="return submitPosting()">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;"><spring:message
									code="posting.page.img.head" /> <form:errors /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><form:input path="imgpostTitle" cssClass="form-control"
									cssStyle="font-size: 13px" placeholder="제목 / Title"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '제목 / Title'" maxlength="1024" /> <form:errors
									path="imgpostTitle" /></td>
						</tr>
						<tr>
							<td><form:textarea path="imgpostContent"
									cssClass="form-control" placeholder="내용 / Content"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '내용 / Content'" maxlength="2048"
									cssStyle="height: 350px; font-size: 13px" /> <form:errors
									path="imgpostContent" /></td>
						</tr>
						<tr>
							<td>
								<div class="col-md-4">
									<img alt="" width="100px"
										src="${pageContext.request.contextPath}/upload/${image.imagePath}">
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<form:hidden path="imageNumber" value="${image.imageNumber}" />
				<%-- 
				<form:hidden path="petRegistrationNumber"
					value="${petRegistrationNumber}" /> --%>
				<input type="submit" class="btn btn-primary pull-right mr-5"
					style="margin-left: 91%"
					value="<spring:message code="posting.page.img.post" />" />
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

</body>
<script defer type="text/javascript" charset="utf-8">
	function submitPosting() {
		if ($("#imgpostTitle").val() == "") {
			alert("제목을 입력해주세요.");
			return false;
		} else if ($("#imgpostContent").val().length < 2) {
			alert("내용은 최소 2자 이상 입력해 주십시오.");
			return false;
		}
		return true;
	}
</script>
</html>