<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" id="navbar-brand-link" href="#">
      <img src="https://i.imgur.com/PtjF1TT.png" alt="suports_logo" width="30px" height="30px" />
      </a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
      <ul class="nav navbar-nav">
        <li><a href="#" id="home_glym"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
        <li><a href="#" id="user_glym"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
        <li><a href="#" id="apple_gylm"><span class="glyphicon glyphicon-apple" aria-hidden="true"></span></a></li>
        <li><a href="#" id="briefcase_glym"><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span></a></li>
        <li><a href="#" id="th_glym"><span class="glyphicon glyphicon-th" aria-hidden="true"></span></a></li>
        <li><a href="#" id="ok_glym"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></a></li>
        <li><a href="#"></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
        <!-- ALL WRONG!!! NEED TO EDIT ASAP -->
        <c:choose>
  	   		<c:when test="${ customer.customerId != null }">
  	  			<img id="profile_img" src="${imgpath}${image.imgName}.${image.imgExtention}" width="45px" height="45px">
  	 	 	</c:when>
  	 	 	<c:when test="${ employee.employeeId != null }">
  	 	 		<img id="profile_img" src="${imgpath}${image.imgName}.${image.imgExtention}" width="45px" height="45px">
  	 	 	</c:when>
  	 	 	<c:otherwise>
  	 	 		<img src="${imgpath}default_photo.gif" width="45px" height="45px"> 
  	 	 	</c:otherwise>
     	</c:choose>
     	</li>
        <li class="dropdown navbar-right">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
			<c:choose>
  	   		<c:when test="${ customer.customerId != null }">
  	  			${ customer.contactName } 
  	 	 	</c:when>
  	 	 	<c:when test="${ employee.employeeId != null }">
  	  			${ employee.employeeId } 
  	 	 	</c:when>
  	 	 	<c:otherwise>
  	 	 		M_INFO
  	 	 	</c:otherwise>
     		</c:choose>
		<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Mail</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#" style='color:red'>Logout</a></li>
          </ul>
        </li>
      </ul>
       <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">S</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<script>
	$('#navbar-brand-link').click(function() {
	    location.assign('${ctx}/home.do');
	});
	$('#profile_img').click(function() {
	    location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=detail&customer_id=${customer.customerId}');
	});
	$('#home_glym').click(function() {
	    location.assign('${ctx}/home.do');
	});
	$('#apple_gylm').click(function() {
	    location.assign('${ctx}/product.do?cmd=prod_list&page=main');
	});
	</script>
