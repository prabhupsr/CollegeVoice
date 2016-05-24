
$(document).ready(
		function() {
			// alert($('#reloadID').val());
			// alert($('#reloadID').val() == "true");

			if ($('#reloadID').val() == "true") {
				$('#userMsg').text("login failed ");
				$("#userMsg").css("color", "red");
				$("#userMsg").css("font-size", "18px");
			}

			$("#login").click(
					function() {
						var userName = $("#userName").val();
						var password = $("#password").val();
						// Checking for blank fields.
						if (userName == '' || password == '') {
							$('input[type="text"],input[type="password"]').css(
									"border", "2px solid red");
							$('input[type="text"],input[type="password"]').css(
									"box-shadow", "0 0 3px red");
							alert("Please fill all fields...!!!!!!");
						} else {
							/*
							 * $.get("/voiceapp/login/",{ userName: userName,
							 * password:password}, function(data) {
							 * if(data=='login') {
							 * $('input[type="text"]').css({"border":"2px solid
							 * red","box-shadow":"0 0 3px red"});
							 * $('input[type="password"]').css({"border":"2px
							 * solid #00F5FF","box-shadow":"0 0 5px #00F5FF"});
							 * $('#userMsg').text("login failed ");
							 * $("#userMsg").css("color", "red" );
							 * $("#userMsg").css("font-size", "18px" ); } else{
							 * alert(data);
							 *  } });
							 */
						}
					});
		});