<%--
========================================================================
파    일    명: leftMenu.jsp
========================================================================
작    성    자: 강지호
작    성    일: 2020.11.18
작  성  내  용: 왼쪽메뉴
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- leftcolumn 시작 -->
<div id="leftcolumn">
	<div id="menu">
		<ul id="sidemenu">
			<c:choose>
				<c:when test="${param.type eq 'kindcode'}">
					<li><a href="#" class="more">코드관리</a>
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/admin/code/kindcode/list">견종관리</a></li>
						</ul></li>
				</c:when>

				<c:when test="${param.type eq 'list_member'}">
					<li><a href="#" class="more"><spring:message
								code="admin.member.banner" /></a>
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/admin/member/list"><spring:message
										code="admin.member.banner" /></a></li>
						</ul></li>
				</c:when>
			</c:choose>

		</ul>
	</div>
</div>
<!-- leftcolumn 끝 -->