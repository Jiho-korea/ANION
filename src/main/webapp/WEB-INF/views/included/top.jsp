<%--
========================================================================
파    일    명 : top.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.10.10
작  성  내  용 : 견명목록
========================================================================
수    정    자 : 배준철
수    정    일 : 2020.10.19
수  정  내  용 : 필요없는부분 주석
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width , initial-scale=1" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
<style>
#main {
	width: 100%;
	margin-top: 50px;
}

a, a:hover {
	color: #000000;
	text-decoration: none;
}
</style>

<title></title>
<script defer src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script defer
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body--%>
<!-- ? Preloader Start
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="${pageContext.request.contextPath}/img/logo/loder.png" alt="">
                </div>
            </div>
        </div>
    </div>
   Preloader Start -->
<header>
	<!-- Header Start -->
	<div class="header-area">
		<div class="main-header ">
			<div class="header-bottom  header-sticky">
				<div class="container-fluid">
					<div class="row align-items-center">
						<!-- Logo -->
						<div class="col-xl-2 col-lg-2">
							<div class="logo">
								<a href="${pageContext.request.contextPath}/home"><img
									src="${pageContext.request.contextPath}/img/logo/logo.jpg"
									alt=""></a>
							</div>
						</div>
						<div class="col-xl-10 col-lg-10">
							<div
								class="menu-wrapper  d-flex align-items-center justify-content-end">
								<!-- Main-menu -->
								<div class="main-menu d-none d-lg-block">
									<nav>
										<ul id="navigation">
											<li><a href="index.html">회사소개</a>
												<ul class="submenu">
													<li><a href="blog.html">회사소개</a></li>
													<li><a href="blog_details.html">회사비전</a></li>
													<li><a href="elements.html">오시는길</a></li>
												</ul></li>
											<li><a href="about.html">사업1</a>
												<ul class="submenu">
													<li><a
														href="${pageContext.request.contextPath}/register/step1">반려동물등록</a></li>
													<c:if test="${not empty sessionScope.login}">
														<li><a href="${pageContext.request.contextPath}/main/list">반려견 리스트</a></li>
													</c:if>
													<li><a href="blog_details.html">안면등록</a></li>
													<li><a href="elements.html">유전자검사</a></li>
												</ul></li>
											<li><a href="what-do.html">사업2</a>
												<ul class="submenu">
													<li><a href="blog.html">반려동물 마이크로바이옴</a></li>
													<li><a href="blog_details.html">피부미생물 검사</a></li>
													<li><a href="elements.html">항생제 감수성 테스트</a></li>
												</ul></li>
											<li><a href="projects.html">사업3</a>
												<ul class="submenu">
													<li><a href="blog.html">반려동물 펫푸드</a></li>
													<li><a href="blog_details.html">특허소개</a></li>
													<li><a href="elements.html">폐쇄몰(상품홍보)</a></li>
												</ul></li>
											<li><a href="blog.html">파트너</a>
												<ul class="submenu">
													<li><a href="blog.html">포스텍홀딩스</a></li>
													<li><a href="blog_details.html">포항테크노파크</a></li>
												</ul></li>
											<!-- <li><a href="contact.html">Contact</a></li> -->
										</ul>
									</nav>
								</div>
								<!-- Header-btn -->
								<div class="header-right-btn d-none d-lg-block ml-20">
									<c:choose>
										<c:when test="${empty sessionScope.login}">
											<a href="${pageContext.request.contextPath}/login/login"
												class="btn header-btn">로그인</a>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/logout"
												class="btn header-btn">로그아웃</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<!-- Mobile Menu -->
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End -->
</header>
<%--/body>
</html--%>