<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<jsp:include page="../home/head.jsp" />

<link rel="stylesheet" href="${css}/employee/register.css" />

		<div class="grid-item" id="navi-bar">
			<c:choose>
				<c:when test="${dest eq 'login'}">
					<jsp:include page="../employee/post-navi-bar.jsp" />
				</c:when>

				<c:otherwise>
					<jsp:include page="../employee/pre-navi-bar.jsp" />
				</c:otherwise>
			</c:choose>
		</div>

		<div class="grid-item" id="memberhv">
			<jsp:include page="../home/memberhv.jsp" />
		</div>
		
<form id="content-wide">
	<div class="grid-item" id="joinform">
		<div>Contact Name</div>
		<div>
			<input type="text" name="cust_contact_name" id="contname" />
		</div>
		<div>Address</div>
		<div>
			<input type="text" name="cust_address" id="add" />
		</div>
		<div>City</div>
		<div>
			<input type="text" name="cust_city" id="city" />
		</div>
		<div>Postal code</div>
		<div>
			<input type="text" name="cust_postalcode" id="postalcode" />
		</div>
		<div>Country</div>
		<div>
			<input type="text" name="cust_country" id="country" />
		</div>
		<div id="joinbtn">
			<input type="submit" value="NewCustomer" />
		</div>
		<input type="hidden" name="cmd" value="register" />
		<input type="hidden" name="page" value="access" />
		<div id="resetbtn">
			<input type="reset" value="RESET">
		</div>
	</div>
</form>

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
