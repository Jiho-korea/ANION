<%--
========================================================================
파    일    명: leftMenu.jsp
========================================================================
작    성    자: 배준철
작    성    일: 2010.01.12
작  성  내  용: 왼쪽메뉴
========================================================================
수    정    자:
수    정    일:
수  정  내  용:
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
			<li><a href="#" class="more"><spring:message code="admin.member.banner" /></a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/admin/member/list"><spring:message code="admin.member.banner" /></a></li>
				</ul></li>
		</ul>
	</div>
</div>
<!-- leftcolumn 끝 -->