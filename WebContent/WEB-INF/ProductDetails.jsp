<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductDetails</title>

<style>
fieldset {
	width: 200px;
	height: 180px;
	border-color: red;
	color: blue;
}
</style>

<script type="text/javascript">
function clockTime()
{
var todayDate=new Date();	
var hrs=todayDate.getHours();
var mns=todayDate.getMinutes()+1;
var scs=todayDate.getSeconds();
mns=check(mns);
scs=check(scs);
document.getElementById('displayTime').innerHTML=hrs+":"+mns+":"+scs;
t=setTimeout('clockTime()',1000);
}
function clockTime1()
{
	var today=new Date();
	var month=today.getMonth()+1;
	var year=today.getFullYear();
	var day=today.getDate();
	month=check(month);
	day=check(day);
	document.getElementById('displayTime1').innerHTML=day+":"+month+":"+year;
	t=setTimeout('clockTime1()',1000);
}
function check(t)
{
if(t<10)
{
t="0"+t;
}
return t;
}

</script>
</head>	
<body onload="clockTime();clockTime1()">
<div id="displayTime" style="float:left"></div>
<div id="displayTime1" style="float:right"></div>

</head>

<body>

<center><img src="images/d1.png" height="100" width="300">&copy;<u>delloite.com</u></center>

<hr>



</head>
<body bgcolor="blue.jfif">
<center>
<fieldset>

<legend>Enter the Details</legend>

<form>
<table>

<tr>
<td>ProductId:</td><td><input type="text" name="txtid"></td>
</tr>

<tr>
<td>ProductName:</td><td><input type="text" name="txtname"></td>
</tr>

<tr>
<td>Quantity:</td><td><input type="text" name="txtquan"></td>
</tr>

<tr>
<td>Description:</td><td><input type="text" name="txtdes"></td>
</tr>

<tr>
<td>Price:</td><td><input type="text" name="txtpri"></td>
</tr>
</table>

<br>
<input type="submit" value="submit">
&nbsp;&nbsp;
<input type="submit" value="cancel">



</form>
</center>
</fieldset>
</body>
</html>