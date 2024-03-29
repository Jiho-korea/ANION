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
수    정    자 : 임원석, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 견종 null값 data 삽입되는 오류 수정
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.11.17
수  정  내  용 : 디자인 수정
========================================================================
수    정    자 : 정세진, 송찬영
수    정    일 : 2020.11.19
수  정  내  용 : 자바스크립트 유효성 검증 추가
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.11.23
수  정  내  용 : 견종 선택 시 요청 파라미터에 status 값이 아닌 견종 코드가 들어가도록 수정
========================================================================
수    정    자 : 송찬영
수    정    일 : 2021.05.06
수  정  내  용 : 품종 선택 시 팝업창을 통해 처리
========================================================================
수    정    자 : 정세진
수    정    일 : 2021.05.10
수  정  내  용 : 특수문자 입력방지 추가
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
	margin-left: 7%;
	width: 69%;
	line-height: 40px;
	border: none;
	outline: none;
	background: #f9f9ff;
	padding: 0 20px 0 10px;
}

.single-input-petRegister {
	display: block;
	margin-left: -2%;
	width: 104.5%;
	line-height: 40px;
	border: none;
	outline: none;
	background: #f9f9ff;
	padding: 0 20px 0 10px;
}
</style>

<title><spring:message code="home.title" /></title>
</head>
<body onload="check()">
	<c:import url="../../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container text-center" id="main">
		<div class="jumbotron">
			<h1 class="display-4">
				<spring:message code="register.pet" />
			</h1>
			<br>
			<form:form action="${pageContext.request.contextPath}/register/step2"
				method="post" cssClass="form-signin"
				modelAttribute="petRegisterRequest" onsubmit="return submitCheck()"
				enctype="multipart/form-data">

				<%--
				<div class="row" style="display: none;">
					<label><input type="file" name="file"></label>
				</div>
				 --%>

				<div class="row">
					<div class="col-md-6 mb-1">
						<label> <form:input path="petName"
								cssClass="single-input-petRegister" placeholder="* 견명 / Name"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = '* 견명 / Name'" /> <form:errors
								path="petName" />
						</label>
					</div>

					<div class="div-map" id="default-select">
						<form:input path="petKind" cssClass="input-map"
							placeholder="* 견종 / Kind" name="petKind" id="petKind"
							readonly="true" />
						<button type="button" onclick="dogmapPopup();"
							style="border: 0; cursor: pointer; background-color: #f9f9ff;">
							<img width="38" height="38"
								src="${pageContext.request.contextPath}/img/button/dog_marker.png" />
						</button>

						<%-- 
						<select style="display: none;" name="petKindcode">
							<option value="">견종 / Dog breed</option>
							<c:forEach var="kindcode" items="${kindcodeList}"
								varStatus="status">
								<option value="${kindcode.petKindcode}">${kindcode.petKind}</option>
							</c:forEach>
						</select>
						<div class="nice-select" tabindex="0">
							<span class="current">견종 / Dog breed</span>
							<ul class="list">
								<li data-value="견종 / Dog breed" class="option selected focus"
									hidden="">견종 / Dog breed</li>
								<c:forEach var="kindcode" items="${kindcodeList}"
									varStatus="status">
									<li data-value="${kindcode.petKindcode}" class="option">${kindcode.petKind}</li>
								</c:forEach>
								<!-- 
								<li data-value="1" class="option">동경이</li>
								<li data-value="2" class="option">진돗개</li>
								--!>
							</ul>
						</div>
						 --%>
						<form:errors path="petKind" />
					</div>
				</div>

				<br class="mb-4" />
				<div class="row">
					<div class="col-md-6 mb-1">
						<label> <form:input path="petMothername"
								cssClass="single-input-petRegister" placeholder="  모견명 / Dog`s mother"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = '  모견명 / Dog`s Mother'" /> <form:errors
								path="petMothername" />


						</label>
					</div>
					<div class="col-md-6 mb-1">
						<label> <!--<spring:message code="pet.father" />--> <form:input
								path="petFathername" cssClass="single-input-petRegister"
								placeholder="  부견명 / Dog`s father" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '  부견명 / Dog`s father'" /> <form:errors
								path="petFathername" />
						</label>
					</div>
				</div>
				<br class="mb-4" />
				<label><spring:message code="pet.sex" /> : <!-- <input type="text" name="petSex" value="1">-->
					<form:radiobutton path="petSex" value="수컷" /> <spring:message
						code="pet.male" />&nbsp;&nbsp;&nbsp;&nbsp;<form:radiobutton
						path="petSex" value="암컷" /> <spring:message code="pet.female" />
					<br class="mb-4" /> <form:errors path="petSex" /></label>
				<br class="mb-4" />
				<br class="mb-4" />
				<label> <!--<spring:message code="pet.microchip" />--> <form:input
						path="petMicrochip" cssClass="single-input" cssStyle="width:350px"
						placeholder="마이크로칩 번호 / Microchip number" type="text" maxlength='15'
						onfocus="this.placeholder = ''" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
						onblur="this.placeholder = '마이크로칩 번호 / Microchip number'" /> <form:errors
						path="petMicrochip" />
				</label>
				<br class="mb-4" />
				<br class="mb-4" />
				<label> <spring:message code="pet.birthday" /> : <input
					type="date" name="petBirthday" id="petBirthday" max="${today}" /><br
					class="mb-4" /> <form:errors path="petBirthday" />
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
	
	function check(){
		var regExp = /[^ㄱ-ㅎ|^ㅏ-ㅣ|^가-힣|^a-z|^A-Z|^0-9]/;
		
		if (regExp.test($("#petName").val())){
			alert("특수문자는 입력할 수 없습니다.");
			return false;
		} else if (regExp.test($("#petMothername").val())) {
			alert("특수문자는 입력할 수 없습니다.");
			return false;
		} else if (regExp.test($("#petFathername").val())) {
			alert("특수문자는 입력할 수 없습니다.");
			return false;
		}
		return true;
	}

	function dogmapPopup() {
		window
				.open(
						"${pageContext.request.contextPath}/popup/petKind",
						"petKind_parent",
						"width=920, height=600, toolbar=no, location=no, resizable=no, directories=no, status=no, menubar=no");
	};

	//최대길이 지정
	function numberMaxLength(el, maxlength) {
		if (el.value.length > maxlength) {
			el.value = el.value.substr(0, maxlength);
		}
	}
	
	function submitCheck(){
		var regExp = /[^ㄱ-ㅎ|^ㅏ-ㅣ|^가-힣|^a-z|^A-Z|^0-9]/;
	
		if ($("#petName").val() == "") {
			alert("견명을 입력해주세요.");
			return false;
		} else if ($('#petKind').val() == "") {
			alert("견종을 선택해주세요.");
			return false;
		} else if ($(':radio[name="petSex"]:checked').length < 1) {
			alert("성별을 선택해주세요.");
			return false;
		} else if ($('#petBirthday').val() == "") {
			alert("생년월일을 입력해주세요.");
			return false;
		} else if (regExp.test($("#petName").val())) {
			alert("특수문자는 입력할 수 없습니다.");
			return false;
		} else if (regExp.test($("#petMothername").val())) {
			alert("특수문자는 입력할 수 없습니다.");
			return false;
		} else if (regExp.test($("#petFathername").val())) {
			alert("특수문자는 입력할 수 없습니다.");
			return false;
		} else if ($("#petMicrochip").val().length < 15
				&& $("#petMicrochip").val() != "") {
			alert("마이크로칩 번호는 15자리입니다.");
			return false;
		}
		return true;
	}
	
</script>
</html>
<!-- 
Copyright Dogtown Central, LLC. 
-->