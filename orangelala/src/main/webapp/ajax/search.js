function search(pageno,title,sortyype){
	url = "searchUI/findall.html";
	$.ajax({
		type:"get",
		url:url,
		data:"pageno="+pageno+"&title="+title+"&sorttype="+sorttype,
		dataType:"json",
		success:function(data){
			
		},
		error:function(){
			alert("请求失败");
		}
	})
}



$(function(){
	var pageno = 1;
	var name = "";
	var sort = "default";
	var url = ""
})



$(document).ready(function(){
	
	
})