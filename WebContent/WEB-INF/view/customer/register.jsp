<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<jsp:include page="../home/head.jsp" />

<div class="row">
	<div class="col-md-10"> <jsp:include page="../employee/post-navi-bar.jsp" /> </div>
	<div class="col-md-2"> 	<jsp:include page="../home/memberhv.jsp" /> </div>
</div>

<div class="row">
	<div class="col-md-2"></div>

	<div class="col-md-8 input-group"> 
	<form id="content-wide">
	<div class="grid-item" id="joinform">
		<span class="input-group-addon" id="basic-addon1">NAME</span>
  		<input type="text" class="form-control" name="cust_contact_name" id="contname" placeholder="Contact Name" aria-describedby="basic-addon1">
  		
		<span class="input-group-addon" id="basic-addon2">ADD</span>
  		<input type="text" class="form-control" name="cust_address" id="address" placeholder="Address" aria-describedby="basic-addon2">
  		
		<span class="input-group-addon" id="basic-addon3">CITY</span>
  		<input type="text" class="form-control" name="cust_city" id="city" placeholder="City" aria-describedby="basic-addon3">
  		
		<span class="input-group-addon" id="basic-addon4">POSTAL CODE</span>
  		<input type="text" class="form-control" name="cust_postalcode" id="code" placeholder="Postal code" aria-describedby="basic-addon4">
  		
		<span class="input-group-addon" id="basic-addon5">COUNTRY</span>
  		<input type="text" class="form-control" name="cust_country" id="country" placeholder="Country" aria-describedby="basic-addon5">
  
  		<div class="col-md-6"> 
  			<span class="input-group-btn">
        	<button class="btn btn-default" id="joinbtn" type="submit">JOIN</button></span>	
        	<input type="hidden" name="cmd" value="SIGNUP" />
        	<input type="hidden" name="dir" value="customer" />
			<input type="hidden" name="page" value=access />       	
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

		var custname = $('#contname').val();
		var custadd = $('#add').val();
		var custcity = $('#city').val();
		var custcode = $('#postalcode').val();
		var custcountry = $('#country').val();

		if (contname === '') {
			alert('Must insert customers name');
		} else if (add === '') {
			alert('Must insert customers address');
		} else if (city === '') {
			alert('Must insert customers city');
		} else if (postalcode === '') {
			alert('Must insert customers postal code ');
		} else {
			alert('Moving..');
			$('#joinform').attr('action', '${ctx}/customer.do').submit();
		}

	});
</script>
