

$(document).ready(function(){
	
	
$("#postMsg").click(function(){	
	var msgtxt=$("#messagearea").val();
	alert(msgtxt);
	$("#messagearea").val('');
	
	
	$.get("/voiceapp/postmessage/",{ message: msgtxt},
			function(data) {	
			//alert(data);
			var obj = JSON.parse(data);
			$.each(obj, function(i, v) {
				console.log("pos"+i+"array val"+v)
			});
			if(data=='login') {
			$('input[type="text"]').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
			$('input[type="password"]').css({"border":"2px solid #00F5FF","box-shadow":"0 0 5px #00F5FF"});
			$('#userMsg').text("login failed ");
			$("#userMsg").css("color", "red" );
			$("#userMsg").css("font-size", "18px" );
			} else{
			//alert(data);

			}
			})
	


});
});