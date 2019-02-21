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

	<form id="form">
		<c:choose>
		<c:when test="${ product.photo == 'default_product.jpg'}">
			<img src="${imgpath}default_product.jpg">	
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
		<div>SUPP ID</div>
		<div>CAT IP</div>
		<div>UNIT</div>
		<div>PRICE</div>
		<div>PHOTO</div>
	</div>
	<div class="profile_info">
<form id="prod_update_form">
		${ product.productId } <br />
		${ product.productName } <br />
		${ product.supplierId } <br />
		${ product.categoryId } <br />
		<div><input type="text" name="unit" placeholder="${ product.unit }"/></div>		
		<div><input type="text" name="price" placeholder="${ product.price }"/></div>
		${ product.photo } <br />
		<input type="hidden" name="product_id" value="${ product.productId }"/>
		<input type="hidden" name="cmd" value="prod_update_page" />
        <input type="hidden" name="dir" value="product" />
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
$('#cancle-btn').click(function() {
	alert('cancel..');
});
$('#file_upload_btn').attr('style','cursor:pointer').click(function(){
	$('#form')
	.attr('method','post')
	.attr('action','${ctx}/product.do?cmd=prod_file_upload&page=detail&product_id=${ product.productId}')
	.attr('enctype','multipart/form-data')
	.submit();
});
$('#confirm_btn').click(function() {
	alert('Update..');
		$('#prod_update_form')
		.attr('action', '${ctx}/product.do')
		.submit();
});
</script>


