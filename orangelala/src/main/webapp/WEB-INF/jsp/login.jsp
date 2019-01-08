<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>登录</title>
	<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" />
	<link href="${pageContext.request.contextPath}/css/dlstyle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/ajax/login.js"></script>
	
	</head>
<body>

<div class="login-boxtitle">
	<a href="${pageContext.request.contextPath}/home.html"><img alt="logo" src="${pageContext.request.contextPath}/images/logobig.png" /></a>
</div>
<div class="login-banner">
	<div class="login-main">
		<div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath}/images/big.jpg" /></div>
		<div class="login-box">
		<br>
		<h3 class="title">登录商城</h3>
		<span name="login_msg"></span>
		<div class="clear"></div>
				
		<div class="login-form">
			<form onsubmit="return login()">
				<div class="user-name">
				    <label for="user"><i class="am-icon-user"></i></label>
				    <input type="text" name="username" id="user" placeholder="请输入用户名">
          		</div>
            	<div class="user-pass">
				    <label for="password"><i class="am-icon-lock"></i></label>
				    <input type="password" name="password" id="password" placeholder="请输入密码">
       			</div>	
			</form>
        </div>
          
          	<div class="login-links">
             	<label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
				<a href="#" class="am-fr">忘记密码</a>
				<br>
				
				<a href="${pageContext.request.contextPath}/registerUI.html" class="zcnext am-fr am-btn-default">注册</a>
				
         	</div>
			<div class="am-cf">
				<input id="login" type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm" >
			</div>
		</div>
	</div>
</div>


<div class="footer ">
	<div class="footer-hd ">
		<p>
			<a href="# ">菜狗集团</a>
			<b>|</b>
			<a href="${pageContext.request.contextPath}/home.html">商城首页</a>
			<b>|</b>
			<a href="# ">支付宝</a>
			<b>|</b>
			<a href="# ">物流</a>
		</p>
	</div>
	<div class="footer-bd ">
		<p>
			<a href="# ">关于悦桔</a>
			<a href="# ">合作伙伴</a>
			<a href="# ">联系我们</a>
			<a href="# ">网站地图</a>
			<em>© 2015-2025 Orangelala.com 版权所有. 更多咨询 <a href="#" target="_blank" title="悦桔拉拉"></a> - Bulid By <a href="#" title="Orangelala" target="_blank">Orangelala</a></em>
		</p>
	</div>
</div>
</body>

</html>