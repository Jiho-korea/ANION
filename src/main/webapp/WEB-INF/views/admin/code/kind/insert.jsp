<%--
========================================================================
파    일    명: insert.jsp
========================================================================
작    성    자: 강지호, 임원석
작    성    일: 2020.11.28
작  성  내  용: 관리자 화면 - 코드관리 - 견종코드 신규등록
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
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/admin/left.css" />
<script defer type="text/javascript">
	
</script>
</head>
<style>
input {
	padding-left: 3px;
}

.textBox {
	width: 100px;
	background-color: #E7E7E7;
	border-width: 1px;
	border-radius: 4px;
	border-width: 1px;
	outline: none;
}
</style>
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
					action="${pageContext.request.contextPath}/admin/code/kindcode/insert"
					cssClass="delivery" cssStyle="display: inline;"
					modelAttribute="kindcode">
					<!--  
					<input type="hidden" name="act" id="act" value="insert"> <input
						type="hidden" name="reg_mem_no" id="reg_mem_no" value="1"> -->
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<th width="12%">견종코드</th>
								<td width="20%"><form:input type="text" path="petKindcode"
										cssClass="txt_box w200" title="견종코드" /> <form:errors
										path="petKindcode" /></td>

								<th width="11%">서식지</th>
								<td width="25%"><input type="text"
									class="form-control textBox" name="petKindHabitat" id="textBox"
									onfocus="inInput(this)" onblur="outInput(this)" readOnly>
									<select onfocus="inInput(this)" onblur="outInput(this)"
									onChange="select(this.value)">
										<option class="form-control" value="">국가코드</option>
										<option class="form-control" onselect="focus">직접입력</option>
										<c:forEach var="countryCode" items="${countryCodeList}"
											varStatus="status">
											<option class="form-control" value="${countryCode}">${countryCode}</option>
										</c:forEach>
								</select> <br> <form:errors path="petKindHabitat" /></td>

								<th width="12%">견종명</th>
								<td width="20%"><form:input type="text" path="petKind"
										cssClass="txt_box w200" maxlength="15" title="견종명" /> <br>
									<form:errors path="petKind" /></td>
							</tr>

						</tbody>
					</table>
					<!-- 개인정보 end-->
					<p class="btn_center_area">
						<input type="image"
							src="${pageContext.request.contextPath}/img/admin/button/bt_save.gif"
							name="btn_save" id="btn_save" width="31" height="19" alt="저장"
							class="btn" border="0">&nbsp; <a
							href="${pageContext.request.contextPath}/admin/code/kindcode/list"><img
							src="${pageContext.request.contextPath}/img/admin/button/bt_cancel.gif"
							name="btn_cancel" id="btn_cancel" width="31" height="19" alt="취소"
							class="btn" border="0"></a>
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
<script defer type="text/javascript" charset="utf-8">
	function select(value) {
		if (value == "") {
			document.getElementById("textBox").value = value;
			document.getElementById("textBox").readOnly = true;
			document.getElementById("textBox").style.backgroundColor = "#E7E7E7";
			document.getElementById("textBox").focus();
		} else if (value != "직접입력") {
			document.getElementById("textBox").value = value;
			document.getElementById("textBox").readOnly = true;
			document.getElementById("textBox").style.backgroundColor = "#FFFFFF";
			document.getElementById("textBox").focus();
		} else {
			document.getElementById("textBox").value = "";
			document.getElementById("textBox").readOnly = false;
			document.getElementById("textBox").style.backgroundColor = "#FFFFFF";
			document.getElementById("textBox").focus();
		}
	}
</script>
</html>