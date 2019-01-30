<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />

<style>

.access-form {
  display: grid;
  grid-template-columns: auto 80%;
  grid-gap: 1px;
  padding: 1px;
}
#access_btn {
	grid-column-start: 1;
	grid-column-end: 3;
	
}
</style>

<form id="accessform">
<div class="access-form">
  <div>Employee ID</div>
  <div><input type="text" name="empno" id="empno2" /></div>
  <div>Employee NAME</div>  
  <div><input type="text" name="employeeName" id="empname2"/></div>
  	<div id="accessbtn"><input type="submit" value="Access" /></div>

</div>
</form>
	<button id="backbtn">BACK</button>
	
	<jsp:include page="../home/tail.jsp" />
	
<script>

	$('#accessbtn').click(function(){
		
		var empno = $('#empno2').val();
		var empname = $('#empname2').val();

	if(empno2 === ''){
		alert('Must insert employee no.');		
	} else if (empname2 === ''){
		alert('Must insert employee name');
	} else {
		alert('Moving..');
		$('#accessform').attr('action', '${ctx}/customer.do').submit();
	}
	
});
</script>







