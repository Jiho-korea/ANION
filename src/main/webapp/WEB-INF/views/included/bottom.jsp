<%--
========================================================================
파    일    명 : bottom.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.10.10
작  성  내  용 : 상단메뉴
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
<footer>
	<div class="footer-wrapper">
		<!-- Footer Start-->
		<div class="footer-area footer-padding">
			<div class="container ">
				<div class="row justify-content-between">
					<div class="col-xl-4 col-lg-3 col-md-8 col-sm-8">
						<div class="single-footer-caption mb-50">
							<div class="single-footer-caption mb-30">
								<!-- logo -->
								<div class="footer-logo mb-35">
									<a href="${pageContext.request.contextPath}/home"><img
										src="${pageContext.request.contextPath}/img/logo/anion.png"
										alt=""></a>
								</div>
								<div class="footer-tittle">
									<div class="footer-pera">
										<p>
											<spring:message code="footer.title" />
										</p>
									</div>
								</div>
								<!-- social -->
								<div class="footer-social">
									<a href="#"><i class="fab fa-twitter"></i></a> <a
										href="https://bit.ly/sai4ull"><i class="fab fa-facebook-f"></i></a>
									<a href="#"><i class="fab fa-pinterest-p"></i></a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-2 col-lg-3 col-md-4 col-sm-4">
						<div class="single-footer-caption mb-50">
							<div class="footer-tittle">
								<h4><spring:message code="solutions.title" /></h4>
								<ul>
									<li><a href="#"><spring:message code="solution.1" /></a></li>
									<li><a href="#"><spring:message code="solution.2" /></a></li>
									<li><a href="#"><spring:message code="solution.3" /></a></li>
									<li><a href="#"><spring:message code="solution.4" /></a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-2 col-lg-2 col-md-4 col-sm-4">
						<div class="single-footer-caption mb-50">
							<div class="footer-tittle">
								<h4><spring:message code="company.title" /></h4>
								<ul>
									<li><a href="#"><spring:message code="company.about" /></a></li>
									<li><a href="#"><spring:message code="company.review" /></a></li>
									<li><a href="#"><spring:message code="company.insights" /></a></li>
									<li><a href="#"><spring:message code="company.carrier" /></a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-lg-4 col-md-6 col-sm-4">
						<div class="single-footer-caption mb-50">
							<div class="footer-tittle">
								<h4><spring:message code="contact.title" /></h4>
								<ul>
									<li><a href="#"><spring:message code="contact.email" /></a></li>
									<li><a href="#"><spring:message code="contact.address" /></a></li>
									<!-- <li class="number"><a href="#">(80) 783 367-3904</a></li>  -->
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- footer-bottom area -->
		<div class="footer-bottom-area">
			<div class="container">
				<div class="footer-border">
					<div class="row d-flex align-items-center">
						<div class="col-xl-12 ">
							<div class="footer-copy-right text-center">
								<p>
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
									Copyright &copy;
									<script>
										document
												.write(new Date().getFullYear());
									</script>
									All rights reserved | This template is made with <i
										class="fa fa-heart" aria-hidden="true"></i> by <a
										href="https://colorlib.com" target="_blank">Colorlib</a>
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer End-->
	</div>
</footer>