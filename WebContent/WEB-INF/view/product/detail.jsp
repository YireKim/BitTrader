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
	<c:choose>
		<c:when test="${ product.photo == 'default_product.jpg'}">
			<img src="${imgpath}default_product.jpg">	
		</c:when>
		<c:otherwise>
			<img src="${imgpath}${image.imgName}.${image.imgExtention}" style="width: 100%">
		</c:otherwise>
	</c:choose>
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
		${ product.productId} <br />
		${ product.productName} <br />
		${ product.supplierId} <br />
		${ product.categoryId} <br />
		${ product.unit} EA<br />
		${ product.price} $<br />
		${ product.photo} <br />
		</div>
		<div class="lavels">
		<form id="prod_update_form">
			<span class="label label-warning" id="prod_update_btn">UPDATE</span>
			<input type="hidden" name="product_id" value="${ product.productId}"/>
			<input type="hidden" name="cmd" value="prod_retrieve" />
			<input type="hidden" name="page" value="update" />
		</form>
		<form id="prod_delete_form">
			<span class="label label-danger" id="prod_delete_btn">DELETE</span>
			<input type="hidden" name="product_id" value="${ product.productId}"/>
			<input type="hidden" name="cmd" value="prod_delete" />
		</form>
		</div>
</div>
<jsp:include page="../home/tail.jsp" />

<script>
$('#prod_update_btn').click(function() {
	$('#prod_update_form')
	.attr('action', '${ctx}/product.do')
	.submit();
});
$('#cust_delete_btn').click(function() {
	alert('Delete product item..');
	$('#prod_delete_form')
	.attr('action', '${ctx}/product.do')
	.submit();
});
</script>

