<%--
========================================================================
파    일    명 : top.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.10.10
작  성  내  용 : 상단메뉴
========================================================================
수    정    자 : 배준철
수    정    일 : 2020.10.19
수  정  내  용 : 필요없는부분 주석
========================================================================
수    정    자 : 임원석, 송찬영
수    정    일 : 2020.11.11
수  정  내  용 : 관리자 메뉴(톱니바퀴) 생성
========================================================================
수    정    자 : 배준철
수    정    일 : 2020.11.12
수  정  내  용 : 모바일화면 로그인, 로그아웃, 회원가입버튼 보이도록수정
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<%-- Header Start --%>
	<div class="header-area">
		<div class="main-header">
			<div class="header-bottom header-sticky">
				<div class="container-fluid">
					<div class="row align-items-center">
						<%-- Logo --%>
						<div class="col-xl-2 col-lg-2">
							<div class="logo">
								<a href="${pageContext.request.contextPath}/home"><img
									src="${pageContext.request.contextPath}/img/logo/anion.png"
									alt=""></a>
							</div>
						</div>
						<div class="col-xl-10 col-lg-10">
							<div class="menu-wrapper d-flex align-items-center justify-content-end">
								<%-- Main-menu --%>
								<div class="main-menu d-none d-lg-block">
									<nav>
										<ul id="navigation">
											<li>
												<a href="#"><spring:message code="company.introduction.title" /></a>
												<ul class="submenu">
													<li><a href="${pageContext.request.contextPath}/about"><spring:message code="company.introduction.title" /></a></li>
													<li><a href="${pageContext.request.contextPath}/vision"><spring:message code="company.vision.title" /></a></li>
													<li><a href="${pageContext.request.contextPath}/directions"><spring:message code="company.directions.title" /></a></li>
												</ul>
											</li>
											<li>
												<a href="#"><spring:message code="pet.certification.title" /></a>
												<ul class="submenu">
													<li><a href="${pageContext.request.contextPath}/register/step1"><spring:message code="pet.registration.title" /></a></li>
													<c:if test="${not empty sessionScope.login}">
													<li><a href="${pageContext.request.contextPath}/main/list"><spring:message code="pet.list.title" /></a></li>
													</c:if>
													<li><a href="#"><spring:message code="pet.facial.registration" /></a></li>
													<li><a href="#"><spring:message code="pet.genetic.testing" /></a></li>
												</ul>
											</li>
											<li>
												<a href="#"><spring:message code="microbiome.title" /></a>
												<ul class="submenu">
													<li><a href="#"><spring:message code="microbiome.pet" /></a></li>
													<li><a href="#"><spring:message code="skin.microbiological.examination" /></a></li>
													<li><a href="#"><spring:message code="antibiotic.sensitivity.test" /></a></li>
												</ul>
											</li>
											<li>
												<a href="#"><spring:message code="pet.food.title" /></a>
												<ul class="submenu">
													<li><a href="${pageContext.request.contextPath}/petFood"><spring:message code="pet.food" /></a></li>
													<li><a href="#"><spring:message code="patent.introduction" /></a></li>
													<li><a href="#"><spring:message code="product.promotion" /></a></li>
												</ul>
											</li>
											<li>
												<a href="#"><spring:message code="company.partner" /></a>
												<ul class="submenu">
													<li><a href="http://postechholdings.com/"><spring:message code="POSTEC.holdings" /></a></li>
													<li><a href="https://www.ptp.or.kr/"><spring:message code="techno.park" /></a></li>
													<li><a href="${pageContext.request.contextPath}/preservation"><spring:message code="freeze.preservation" /></a></li>
												</ul>
											</li>
											<%-- li><a href="contact.html">Contact</a></li --%>
										</ul>
									</nav>
								</div>
								<!-- Header-btn -->
								<div class="header-right-btn d-none d-lg-block ml-20">
									<c:choose>
										<c:when test="${empty sessionScope.login}">
										<a href="${pageContext.request.contextPath}/login/login" class="btn header-btn"><spring:message code="go.login" /></a>
										<a href="${pageContext.request.contextPath}/signup/step1" class="btn btn-dark"><spring:message code="go.register" /></a>
										</c:when>
										<c:otherwise>
										<a href="${pageContext.request.contextPath}/logout" class="btn header-btn"><spring:message code="top.logout" /></a>
										<c:if test="${sessionScope.login.memberLevel eq 1}">
										<a href="#"><img src="${pageContext.request.contextPath}/img/logo/tts.jpg" style="max-width: 50px; height: 50px;" alt=""></a>
										</c:if>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<!-- Mobile Menu -->
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
							<%-- 모바일 해상도일때 로그인, 로그아웃 회원가입 버튼 보이도록 --%>
							<div class="d-block d-lg-none" style="float:right; margin-right:40px; margin-top:-50px;">
								<c:choose>
								<c:when test="${empty sessionScope.login}">
								<a href="${pageContext.request.contextPath}/login/login" class="btn2" style="
	border:none;
	padding:5px 15px;
	text-transform:capitalize;
	border-radius:10px;
	cursor:pointer;
	color:#fff;
	display:inline-block;
	font-size:10px;
	transition:0.6s;
	box-shadow:0px 7px 21px 0px rgba(0,0,0,0.12);
	background-image:linear-gradient(to left,#46C0BE,#6DD56F,#46C0BE);
	background-position:right;
	background-size:200%
	margin-bottom:100px;
	margin-top:12px;
								"><spring:message code="go.login" /></a>
								<a href="${pageContext.request.contextPath}/signup/step1" class="btn2" style="
	border:none;
	padding:5px 15px;
	text-transform:capitalize;
	border-radius:10px;
	cursor:pointer;
	color:#fff;
	display:inline-block;
	font-size:10px;
	transition:0.6s;
	box-shadow:0px 7px 21px 0px rgba(0,0,0,0.12);
	background-image:linear-gradient(to left,#46C0BE,#6DD56F,#46C0BE);
	background-position:right;
	background-size:200%
	margin-bottom:100px;
	margin-top:12px;
								"><spring:message code="go.register" /></a>
								</c:when>
								<c:otherwise>
								<a href="${pageContext.request.contextPath}/logout" class="btn2" style="
	border:none;
	padding:5px 15px;
	text-transform:capitalize;
	border-radius:10px;
	cursor:pointer;
	color:#fff;
	display:inline-block;
	font-size:10px;
	transition:0.6s;
	box-shadow:0px 7px 21px 0px rgba(0,0,0,0.12);
	background-image:linear-gradient(to left,#46C0BE,#6DD56F,#46C0BE);
	background-position:right;
	background-size:200%
	margin-bottom:100px;
	margin-top:12px;
								"><spring:message code="top.logout" /></a>
								</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End -->
</header>