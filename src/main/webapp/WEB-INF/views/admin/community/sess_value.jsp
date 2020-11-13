<%--
========================================================================
파    일    명: sess_value.jsp
========================================================================
작    성    자: 배준철
작    성    일: 2011.10.26
작  성  내  용: 세션변수
========================================================================
수    정    자:
수    정    일:
수  정  내  용:
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="user_row_id" value="${sessionScope.SESS_USERNUM }" />
<c:set var="user_id" value="${sessionScope.SESS_USERID }" />
<c:set var="user_nm" value="${sessionScope.SESS_USERNAME }" />
<c:set var="user_mail" value="${sessionScope.SESS_EMAIL }" />
<c:set var="subject_ty_cd" value="${sessionScope.SESS_SUBJECTCD }" />
<c:if test="${empty subject_ty_cd }">
	<c:set var="subject_ty_cd" value="200" />
</c:if>