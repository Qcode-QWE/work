<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>付款成功页面</title>
<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css"/>
<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/basic/css/demo.css" rel="stylesheet" type="text/css" />

<link href="${pageContext.request.contextPath}/css/sustyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/basic/js/jquery-1.7.min.js"></script>

</head>

<body>


<jsp:include page="commons/header.jsp"></jsp:include>
<!--悬浮搜索框-->
<jsp:include page="commons/search.jsp"></jsp:include>

<div class="clear"></div>



<div class="take-delivery">
 <div class="status">
   <h2>您已成功付款</h2>
   <div class="successInfo">
    
     <div class="option">
        </div>
    </div>
  </div>
</div>


<!--引导页脚 -->
		<jsp:include page="commons/footer.jsp"></jsp:include>  


</body>
</html>
