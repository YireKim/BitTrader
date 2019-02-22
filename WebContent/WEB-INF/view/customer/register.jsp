<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<jsp:include page="../home/head.jsp" />
<jsp:include page="post_nav.jsp" />

<div class="row">
	<div class="col-md-10"></div>
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
  
		<span class="input-group-addon" id="basic-addon6">SSN</span>
  		<input type="text" class="form-control" name="cust_ssn" id="ssn" placeholder="SSN" aria-describedby="basic-addon5">
  
		<span class="input-group-addon" id="basic-addon7">PHONE</span>
  		<input type="text" class="form-control" name="cust_phone" id="phone" placeholder="Phone" aria-describedby="basic-addon5">
  
		<span class="input-group-addon" id="basic-addon8">PASSWORD</span>
  		<input type="text" class="form-control" name="cust_password" id="paaword" placeholder="Password" aria-describedby="basic-addon5">
  
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
	$('#joinbtn').click(() => {

		var custname = $('#contname').val();
		var custadd = $('#add').val();
		var custcity = $('#city').val();
		var custcode = $('#postalcode').val();
		var custcountry = $('#country').val();
		var custaddress = $('#address').val();
		var custssn = $('#ssn').val();
		var custphone = $('#phone').val();
		var custpassword = $('#password').val();
		
		if (custpassword === '') {
			alert('Must insert all values');
			} else {
			alert('Moving..');
			$('#joinform').attr('action', '${ctx}/customer.do').submit();
		}

	});
</script>
