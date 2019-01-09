$(function() {
	$("#J_Go").click(function(){
		var orderId = $("#orderId").val();
		var msg = $("#msg").val();
		alert(orderId);
		alert(msg);
		window.location.replace("http://localhost:8080/orangelala/pay/payItem.html?orderId="+orderId+"&msg="+msg);
	});

})