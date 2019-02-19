<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="head.jsp" />

<style>
button::-moz-focus-inner,
input::-moz-focus-inner {
    border: 0;
    padding: 0;
}
 
.ct-btn {
	display: inline-block;
	margin: 5px 0;
	padding: .5em .75em;
	border-radius: .25em;
	box-sizing: content-box;
	-moz-box-sizing: content-box;
	background: transparent;
	outline: 0;
	vertical-align: middle;
	font-family: inherit;
	font-size: 18px;
	text-decoration: none;
	white-space: nowrap;
	cursor: pointer
}
.ct-btn.white,
.ct-btn.white:link,
.ct-btn.white:visited {
	color: #666;
	border: 1px solid #ebebeb;
	border-bottom-color: #c6c6c6;
	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.04);
	background: #fff;
	background: linear-gradient(to bottom, #ffffff 40%, #f6f6f6 100%);
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#f6f6f6', GradientType=0 );/*IE*/
}
 
/* 마우스오버 */
.ct-btn.white:focus,
.ct-btn.white:hover {
	background: #f4f4f4;
	background: linear-gradient(to bottom, #fafafa 0%, #fff 100%);
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fafafa', endColorstr='#ffffff', GradientType=0 );/*IE*/
}
 
/* 눌려졌거나 선택 된 상황 */
.ct-btn.white:active,
.ct-btn.white.active {
	text-shadow: 0 1px 0px #fff;
	border-color: #ebebeb;
	border-top-color: #ddd;
	background: #f4f4f4;
	box-shadow: none
</style>
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