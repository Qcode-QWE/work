function search(pageno,title,sorttype){
	alert(pageno+title+sorttype);
	url = "searchUI/findall.html";
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


$(function(){
	search(1,"","");
	
	
})



$(document).ready(function(){
	var searchname="";
	var pageno=1;
	var sorttype="default";
	$("#ai-topsearch").click(function(){
		searchname = $("input[name='index_none_header_sysc']").val();
		search(1,searchname,sorttype);
		pageno = 1;
		return false;
	})
	//<a href="#">2</a>
	$(".page_num").click(function(){
		pageno =$(this).text();
		search(pageno,searchname,sorttype);
	})
	
	$(".sorttype").click(function(){
		sorttype="";
		var child = $(this).children()[0];
		sorttype = child.getAttribute("title");
		pageno = 1;
		search(pageno,searchname,sorttype);
		return false;
		
	})
})