function search(pageno,title,sorttype){
	url = "/orangelala/searchUI/findall.html";
	$.ajax({  
		type:"get",
		url:url,
		data:"pageno="+pageno+"&title="+title+"&sorttype="+sorttype,
		dataType:"json",
		success:function(data){
			if(data.status==200){ 
				console.log(data);
				var html="";    
				for(var i = 0 ; i< data.data.items.length;i++){
					html += "<li><div class='i-pic limit' onclick='goIntro("+data.data.items[i].id+")'>";
					var img = "<img src='images/phone.jpg' />";
					var p1 = "<p class='title f1'>"+data.data.items[i].title+"</p>";
					var p2 = "<p class='price f1'><b>¥</b><strong>"+data.data.items[i].price/100+"</strong></p>";
					var p3 = "<p class='number f1'>销量<span>"+data.data.items[i].num+"</span></p>"
					html += img+p1+p2+p3;
					html += "</div></li>";
				}
				$("#items").html(html);
				//回显分页导航栏页数标签
				showPages(data.data.pages);
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

//进入商品详情页面
function goIntro(id){
	window.location.replace("http://localhost:8080/orangelala/introduction/to.html?id="+id);
}

//回显分页导航栏页数标签
function showPages(pages){
	var page = $(".page_num");
	//var i ;
	for( var i=0 ; i<page.length;i++){
		page.eq(i).children().text(pages[i]);
	}
	$("#totalPage").children().text(pages[5]);
	$("#nowPage").children().text(pages[6]);    
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
	$(".firstPage").click(function(){
		pageno =1;
		search(pageno,searchname,sorttype);
	})
	$(".lastPage").click(function(){
		pageno =-1;
		search(pageno,searchname,sorttype);
	})
	  
	$("#goPage").keyup(function(){
		if(event.keyCode ==13){
			pageno = $(this).val();
			search(pageno,searchname,sorttype);
		  }
		
		
	})
	
})