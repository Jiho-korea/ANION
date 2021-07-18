<%--
========================================================================
파    일    명 : petList.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.07.02
작  성  내  용 : 반려견 목록 (비문 등록 이벤트)
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

<meta name="viewport" content="width=device-width, initial-scale=1" />
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

#petName:hover {
	font-size: 1.2em;
}

.btn_download, .btn_gallery {
	border: none;
	cursor: pointer;
	background-color: transparent;
}
</style>

<title><spring:message code="home.title" /></title>
</head>
<body>
	<c:import url="../../../../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>


	<div class="container text-center">
		<div id="main">
			<h1 class="display-4">
				<c:choose>
					<c:when test="${empty admin}">
						<spring:message code="list.pet" />
					</c:when>
					<c:otherwise>
						<spring:message code="list.pet.admin">
							<spring:argument value="${member.memberName}" />
						</spring:message>
					</c:otherwise>
				</c:choose>
			</h1>
		</div>
		<div class="text-left mb-10">
			<c:choose>
				<c:when test="${empty admin}">
					<%-- 회원의  뒤로가기 버튼 --%>
					<a href="${pageContext.request.contextPath}/pet/list" class="mb-30"><button
							type="submit" class="btn btn-info pull-right">
							<spring:message code="go.back" />
						</button></a>
				</c:when>
				<c:otherwise>
					<%-- 관리자의 뒤로가기 버튼 --%>
					<a
						href="${pageContext.request.contextPath}/admin/pet/${member.memberNumber}"
						class="mb-30"><button type="submit"
							class="btn btn-info pull-right">
							<spring:message code="go.back" />
						</button></a>
				</c:otherwise>
			</c:choose>


		</div>


		<%--p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p--%>
		<%-- table(기본) table-striped(스트라이프 무늬 추가), table-bordered(선) --%>
		<table class="table table-striped table-bordered mt-5">
			<thead>
				<!-- table head -->
				<tr>


					<c:choose>
						<c:when
							test="${sessionScope.login.memberlevel.memberLevelCode eq 0}">
							<!-- table row -->
							<th width="10%"><spring:message code="list.num" /></th>
							<th width="35%"><spring:message code="list.pet.name" /></th>
							<th width="30%"><spring:message code="event.nose.num" /></th>
							<th width="15%"><spring:message code="event.nose.enroll" /></th>
							<th width="10%"><spring:message code="go.zip.image" /></th>
						</c:when>
						<c:otherwise>
							<!-- table row -->
							<th width="15%"><spring:message code="list.num" /></th>
							<th width="40%"><spring:message code="list.pet.name" /></th>
							<th width="30%"><spring:message code="event.nose.num" /></th>
							<th width="15%"><spring:message code="event.nose.enroll" /></th>
						</c:otherwise>
					</c:choose>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pet" items="${petList}" varStatus="status">
					<tr>
						<c:choose>
							<c:when
								test="${sessionScope.login.memberlevel.memberLevelCode eq 0}">
								<td>${status.index + 1}</td>
								<td><a
									href="${pageContext.request.contextPath}/info/pet?petRegistrationNumber=${pet.petRegistrationNumber}"
									style="color: #000000;" id="petName">${pet.petName}</a></td>
								<td>${pet.noseprintImageCount}건</td>
								<td><c:choose>
										<c:when test="${empty admin}">
											<a
												href="${pageContext.request.contextPath}/info/list/npimage?petRegistrationNumber=${pet.petRegistrationNumber}">
												<button class="btn_gallery" id="btn_gallery" type="button">
													<img
														src="${pageContext.request.contextPath}/img/button/dog_nose.png">
												</button>
											</a>
										</c:when>
										<c:otherwise>
											<a
												href="${pageContext.request.contextPath}/admin/pet/image/npevent/${member.memberNumber}?petRegistrationNumber=${pet.petRegistrationNumber}">
												<button class="btn_gallery" id="btn_gallery" type="button">
													<img
														src="${pageContext.request.contextPath}/img/button/dog_nose.png">
												</button>
											</a>
										</c:otherwise>
									</c:choose></td>
								<td><a
									href="${pageContext.request.contextPath}/info/list/npimage/download?petRegistrationNumber=${pet.petRegistrationNumber}">
										<button class="btn_download" id="btn_download" type="button">
											<img
												src="${pageContext.request.contextPath}/img/button/download1.png">
										</button>
								</a></td>
							</c:when>
							<c:otherwise>
								<td>${status.index + 1}</td>
								<td><a
									href="${pageContext.request.contextPath}/info/pet?petRegistrationNumber=${pet.petRegistrationNumber}"
									style="color: #000000;" id="petName">${pet.petName}</a></td>
								<td>${pet.noseprintImageCount}건</td>
								<td><a
									href="${pageContext.request.contextPath}/info/list/npimage?petRegistrationNumber=${pet.petRegistrationNumber}">
										<button class="btn_gallery" id="btn_gallery" type="button">
											<img
												src="${pageContext.request.contextPath}/img/button/dog_nose.png">
										</button>
								</a></td>

							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
</body>
</html>