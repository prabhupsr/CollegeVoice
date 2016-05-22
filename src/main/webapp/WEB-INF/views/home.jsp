<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="/voiceapp/resources/css/stylz.css" />
<!-- Include CSS File Here -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="/voiceapp/resources/js/studenthomepage.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- <form action="/voiceapp/login/" method="post" id="form1">
  User Name : <input type="text" name="userName"><br>
  Password : <input type="text" name="password"><br>
  <button type="submit" form="form1" value="Submit">Submit</button>
</form> -->

<div class="form-group">
  <label for="messagearea">Messages:</label>
  <textarea class="form-control" rows="5" id="messagearea"></textarea>
</div>
<button class="table-title" id="postMsg">PostMessage</button>
	  <div id="msgLstDiv"></div>
<table>
<tr>
<td>name</td>
<td>age</td>
</tr>
<tr>
<td>pr</td>
<td>prr</td>
</tr>
<tr>
<td>as</td>
<td>123</td>
</tr>
</table>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
