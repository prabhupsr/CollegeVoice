$(document)
		.ready(
				function() {
					var userid = $('#loginuserid').val();
					alert(userid);
					var getmessagesurl = "/voiceapp/getmessages/";
					var postmessagesurl = "/voiceapp/postmessage/";

					loadmessages(getmessagesurl, "");

					$(document.body).on('click', 'button', function() {
						alert('button ' + this.id + ' clicked');
						if (this.id.indexOf('likemsgid') >= 0) {
							// Found world
							$.get("/voiceapp/updatelike/", {
								messageID : this.id.substring(9)
							}, function(data) {
							})

							$("#" + this.id).attr('disabled', 'disabled');
						}

					});

					$("#postMsg").click(function() {
						var msgtxt = $("#messagearea").val();
						$("#messagearea").val('');
						loadmessages(postmessagesurl, msgtxt);

					});

					function loadmessages(url, msgtxt) {

						$
								.get(
										url,
										{
											message : msgtxt
										},
										function(data) {
											// alert(data);
											var tablestyle = "<table class='table-fill'><tr><td>msg</td><td>createdDate</td><td>Lke</td></tr>";

											var obj = JSON.parse(data);
											$
													.each(
															obj,
															function(i, v) {
																console
																		.log("pos"
																				+ i
																				+ "array val"
																				+ v)
																tablestyle = tablestyle
																		+ "<tr><td>"
																		+ v.message
																		+ "</td><td>"
																		+ v.createdDate;
																if (v.messageUserId == userid
																		|| v.likedUserId == userid) {
																	tablestyle = tablestyle
																			+ "</td><td><button id="
																			+ "likemsgid"
																			+ v.messageId
																			+ " disabled>Like</button></td></tr>";
																} else {
																	tablestyle = tablestyle
																			+ "</td><td><button id="
																			+ "likemsgid"
																			+ v.messageId
																			+ ">Like</button></td></tr>";
																}

															});
											tablestyle = tablestyle
													+ "</table>";
											console.log(tablestyle);
											$('#msgLstDiv').html(tablestyle);

											if (data == 'login') {
												$('input[type="text"]')
														.css(
																{
																	"border" : "2px solid red",
																	"box-shadow" : "0 0 3px red"
																});
												$('input[type="password"]')
														.css(
																{
																	"border" : "2px solid #00F5FF",
																	"box-shadow" : "0 0 5px #00F5FF"
																});
												$('#userMsg').text(
														"login failed ");
												$("#userMsg").css("color",
														"red");
												$("#userMsg").css("font-size",
														"18px");
											} else {
												// alert(data);

											}
										})

					}

				});
