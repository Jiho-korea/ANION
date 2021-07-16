<%--
========================================================================
파    일    명: header.jsp
========================================================================
작    성    자: 강지호
작    성    일: 2020.11.18
작  성  내  용: 상단메뉴
========================================================================
작    성    자: 강지호
작    성    일: 2020.11.23
작  성  내  용: 견종 관리 링크 추가
========================================================================
작    성    자: 임원석
작    성    일: 2021.07.04
작  성  내  용: 이벤트 관리 상단 링크 추가
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- header 시작 -->
<div id="header">
	<div class="logo">
		<a href="${pageContext.request.contextPath}/home" target="_blank"><img
			src="${pageContext.request.contextPath}/img/admin/common/logo.png"
			border="0" /></a>
	</div>
	<div class="top_menu">
		<p align="right" style="padding-top: 8px; padding-bottom: 18px;">
			<a href="#"><strong>관리자홈</strong></a>&nbsp;&nbsp;<a
				href="${pageContext.request.contextPath}/logout"><img
				src="${pageContext.request.contextPath}/img/admin/login/logout.gif"
				alt="로그아웃" width="51" height="18" border="0" align="absmiddle" /></a></span>
		</p>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="menu">
			<tr>
				<th><a
					href="${pageContext.request.contextPath}/admin/code/kindcode/list"><spring:message
							code="admin.manage.kindcode" /></a></th>
				<th><a
					href="${pageContext.request.contextPath}/admin/member/list"><spring:message
							code="admin.member.banner" /></a></th>
				<th><a href="#"><spring:message code="admin.manage.pet" /></a></th>
				<th><a href="#"><spring:message code="admin.manage.board" /></a></th>
				<th><a
					href="${pageContext.request.contextPath}/admin/event/list"><spring:message
							code="admin.event.banner" /></a></th>
			</tr>
		</table>
	</div>
</div>
<!-- header 끝 -->