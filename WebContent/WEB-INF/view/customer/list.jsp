<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />
<jsp:include page="post_nav.jsp" />

<style>
.wrapper>div {
	border: 2px;
	border-radius: 5px;
	padding: 1em;
}
.wrapper {
	display: grid;
	grid-template-columns: repeat(12, 1fr);
	grid-gap: 8px;
	grid-auto-rows: minmax(100px, auto);
}
.table {
	grid-column: 2/12;
	grid-row: 1;
}
.table td, th {
	border: 1px solid #dddddd;
	text-align: lfet;
	padding: 8px;
}
.table tr:nth-child(even) {
	background-color: #eeeeee;
}
.pagination {
	grid-column: 5/12;
	grid-row: 2;
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
.pagination a:hover:not (.active ) {
	background-color: #4CAF50;
}
#search-bar {
	grid-column: 2;
	grid-row: 3;
}
#grid-edit {
	grid-column: 7;
	grid-row: 3;
}
#grid-remove {
	grid-column: 8;
	grid-row: 3;
}
</style>
<div class="wrapper">
<div class="table">
	<table>
		<tr>
			<th></th>
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

		<c:forEach var="customer" items="${list}">
			<tr>
				<td><label class="radio-inline">
  					<input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"></label></td>
				<td>${ customer.no }</td>
				<td>${ customer.customerId }</td>
				<th><a href="${ctx}/customer.do?cmd=cust_retrieve&page=detail&customer_id=${ customer.customerId }">${ customer.contactName }</a></th>
				<th>${ customer.ssn }</th>
				<th>${ customer.phone }</th>
				<th>${ customer.address }</th>
				<th>${ customer.city }</th>
				<th>${ customer.postalCode }</th>
				<th>${ customer.country }</th>
			</tr>
		</c:forEach>
	</table>
	<div id="search-bar">
	search bar
	</div>
	<div id="grid-edit">
				<a class="btn btn-primary" href="${ctx}/customer.do?cmd=cust_retrieve&page=update&customer_id=${ customer.customerId }">UPDATE</a>
			</div>
			<div id="grid-remove">
				<a class="btn btn-danger" href="${ctx}/customer.do?cmd=cust_delete&page=list&customer_id=${ customer.customerId }" >DELETE</a>
			</div>
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
</div>

<button type="button" class="btn btn btn-lg" data-toggle="modal" data-target="#myModal">
  wating :33
</button>

<jsp:include page="delete_confirm_modal.jsp" />
<jsp:include page="../home/tail.jsp" />

<script>
$('.page' ).click(() => {
	location.assign('${ctx}/customer.do?cmd=list&page=list&page_num='+$(this).text());
});
</script>
