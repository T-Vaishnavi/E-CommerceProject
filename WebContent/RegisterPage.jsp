<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="honeydew">
	<center>
		<form action="Registration">
			<h1>RegistrationForm</h1>
			<table>
				<tr>
					<td>username:</td>
					<td><input type="text" Name="txtfirst" method="post" required
						autofocus placeholder="enter your name"></td>
				</tr>
				
				<tr>
					<td>email</td>
					<td><input type="email" name="txtemail"></td>
				</tr>
				<tr>
					<td>Phno</td>
					<td><input type="text" Name="txtphoneno" method="post"
						required autofocus placeholder="enter your phone no">(max
						10 digits)</td>
				</tr>
				
				<tr>
					<td>password</td>
					<td><input type="password" name="txtpass" required></td>
				</tr>
			
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"> <input
						type="reset" value="cancel"></td>
				</tr>
			</table>
	</center>
	</form>
</body>
</html>