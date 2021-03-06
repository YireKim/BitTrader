<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />
<jsp:include page="post_nav.jsp" />

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
  <div>Customer ID</div>
  <div><input type="text" name="customer_id" id="custid" value="10064"/></div>
  <div>Customer Password</div>  
  <div><input type="text" name="customer_password" id="contname" value="10"/>
       <input type="hidden" name="cmd" value="signin" />
       <input type="hidden" name="dir" value="category" />
	   <input type="hidden" name="page" value="main" />
	   </div>
  	<div id="accessbtn"><input type="submit" value="access" /></div>

</div>
</form>
	<button id="backbtn">BACK</button>
	
	<jsp:include page="../home/tail.jsp" />
	
<script>

	$('#accessbtn').click(() => {
		
		var custid = $('#custid').val();
		var contname = $('#contname').val();

	if(custid === ''){
		alert('Must insert customers id');		
	} else if (contname === ''){
		alert('Must insert contacts name');
	} else {
		$('#accessform').attr('action', '${ctx}/customer.do').submit();
	}
	
});
</script>







