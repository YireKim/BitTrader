<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
			<form id="login-form">
				<table style="width: 100%">
					<tr>
						<th><input id="uid" name="uid"
							style="width: 100%; height: 40px;" /></th>
						<th rowspan="2">
						<button id="login-btn">LOGIN</button> <br />
						</th>
					</tr>

					<tr>
						<th><input id="upw" name="upw" type="password"
							style="width: 100%; height: 40px;" /></th>
					</tr>
				</table>
			</form>

		<a href="admin.do">Admin</a> | <a id="join-link" href="member.do?dest=join-form">Sign up</a>
		<h1
			style="margin: 0 auto; width: 50%; background-color: MediumSeaGreen;">
			INDEX LOGIN</h1>


</body>
</html>