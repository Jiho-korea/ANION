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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="reURL" value="${fn:split(pageContext.request.servletPath , '/')}" />
<%-- http://blog.daum.net/haha25/5388656 --%>
<style type="text/css">
#leftmenu {
	width:170px; /* 가로 너비를 정하는 속성입니다. */
}

#leftmenu a {
	display:block; /* a태그의 display속성을 block으로 설정 */	
	padding:10px 10px 10px 15px; /* 내부여백 padding값 순서대로 top right bottom left */
	margin-bottom:1px; /* 하단에 외부여백 1px */
	background-color:#fff; /* 바탕색 */
	color:#fff; /* 글자색 */
	font:12px Verdana; /* 폰트 속성 순서대로 크기 글꼴 */
	font-weight:bold;
	/* text-transform:uppercase; */ /* 폰트를 대문자로 바꿔준다. */
	border:1px solid #ccc;
}

#leftmenu a:hover {
	padding-left:10px; /* 왼쪽 여백을 기존 15px에서 10px으로 줄여준다. */
	border-left:5px solid #b6e24c; /* 줄어든 여백만큼 border로 5px을 지정해 준다. */
	color:#fff; /* 폰트 색상 */
	background-color:#669933; /* 바탕색 */
}

#leftmenu a.on {
	padding-left:10px; /* 왼쪽 여백을 기존 15px에서 10px으로 줄여준다. */
	border-left:5px solid #b6e24c; /* 줄어든 여백만큼 border로 5px을 지정해 준다. */
	color:#fff; /* 폰트 색상 */
	background-color:#669933; /* 바탕색 */
	/* border:1px solid #b6e24c; */
}
</style>
<script type="text/javascript">
<!--
function _trace(){
	var pop_status; // 하나 만들어줌.. 팝업창 뒤로 갔을 때 다시 앞으로가게 하기
	var winWidth  = 1024;
	var winHeight = 768;
	var CenterW = (screen.availWidth -winWidth)/2;
	var CenterH = (screen.availHeight - winHeight)/2;
	pop_status = window.open("${pageContext.request.contextPath}/smc/producer/producer05.jsp" , "_sample", "left="+ CenterW +", top="+ CenterH +", width="+ winWidth +" height="+ winHeight +", scrollbars=yes, toolbars=no, resizable=no");
	pop_status.focus();
}
//-->
</script>
	<%--ul id="leftmenu">
		<!--li><a href="../officer/list.do"  onBlur="" onFocus=""onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image1','','../images/menu/sub1_on.gif',1)"><img src="../images/menu/sub1<c:if test="${reURL[2] == 'officer' }">_on</c:if>.gif" name="Image1" width="150" height="40" border="0" alt="권한관리" /></a>
			<ul>
				<li><a href="#">- 공통코드</a></li>
				<li><a href="#">- 품목코드</a></li>
			</ul>
		</li-->
		<li><a href="../member/list.do"><img src="../images/menu/sub2<c:if test="${reURL[2] eq 'member'}">_on</c:if>.gif" name="Image2" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image2','','../images/menu/sub2_on.gif',1);" alt="회원관리" /></a></li>
		<li><a href="../bbs/list.do"><img src="../images/menu/sub3<c:if test="${reURL[2] eq 'bbs'}">_on</c:if>.gif" name="Image3" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image3','','../images/menu/sub3_on.gif',1);" alt="게시판관리" /></a></li>
		<!--li><img src="../images/menu/sub4<c:if test="${reURL[2] eq 'syscode' or reURL[2] eq 'itemcode'}">_on</c:if>.gif" name="Image4" width="150" height="40" border="0" alt="기준정보관리" />
			<ul>
				<li><a href="../mstcode/list.do">- 공통코드</a></li>
				<li><a href="../itemcode/treeList.do">- 품목코드</a></li>
			</ul>
		</li-->
		<!--li><a href="#" onclick="_trace();"><img src="../images/menu/sub5.gif" name="Image5" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image5','','../images/menu/sub5_on.gif',1);" alt="종자관리업무관리" /></a></li-->
		<!--li><a href="#"><img src="../images/menu/sub6<c:if test="${reURL[2] eq 'state'}">_on</c:if>.gif" name="Image6" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image6','','../images/menu/sub6_on.gif',1);" alt="통계정보관리" /></a>
			<ul>
				<li><a href="#">- 농가재배관리번호별 조회수</a></li>
				<li><a href="#">- 관리번호별조회수</a></li>
				<li><a href="#">- 품목별관리번호조회수</a></li>
				<li><a href="#">- 품목별생산자수</a></li>
			</ul>
		</li-->
		<!--li><a href="../crop/list.do"><img src="../images/menu/sub7<c:if test="${reURL[2] eq 'crop'}">_on</c:if>.gif" name="Image7" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image7','','../images/menu/sub7_on.gif',1);" alt="" /></a></li-->
		<li><a href="../farmbase/list.do"><img src="../images/menu/sub8<c:if test="${reURL[2] eq 'farmbase'}">_on</c:if>.gif" name="Image8" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image8','','../images/menu/sub8_on.gif',1);" alt="" /></a></li>
		<!--li><a href="../mobile/list.do"><img src="../images/menu/sub9<c:if test="${reURL[2] eq 'member'}">_on</c:if>.gif" name="Image9" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image9','','../images/menu/sub9_on.gif',1);" alt="" /></a></li-->
		<li><a href="../product/list.do"><img src="../images/menu/sub10<c:if test="${reURL[2] eq 'product'}">_on</c:if>.gif" name="Image10" width="150" height="40" border="0" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('Image10','','../images/menu/sub10_on.gif',1);" alt="" /></a></li>
	</ul--%>
	<div id="leftmenu">
		<a href="${pageContext.request.contextPath}/admin/member/list" class="<c:if test="${reURL[2] eq 'member'}">on</c:if>">회원관리</a>
		<%--
		<a href="${pageContext.request.contextPath}/smc/sysadm/bbs/list.do" class="<c:if test="${reURL[2] eq 'bbs'}">on</c:if>">게시판관리</a>
		<a href="${pageContext.request.contextPath}/smc/sysadm/farmbase/list.do" class="<c:if test="${reURL[2] eq 'farmbase'}">on</c:if>">생물자원기초정보관리</a>
		<a href="${pageContext.request.contextPath}/smc/sysadm/product/list.do" class="<c:if test="${reURL[2] eq 'product'}">on</c:if>">상품소개관리</a>
		<a href="${pageContext.request.contextPath}/smc/sysadm/certify/companyList.do" class="<c:if test="${reURL[2] eq 'certify'}">on</c:if>">인증업체관리</a>
		<a href="${pageContext.request.contextPath}/smc/sysadm/mobile/menuList.do" class="<c:if test="${reURL[2] eq 'mobile'}">on</c:if>">모바일</a>
	 --%>
	</div>