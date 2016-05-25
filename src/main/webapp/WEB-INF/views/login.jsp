<!DOCTYPE html>
<html>
<head>
<title>login</title>
<meta name="robots" content="noindex, nofollow">
<!-- Include CSS File Here -->
<link rel="stylesheet" href="/voiceapp/resources/css/stylz.css" />
<!-- Include CSS File Here -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="/voiceapp/resources/js/login.js"></script>
</head>

<!-- action="/voiceapp/login/" -->
<body onload="">
	<div class="container">
		<div class="main">
			<form class="form" method="get" action="/voiceapp/login/">
				<h2>College Voice Login</h2>
				<label>UserName :</label> <input type="text" name="userName"
					id="userName"> <label>Password :</label> <input
					type="password" name="password" id="password">
				<div id="userMsg"></div>
				<input type="submit" name="login" id="login" value="Login">
			</form>
			<input type="hidden" id="reloadID" value="${reloadID}">


		</div>
	</div>
</body>
</html>