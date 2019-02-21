<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../home/head.jsp" />
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
	grid-column: 4 / 10;
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
		<img src="${imgpath}${image.imgName}.${image.imgExtention}" style="width: 100%">
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
		<span class="label label-warning" id="update-profile-btn">UPDATE</span>
		<span class="label label-danger" id="cancle-btn">DELETE</span>
		</div>
</div>

<jsp:include page="../home/tail.jsp" />

<script>
$('#update-profile-btn').click(function() {
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customer_id=${ customer.customerId }');
});
$('#upload_btn').click(function() {
	alert('file upload..');
		$('#file_form')
		.attr('method', 'post')
		.attr('action', '${ctx}/customer.do')
		.attr('enctype', 'multipart/form-data')
		.submit();
});
</script>

