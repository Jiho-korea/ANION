<%--
========================================================================
파    일    명: list.jsp
========================================================================
작    성    자: 임원석
작    성    일: 2021.07.04
작  성  내  용: 관리자 회면 - 이벤트 관리,목록
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<title><spring:message code="admin.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/css/admin/common.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/css/admin/left.css" />
	<script defer type="text/javascript">
	<!--
		
	//-->
	</script>
</head>
<body>
	<!-- wrapper 시작 -->
	<div id="wrapper">
		<!-- header 시작 -->
		<c:import url="../common/header.jsp" />
		<!-- header 끝 -->

		<!-- leftcolumn 시작 -->
		<c:import url="../common/leftMenu.jsp">
			<c:param value="list_event" name="type" />
		</c:import>
		<!-- leftcolumn 끝 -->

		<!-- rightcolumn 시작 -->
		<div id="rightcolumn">
			<div class="title_nav">
				<h1>
					<spring:message code="admin.event.banner" />
				</h1>
				<p class="location">
					<spring:message code="admin.home" />
					&gt;
					<spring:message code="admin.event.banner" />
					&gt;
					<spring:message code="admin.event.banner" />
				</p>
			</div>
			<div class="boardTable">
				<!--  
				<div><spring:message code="admin.member.total.member" />:&nbsp;${memberCount},&nbsp;&nbsp;<spring:message code="admin.member.total.pet" />:&nbsp;${petCount},&nbsp;&nbsp;<spring:message code="admin.member.total.image" />:&nbsp;${imageCount}</div>
				<br/>
				<div id="serach_area" style="padding-bottom: 10px;">
					<form name="delivery" id="myForm" method="get">
						<input type="hidden" name="find_key" id="find_key"
							value="delivery_company_name" />
						<spring:message code="admin.search" />
						&nbsp;<input type="text" name="find_keyword" id="find_keyword"
							class="" /> <input type="submit" name="btn_search"
							id="btn_search" class="btn_search" value="조회" />
					</form>
				</div>
				-->
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th height="32" width="5%"><spring:message
									code="admin.member.number" /></th>
							<th width="15%"><spring:message code="admin.event.status" /></th>
							<th width="40%"><spring:message code="admin.event.title" /></th>
							<th width="40%"><spring:message code="admin.event.date" /></th>
							<th><input type="button"
								value="<spring:message code="new.register" />" /></th>

						</tr>
					</thead>
					<tbody>

						<tr
							onclick="location.href='${pageContext.request.contextPath}/admin/event/event'"
							style="cursor: pointer;">

							<td width="8%" align="center">${status.index + 1}</td>
							<td width="12%" align="center"><spring:message
									code="proceeding" /></td>
							<td width="20%" align="center"><spring:message
									code="admin.event.dog.nosePrints.register" /></td>
							<td width="20%" align="center"><fmt:formatDate
									value="${member.memberRegisterDate}" pattern="yyyy-MM-dd" />2021-07-04
								~ 0000-00-00</td>

							<td><div align="center">
									<a href="#"> <input type="button" name="btn_modify"
										id="btn_modify" class="btn_modify {delivery_no: 4}"
										value="<spring:message code="edit" />" />
									</a> <a href="#"> <input type="button" name="btn_modify"
										id="btn_modify" class="btn_modify {delivery_no: 4}"
										value="<spring:message code="end" />" /></a>
								</div></td>




						</tr>

						<!-- 
							<tr>
								<td colspan="8" height="1" bgcolor="#EEEEEE"></td>
							</tr>
							 -->

					</tbody>
				</table>
				<div id="paging" class="paging"
					style="text-align: center; padding-bottom: 20px;">
					<img
						src="${pageContext.request.contextPath}/img/admin/common/btn_l.gif"
						alt="<" border=" 0" /><strong>1</strong>&nbsp;<img
						src="${pageContext.request.contextPath}/img/admin/common/btn_r.gif"
						alt=">" border="0" />
				</div>
			</div>
		</div>
		<!-- rightcolumn 끝 -->
		<!-- 하단 푸터 시작 -->
		<c:import url="../common/footer.jsp" />
		<!-- 하단 푸터 끝-->
	</div>
	<!-- wapper 끝-->
</body>
</html>