<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="${pageContext.request.contextPath}/css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/ajax/register.js"></script>
	</head>

<body>

<div class="login-boxtitle">
	<a href="home/demo.html"><img alt="" src="${pageContext.request.contextPath}/images/logobig.png" /></a>
</div>

<div class="res-banner">
	<div class="res-main">
		<div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath}/images/big.jpg" /></div>
		<div class="login-box">
			<div class="am-tabs">
				<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
					<li class="am-active"><a href="">邮箱注册</a></li>
				</ul>
				<span name="register_username_msg" ></span><br>
				<span name="register_password_msg" ></span><br>
				<div class="am-tabs-bd">
					<div class="am-tab-panel am-active">
						<form method="post">
							<div class="user-name">
							    <label for="user"><i class="am-icon-user"></i></label>
							    <input type="text" name="username" id="username" placeholder="请输入用户名">
				       		</div>
							<div class="user-email">
								<label for="email"><i class="am-icon-envelope-o"></i></label>
								<input type="email" name="useremail" id="email" placeholder="请输入邮箱账号">
              				</div>										
				             <div class="user-pass">
							    <label for="password"><i class="am-icon-lock"></i></label>
							    <input type="password" name="password1" id="password1" placeholder="设置密码">
				             </div>										
				             <div class="user-pass">
							    <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
							    <input type="password" name="password2" id="password2" placeholder="确认密码">
				             </div>	
              			</form>
						<div class="login-links">
							<label for="reader-me">
								<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
							</label>
				  		</div>
						<div class="am-cf">
							<input type="submit" id="register" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
			
	<!--引导页脚 -->
		<jsp:include page="commons/footer.jsp"></jsp:include>  
</body>

</html>