<%--
========================================================================
파    일    명 : bbs_img.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.05
작  성  내  용 : 다른 사람들의 반려견 사진 게시글 목록을 볼 수 있는 게시판
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container" style="margin-top: 60px">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th
							style="background-color: #eeeeee; text-align: center; width: 15%">글번호</th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 55%">제목</th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 10%">작성자</th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 20%">작성일</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="post" items="${postList}">
						<tr>
							<td>${post.postNo}</td>
							<td><a href="../from/post?postNo=${post.postNo}">${fn:replace(fn:replace(fn:replace(fn:replace(fn:replace(post.title, ' ', '&nbsp;'), '<', '&lt;'), '>', '&gt;'), '\\n', ''), '\"', '&quot;')}
							</a></td>
							<td>${post.student.name}</td>
							<td>${fn:split(fn:substring(post.postingdate, 0, 10),'-')[0]}년
								${fn:split(fn:substring(post.postingdate, 0, 10),'-')[1]}월
								${fn:split(fn:substring(post.postingdate, 0, 10),'-')[2]}일</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>



		</div>
		<div style="float: left">

			<c:choose>
				<c:when test="${pageNumber ne 1}">
					<a
						href="${pageContext.request.contextPath}/from/board?pageNumber=${pageNumber - 1}"
						class="btn btn-secondary" style="margin-left: 20px">◀</a>
				</c:when>
				<c:when test="${nextPage}">
					<a
						href="${pageContext.request.contextPath}/from/board?pageNumber=${pageNumber + 1}"
						class="btn btn-secondary" style="margin-left: 20px">▶</a>
				</c:when>
			</c:choose>

		</div>

		<div style="float: right">
			<a href="${pageContext.request.contextPath}/from/postingpage"
				class="btn btn-primary pull-right">글쓰기</a>
		</div>

		<div style="float: right" align="center">
			<form action="${pageContext.request.contextPath}/from/board"
				class="form-inline">
				<div class="form-group mx-sm-3 mb-2">
					<label for="title" class="sr-only">제목</label> <input type="text"
						name="title" id="title" class="form-control" placeholder="제목">
					<input type="hidden" name="pageNumber" value="${pageNumber}">
					<button type="submit" class="btn btn-primary pull-right">검색</button>
				</div>

			</form>

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
</html>