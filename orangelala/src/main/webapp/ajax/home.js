$(function(){
	alert(123);
	var id = {"1":"1"};
	$.ajax({
		url : "home/itemCat/subnav.html",
		dataType : "json",
		type : "GET",
		data : id,
		success : function(data){
			alert("success"+data.status);
		},
		error : function(data) {
			alert("error",data)
		}
		
	})

})