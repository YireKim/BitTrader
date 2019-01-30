<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="update" style="margin: 0 auto">

	<h1>Memeber update</h1>
	
	<table>
		<tr>
			<th></th>
			<th>Content</th>
		</tr>
		<tr>
			<td>ID</td>
			<td>${user.id}</td>
		</tr>
		<tr>
			<td>PASS</td>
			<td>${user.pass}</td>
		</tr>
		<tr>
			<td>NAME</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>SSN</td>
			<td>${user.ssn}</td>
		</tr>
	</table>
</div>