<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="diarys" />
<%@ include file="../part/head.jspf"%>

<div class="con">

	<div>${member.nickName}</div>

	<c:forEach items="${diarys}" var="diary">
		<section>
			<a href="./detail?id=${diary.id}"> ${diary.id} /  ${diary.title}</a>
		</section>
	</c:forEach>
	
</div>

<%@ include file="../part/foot.jspf"%> 