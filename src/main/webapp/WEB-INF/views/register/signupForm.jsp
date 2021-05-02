<!-- 
========================================================================
작    성    자 : 정세진, 임원석
작    성    일 : 2020.11.09
작  성  내  용 : 회원가입 폼 jsp
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.19
수  정  내  용 : 자바스크립트 유효성 검증 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2020.11.17
수  정  내  용 : 아이디 중복체크 -> 이메일 인증 방식의 폼 jsp
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
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div class="container text-center" id="main">
		<div
			class="jumbotron d-flex justify-content-center align-items-center"
			style="background: transparent !important;">
			<form:form action="${pageContext.request.contextPath}/signup/step2"
				method="post" cssClass="form-signin"
				modelAttribute="memberRegisterRequest">
				<h1 class="h1 mb-3 font-weight-bold">
					<spring:message code="go.register" />
				</h1>
				<br>

				<form:errors />
				<br>
				<br>
				<label> <form:input path="memberId" cssClass="single-input"
						placeholder="이메일 / Email" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '이메일 / Email'" cssStyle="width:350px" />
				</label>
				<label> <form:errors path="memberId" />
				</label>

				<br>

				<label> <form:password path="memberPassword"
						cssClass="single-input mt-2" placeholder="비밀번호 / Password"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = '비밀번호 / Password'"
						cssStyle="width:350px" />

				</label>
				<label> <form:errors path="memberPassword" />
				</label>

				<br>
				<label> <form:password path="checkPassword"
						cssClass="single-input mt-2"
						placeholder="비밀번호 확인 / Confirm Password"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = '비밀번호 확인 / Confirm Password'"
						cssStyle="width:350px" />
				</label>
				<label> <form:errors path="checkPassword" />
				</label>

				<br>
				<label> <form:input path="memberName"
						cssClass="single-input mt-2" placeholder="이름 / Name"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = '이름 / Name'" cssStyle="width:350px" />
				</label>
				<label> <form:errors path="memberName" />
				</label>
				<br>
				<label> <form:input path="memberPhoneNumber"
						cssClass="single-input mt-2" placeholder="전화번호 / Phone Number"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = '전화번호 / Phone Number'"
						onKeyup="inputPhoneNumber(this);" maxlength="13"
						pattern=".{13,13}" cssStyle="width:350px" />

				</label>
				<label> <form:errors path="memberPhoneNumber" />
				</label>
				<br>

				<button id="btn_register" class="btn btn-info pull-right mt-5"
					type="submit">
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
	<script>
		function inputPhoneNumber(obj) {

			var number = obj.value.replace(/[^0-9]/g, "");
			var phone = "";

			if (number.length < 4) {
				return number;
			} else if (number.length < 7) {
				phone += number.substr(0, 3);
				phone += "-";
				phone += number.substr(3);
			} else if (number.length < 11) {
				phone += number.substr(0, 3);
				phone += "-";
				phone += number.substr(3, 3);
				phone += "-";
				phone += number.substr(6);
			} else {
				phone += number.substr(0, 3);
				phone += "-";
				phone += number.substr(3, 4);
				phone += "-";
				phone += number.substr(7);
			}
			obj.value = phone;
		}
	</script>
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
	$("#btn_register").click(function() {
		const target = document.getElementById('btn_register');
		opacity: 0.3;
		target.disabled = true;
		target.value = 'Loading';

		if ($("#memberId").val() == "") {
			setTimeout(function() {
				alert("이메일을 입력해주세요.");
				target.disabled = false;
				target.value = '<spring:message code="go.register" />';
			}, 100);
			return false;
		} else if ($("#memberPassword").val() == "") {
			setTimeout(function() {
				alert("비밀번호을 입력해주세요.");
				target.disabled = false;
				target.value = '<spring:message code="go.register" />';
			}, 100);
			return false;
		} else if ($("#memberPassword").val() != $("#checkPassword").val()) {
			setTimeout(function() {
				alert("비밀번호와 비밀번호 확인란이 동일하지 않습니다.");
				target.disabled = false;
				target.value = '<spring:message code="go.register" />';
			}, 100);
			return false;
		} else if ($("#memberName").val() == "") {
			setTimeout(function() {
				alert("이름을 입력해주세요.");
				target.disabled = false;
				target.value = '<spring:message code="go.register" />';
			}, 100);
			return false;
		} else if ($("#memberPhoneNumber").val() == "") {
			setTimeout(function() {
				alert("전화번호를 입력해주세요.");
				target.disabled = false;
				target.value = '<spring:message code="go.register" />';
			}, 100);
			return false;
		}

		target.form.submit();

	});
</script>

</html>