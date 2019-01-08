$(document).ready(function(){
	
	$("#username").blur(function(){
		var username = $("input[name='username']").val();
		//alert(username);
		url = "registerUI/checkUsername.html";
		if(username==""){
			$("span[name='register_username_msg']").html("<font color='red'>用户名不能为空<font/>");
		}
		else{
			$.ajax({
				type:"get",
				url:url,
				data:"username="+username,
				dataType:"json",
				success:function(data){
					if(data.data==0){
						$("span[name='register_username_msg']").html("<font color='green'>用户名可用<font/>");
					}
					else if(data.data==1){
						$("span[name='register_username_msg']").html("<font color='red'>用户名已存在<font/>");
					}
				},
				error:function(){
					alert("请求失败。");
				}
			})
		}
	})
	
	$("#password1").blur(function(){
		var password1 = $("input[name='password1']").val();
		if(password1==""){
			$("span[name='register_password_msg']").html("<font color='red'>密码不能为空<font/>");
		}
		else{
			$("span[name='register_password_msg']").html("");
		}
	})
	
	$("#password2").blur(function(){
		var password1 = $("input[name='password1']").val();
		var password2 = $("input[name='password2']").val();
		if(password1!=""&&password1==password2){
			$("span[name='register_password_msg']").html("<font color='green'>密码可用。<font/>");
		}
		else{
			$("span[name='register_password_msg']").html("<font color='red'>密码不一致!<font/>");
		}
	})
	
	$("#register").click(function(){
		var username = $("input[name='username']").val();
		var password1 = $("input[name='password1']").val();
		var password2 = $("input[name='password2']").val();
		var email = $("input[name='useremail']").val();
		var url = "registerUI/addUser.html";
		if(password1==password2){
			$.ajax({
				url:url,
				type:"get",
				data:"username="+username+"&email="+email+"&password="+password1,
				dataType:"json",
				success:function(data){
					if(data.status==200){
						if(data.data==1){
							alert("注册成功！去登录吧。");
							window.location.href="http://localhost:8080/orangelala/loginUI.html";
						}
						else{
							alert("出现未知错误！")
						}
					}
					else if(data.status==400){
						alert("信息不正确，请再次确认！");
					}
				},
				error:function(){
					alert("请求失败！");
				}
			})
		}
	})
	
	
	
})