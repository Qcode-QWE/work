function search(pageno,title,sorttype){
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
					html += "<li><div class='i-pic limit' onclick='goIntro("+data.data[i].id+")'>";
					var img = "<img src='images/phone.jpg' />";
					var p1 = "<p class='title f1'>"+data.data[i].title+"</p>";
					var p2 = "<p class='price f1'><b>¥</b><strong>"+data.data[i].price/100+"</strong></p>";
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
  
function goIntro(id){
	window.location.replace("http://localhost:8080/orangelala/introduction/to.html?id="+id);
}
$(document).ready(function(){
	//载入缓存后执行第一次搜索
	var title = $("#searchInput").val();
	search(1,title,"default");    
	
	var searchname=title;
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