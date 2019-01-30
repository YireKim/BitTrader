<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="join-form">
	<h1 style="background-color: MediumSeaGreen;">META SIGN UP</h1>

	<form action="member.do">
		I D : <br />
		<input type="text" name="id" /> <br /> PASS : <br />
		<input type="text" name="pass" /> <br /> NAME : <br />
		<input type="text" name="name" /> <br /> SSN : <br />
		<input type="text" name="ssn" /> <br /> HEIGHT : <br />
		<input type="text" name="height" /><br /> WEIGHT : <br />
		<input type="text" name="weight" /><br /> 
		<input type="hidden" name="cmd" value="join-member" /> 
        <input type="hidden" name="dir" value="home" /> 
        <input type="hidden" name="dest" value="login-success" /> 
        <input type="submit" id="btn" value="Check" />
	</form>
</div>
