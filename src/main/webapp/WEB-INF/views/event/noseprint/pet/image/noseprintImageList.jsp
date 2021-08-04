<%--
========================================================================
파    일    명 : noseprintImageList.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.04
작  성  내  용 : 비문 이미지 목록 화면
========================================================================
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
				alert("ܨfȒ ܧ¸; ܱƃȘ ܼࠤ.");
				return false;
			} else {
				return true
			}
		})
	})
</script>

</head>
<body>
	<c:import url="../../../../included/top.jsp" />
	<div class="container text-center">
		<div id="main">
			<h1 class="display-4">
				<c:choose>
					<c:when test="${empty admin}">
						<spring:message code="event.nose.list">
							<spring:argument value="${pet.petName}" />
						</spring:message>
					</c:when>
					<c:otherwise>
						<spring:message code="event.nose.list.admin">
							<spring:argument value="${member.memberName}" />
							<spring:argument value="${pet.petName}" />
						</spring:message>
					</c:otherwise>
				</c:choose>
			</h1>
		</div>
		<div class="text-right mb-10">
		
			<c:choose>
				<c:when test="${delete ne 1}">
					<div class="filebox">
						<c:choose>
							<c:when test="${not empty admin}">
								<c:choose>
									<c:when test="${check ne 1}">
										<form id="form" method="post" class="form-signin"
											enctype="multipart/form-data">

											<a
												href="${pageContext.request.contextPath}/admin/pet/npevent/${member.memberNumber}">
												<button type="button" value="true"
													class="btn btn-info pull-left" style="float: left;">
													<spring:message code="go.list" />
												</button>
											</a> <label for="ex_file"><a class="btn btn-info"
												style="color: white;"><spring:message
														code="event.nose.insert" /></a></label> <input type="file"
												multiple="multiple" name="file" id="ex_file"
												style="display: none" accept="image/*"
												onchange="checkFile(this)"
												formaction="${pageContext.request.contextPath}/admin/pet/image/npevent/${member.memberNumber}" />
											<input type="hidden" name=petRegistrationNumber id="prn"
												value="${pet.petRegistrationNumber}" />
											<button type="submit" value="true"
												class="btn btn-info pull-right"
												formaction="${pageContext.request.contextPath}/admin/pet/image/npevent/${member.memberNumber}/check">
												<spring:message code="event.noseprint.check" />
												<input type="hidden" name=petRegistrationNumber id="prn"
													value="${pet.petRegistrationNumber}" />
											</button>

											<c:if test="${empty admin}">
												<button type="submit" name="delete" value="true"
													class="btn btn-info pull-right">
													<spring:message code="event.nose.delete" />
												</button>
											</c:if>

											</a> <br> <a
												href="${pageContext.request.contextPath}/guidance/npevent"
												style="color: #DF6464; font-weight: bold;"> <spring:message
													code="event.nose.warming" />
											</a>
											<div class="row gallery-item">
												<c:forEach var="noseprintImage"
													items="${noseprintImageList}" varStatus="status">
													<div class="col-md-4">
														<a
															href="${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath}"
															class="img-pop-up">
															<div class="single-gallery-image"
																style="background: url(${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath});"></div>
														</a>
													</div>
												</c:forEach>
											</div>
										</form>
									</c:when>
									<c:otherwise>
										<form id="form" method="post" class="form-signin"
											enctype="multipart/form-data">

											<a
												href="${pageContext.request.contextPath}/admin/pet/npevent/${member.memberNumber}">
												<button type="button" value="true" 
													class="btn btn-info pull-left" style="float: left;">
													<spring:message code="go.list" />
												</button>

												<button type="submit" name="checkSubmit" value="true"
													formaction="${pageContext.request.contextPath}/admin/pet/image/npevent/auth/${member.memberNumber}/change"
													class="btn btn-info pull-right">
													<spring:message code="event.noseprint.check" />
													<input type="hidden" name=petRegistrationNumber id="prn"
														value="${pet.petRegistrationNumber}" />
												</button> <c:if test="${empty admin}">
													<button type="submit" name="delete" value="true"
														class="btn btn-info pull-right">
														<spring:message code="event.nose.delete" />
													</button>
												</c:if>

											</a> <br> <a
												href="${pageContext.request.contextPath}/guidance/npevent"
												style="color: #DF6464; font-weight: bold;"> <spring:message
													code="event.nose.warming" />
											</a>
											<div class="row gallery-item">
												<c:forEach var="noseprintImage"
													items="${noseprintImageList}" varStatus="status">
													<div class="col-md-4">
														<a
															href="${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath}"
															class="img-pop-up">
															<div class="single-gallery-image"
																style="background: url(${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath});"></div>
														</a> <br>
														<div
															class="checkBox d-flex justify-content-center align-items-center">
															<input type="checkbox" name="chBox" class="chBox"
																value="${noseprintImage.noseprintImagePath}">&nbsp
															<spring:message code="event.noseprint.ok" />
															</input>
														</div>
													</div>
												</c:forEach>
											</div>
									</c:otherwise>
								</c:choose>
							</c:when>

							<c:otherwise>
								<form
									action="${pageContext.request.contextPath}/info/list/npimage"
									id="form" method="post" class="form-signin"
									enctype="multipart/form-data">

									<a href="${pageContext.request.contextPath}/pet/list/npevent">
										<button type="button" value="true"
											class="btn btn-info pull-left" style="float: left;">
											<spring:message code="go.list" />
										</button>
									</a> <label for="ex_file"><a class="btn btn-info"
										style="color: white;"><spring:message
												code="event.nose.insert" /></a></label> <input type="file"
										multiple="multiple" name="file" id="ex_file"
										style="display: none" accept="image/*"
										onchange="checkFile(this)" /> <input type="hidden"
										name=petRegistrationNumber id="prn"
										value="${pet.petRegistrationNumber}" /> <a href="#"
										class="mb-30">
										<button type="submit" name="delete" value="true"
											class="btn btn-info pull-right">
											<spring:message code="event.nose.delete" />
										</button>
									</a> <br> <a
										href="${pageContext.request.contextPath}/guidance/npevent"
										style="color: #DF6464; font-weight: bold;"> <spring:message
											code="event.nose.warming" />
									</a>
									<div class="row gallery-item">
										<c:forEach var="noseprintImage" items="${noseprintImageList}"
											varStatus="status">
											<div class="col-md-4">
												<a
													href="${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath}"
													class="img-pop-up">
													<div class="single-gallery-image"
														style="background: url(${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath});"></div>
												</a>
											</div>
										</c:forEach>
									</div>
								</form>

							</c:otherwise>
						</c:choose>
					</div>
				</c:when>

				<c:otherwise>
					<c:if test="${empty admin}">
						<form
							action="${pageContext.request.contextPath}/info/list/npimageDelete"
							id="form" method="post" class="form-signin"
							enctype="multipart/form-data">
							<input type="checkbox" id="allCheck" />
							<spring:message code="check.all" />
							&nbsp; <input type="submit" class="btn btn-info pull-right"
								value="<spring:message code="delete.button" />"
								id="deleteButton"> &nbsp; <a
								href="${pageContext.request.contextPath}/info/list/npimage?petRegistrationNumber=${pet.petRegistrationNumber}"
								class="btn btn-info pull-right" id="cancelButton"
								style="color: #ffffff"><spring:message code="cancel" /></a> <input
								type="hidden" name=petRegistrationNumber id="prn"
								value="${pet.petRegistrationNumber}" />
							<div class="row gallery-item">
								<c:forEach var="noseprintImage" items="${noseprintImageList}"
									varStatus="status">
									<div class="col-md-4">
										<a
											href="${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath}"
											class="img-pop-up">
											<div class="single-gallery-image"
												style="background: url(${pageContext.request.contextPath}/upload/noseprint/${noseprintImage.noseprintImagePath});"></div>
										</a> <br>
										<div
											class="checkBox d-flex justify-content-center align-items-center">
											<input type="checkbox" name="chBox" class="chBox"
												value="${noseprintImage.noseprintImagePath}" />
										</div>
									</div>
								</c:forEach>
							</div>
						</form>
					</c:if>
				</c:otherwise>
			</c:choose>

		</div>
	</div>

	<c:import url="../../../../included/bottom.jsp">
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
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</body>

<script defer type="text/javascript">
	document.getElementById("ex_file").onchange = function() {
		document.getElementById("form").submit();
	};
</script>
</html>