<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        <li><a href="#">ABOUT</a></li>
        <li><a href="#">EMPLOYEE</a></li>
        <li><a href="#">CUSTOMER</a></li>
        <li><a href="#">ORDER</a></li>
        <li><a href="#">ETC</a></li>
        <li><a href="#">ADMIN</a></li>
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
        <li><img src="https://cdns.iconmonstr.com/wp-content/assets/preview/2019/96/iconmonstr-cat-3.png" width="45px" height="45px"></li>
        <li class="dropdown navbar-right">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">M_INFO <span class="caret"></span></a>
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
	$('#navbar-brand-link').click(() => {
	    location.assign('home.do?cmd=move&page=main');
	});
	</script>
