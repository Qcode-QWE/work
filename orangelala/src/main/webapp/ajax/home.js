$(function(){
	alert(123);
	var id = {"1":"1"};
	$.ajax({
		url : "ajax.html",
		dataType : "json",
		type : "GET",
		data : id,
		success : function(data){
			alert("success"+data["1"]);
		},
		error : function(data) {
			alert("error",data)
		}
		
	})

})