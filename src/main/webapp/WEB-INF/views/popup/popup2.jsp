<!-- 
========================================================================
파    일    명 : popup2.jsp
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.05.03
작  성  내  용 : 대동견지도
========================================================================
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ANION popup1</title>
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
body {
	background-repeat: no-repeat;
	background-position: left top;
	background-attachment: fixed;
}

.jumbotron {
	opacity: 0.8;
}
</style>
<body>
	<img src="${pageContext.request.contextPath}/img/popupBack/dog_map.jpg"
		width="900" height="600" usemap="#dogmap">

	<map name="dogmap">
		<c:forEach var="kindcode" items="${kindcodeList}" varStatus="status">
			<area shape="rect" coords="600,300,700,200"
				href="${pageContext.request.contextPath}/popup/2/click/${kindcode.petKindcode}">
		</c:forEach>
	</map>

	<div class="container d-flex justify-content-center mt-5">
		<select style="display: none;" id="childKindcode" name="childKindcode">
			<c:if test="${empty kindcode}">
				<option value=""></option>
			</c:if>
			<c:if test="${not empty kindcode}">
				<option value="${kindcode.petKindcode }"></option>
			</c:if>
			<c:forEach var="kindcode" items="${kindcodeList}" varStatus="status">
				<option value="${kindcode.petKindcode}">${kindcode.petKind}</option>
			</c:forEach>


		</select>
		<div class="nice-select" tabindex="0">

			<c:if test="${empty kindcode}">
				<span class="current">견종 / Dog breed</span>
			</c:if>
			<c:if test="${not empty kindcode}">
				<span class="current">${kindcode.petKind }</span>
			</c:if>
			<ul class="list">
				<li data-value="견종 / Dog breed" class="option selected focus"
					hidden="">견종 / Dog breed</li>
				<c:forEach var="kindcode" items="${kindcodeList}" varStatus="status">
					<li data-value="${kindcode.petKindcode}" class="option">${kindcode.petKind}</li>
				</c:forEach>
			</ul>
		</div>

		&nbsp;&nbsp;
		<button type="button"
			class="btn header-btn d-flex justify-content-center"
			onclick="dogSelect();">Select</button>
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
<script defer type="text/javascript">
	var width = window.outerWidth;
	var height = window.outerHeight;
	function popResizer() {
		window.resizeTo(width, height);
	};

	popResizer();
	$(window).resize(popResizer);

	function dogSelect() {
		if ($("[name=childKindcode] > option:selected").val() == '') {
			alert("견종을 선택해주세요.");
			return false;
		}

		$("#petKindcode", opener.document).val(
				document.getElementById("childKindcode").value);
		window.close();
	}
</script>
</html>