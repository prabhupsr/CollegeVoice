<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form action="/voiceapp/login/" method="post" id="form1">
  User Name : <input type="text" name="userName"><br>
  Password : <input type="text" name="password"><br>
  <button type="submit" form="form1" value="Submit">Submit</button>
</form>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
