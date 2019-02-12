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
	margin-left: auto;
	margin-right: auto;
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

<div class="pagination">
  <a href="#">&lt;</a>
  <a href="#" class="page1">1</a>
  <a href="#" class="page2">2</a>
  <a href="#" class="page3">3</a>
  <a href="#" class="page4">4</a>
  <a href="#" class="page5">5</a>
  <a href="#">&gt;</a>
</div>

<jsp:include page="../home/tail.jsp" />

<script>

$('.page1').click(function(){
	location.assign('customer.do?cmd=list&page=list&page_num=1');
});

$('.page2').click(function(){
	location.assign('customer.do?employee_id=1000&employee_name=SULMIN&cmd=list&page=list&page_num=2');
});

$('.page3').click(function(){
	alert('Page3');
});

$('.page4').click(function(){
	alert('Page4');
});

$('.page5').click(function(){
	alert('Page6');
});

</script>