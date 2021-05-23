<!-- 
========================================================================
파    일    명 : kindcodeListAjax.jsp
========================================================================
작    성    자 : 강지호
작    성    일 : 2021.05.23
작  성  내  용 : 견종 선택 지도 팝업에서 변하는 부분만을 나타내는 jsp
========================================================================
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
#kindcodeListAjax {
	width: 100%;
	align-items: center;
	display: flex;
}
</style>
<div id="kindcodeListAjax">
	<select style="display: none;" id="childKind" name="childKind">
		<c:if test="${empty kindcode}">
			<option value=""></option>
		</c:if>
		<c:if test="${!empty kindcode}">
			<option value="${kindcode.petKind }"></option>
		</c:if>
		<c:forEach var="kindcode" items="${kindcodeListPage}"
			varStatus="status">
			<option value="${kindcode.petKind}">${kindcode.petKind}</option>
		</c:forEach>
	</select>
	<c:if test="${empty selectOpen}">
		<div class="nice-select" tabindex="0">
			<c:if test="${empty kindcode}">
				<span class="current">견종 / Dog breed</span>
			</c:if>
			<c:if test="${not empty kindcode}">
				<span class="current">${kindcode.petKind }</span>
			</c:if>
			<ul class="list">
				<li data-value="견종 / Dog breed" class="option selected focus"
					hidden="">견종 / Dog breed</li>
				<c:forEach var="kindcode" items="${kindcodeListPage}"
					varStatus="status">
					<li data-value="${kindcode.petKind}" class="option">${kindcode.petKind}</li>
				</c:forEach>

				<div class="d-flex justify-content-center">
					<c:if test="${pageNumber ne 1}">
						<button id="btn_left_arrow" type="button"
							style="border: 0; background-color: #FFFFFF;"
							onclick="pagingFunction(${pageNumber - 1})">
							<img style="cursor: pointer;"
								src="${pageContext.request.contextPath}/img/button/left-icon.png">
						</button>
					</c:if>
					<c:if test="${nextPage}">
						<button id="btn_right_arrow" type="button"
							style="border: 0; background-color: #FFFFFF;"
							onclick="pagingFunction(${pageNumber + 1})">
							<img style="cursor: pointer;"
								src="${pageContext.request.contextPath}/img/button/right-icon.png">
						</button>

					</c:if>
				</div>
			</ul>
		</div>
	</c:if>

	<c:if test="${!empty selectOpen}">
		<div class="nice-select open" tabindex="0">
			<c:if test="${empty kindcode}">
				<span class="current">견종 / Dog breed</span>
			</c:if>
			<c:if test="${not empty kindcode}">
				<span class="current">${kindcode.petKind }</span>
			</c:if>
			<ul class="list">
				<li data-value="견종 / Dog breed" class="option selected focus"
					hidden="">견종 / Dog breed</li>
				<c:forEach var="kindcode" items="${kindcodeListPage}"
					varStatus="status">
					<li data-value="${kindcode.petKind}" class="option">${kindcode.petKind}</li>
				</c:forEach>

				<div class="container d-flex justify-content-center">
					<c:if test="${pageNumber ne 1}">
						<button id="btn_left_arrow" type="button"
							style="border: 0; background-color: #FFFFFF;"
							onclick="pagingFunction(${pageNumber - 1})">
							<img style="cursor: pointer;"
								src="${pageContext.request.contextPath}/img/button/left-icon.png">
						</button>
					</c:if>
					<c:if test="${nextPage}">
						<button id="btn_right_arrow" type="button"
							style="border: 0; background-color: #FFFFFF;"
							onclick="pagingFunction(${pageNumber + 1})">
							<img style="cursor: pointer;"
								src="${pageContext.request.contextPath}/img/button/right-icon.png">
						</button>

					</c:if>
				</div>
			</ul>
		</div>
	</c:if>


	&nbsp;&nbsp;
	<button type="button"
		class="btn header-btn d-flex justify-content-center"
		onclick="dogSelect();">OK</button>
</div>