<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1">
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<title><spring:message code="home.title" /></title>
</head>
<body>
	<c:import url="../../included/top.jsp">
		<c:param value="board" name="type" />
	</c:import>

	<div class="container" style="margin-top: 60px">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd; word-wrap: break-word; word-break: break-all;">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #dddddd; text-align: center; font-weight: normal">${fn:replace(fn:replace(fn:replace(fn:replace(fn:replace(imgpost.imgpostTitle, ' ', '&nbsp;'), '<', '&lt;'), '>', '&gt;'), '\\n', ''), '\"', '&quot;')}</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%"><spring:message
								code="bbs.img.board.writer" /></td>
						<td colspan="2">${imgpost.member.memberName}</td>
					</tr>
					<tr>
						<td><spring:message code="bbs.img.board.reportingdate" /></td>
						<td colspan="2">${fn:substring(imgpost.imgpostPostingtime, 0, 10)}
							${fn:substring(imgpost.imgpostPostingtime, 11, 13)}:${fn:substring(imgpost.imgpostPostingtime, 14, 16)}</td>
					</tr>
					<tr style="background-color: #ffffff">
						<td><spring:message code="bbs.img.board.content" /></td>
						<td colspan="2" style="height: 200px; text-align: left"><c:forEach
								var="imgpostAndImage" items="${imgpost.imgpostAndImages}"
								varStatus="status">
								<img alt=""
									src="${pageContext.request.contextPath}/upload/${imgpostAndImage.image.imagePath}">
							</c:forEach> <br>
						<br>
						<br>
							<div>
								${fn:replace(fn:replace(fn:replace(fn:replace(fn:replace(imgpost.imgpostContent, ' ', '&nbsp;'), '<', '&lt;'), '>', '&gt;'), '\\n', ''), '\"', '&quot;')}
							</div></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="float: right">

			<c:if
				test="${sessionScope.login.memberNumber eq imgpost.memberNumber}">
				<a href="#" class="btn btn-primary"><spring:message code="edit" /></a>
				<a href="#" class="btn btn-primary"
					onclick="return confirm('<spring:message
						code="bbs.img.board.delete.confirm" />')"><spring:message
						code="delete.button" /></a>
			</c:if>

			<a href="${pageContext.request.contextPath}/board/img"
				class="btn btn-primary"><spring:message code="go.list" /></a>
		</div>

		<br> <br>
	</div>
	<%--
		<form
			action="${pageContext.request.contextPath}/from/comment?postNo=${imgpost.imgpostNo}"
			method="post">

			<div class="form-group">
				<div class="input-group mb-3">
					<textarea rows="3" cols="90" class="form-control" rows="3"
						name="commentContent" aria-describedby="button-addon2"></textarea>
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="submit"
							id="button-addon2">댓글작성</button>
					</div>
				</div>
			</div>


		</form>
	</div>

	<c:if test="${!empty imgpost.comments}">
		<div class="container" style="margin-top: 60px">
			<div class="row">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<c:forEach var="c" items="${post.comments}">
						<tr>
							<td width="30%">${c.student.name}</td>
							<td width="70%"><c:choose>
									<c:when
										test="${comment ne null && comment.commentNo eq c.commentNo}">
										<div class="form-group">
											<div class="input-group">
												<form
													action="${pageContext.request.contextPath}/from/updatecomment?postNo=${post.postNo}&commentNo=${c.commentNo}"
													method="post">



													<textarea rows="3" cols="100" class="form-control"
														name="commentContent" aria-describedby="button-addon4">${c.commentContent}</textarea>


													<div class="input-group-append" style="float: right"
														id="button-addon4">
														<button class="btn btn-outline-secondary" type="submit">수정</button>
														<a
															href="${pageContext.request.contextPath}/from/post?postNo=${post.postNo}">
															<button class="btn btn-outline-secondary" type="button">취소</button>
														</a>
													</div>

												</form>


											</div>

										</div>
									</c:when>
									<c:otherwise>
										${c.commentContent}
										<c:if test="${sessionScope.login eq c.sid}">
											<a
												href="${pageContext.request.contextPath}/from/post?postNo=${post.postNo}&commentNo=${c.commentNo}"><input
												type="button" class="btn btn-secondary btn-sm" value="수정" /></a>
											<a
												href="${pageContext.request.contextPath}/from/deletecomment?commentNo=${c.commentNo}&postNo=${post.postNo}"><input
												type="button" class="btn btn-secondary btn-sm" value="삭제" /></a>
										</c:if>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</c:if>
 --%>

</body>
<script defer type="text/javascript">
	function fn_updateImgpost(imgpostNo) {
		var url = "${pageContext.request.contextPath}/board/img/view";
		url = url + "?imgpostNo=" + imgpostNo;
		location.href = url;
	}

	function fn_deleteImgpost(imgpostNo) {
		var url = "${pageContext.request.contextPath}/board/img/view";
		url = url + "?imgpostNo=" + imgpostNo;
		location.href = url;
	}
</script>
</html>