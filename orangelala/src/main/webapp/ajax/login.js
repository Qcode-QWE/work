$(document).ready(function(){

	$("#login").click(function(){
	    var url="login/login.html";
		var username = $("input[name='username']").val();
		var password = $("input[name='password']").val();
		if(username!=""&&password!=""){
			$.ajax({
				type:"get",
				url:url,
				data:"username="+username+"&password="+password,
				dataType:"json",
				success:function(data){
					if(data.status==200){
						$.session.set("user",data.data);
						$("span[name='login_msg']").html("<font color='green'>用户名与密码正确。<font/>");
						window.location.href("home.html");
					}
					else if(data.status==400){
						$("span[name='login_msg']").html("<font color='red'>用户名和密码不匹配。<font/>");
					}
				},
				error:function(){
					alert("请求失败。");
				}
			});
		}
		else{
			$("span[name='login_msg']").html("<font color='red'>用户名和密码不能为空。<font/>");
		}
	});
	
//	function login(){
//		var url="login/login.html";
//		var username = document.username.value;
//		var password = document.password.value;
//		alert(username+password);
//		if(username!=""&&password!=""){
//			$.ajax({
//				type:"get",
//				url:url,
//				data:"username="+username+"&password="+password,
//				type="",
//				success:function(){
//					
//				},
//				error:function(){
//					
//				}
//			});
//		}
//		else{
//			
//		}
//	}
	
})

	
