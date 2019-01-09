<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navCir">
	<li class="active"><a href="home2.html"><i class="am-icon-home "></i>首页</a></li>
	<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
	<li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
	<li><a href="person/index.html"><i class="am-icon-user"></i>我的</a></li>					
</div>    
<div class=tip>
	<div id="sidebar">
		<div id="wrap">
			<div id="prof" class="item ">
				<a href="# ">
					<span class="setting "></span>
				</a>
				<div class="ibar_login_box status_login ">
					<div class="avatar_box ">
						<p class="avatar_imgbox "><img src="${pageContext.request.contextPath}/images/no-img_mid_.jpg " /></p>
						<ul class="user_info ">
							<c:if test="${user!=null}">
								<li>用户名：${user.username}</li>
								<li>级&nbsp;别：普通会员</li>
							</c:if>
							<c:if test="${user==null}">
								<li>用户名：???</li>
								<li>级&nbsp;别：普通会员</li>
							</c:if>
						</ul>
					</div>
					<div class="login_btnbox ">
						<a href="# " class="login_order ">我的订单</a>
						<a href="# " class="login_favorite ">我的收藏</a>
					</div>
					<i class="icon_arrow_white "></i>
				</div>

			</div>
			<div id="shopCart " class="item ">
				<a href="# ">
					<span class="message "></span>
				</a>
				<p>
					购物车
				</p>
				<p class="cart_num ">0</p>
			</div>
			<div id="asset " class="item ">
				<a href="# ">
					<span class="view "></span>
				</a>
				<div class="mp_tooltip ">
					我的资产
					<i class="icon_arrow_right_black "></i>
				</div>
			</div>

			<div id="foot " class="item ">
				<a href="# ">
					<span class="zuji "></span>
				</a>
				<div class="mp_tooltip ">
					我的足迹
					<i class="icon_arrow_right_black "></i>
				</div>
			</div>

			<div id="brand " class="item ">
				<a href="#">
					<span class="wdsc "><img src="${pageContext.request.contextPath}/images/wdsc.png " /></span>
				</a>
				<div class="mp_tooltip ">
					我的收藏
					<i class="icon_arrow_right_black "></i>
				</div>
			</div>

			<div id="broadcast " class="item ">
				<a href="# ">
					<span class="chongzhi "><img src="${pageContext.request.contextPath}/images/chongzhi.png " /></span>
				</a>
				<div class="mp_tooltip ">
					我要充值
					<i class="icon_arrow_right_black "></i>
				</div>
			</div>

			<div class="quick_toggle ">
				<li class="qtitem ">
					<a href="# "><span class="kfzx "></span></a>
					<div class="mp_tooltip ">客服中心<i class="icon_arrow_right_black "></i></div>
				</li>
				<!--二维码 -->
				<li class="qtitem ">
					<a href="#none "><span class="mpbtn_qrcode "></span></a>
					<div class="mp_qrcode " style="display:none; "><img src="${pageContext.request.contextPath}/images/weixin_code_145.png " /><i class="icon_arrow_white "></i></div>
				</li>
				<li class="qtitem">
					<a href="#top " class="return_top "><span class="top "></span></a>
				</li>
			</div>
			<!--回到顶部 -->
			<div id="quick_links_pop " class="quick_links_pop hide "></div>

		</div>

	</div>
	<div id="prof-content " class="nav-content ">
		<div class="nav-con-close ">
			<i class="am-icon-angle-right am-icon-fw "></i>
		</div>
		<div>
			我
		</div>
	</div>
	<div id="shopCart-content " class="nav-content ">
		<div class="nav-con-close ">
			<i class="am-icon-angle-right am-icon-fw "></i>
		</div>
		<div>
			购物车
		</div>
	</div>
	<div id="asset-content " class="nav-content ">
		<div class="nav-con-close ">
			<i class="am-icon-angle-right am-icon-fw "></i>
		</div>
		<div>
			资产
		</div>

		<div class="ia-head-list ">
			<a href="# " target="_blank " class="pl ">
				<div class="num ">0</div>
				<div class="text ">优惠券</div>
			</a>
			<a href="# " target="_blank " class="pl ">
				<div class="num ">0</div>
				<div class="text ">红包</div>
			</a>
			<a href="# " target="_blank " class="pl money ">
				<div class="num ">￥0</div>
				<div class="text ">余额</div>
			</a>
		</div>

	</div>
	<div id="foot-content " class="nav-content ">
		<div class="nav-con-close ">
			<i class="am-icon-angle-right am-icon-fw "></i>
		</div>
		<div>
			足迹
		</div>
	</div>
	<div id="brand-content " class="nav-content ">
		<div class="nav-con-close ">
			<i class="am-icon-angle-right am-icon-fw "></i>
		</div>
		<div>
			收藏
		</div>
	</div>
	<div id="broadcast-content " class="nav-content ">
		<div class="nav-con-close ">
			<i class="am-icon-angle-right am-icon-fw "></i>
		</div>
		<div>
			充值
		</div>
	</div>
</div>