/**
 *根据商品id回显商品详情页面  @RequestMapping("/introduction/item/get")
 *
 * @returns
 */
$("document").ready(function(){
	var itemId=$("#itemId").val();  //<input id="itemId" value="${ItemId }" hidden="true"/>
	var url ="item/get.html";
	    
	$.ajax(  
			{
				type: "post",
				timeout : 5000,    //设置超时时间5秒钟
		        url: url,    
		        data: {"id":itemId},  
		        traditional: true,
		        cache: false,
		        async : true,    //async必须设置为async:true，timeout才生效；如果设置为async:false，则锁住浏览器，禁止一切操作，直到请求有返回结果。
		        dataType: "json",
		        success: function (data)
		        {
		        	if(data.status==200){
		        	//	var div = $(".ml-22");  //<a class="ml-22" title="饼干、膨化">饼干/膨化</a>
		        		var d = data.data
		        		var item = d['item'];
		        		var itemDesc = d['itemDesc'];
		        		var itemParamItem = d['itemParamItem'];
		        		//标题
		        		var title = $("#item-title");
		        		title.html("<h1>"+item['title']+"</h1>")
		        		//卖点
		        		var gold_list = $("#gold-list");
		        		gold_list.html('<p>'+item['sellPoint']+'</p>');
		        		//价格
		        		var sys_item_price = $("#sys_item_price");
		        		sys_item_price.html(item['price']/100);
		        		var sys_item_mktprice = $("#sys_item_mktprice");
		        		sys_item_mktprice.html(((item['price']/100)*1.2).toFixed(2));
		        		//库存数量
		        		var stock_num = $("#stock_num");
		        		stock_num.html(item['num']);
		        		//图片   
		        		var slides_img = $("#thumbMax");   
		        		//console.log(item['image']);
		        		slides_img.html('<a href="../images/01.jpg"><img src="../images/phone.jpg" /></a>');      
		        		
		        		//商品介绍
		        		var twlistNews = $("#twlistNews");
		        		twlistNews.html(itemDesc['itemDesc']);
		        		//商品规格
		        		var J_AttrUL = $("#J_AttrUL");
		        		J_AttrUL.html(itemParamItem);
		        		
		        		//console.log(data);
		        	}else{         
		        		//载入缓存失败图片        
		        		$("#item-title").empty().append('<img src="../images/loading.gif" style="width:30px"/>');
		        		$("#gold-list").empty().append('<img src="../images/loading.gif" style="width:30px"/>');
		        		$("#sys_item_price").empty().append('<img src="../images/loading.gif" style="width:30px"/>');
		        		$("#sys_item_mktprice").empty().append('<img src="../images/loading.gif" style="width:30px"/>');  
		        		$("#stock_num").empty().append('<img src="../images/loading.gif" style="width:30px"/>');
		        		$("#thumbMax").empty().append('<img src="../images/loading.gif" style="width:300px"/>');      
		        		$("#twlistNews").empty().append('<img src="../images/loading.gif" style="width:30px"/>');
		        		$("#J_AttrUL").empty().append('<img src="../images/loading.gif" style="width:30px"/>');
		        	}
		        },  
		        error:function (data,status) { 
	        		if(status=='timeout'){
		        		alert("请求超时");  
		        		ajaxTimeOut.abort();//取消请求
		        	//	window.location.href="index.jsp";
		        	}else{
		        		 alert("请求失败！");
		        	}
		        }
			}
		);

	/**
	 * 添加到购物车
	 */
	$("#LikBasket").click(function(){
		var url = "item/car.html";
		var itemId=$("#itemId").val();  //<input id="itemId" value="${ItemId }" hidden="true"/>
		var num = $("#text_box").val();
		var data={"id":itemId,"num":num};
		$.ajax(
			{
				type: "post",
				timeout : 5000,    //设置超时时间5秒钟
		        url: url,    
		        data: data,
		        traditional: true,
		        cache: false,
		        async : true,    //async必须设置为async:true，timeout才生效；如果设置为async:false，则锁住浏览器，禁止一切操作，直到请求有返回结果。
		        dataType: "json",
		        success: function (data)
		        {
		        	if(data.status==200){
		        		alert("添加成功！");
		        	}else{
		        		//载入缓存失败图片
//		        		var div = $(".ml-22");
//		        		div.empty();
//		        		div.append('<img src="images/loading.gif" style="width:20px"/>');
		        	}
		        },  
		        error:function (data,status) { 
	        		if(status=='timeout'){
		        		alert("请求超时");  
		        		ajaxTimeOut.abort();//取消请求
		        	//	window.location.href="index.jsp";
		        	}else{
		        		 alert("请求失败！");
		        	}
		        }
			}
		);
	})
})


