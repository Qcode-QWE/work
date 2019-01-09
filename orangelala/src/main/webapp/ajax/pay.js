$(function() {
	$("#J_Go").click(function(){
		var orderId = $("#orderId").val();
		var msg = $("#msg").val();
		//alert(orderId);
		//alert(msg);
		var ids = [536563];
		ids = JSON.stringify(ids);
		var nums = [1];
		nums = JSON.stringify(nums);
		//window.location.replace("http://localhost:8080/orangelala/payItem.html?orderId="+orderId+"&msg="+msg);
		window.location.replace("http://localhost:8080/orangelala/carToPay.html?ids="+ids+"&nums="+nums);
	});

})