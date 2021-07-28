<%--
========================================================================
파    일    명 : memberProfile.jsp
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.01.15
작  성  내  용 : 회원 정보 페이지
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.01.30
수  정  내  용 : 변경할 수 있도록 form 추가
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.02.30
수  정  내  용 : 이메일 변경버튼을 연속클릭시 data 중복삽입 발생하는 오류 제거
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.05
수  정  내  용 : Loading 폼 추가
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
<style>
#main {
	width: 100%;
	margin-top: 50px;
}

a, a:hover {
	color: #000000;
	text-decoration: none;
	'
}
</style>
</head>

<body>
	<c:import url="../../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div class="container text-center" id="main" style="width: 70%">
		<h1 class="display-4">
			<spring:message code="info.member.banner" />
		</h1>
		<br>
		<div style="background: transparent !important"
			class="jumbotron border">
			<h2 style="text-align: left">
				<b><spring:message code="info.member.profile" /></b>
			</h2>
			<br> <br>

			<form:errors />
			<h4 style="text-align: left">
				<c:choose>
					<c:when test="${empty updateId}">
						<spring:message code="info.member.id">
							<spring:argument value="${sessionScope.login.memberId }" />
						</spring:message>

						<a href="${pageContext.request.contextPath}/edit/updateId"
							style="color: lightgray;" class="ml-10"><i
							class="far fa-edit"></i></a>

						<c:if test="${sessionScope.login.memberauth.memberAuthStatus==2}">
							<a
								href="${pageContext.request.contextPath}/email/validForm?memberId=${sessionScope.login.memberId}"><input
								type="button" value=<spring:message code="valid" /> /> </a>
						</c:if>
					</c:when>
					<c:otherwise>
						<form:form
							action="${pageContext.request.contextPath}/edit/updateId"
							method="post" cssClass="form-signin"
							modelAttribute="changeIdCommand" enctype="multipart/form-data">
							<spring:message code="info.member.id">
								<spring:argument value="" />
							</spring:message>
							<form:input path="memberId" placeholder="변경할 이메일"
								value="${sessionScope.login.memberId }"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = '변경할  이메일'" />

							<input type="hidden" name="memberNumber"
								value="${sessionScope.login.memberNumber }" />
							<input type="submit" name="btn_modify" id="btn_modify"
								onclick="btn_submit()"
								value=<spring:message code="edit" /> />

							<a href="${pageContext.request.contextPath}/profile"><input
								type="button" name="btn_modify_cancel" id="btn_modify_cancel"
								value=<spring:message code="cancel" /> /> </a>

							<form:errors path="memberId" />
						</form:form>
					</c:otherwise>
				</c:choose>

				<form:errors path="memberId" />
			</h4>

			<hr class="my-4">
			<h4 style="text-align: left">
				<c:choose>
					<c:when test="${empty updateName}">
						<spring:message code="info.member.name">
							<spring:argument value="${sessionScope.login.memberName }" />
						</spring:message>
						<a href="${pageContext.request.contextPath}/edit/updateName"
							style="color: lightgray;" class="ml-10"><i
							class="far fa-edit"></i></a>
					</c:when>
					<c:otherwise>
						<form:form
							action="${pageContext.request.contextPath}/edit/updateName"
							method="post" cssClass="form-signin"
							modelAttribute="changeNameCommand" enctype="multipart/form-data">
							<spring:message code="info.member.name">
								<spring:argument value="" />
							</spring:message>
							<form:input path="memberName" placeholder="변경할 이름"
								value="${sessionScope.login.memberName }"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = '변경할  이름'" />
							<input type="hidden" name="memberNumber"
								value="${sessionScope.login.memberNumber }" />
							<input type="submit" name="btn_modify" id="btn_modify"
								onclick="btn_submit()"
								value=<spring:message code="edit" /> />

							<a href="${pageContext.request.contextPath}/profile"><input
								type="button" name="btn_modify_cancel" id="btn_modify_cancel"
								value=<spring:message code="cancel" /> /> </a>

							<form:errors path="memberName" />
						</form:form>
					</c:otherwise>
				</c:choose>
			</h4>

			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.member.registration.date">
					<spring:argument value="${sessionScope.login.memberRegisterDate}" />
				</spring:message>
			</h4>
			<hr class="my-4">
			<h4 style="text-align: left">
				<spring:message code="info.member.authlevel">
					<spring:argument
						value="${sessionScope.login.memberlevel.memberLevelDescription}" />
				</spring:message>
			</h4>

			<!-- css 수정해야할 부분 -->
			<hr class="my-4">
			<h4 style="text-align: left">
				<a href="${pageContext.request.contextPath}/edit/updatePassword"
					style="color: blue;"><spring:message
						code="edit.member.password.change" /></a>
			</h4>
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
		function btn_submit() {
			document.getElementById('btn_modify_cancel').style.visibility = 'hidden';
			const target = document.getElementById('btn_modify');
			var regExp = /[^ㄱ-ㅎ|^ㅏ-ㅣ|^가-힣|^a-z|^A-Z|^0-9]/;
			
			target.disabled = true;
			target.value = 'Loading';
			
			if(regExp.test($("#memberName").val())){
				alert("이름에 특수문자를 입력할 수 없습니다.");
				location.reload();
				
				return false();
			}
			target.form.submit();
			
		}
	</script>
	<script defer
		src="${pageContext.request.contextPath}/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script defer
		src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script defer src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
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
	<script defer src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
	<!-- Progress -->
	<script defer src="${pageContext.request.contextPath}/js/jquery.barfiller.js"></script>

	<!-- counter , waypoint,Hover Direction -->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.counterup.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/waypoints.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/hover-direction-snake.min.js"></script>

	<!-- contact js -->
	<script defer src="${pageContext.request.contextPath}/js/contact.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/mail-script.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script defer src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script defer src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</body>
</html>