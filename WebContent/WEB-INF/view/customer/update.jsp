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

	<form id="form">
		<c:choose>
		<c:when test="${ product.photo == 'default_product.jpg'}">
			<img src="${imgpath}default_profile.gif">	
		</c:when>
		<c:otherwise>
			<img src="${imgpath}${image.imgName}.${image.imgExtention}" style="width: 100%">
		</c:otherwise>
		</c:choose>
       	<input type="file" name="file_upload" />
		<input type="submit" id="file_upload_btn" />
	</form>
</div>
	<div class="profile_tag">
		<div>ID</div>
		<div>NAME</div>
		<div>PHOTO</div>
		<div>PASSWORD</div>
		<div>SSN</div>
		<div>PHONE</div>
		<div>ADDRESS</div>
		<div>CITY</div>
		<div>COUNTRY</div>
	</div>
	<div class="profile_info">
		<div>${ customer.customerId}</div>
		<div>${ customer.contactName}</div>
		<div>${ customer.photo}</div>
<form id="cust_update_form">
		<div><input type="text" name="password" placeholder="${ customer.password}"/></div>		
		<div><input type="text" name="ssn" placeholder="${ customer.ssn}"/></div>
		<div><input type="text" name="phone" placeholder="${ customer.phone}"/></div>
		<div><input type="text" name="address" placeholder="${ customer.address}"/></div>
		<div><input type="text" name="city" placeholder="${ customer.city}"/></div>
		<div><input type="text" name="country" placeholder="${ customer.country}"/></div>
		<input type="hidden" name="customer_id" value="${ customer.customerId }"/>
		<input type="hidden" name="cmd" value="cust_update_page" />
        <input type="hidden" name="dir" value="customer" />
	    <input type="hidden" name="page" value="detail" />
</form>
	</div>
	<div class="lavels">
		<span class="label label-success" id="confirm_btn">CONFIRM</span>
		<span class="label label-danger" id="cancle_btn">CANCLE</span>
	</div>
</div>

<jsp:include page="../home/tail.jsp" />

<script>
$('#cancle-btn').click(() => {
	alert('cancel..');
});
$('#file_upload_btn').attr('style','cursor:pointer').click(() => {
	$('#form')
	.attr('method','post')
	.attr('action','${ctx}/customer.do?cmd=cust_file_upload&page=detail&&customer_id=${customer.customerId}')
	.attr('enctype','multipart/form-data')
	.submit();
});
$('#confirm-btn').click(() => {
	alert('Update..');
		$('#cust_update_form')
		.attr('action', '${ctx}/customer.do')
		.submit();
});
</script>


