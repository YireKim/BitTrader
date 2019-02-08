<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<jsp:include page="../home/head.jsp" />

<div class="row">
	<div class="col-md-2"></div>

	<div class="col-md-8 input-group"> 
<form id="content-wide">
	<div class="grid-item" id="joinform">
		<span class="input-group-addon" id="basic-addon1">Name</span>
  		<input type="text" class="form-control" name="employeeName" id="empname" placeholder="User id" aria-describedby="basic-addon1">
  		
		<span class="input-group-addon" id="basic-addon2">BDay</span>
  		<input type="text" class="form-control" name="birthDate" id="bday" placeholder="Birth day" aria-describedby="basic-addon2">
  		
		<span class="input-group-addon" id="basic-addon3">PHOTO</span>
  		<input type="text" class="form-control" name="photo" id="photo" placeholder="User id" aria-describedby="basic-addon3">
  		
		<span class="input-group-addon" id="basic-addon4">INFO</span>
  		<input type="text" class="form-control" name="noteInfo" id="note" placeholder="User id" aria-describedby="basic-addon4">
  		
		<span class="input-group-addon" id="basic-addon5">Manager</span>
  		<input type="text" class="form-control" name="managerId" id="mngid" placeholder="User id" aria-describedby="basic-addon5">
  
  		<div class="col-md-6"> 
  			<span class="input-group-btn">
        	<button class="btn btn-default" id="joinbtn" type="submit">JOIN</button></span>	
        	<input type="hidden" name="cmd" value="register" />
        	<input type="hidden" name="dir" value="employee" />
			<input type="hidden" name="page" value="access" />       	
      	</div>	
      	<div class="col-md-6"> 
      		<span class="input-group-btn">
        	<input class="btn btn-default" id="restbtn" type="reset" value="RESET">RESET</span>	
      	</div>   	
	</div>
</form>

	</div>

		<div class="col-md-2"></div>
</div>


<jsp:include page="../home/tail.jsp" />

<script>
	$('#joinbtn').click(function() {

		var empno = $('#empno').val();
		var empname = $('#empname').val();
		var mngid = $('#mngid').val();
		var bday = $('#bday').val();
		var note = $('#note').val();

		if (empno === '') {
			alert('Must insert employee no.');
		} else if (empname === '') {
			alert('Must insert employee name');
		} else if (mngid === '') {
			alert('Must insert manager id');
		} else if (bday === '') {
			alert('Must insert your birth day');
		} else {
			alert('Moving..');
			$('#joinform').attr('action', '${ctx}/employee.do').submit();
		}

	});
</script>
