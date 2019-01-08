
/**
 * 从home页面跳转到商品详情页面
 * @returns
 */
$("document").ready(function(){
	$("a").click(function(){
		$(this).attr("href","introduction/to.html?id=536563");
	})
})