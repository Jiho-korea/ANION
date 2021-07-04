<%--
========================================================================
파    일    명 : imageList.jsp
========================================================================
작    성    자 : 배준철
작    성    일 : 2020.10.20
작  성  내  용 : 이미지갤러리 참고용
========================================================================
수    정    자 : 강지호
수    정    일 : 2020.10.22
수  정  내  용 : C를 거쳐 뷰페이지 보이도록 수정
========================================================================
수    정    자 : 임원석,정세진
수    정    일 : 2021.01.30
수  정  내  용 : 사진삭제외관만 수정
========================================================================
수    정    자 : 임원석,정세진
수    정    일 : 2021.02.02
수  정  내  용 : 사진 다중업로드 및 전체삭제 외관 수정
========================================================================
* 파일선택하면 자동으로 비동기식으로 업로드 되도록 처리하면 될듯
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<title><spring:message code="home.title" /></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<%--link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script--%>
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

.btn_share {
	border: none;
	width: 32px;
	height: 32px;
	cursor: pointer;
	background-color: transparent;
}
</style>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#allCheck").click(function() {
			if ($("#allCheck").prop("checked")) {
				$("input[type=checkbox]").prop("checked", true);
			} else {
				$("input[type=checkbox]").prop("checked", false);
			}
		})
	})

	$(function() {
		$("#deleteButton").click(function() {
			if ($("input:checkbox[type=checkbox]:checked").length == 0) {
				alert("삭제할 사진을 선택해 주세요.");
				return false;
			} else {
				return true
			}
		})
	})
</script>

</head>
<body>

	<c:import url="../../included/top.jsp" />
	<div class="container text-center">
		<div id="main">
			<h1 class="display-4">
				<spring:message code="image.gallery" />
			</h1>
		</div>
		<div class="text-right mb-10">

			<c:choose>
				<c:when test="${delete ne 1}">
					<div class="filebox">

						<form action="${pageContext.request.contextPath}/info/list/image"
							id="form" method="post" class="form-signin"
							enctype="multipart/form-data">
							<a href="${pageContext.request.contextPath}/pet/list">
								<button type="button" value="true"
									class="btn btn-info pull-left" style="float: left;">
									<spring:message code="go.list" />
								</button>
							</a> <label for="ex_file"><a class="btn btn-info"
								style="color: white;"><spring:message
										code="list.image.upload" /></a></label> <input type="file"
								multiple="multiple" name="file" id="ex_file"
								style="display: none" accept="image/*"
								onchange="checkFile(this)" /> <input type="hidden"
								name=petRegistrationNumber id="prn"
								value="${petRegistrationNumber}" /> <a href="#" class="mb-30">
								<button type="submit" name="delete" value="true"
									class="btn btn-info pull-right">
									<spring:message code="list.image.delete" />
								</button>
							</a>
							<div class="row gallery-item">
								<c:forEach var="image" items="${imageList}" varStatus="status">
									<div class="col-md-4">
										<a
											href="${pageContext.request.contextPath}/upload/${image.imagePath}"
											class="img-pop-up">
											<div class="single-gallery-image"
												style="background: url(${pageContext.request.contextPath}/upload/${image.imagePath});"></div>
										</a>
										<%-- 버튼안 텍스트 옆에 이미지를 넣는 방법
										<button type="button" id="" class="btn btnEvent">
											<img
												src="https://img.icons8.com/flat-round/64/000000/share--v1.png"
												alt="btnImages" class="btnImages">
										</button>
										--%>
										
										<%-- 공유하기 버튼!! 임시 삭제
										<a
											href="${pageContext.request.contextPath}/posting/img?imageNumber=${image.imageNumber}"><button
												class="btn_share mt-2 mr-3" id="btn_share" type="button">
												<img
													src="${pageContext.request.contextPath}/img/button/share1.png">
											</button></a>  --%>
									</div>
								</c:forEach>
							</div>
						</form>
					</div>
				</c:when>

				<c:otherwise>
					<form
						action="${pageContext.request.contextPath}/info/list/imageDelete"
						id="form" method="post" class="form-signin"
						enctype="multipart/form-data">
						<input type="checkbox" id="allCheck" />
						<spring:message code="check.all" />
						&nbsp; <input type="submit" class="btn btn-info pull-right"
							value="<spring:message code="delete.button" />" id="deleteButton">
						&nbsp; <a
							href="${pageContext.request.contextPath}/info/list/image?petRegistrationNumber=${petRegistrationNumber}"
							class="btn btn-info pull-right" id="cancelButton"
							style="color: #ffffff"><spring:message code="cancel" /></a> <input
							type="hidden" name=petRegistrationNumber id="prn"
							value="${petRegistrationNumber}" />
						<div class="row gallery-item">
							<c:forEach var="image" items="${imageList}" varStatus="status">
								<div class="col-md-4">
									<a
										href="${pageContext.request.contextPath}/upload/${image.imagePath}"
										class="img-pop-up">
										<div class="single-gallery-image"
											style="background: url(${pageContext.request.contextPath}/upload/${image.imagePath});"></div>
									</a> <br>
									<div
										class="checkBox d-flex justify-content-center align-items-center">
										<input type="checkbox" name="chBox" class="chBox"
											value="${image.imagePath}" />
									</div>
								</div>
							</c:forEach>
						</div>
					</form>
				</c:otherwise>
			</c:choose>

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

<script defer type="text/javascript">
	document.getElementById("ex_file").onchange = function() {
		document.getElementById("form").submit();
	};
</script>
</html>