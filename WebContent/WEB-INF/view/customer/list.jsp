<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />

<style>
.table1 {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	padding: 8px 8px;
	border: 1px solid #ddd;
	margin-left: 200px;
	margin-right: 200px;
}

.table1 td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

.table1 tr:nth-child(even) {
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

<div class="table1">
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
				<th>${ cust.contactName }</th>
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


<%-- <div class="pagination">
	<a href="#">&lt;</a>
	<c:forEach begin="1" end="5" varStatus="status">
		<a href="#" id="page_${ status.count }">${ status.count }</a>
	</c:forEach>
	<a href="#">&gt;</a>
</div> --%>


<%-- <div class="pagination" style="margin-left: 200px">

<c:url var="action" value="/customer.do?&cmd=list&page=list"/>
<a href="javascript:PageMove(${pagination.prev})">&lt;</a>
<c:if test="${param.prev}">
    <a href="${action}?page_num=${param.beginPage-1}">prev</a>
</c:if>
<c:forEach begin="${param.startPage}" end="${param.endPage}" step="1" var="index">
    <c:choose>
        <c:when test="${param.page_num==index}">
            ${index}
        </c:when>
        <c:otherwise>
            <a href="${action}?page=${index}">${index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${param.next}">
    <a href="${action}?page=${param.endPage+1}">next</a>
</c:if>
</div> --%>

<div class="pagination">
<c:choose>
	<c:when test="${pagination.prev}">
	<a href="#" class="prev">&laquo;</a>
	</c:when>
	<c:otherwise>
	<a href="#" class="prev_x">X</a>
	</c:otherwise>
</c:choose>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" varStatus="status">
    	<a href="#" class="page">${status.index}</a>
		</c:forEach>
<c:choose>
	<c:when test="${pagination.next}">
	<a href="#" class="next">&raquo;</a>
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
$('.prev' ).click(function() {
	location.assign('${ctx}/customer.do?cmd=list&page=list&page_num='+${pagination.prevBlock});
});
$('.next' ).click(function() {
	location.assign('${ctx}/customer.do?cmd=list&page=list&page_num='+${pagination.nextBlock});
});
</script>
