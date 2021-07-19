<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
#petLocationSelectAjax {
	align-items: center;
}
</style>
<div id="petLocationSelectAjax">
	<span class="title" style="text-align: center;">${address } <span
		id="centerAddr"
		style="position: absolute; left: 50%; transform: translate(-50%, 0%);"><br>
			<button type="button" class="btn header-btn"
				onclick="popupClose()">OK</button></span>
	</span>
</div>