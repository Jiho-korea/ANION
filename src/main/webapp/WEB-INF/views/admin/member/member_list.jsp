<%--
========================================================================
파    일    명: memebr_list.jsp
========================================================================
작    성    자: 강지호,임원석
작    성    일: 2020.11.13
작  성  내  용: 회원목록
========================================================================
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 모드</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/main.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/menu.js"></script>
<script type="text/javascript">
<!--
	//회원추가
	function _insert() {
		self.location.href = "writeFrm.do";
	}
	// 회원상세정보
	function _view(user_row_id) {
		self.location.href = "view.do?act=view&m_row_id=" + user_row_id;
	}
	// 회원정보수정
	function _modify(user_row_id) {
		//	alert(no);
		self.location.href = "modifyFrm.do?user_row_id=" + user_row_id;
	}
	//회원정보삭제
	function _delete(no) {
		//	alert(no);
		if (confirm("정말 삭제하시겠습니까?\n\n삭제후에는 복구가 불가능합니다.")) {
			self.location.href = "delete.do?m_row_id=" + no;
		}
	}
//-->
</script>
</head>
<body>
	<!-- 전체 wrapper시작 -->
	<div id="wrapper">
		<!-- 상단메뉴 -->
		<div id="header">
			<div class="logo">
				<c:import url="../common/logo.jsp" />
			</div>
			<div class="top_right">
				<c:import url="../common/header.jsp" />
				<div class="text_img">
					<img src="${pageContext.request.contextPath}/img/admin/title/text_title02.gif" width="120" height="30"
						alt="회원관리" />
				</div>
			</div>
		</div>
		<!-- 상단메뉴끝 -->
		<!-- 왼쪽메뉴 -->
		<div id="leftcolumn">
			<c:import url="../common/leftMenu.jsp" />
		</div>
		<!-- 왼쪽메뉴끝-->
		<!-- 오른쪽 내용-->
		<div id="rightcolumn">
			<div id="search" style="padding-bottom: 10px;">
				<form name="member" id="member" action="list.do" method="get">
					구분 <select name="subject_ty_cd" id="subject_ty_cd">
						<option value="0"
							<c:if test="${param.subject_ty_cd == 0 }">selected="selected"</c:if>>-전체-</option>
						<option value="100"
							<c:if test="${param.subject_ty_cd == 100 }">selected="selected"</c:if>>생산자</option>
						<option value="110"
							<c:if test="${param.subject_ty_cd == 110 }">selected="selected"</c:if>>보급센터</option>
						<option value="160"
							<c:if test="${param.subject_ty_cd == 160 }">selected="selected"</c:if>>유통센터</option>
						<option value="170"
							<c:if test="${param.subject_ty_cd == 170 }">selected="selected"</c:if>>매장</option>
						<option value="130"
							<c:if test="${param.subject_ty_cd == 130 }">selected="selected"</c:if>>일반회원</option>
						<option value="140"
							<c:if test="${param.subject_ty_cd == 140 }">selected="selected"</c:if>>관리자</option>
					</select> 회원명 <input type="text" name="find_keyword" id="find_keyword"
						value="${param.find_keyword }" /> 회원상태 <select
						name="confirmation_part" id="confirmation_part">
						<option value=""
							<c:if test="${param.confirmation_part == '' }">selected="selected"</c:if>>-전체-</option>
						<option value="1"
							<c:if test="${param.confirmation_part == 1 }">selected="selected"</c:if>>신청</option>
						<option value="2"
							<c:if test="${param.confirmation_part == 2 }">selected="selected"</c:if>>승인</option>
						<option value="3"
							<c:if test="${param.confirmation_part == 3 }">selected="selected"</c:if>>승인취소</option>
						<option value="9"
							<c:if test="${param.confirmation_part == 9 }">selected="selected"</c:if>>탈퇴</option>
					</select> <input type="image" name="" id=""
						src="${pageContext.request.contextPath}/img/admin/btn/btn_search.gif" align="absmiddle" />
				</form>
			</div>
			<table width="800px" border="0" cellspacing="0" cellpadding="0"
				class="boardbg">
				<thead>
					<tr>
						<th height="32"><spring:message code="admin.member.list.number" /></th>
						<th><spring:message code="admin.member.list.level" /></th>
						<th><spring:message code="admin.member.list.name" /></th>
						<th><spring:message code="admin.member.list.id" /></th>
						<th><spring:message code="admin.member.list.phoneNumber" /></th>
						<th><spring:message code="admin.member.list.status" /></th>
						<th><spring:message code="admin.member.list.date" /></th>
						<th><button class="btn"
								style="background-image: url('${pageContext.request.contextPath}/img/admin/btn/btn_plus.gif'); width: 54px; height: 19px;"
								onclick="_insert();" title="신규추가"></button></th>
					</tr>
				</thead>
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
						<td width="15%" align="center">${member.memberRegisterDate }</td>
						<td width="15%" align="center"><button class="btn"
								style="background-image: url('${pageContext.request.contextPath}/img/admin/btn/btn_modify.gif'); width: 30px; height: 19px;"
								onclick="_modify('${item.user_row_id }');" title="수정"></button></td>
						<!-- td width="15%" align="center"><button class="btn" style="background-image:url('../images/btn_view.gif'); width:30px; height:19px;"  onclick="_view('${item.user_row_id }');" title="보기" ></button></td-->
						<!-- td width="10%" align="center">
					<button class="btn" style="background-image:url('../images/btn_modify.gif'); width:30px; height:19px;" onclick="_modify('${item.user_row_id }');" title="수정"></button>
					<button class="btn" style="background-image:url('../images/btn_delete.gif'); width:30px; height:19px;" onclick="_delete('${item.user_row_id }');" title="삭제"></button>
				</td-->
					</tr>
					<tr>
						<td colspan="8" height="1" bgcolor="#EEEEEE"></td>
					</tr>
				</c:forEach>
				<%--
				<c:forEach items="${memberList }" var="item">
					<tr height="30">
						<td width="5%" align="center">${(totalRecord - item.user_rnum) + 1 }</td>
						<td width="10%" align="center">${item.subject_ty_cd }</td>
						<td width="15%" align="center">${item.user_nm }</td>
						<td width="15%" align="center">${item.user_id }</td>
						<td width="15%" align="center">${item.tel_no }</td>
						<td width="15%" align="center">${item.confirmation_part }</td>
						<td width="15%" align="center">${item.input_order_ymd }</td>
						<td width="15%" align="center"><button class="btn"
								style="background-image: url('${pageContext.request.contextPath}/img/admin/btn/btn_modify.gif'); width: 30px; height: 19px;"
								onclick="_modify('${item.user_row_id }');" title="수정"></button></td>
						<!-- td width="15%" align="center"><button class="btn" style="background-image:url('../images/btn_view.gif'); width:30px; height:19px;"  onclick="_view('${item.user_row_id }');" title="보기" ></button></td-->
						<!-- td width="10%" align="center">
					<button class="btn" style="background-image:url('../images/btn_modify.gif'); width:30px; height:19px;" onclick="_modify('${item.user_row_id }');" title="수정"></button>
					<button class="btn" style="background-image:url('../images/btn_delete.gif'); width:30px; height:19px;" onclick="_delete('${item.user_row_id }');" title="삭제"></button>
				</td-->
					</tr>
					<tr>
						<td colspan="8" height="1" bgcolor="#EEEEEE"></td>
					</tr>
				</c:forEach>
				--%>
			</table>
			<div id="paging" class="paging" style="text-align:center; "><img src="${pageContext.request.contextPath}/img/admin/common/bt_l.gif" alt="왼쪽이동" name="Image38" width="13" height="13" border="0" style="padding-right:10px"><strong>1</strong>&nbsp;<img src="${pageContext.request.contextPath}/img/admin/common/bt_r.gif" alt="오른쪽이동" name="Image39" width="13" height="13" border="0" style="padding-left:10px"></div>
		</div>
		<!-- 내용 끝 -->
		<!-- 하단푸터 -->
		<div id="footer">
			<c:import url="../common/footer.jsp" />
		</div>
		<!-- 푸터끝-->
	</div>
	<!-- wapper 끝 -->
</body>
</html>