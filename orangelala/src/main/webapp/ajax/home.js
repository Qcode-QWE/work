$(function(){
	var url = "home/itemCat/subnav.html";
		
		var a=[2,74,161,249,291,296,378,438,495,558,580,633,699,749,865,903];
		//设置数组模式
		$.ajax(
			{
				type: "get",
		        url: url,
		        data: {"id":a},
		        traditional: true,
		        cache: false,
		        async : false,
		        dataType: "json",
		        success: function (data)
		        {
		        	console.log(data.data[0]);
		        	if(data.status==200){
		        		var One = $(".ml-22");  //<a class="ml-22" title="饼干、膨化">饼干/膨化</a>
		        		for(var i = 0;i<One.length;i++){
		        			One.eq(i).attr("title",data.data[i]["name"]);
		        			One.eq(i).text(data.data[i]["name"]);
		        		//	findTwoByOne(data.data[i]["id"]);
		        		}
		        	}
		        },
		        error:function () {      
		            alert("请求失败！");
		        }
			}
		);
})


//function findTwoByOne(id){
//	var url = "home/itemCat/subnavTwo.html";
//	//设置数组模式
//	$.ajax(
//		{
//			type: "get",
//	        url: url,
//	        data: {"id":id},
//	        traditional: true,
//	        cache: false,
//	        async : false,
//	        dataType: "json",
//	        success: function (data)
//	        {
//	        	
//	        },
//	        error:function () {      
//	            alert("请求失败！");
//	        }
//		}
//	);
//}


