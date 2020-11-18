<%--
========================================================================
파    일    명: list.jsp
========================================================================
작    성    자: 강지호
작    성    일: 2020.11.18
작  성  내  용: 관리자 회면 - 회원목록
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<title><spring:message code="admin.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/left.css" />
<script type="text/javascript">
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
		<c:import url="../common/leftMenu.jsp" />
		<!-- leftcolumn 끝 -->

		<!-- rightcolumn 시작 -->
		<div id="rightcolumn">
			<div class="title_nav">
				<h1>
					<spring:message code="admin.member.banner" />
				</h1>
				<p class="location">
					<spring:message code="admin.home" />
					&gt;
					<spring:message code="admin.member.banner" />
					&gt;
					<spring:message code="admin.member.banner" />
				</p>
			</div>
			<div class="boardTable">
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
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th height="32" width="5%"><spring:message
									code="admin.member.number" /></th>
							<th width="5%"><spring:message code="admin.member.level" /></th>
							<th width="15%"><spring:message code="admin.member.name" /></th>
							<th width="15%"><spring:message code="admin.member.id" /></th>
							<th width="15%"><spring:message
									code="admin.member.phoneNumber" /></th>
							<th width="15%"><spring:message code="admin.member.status" /></th>
							<th width="15%"><spring:message code="admin.member.date" /></th>
							<!-- 
							<th width="5%">순번</th>
							<th width="8%">코드</th>
							<th width="8%">견종명</th>
							<th width="6%">사용여부</th>
							 -->
							<th width="15%"><a href="#"><input type="button" name="btn_plus"
								id="btn_plus" class="btn_plus" value="신규등록" /></a></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${totalRecord==0 }">
							<tr>
								<td colspan="8" height="30" align="center">저장된 내용이 없습니다.</td>
							</tr>
							<tr>
								<td colspan="8" height="1" bgcolor="#EEEEEE"></td>
							</tr>
						</c:if>
						<c:forEach var="member" items="${memberList}" varStatus="status">
							<tr height="30">
								<td width="5%" align="center">0</td>
								<td width="10%" align="center">${member.memberLevel}</td>
								<td width="15%" align="center">${member.memberName }</td>
								<td width="15%" align="center">${member.memberId }</td>
								<td width="15%" align="center">${member.memberPhoneNumber }</td>
								<td width="15%" align="center">승인</td>
								<td width="15%" align="center"><fmt:formatDate value="${member.memberRegisterDate}" pattern="yyyy-MM-dd" /></td>
								<td width="15%" align="center"><div align="center">
										<a href="#"> <input type="button" name="btn_modify"
											id="btn_modify" class="btn_modify {delivery_no: 4}"
											value="수정" /></a> <a href="#"><input type="button" name="btn_delete"
											id="btn_delete" class="btn_delete {delivery_no: 4}"
											value="삭제" /> </a>
									</div></td>
							</tr>
							<!-- 
							<tr>
								<td colspan="8" height="1" bgcolor="#EEEEEE"></td>
							</tr>
							 -->
						</c:forEach>
						<!-- 
						<tr>
							<td><div align="center">4</div></td>
							<td><div align="center">A001</div></td>
							<td><div align="left">동경이</div></td>
							<td><div align="center">Y</div></td>
							<td><div align="center">
									<input type="button" name="btn_modify" id="btn_modify"
										class="btn_modify {delivery_no: 4}" value="수정" /><input
										type="button" name="btn_delete" id="btn_delete"
										class="btn_delete {delivery_no: 4}" value="삭제" />
								</div></td>
						</tr>
						<tr>
							<td><div align="center">3</div></td>
							<td><div align="center">A002</div></td>
							<td><div align="left">íì°ê°</div></td>
							<td><div align="center">Y</div></td>
							<td><div align="center">
									<input type="button" name="btn_modify" id="btn_modify"
										class="btn_modify {delivery_no: 4}" value="ìì " /><input
										type="button" name="btn_delete" id="btn_delete"
										class="btn_delete {delivery_no: 4}" value="ì­ì " />
								</div></td>
						</tr>
						<tr>
							<td><div align="center">2</div></td>
							<td><div align="center">A003</div></td>
							<td><div align="left">ì½ì´ê°</div></td>
							<td><div align="center">Y</div></td>
							<td><div align="center">
									<input type="button" name="btn_modify" id="btn_modify"
										class="btn_modify {delivery_no: 4}" value="ìì " /><input
										type="button" name="btn_delete" id="btn_delete"
										class="btn_delete {delivery_no: 4}" value="ì­ì " />
								</div></td>
						</tr>
						<tr>
							<td><div align="center">1</div></td>
							<td><div align="center">A004</div></td>
							<td><div align="left">ì§ëê°</div></td>
							<td><div align="center">Y</div></td>
							<td><div align="center">
									<input type="button" name="btn_modify" id="btn_modify"
										class="btn_modify {delivery_no: 4}" value="ìì " /><input
										type="button" name="btn_delete" id="btn_delete"
										class="btn_delete {delivery_no: 4}" value="ì­ì " />
								</div></td>
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