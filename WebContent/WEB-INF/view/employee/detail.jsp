<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />
<jsp:include page="post_nav.jsp" />
<style>
.wrapper > div {
  border: 2px;
  border-radius: 5px;
  padding: 1em;
}
.wrapper {
  display: grid;
  grid-template-columns: repeat(12, 1fr);
  grid-gap: 8px;
  grid-auto-rows: minmax(100px, auto);
}
.profile_pic {
	grid-column: 5 / 9;
	grid-row: 1;
}
.profile_tag {
	grid-column: 5;
	grid-row: 2;
}
.profile_info {
	grid-column: 6 / 9;
	grid-row: 2;
}
.lavels {
	grid-column: 6 / 8;
	grid-row: 3;
}

</style>


<div class="wrapper">
	<div class="profile_pic">
		<c:choose>
		<c:when test="${ product.photo == 'default_product.jpg'}">
			<img src="${imgpath}default_photo.gif">	
		</c:when>
		<c:otherwise>
			<img src="${imgpath}${image.imgName}.${image.imgExtention}" style="width: 100%">
		</c:otherwise>
	</c:choose>
		</div>
	<div class="profile_tag">
		<div>ID</div>
		<div>NAME</div>
		<div>SSN</div>
		<div>PHONE</div>
		<div>ADDRESS</div>
		<div>CITY</div>
		<div>COUNTRY</div>
		<div>PHOTO</div>
	</div>
	<div class="profile_info">
		${ customer.customerId} <br />
		${ customer.contactName} <br />
		${ customer.ssn } <br />
		${ customer.phone } <br />
		${ customer.address } <br />
		${ customer.city } <br />
		${ customer.country } <br />
		${ customer.photo } <br />
		</div>
		<div class="lavels">
		<form id="cust_update_form">
			<span class="label label-warning" id="cust_update_btn">UPDATE</span>
			<input type="hidden" name="customer_id" value="${ customer.customerId }"/>
			<input type="hidden" name="cmd" value="cust_retrieve" />
			<input type="hidden" name="page" value="update" />
		</form>
		<form id="cust_delete_form">
			<span class="label label-danger" id="cust_delete_btn">DELETE</span>
			<input type="hidden" name="customer_id" value="${ customer.customerId }"/>
			<input type="hidden" name="cmd" value="cust_delete" />
		</form>
		</div>
</div>
<jsp:include page="../home/tail.jsp" />

<script>
$('#cust_update_btn').click(() => {
	$('#cust_update_form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
$('#cust_delete_btn').click(() => {
	alert('Delete customer account..');
	$('#cust_delete_form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>

