<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />

<style>
.table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	padding: 8px 8px;
	border: 1px solid #ddd;
	margin-left: 200px;
	margin-right: 200px;
}

.table td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

.table tr:nth-child(even) {
	background-color: #eeeeee;
}

.pagination {
	display: inline-block;
	margin: auto auto auto 450px;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 4px 4px;
}

.pagination a.active {
	background-color: #45a049;
	color: white;
	border: 1px solid #4CAF50;
}
.pagination a:hover:not(.active) { 
	background-color: #4CAF50;
}
</style>

<div class="table">
	<table>
		<tr>
			<th>NO.</th>
			<th>Customer ID</th>
			<th>Name</th>
			<th>SSN</th>
			<th>Phone</th>
			<th>Address</th>
			<th>City</th>
			<th>Postal-code</th>
			<th>Country</th>
		</tr>

		<c:forEach var="cust" items="${list}">
			<tr>
				<td>${ cust.no }</td>
				<td>${ cust.customerId }</td>
				<th><a href="${ctx}/customer.do?cmd=cust_retrieve&page=detail&customer_id=${ cust.customerId }">${ cust.contactName }</a></th>
				<th>${ cust.ssn }</th>
				<th>${ cust.phone }</th>
				<th>${ cust.address }</th>
				<th>${ cust.city }</th>
				<th>${ cust.postalCode }</th>
				<th>${ cust.country }</th>
			</tr>
		</c:forEach>
	</table>
</div>

<div class="pagination">
<c:choose>
	<c:when test="${pagination.prev}">
	<a href="${ctx}/customer.do?cmd=list&page=list&page_num=${pagination.prevBlock}" class="prev">&laquo;</a>
	</c:when>
	<c:otherwise>
	<a href="#" class="prev_x">X</a>
	</c:otherwise>
</c:choose>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" varStatus="status">
<c:choose>
	<c:when test="${ pagination.pageNum eq status.index }">
    	<a href="#" class="page active">${status.index}</a>
	</c:when>
	<c:otherwise>
    	<a href="#" class="page">${status.index}</a>
	</c:otherwise>
</c:choose>
		</c:forEach>
<c:choose>
	<c:when test="${pagination.next}">
	<a href="${ctx}/customer.do?cmd=list&page=list&page_num=${pagination.nextBlock}" class="next">&raquo;</a>
	</c:when>
	<c:otherwise>
	<a href="#" class="next_x">X</a>
	</c:otherwise>
</c:choose>
</div>


<jsp:include page="../home/tail.jsp" />

<script>
$('.page' ).click(function() {
	location.assign('${ctx}/customer.do?cmd=list&page=list&page_num='+$(this).text());
});
</script>
