<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
<c:if test="${sessionScope.SESS_SUBJECTCD != 140 }">
<script type="text/javascript">
<!--
alert("다시로그인 하시기바랍니다.");
self.location.href="${pageContext.request.contextPath }/smc/sysadm";
//-->
</script>
</c:if>
--%>
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="75%">&nbsp;</td>
                  <td width="20%"> <b>${sessionScope.login.ownerName}</b> 님 반갑습니다.</td>
                  <td width="5%"><a href="${pageContext.request.contextPath}/logout"><img src="${pageContext.request.contextPath}/img/admin/common/logout.gif" alt="로그아웃" width="51" height="18" border="0" /></a></td>
                </tr>
              </table>