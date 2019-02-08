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
  <div><input type="text" name="employee_id" id="empid"/></div>
  <div>Employee NAME</div>  
  <div><input type="text" name="employee_name" id="empname"/>
       <input type="hidden" name="cmd" value="access" />
       <input type="hidden" name="dir" value="employee" />
	   <input type="hidden" name="page" value="main" />
	   </div>
  	<div id="accessbtn"><input type="submit" value="access" /></div>

</div>
</form>
	<button id="backbtn">BACK</button>
	
	<jsp:include page="../home/tail.jsp" />
	
<script>

	$('#accessbtn').click(function(){
		
		var empno = $('#empid').val();
		var empname = $('#empname').val();

	if(empno === ''){
		alert('Must insert employee no.');		
	} else if (empname === ''){
		alert('Must insert employee name');
	} else {
		alert('Moving..');
		$('#accessform').attr('action', '${ctx}/employee.do').submit();
	}
	
});
</script>







