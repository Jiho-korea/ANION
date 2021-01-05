<%--
========================================================================
파    일    명: update.jsp
========================================================================
작    성    자: 강지호
작    성    일: 2021.01.05
작  성  내  용: 관리자 화면 - 코드관리 - 견종코드 수정
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="admin.title" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/left.css" />
<script type="text/javascript">
	
</script>
</head>
<body>
	<!-- wrapper 시작 -->
	<div id="wrapper">
		<!-- header 시작 -->
		<c:import url="../../common/header.jsp" />
		<!-- header 끝 -->

		<!-- leftcolumn 시작 -->
		<c:import url="../../common/leftMenu.jsp">
			<c:param value="kindcode" name="type" />
		</c:import>
		<!-- leftcolumn 끝 -->

		<!-- rightcolumn 시작 -->
		<div id="rightcolumn">
			<div class="title_nav">
				<h1>견종관리</h1>
				<p class="location">홈 &gt; 코드관리 &gt; 견종관리</p>
			</div>

			<div class="input_tt_style">
				<div id="error_area"></div>
				<form:form name="delivery" id="myForm" method="POST"
					action="${pageContext.request.contextPath}/admin/code/kindcode/update"
					cssClass="delivery" cssStyle="display: inline;" modelAttribute="kindcode">
					<!--  
					<input type="hidden" name="act" id="act" value="insert"> <input
						type="hidden" name="reg_mem_no" id="reg_mem_no" value="1"> -->
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<th width="15%">견종코드</th>
								<td width="30%"><form:input type="text" path="petKindcode"
										cssClass="txt_box w200" title="견종코드" disabled="true"/>
									<form:errors path="petKindcode" /></td>
								<th width="15%">견종명</th>
								<td width="30%"><form:input type="text" path="petKind"
										cssClass="txt_box w200" maxlength="15" title="견종명" />
									<form:errors path="petKind" /></td>
							</tr>

						</tbody>
					</table>
					<!-- 개인정보 end-->
					<p class="btn_center_area">
						<input type="image"
							src="${pageContext.request.contextPath}/img/admin/button/bt_save.gif"
							name="btn_save" id="btn_save" width="31" height="19" title="저장"
							class="btn" border="0">&nbsp; <img
							src="${pageContext.request.contextPath}/img/admin/button/bt_cancel.gif"
							name="btn_cancel" id="btn_cancel" width="31" height="19" alt="취소"
							class="btn" border="0">
					</p>
				</form:form>
			</div>
		</div>
		<!-- rightcolumn 끝 -->
		<!-- 하단 푸터 시작 -->
		<c:import url="../../common/footer.jsp" />
		<!-- 하단 푸터 끝-->
	</div>
	<!-- wapper 끝-->
</body>
</html>