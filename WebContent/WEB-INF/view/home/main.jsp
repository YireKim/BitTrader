<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="head.jsp" />

<div class="row">
	<div class="col-md-4"></div>  
	<div class="col-md-2">  
	Customers only<br /><br />
        <a href="#" id="cust_register" >Sign up</a><br />
        <a href="#" id="cust_access" >Login</a> </div>
	<div class="col-md-2">  
	Employees Only<br /><br />
        <a href="#" id="emp_register" >Sign up</a><br />
        <a href="#" id="emp_access">Login</a> </div>
    <div class="col-md-4"></div>  
</div>
	
<jsp:include page="tail.jsp"/>

	<script>
	$('#cust_register').click(function(){
	    location.assign('customer.do?cmd=move&page=register');
	});
	$('#cust_access').click(function(){
	    location.assign('customer.do?cmd=move&page=access');
	});
	$('#emp_register').click(function(){
	    location.assign('employee.do?cmd=move&page=register');
	});
	$('#emp_access').click(function(){
	    location.assign('employee.do?cmd=move&page=access');
	});
	</script>