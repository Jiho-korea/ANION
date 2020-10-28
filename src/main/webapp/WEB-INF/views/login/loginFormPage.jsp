<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
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
<script defer src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script defer src="js/bootstrap.js"></script>
<title><spring:message code="login.title" /></title>
</head>
<body class="text-center">
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	<div class="container" id="main">
		<div class="jumbotron">
			<form:form action="${pageContext.request.contextPath}/login/login"
				method="post" cssClass="form-signin" modelAttribute="loginRequest">
				<h1 class="h3 mb-3 font-weight-bold">
					<spring:message code="login.banner" />
				</h1>
				<form:errors />
				<br>

				<label style="margin-top: 20px"><spring:message code="id" />
					<form:input path="id" cssClass="form-control" /> <form:errors
						path="id" /> </label>
				<br>
				<label><spring:message code="password" /> <form:password
						path="password" cssClass="form-control" /> <form:errors
						path="password" /> </label>

				<div class="checkbox mb-3">
					<form:checkbox path="memory" />
					<spring:message code="login.memory" />
				</div>

				<button class="btn btn-info pull-right" type="submit">
					<spring:message code="go.login" />
				</button>
				<!-- 
				<a href="${pageContext.request.contextPath}/register/step1"><spring:message
						code="go.owner.register" /></a>  -->
				<p class="mt-5 mb-3 text-muted">
					<spring:message code="login.right" />
				</p>
			</form:form>

		</div>
	</div>

</body>
</html>