<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />

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
	grid-column: 4/12;
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
#edit_margin{
	text-align: center;
}
#remove_margin{
	text-align: center;
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
</style>
<div class="wrapper">
<div class="table">
	<table>
		<tr>
			<th>NO.</th>
			<th>Product ID</th>
			<th>Name</th>
			<th>Supplier ID</th>
			<th>Category ID</th>
			<th>Unit</th>
			<th>Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="prod" items="${list}">
		<tr>
			<td>${ prod.no }</td>
			<td>${ prod.productId }</td>
			<th><a href="${ctx}/product.do?cmd=prod_retrieve&page=detail&product_id=${ prod.productId }">${ prod.productName }</a></th>
			<th>${ prod.supplierId }</th>
			<th>${ prod.categoryId }</th>
			<th>${ prod.unit }</th>
			<th>${ prod.price }</th>
			<th id="edit_margin"><span id="edit" class="glyphicon glyphicon-edit" aria-hidden="true"></span></th>
			<th id="remove_margin"><span id="remove" class="glyphicon glyphicon-floppy-remove" aria-hidden="true"></span></th>
		</tr>
		</c:forEach>
	</table>
</div>

<div class="pagination">
<c:choose>
	<c:when test="${pagination.prev}">
	<a href="${ctx}/product.do?cmd=prod_list&page=main&page_num=${pagination.prevBlock}" class="prev">&laquo;</a>
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
	<a href="${ctx}/product.do?cmd=prod_list&page=main&page_num=${pagination.nextBlock}" class="next">&raquo;</a>
	</c:when>
	<c:otherwise>
	<a href="#" class="next_x">X</a>
	</c:otherwise>
</c:choose>
</div>
</div>

<jsp:include page="../home/tail.jsp" />

<script>
$('.page' ).click(function() {
	location.assign('${ctx}/product.do?cmd=prod_list&page=main&page_num='+$(this).text());
});
</script>
