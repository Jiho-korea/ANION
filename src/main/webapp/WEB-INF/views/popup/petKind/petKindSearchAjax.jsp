<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
#petKindSearchAjax {
	width: 100%;
	align-items: center;
	display: flex;
}
</style>
<div id="petKindSearchAjax">

	<input id="petKindSearch" type="text" />
	<button type="button"
		class="btn header-btn d-flex justify-content-center"
		onclick="searchFunction();">Search</button>
</div>