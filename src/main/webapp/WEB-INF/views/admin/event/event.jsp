<%--
========================================================================
파    일    명: event.jsp
========================================================================
작    성    자: 임원석
작    성    일: 2021.07.04
작  성  내  용: 임시 이벤트 확인 
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
					비문 등록 이벤트
				</h1>
			
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
							<th height="32" width="5%"><spring:message code="admin.member.number" /></th>
							<th width="10%"><spring:message code="admin.member.name" /></th>
							<th width="10%"><spring:message code="admin.member.id" /></th>
							<th width="10%">반련견 수</th>
							<th width="10%">등록 사진수</th>
							<th width="10%">승인 사진</th>
							<th width="10%">목록</th>
							
							
						</tr>
					</thead>
					<tbody>
						
							<tr>
												
								<td width="5%" align="center">${status.index + 1}</td>
								<td width="10%" align="center">김덕배</td>
								<td width="10%" align="center">abc1234</td>
								<td width="10%" align="center">10</td>
								<td width="10%" align="center">10</td>
								<td width="10%" align="center">10</td>
								
								<td width="6%" align="center">
									<div align="center">
										<a href="#" target="_blank"> 
										<input type="button" name="list" class="btn_modify {delivery_no: 4}" value="목록" /></a>
									</div>
									
									</td>
										

		
								
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
						alt="왼쪽이동" border="0" /><strong>1</strong>&nbsp;<img
						src="${pageContext.request.contextPath}/img/admin/common/btn_r.gif"
						alt="오른쪽이동" border="0" />
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