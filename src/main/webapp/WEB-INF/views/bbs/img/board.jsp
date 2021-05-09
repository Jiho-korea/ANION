<%--
========================================================================
파    일    명 : board.jsp
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

.linkImgpost, .linkImgpost:hover {
	color: #000000;
	text-decoration: none;
	'
}

#btn_search {
	height: 26px;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border: 1px solid #61CE89;
	background-color: rgba(0, 0, 0, 0);
	color: #61CE89;
	padding: 5px;
	border-bottom-right-radius: 5px;
}

#btn_search:hover {
	color: white;
	background-color: #61CE89;
}

#btn_left_arrow, #btn_right_arrow {
	border: none;
	width: 32px;
	height: 32px;
	cursor: pointer;
	background-color: transparent;
}
</style>
<title><spring:message code="home.title" /></title>

</head>
<body>
	<c:import url="../../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container" style="margin-top: 60px">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th
							style="background-color: #eeeeee; text-align: center; width: 15%">번호</th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 55%">제목</th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 10%">글쓴이</th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 10%">작성일</th>
						<th
							style="background-color: #eeeeee; text-align: center; width: 10%">조회수</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="imgpost" items="${imgpostList}">
						<tr>
							<td>${imgpost.imgpostNo}</td>
							<%-- ../from/post?postNo=${imgpost.imgpostNo} --%>
							<td><a href="#" class="linkImgpost"
								onClick="fn_postView(<c:out value="${imgpost.imgpostNo}"/>)">${fn:replace(fn:replace(fn:replace(fn:replace(fn:replace(imgpost.imgpostTitle, ' ', '&nbsp;'), '<', '&lt;'), '>', '&gt;'), '\\n', ''), '\"', '&quot;')}
							</a></td>
							<td>${imgpost.member.memberName}</td>
							<%--
							<td>${fn:split(fn:substring(imgpost.imgpostPostingtime, 0, 10),'-')[0]}년
								${fn:split(fn:substring(imgpost.imgpostPostingtime, 0, 10),'-')[1]}월
								${fn:split(fn:substring(imgpost.imgpostPostingtime, 0, 10),'-')[2]}일</td>
							 --%>
							<td>${fn:split(fn:substring(imgpost.imgpostPostingtime, 0, 10),'-')[1]}.${fn:split(fn:substring(imgpost.imgpostPostingtime, 0, 10),'-')[2]}</td>
							<td>${imgpost.imgpostViewcnt}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>



		</div>
		<div style="float: left">

			<c:choose>
				<c:when test="${pageNumber ne 1}">
					<a
						href="${pageContext.request.contextPath}/board/img?pageNumber=${pageNumber - 1}">
						<button class="btn_left_arrow mt-3" id="btn_left_arrow"
							type="button">
							<img
								src="${pageContext.request.contextPath}/img/button/left_arrow1.png">
						</button>
					</a>
				</c:when>
				<c:when test="${nextPage}">
					<a
						href="${pageContext.request.contextPath}/board/img?pageNumber=${pageNumber + 1}">
						<button class="btn_right_arrow mt-3" id="btn_right_arrow"
							type="button">
							<img
								src="${pageContext.request.contextPath}/img/button/right_arrow1.png">
						</button>
					</a>
				</c:when>
			</c:choose>

		</div>

		<div style="float: right">
			<a href="#" class="btn btn-primary pull-right mt-2">글쓰기</a>
		</div>
		<%--  검색창 + 검색버튼
		<div align="center"
			class="d-flex justify-content-center align-items-center mt-5">
			<form action="#" class="form-inline">
				<div class="form-group mx-sm-3 mb-2">
					<label for="title" class="sr-only">제목</label> <input type="text"
						name="title" id="title" class="form-control" placeholder="제목">
					<input type="hidden" name="pageNumber" value="${pageNumber}">
					<button type="submit" id="btn_search" class="d-flex justify-content-center align-items-center">검색</button>
				</div>

			</form>
		</div>
		--%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
<script defer type="text/javascript">
	function fn_postView(imgpostNo) {
		var url = "${pageContext.request.contextPath}/board/img/view";
		url = url + "?imgpostNo=" + imgpostNo;
		location.href = url;
	}
</script>
</html>