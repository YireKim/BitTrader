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
  grid-template-columns: repeat(8, 1fr);
  grid-gap: 8px;
  grid-auto-rows: minmax(100px, auto);
}
.profile_pic {
	grid-column: 2;
	grid-row: 2;
}

.profile_tag {
	grid-column: 2;
	grid-row: 3 / 4;
}
.profile_info {
	grid-column: 3 / 7;
	grid-row: 3 / 4;
}
.lavels {
	grid-column: 3;
	grid-row: 4;
}

</style>


<div class="wrapper">
	<div class="profile_pic">
		<img src="${img}/${image.imgName}.${image.imgExtention}" alt="default_profile" class=".img-responsive">
		
		</div>
	<div class="profile_tag">
		<div>ID</div>
		<div>NAME</div>
		<div>SSN</div>
		<div>PHONE</div>
		<div>ADDRESS</div>
		<div>CITY</div>
		<div>COUNTRY</div>
	</div>
	<div class="profile_info">
		${ customer.customerId} <br />
		${ customer.contactName} <br />
		${ customer.ssn } <br />
		${ customer.phone } <br />
		${ customer.address } <br />
		${ customer.city } <br />
		${ customer.country } <br />
		</div>
		<div class="lavels">
		<span class="label label-warning" id="update-profile-btn">UPDATE</span>
		<span class="label label-danger" id="cancle-btn">DELETE</span>
		</div>
</div>

<jsp:include page="../home/tail.jsp" />

<script>
$('#update-profile-btn').click(function() {
	alert('detail..');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customer_id='+${ customer.customerId });
});
$('#upload_btn').click(function() {
	alert('file upload..');
	$('#file_form')
		.attr('action', '${ctx}/customer.do')
		.attr('method', 'post')
		.attr('enctype', 'multipart/form-data')
		.submit();
});
</script>


