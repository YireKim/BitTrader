<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<jsp:include page="../home/head.jsp" />

<link rel="stylesheet" href="${css}/employee/register.css" />

		<div class="grid-item" id="navi-bar">
			<c:choose>
				<c:when test="${dest eq 'login'}">
					<jsp:include page="post-navi-bar.jsp" />
				</c:when>

				<c:otherwise>
					<jsp:include page="pre-navi-bar.jsp" />
				</c:otherwise>
			</c:choose>
		</div>

		<div class="grid-item" id="memberhv">
			<jsp:include page="../home/memberhv.jsp" />
		</div>
		
<form id="content-wide">
	<div class="grid-item" id="joinform">
		<div>Employee NAME</div>
		<div>
			<input type="text" name="employeeName" id="empname" />
		</div>
		<div>Birth Day</div>
		<div>
			<input type="text" name="birthDate" id="bday" />
		</div>
		<div>PHOTO</div>
		<div>
			<input type="text" name="photo" id="note" />
		</div>
		<div>INFO</div>
		<div>
			<input type="text" name="noteInfo" id="note" />
		</div>
		<div>Manager ID</div>
		<div>
			<input type="text" name="managerId" id="mngid" />
		</div>
		<div id="joinbtn">
			<input type="submit" value="NewMember" />
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

		var empno = $('#empno').val();
		var empname = $('#empname').val();
		var mngid = $('#mngid').val();
		var bday = $('#bday').val();
		var note = $('#note').val();

		if (empno === '') {
			alert('Must insert employee no.');
		} else if (empname === '') {
			alert('Must insert employee name');
		} else if (mngid === '') {
			alert('Must insert manager id');
		} else if (bday === '') {
			alert('Must insert your birth day');
		} else {
			alert('Moving..');
			$('#joinform').attr('action', '${ctx}/employee.do').submit();
		}

	});
</script>
