<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />

<div class="row">
	<div class="col-md-10"><jsp:include page="navi-bar.jsp" /></div>
	<div class="col-md-2"><jsp:include page="../home/memberhv.jsp" /></div>
</div>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8" id="content"><jsp:include page="list.jsp" /></div>
	<div class="col-md-2"></div>
</div>

<jsp:include page="../home/tail.jsp" />