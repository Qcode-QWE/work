function search(pageno,title,sorttype){
//	alert(pageno+title+sorttype);
	url = "/orangelala/searchUI/findall.html";  
	$.ajax({
		type:"get",
		url:url,
		data:"pageno="+pageno+"&title="+title+"&sorttype="+sorttype,
		dataType:"json",
		success:function(data){
			if(data.status==200){
				var html="";
				for(var i = 0 ; i< data.data.length;i++){
					html += "<li><div class='i-pic limit'>";
					var img = "<img src='images/imgsearch1.jpg' />";
					var p1 = "<p class='title f1'>"+data.data[i].title+"</p>";
					var p2 = "<p class='price f1'><b>¥</b><strong>"+data.data[i].price+"</strong></p>";
					var p3 = "<p class='number f1'>销量<span>"+data.data[i].num+"</span></p>"
					html += img+p1+p2+p3;
					html += "</div></li>";
				}
				$("#items").html(html);
			}
			else if(data.status==400){
				alert("400错误！抛出异常了");
			}
		},
		error:function(){
			alert("请求失败");
		}
	})
}

/**
 * 主页搜索点击事件重定向搜索页面
 * @returns
 */
$(document).ready(function(){
	var title = "";
	var pageno = 1;
	var sorttype = "default";
	$("#ai-topsearch").click(function(){
		title = $("#searchInput").val();
		window.location.replace("http://localhost:8080/orangelala/searchUI.html?title="+title);
		return false;
	})
})

