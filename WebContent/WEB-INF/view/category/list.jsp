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
			<th>Category ID</th>
			<th>Name</th>
			<th>Note</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>
		<c:forEach var="cat" items="${list}">
		<tr>
			<td>${ cat.categoryId }</td>
			<td>${ cat.categoryName }</td>
			<th>${ cat.noteDescription }</th>
			<th id="edit_margin">
				<a href="${ctx}/category.do?cmd=cat_retrieve&page=update&category_id=${ cat.categoryId }">
				<span id="edit" class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
			</th>
			<th id="remove_margin">
				<a href="${ctx}/category.do?cmd=cat_delete&page=list&category_id=${ cat.categoryId }">
				<span id="remove" class="glyphicon glyphicon-floppy-remove" aria-hidden="true"></span></a>
			</th>
		</tr>
		</c:forEach>
	</table>
</div>

<div class="pagination">
<c:choose>
	<c:when test="${pagination.prev}">
	<a href="${ctx}/category.do?cmd=cat_list&page=list&page_num=${pagination.prevBlock}" class="prev">&laquo;</a>
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
	<a href="${ctx}/category.do?cmd=cat_list&page=list&page_num=${pagination.nextBlock}" class="next">&raquo;</a>
	</c:when>
	<c:otherwise>
	<a href="#" class="next_x">X</a>
	</c:otherwise>
</c:choose>
</div>
</div>

<jsp:include page="../home/tail.jsp" />

<script>
$('.page' ).click(() => {
	location.assign('${ctx}/product.do?cmd=prod_list&page=main&page_num='+$(this).text());
});

</script>
