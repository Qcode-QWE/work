<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/ajax/search.js"></script>
<script type="text/javascript">
	$("#search_form").submit(function(){
		alert(123);
		var title = $("#searchInput").val();
		
	})

</script>

<div class="nav white">
	<div class="logo"><img src="${pageContext.request.contextPath}/images/logo.png" /></div>
	<div class="logoBig">
		<li><img src="${pageContext.request.contextPath}/images/logobig.png" /></li>
	</div>

	<div class="search-bar pr">
		<a name="index_none_header_sysc" href="#"></a>
		<form id="search_form">
			<input id="searchInput" name="title" type="text" placeholder="搜索" autocomplete="off">
			<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
		</form>
	</div>
</div>