<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />

<div class="grid-item" id="navi-bar">
	<jsp:include page="pre-navi-bar.jsp" />
</div>

<div class="grid-item" id="memberhv">
	<jsp:include page="../home/memberhv.jsp" />
</div>

<div class="grid-item" id="side-menu">
	<jsp:include page="side-menu.jsp" />
</div>

<div class="grid-item" id="content">
	<jsp:include page="content.jsp" />
</div>

<jsp:include page="../home/tail.jsp" />
