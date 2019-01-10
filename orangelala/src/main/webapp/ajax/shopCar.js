/**
 *显示购物车页面  @RequestMapping("/showCar")
 *
 * @returns
 */
$("document").ready(function(){
	$(function(){
		var url = "/orangelala/showCar.html";   
		$.ajax(
			{
				type: "post",
				timeout : 5000,    //设置超时时间5秒钟
		        url: url,    
		        traditional: true,
		        cache: false,
		        async : true,    //async必须设置为async:true，timeout才生效；如果设置为async:false，则锁住浏览器，禁止一切操作，直到请求有返回结果。
		        dataType: "json",
		        success: function (data)
		        {
		        	if(data.status==200){
		        		console.log(data);      
		        		var shopCar=$("#cartTable").empty();   
		        		shopCar.append('<div class="cart-table-th">' +
		        				'<div class="wp">'+
		        				'<div class="th th-chk">'+
		        					'<div id="J_SelectAll1" class="select-all J_SelectAll">'+
		        					'</div>'+
		        				'</div>'+
		        				'<div class="th th-item">'+
		        					'<div class="td-inner">商品信息</div>'+
		        				'</div>'+
		        				'<div class="th th-price">'+
		        					'<div class="td-inner">单价</div>'+
		        				'</div>'+
		        				'<div class="th th-amount">'+
		        					'<div class="td-inner">数量</div>'+
		        				'</div>'+
		        				'<div class="th th-sum">'+
		        					'<div class="td-inner">金额</div>'+
		        				'</div>'+
		        				'<div class="th th-op">'+
		        					'<div class="td-inner">操作</div>'+
		        				'</div>'+  
		        			'</div>'+
		        		'</div>'      
		        		);          
		        		for(var i=0;i<data.data.catItems.length;i++){  
		        			shopCar.append('<div class="clear"></div>'+
		        		'<tr class="item-list">'+
		        		'<input class="itemId" hidden="true" value="'+data.data.catItems[i].id +'"/>'+
						'<div class="bundle  bundle-last ">'+
							'<div class="bundle-hd">'+
								'<div class="bd-promos">'+
									'<div class="bd-has-promo">已享优惠:<span class="bd-has-promo-content">省￥'+data.data.items[i].price/1000*0.1+'</span>&nbsp;&nbsp;</div>'+
									'<div class="act-promo">'+
										'<a href="#" target="_blank">'+data.data.items[i].sellPoint+'<span class="gt">&gt;&gt;</span></a>'+  
									'</div>'+
									'<span class="list-change theme-login">编辑</span>'+
								'</div>'+
							'</div>'+
							'<div class="clear"></div>'+
							'<div class="bundle-main">'+
								'<ul class="item-content clearfix">'+
									'<li class="td td-chk">'+
										'<div class="cart-checkbox ">'+
											'<input class="check" checked="checked" id="J_CheckBox_170769542747" name="items" value="170769542747" type="checkbox">'+
											'<label for="J_CheckBox_170769542747"></label>'+
										'</div>'+
									'</li>'+
									'<li class="td td-item">'+
										'<div class="item-pic">'+
											'<a href="#" target="_blank" data-title="'+data.data.items[i].title+'" class="J_MakePoint" data-point="tbcart.8.12">'+
												'<img src="" class="itempic J_ItemImg"></a>'+
										'</div>'+
										'<div class="item-info">'+
											'<div class="item-basic-info">'+
												'<a href="#" target="_blank" title="'+data.data.items[i].title+'" class="item-title J_MakePoint" data-point="tbcart.8.11">'+data.data.items[i].title+'</a>'+
											'</div>'+
										'</div>'+
									'</li>'+
									'<li class="td td-info">'+
										'<div class="item-props item-props-can">'+
											'<span class="sku-line">颜色：10#蜜橘色</span>'+
											'<span class="sku-line">包装：两支手袋装（送彩带）</span>'+
											'<span tabindex="0" class="btn-edit-sku theme-login">修改</span>'+
											'<i class="theme-login am-icon-sort-desc"></i>'+
										'</div>'+
									'</li>'+
									'<li class="td td-price">'+
										'<div class="item-price price-promo-promo">'+
											'<div class="price-content">'+
												'<div class="price-line">'+
													'<em class="price-original">'+data.data.items[i].price/1000+'</em>'+
												'</div>'+
												'<div class="price-line">'+
													'<em class="J_Price price-now" tabindex="0">'+data.data.items[i].price/1000*0.9+'</em>'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</li>  '+
									'<li class="td td-amount">'+
										'<div class="amount-wrapper ">'+
											'<div class="item-amount ">'+
												'<div class="sl">'+
													'<input class="min am-btn" name="" type="button" value="-" />'+   
													'<input class="text_box" name="" type="text" value="'+data.data.catItems[i].number+'" style="width:30px;" />'+
													'<input class="add am-btn" name="" type="button" value="+" />'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</li>'+
									'<li class="td td-sum">'+
										'<div class="td-inner">'+
											'<em tabindex="0" class="J_ItemSum number">'+data.data.items[i].price/1000*0.9*data.data.catItems[i].number+'</em>'+
										'</div>'+
									'</li>'+
									'<li class="td td-op">'+
										'<div class="td-inner">'+
											'<a title="移入收藏夹" class="btn-fav" href="#">'+
                  '移入收藏夹</a>'+
											'<a href="javascript:;" data-point-url="#" class="delete">'+
                 ' 删除</a>'+
										'</div>'+
									'</li>'+
								'</ul>'+
							'</div>'+
						'</div> '+   
					'</tr>');
		        		}; 
		        		
		        		$("#J_SelectedItemsCount").text($(".check:checked").length);  //已选商品数量
		        		//计算商品总价格
		        		var eachShopTotal=$(".J_ItemSum.number");
		        		var check=$(".check");  
		        		var sum =0;
		        		for(var i=0;i<eachShopTotal.length;i++){
		        			if(check.eq(i).prop("checked")==true){
		        				sum=sum+parseFloat(eachShopTotal.eq(i).text());
		        			}
		        		}
		        		$("#J_Total").text(sum);//显示总价格
		        		//当勾选商品时触发的事件
		        		$(".check").click(function(){
		        			showTotalAndPrice();
		        		})
		        		$(".item-props.item-props-can").empty(); //去除商品规格
		        		$("#J_SelectAllCbx2").remove();  //去除全选框
		        		$(".min.am-btn").click(function(){    
		        			var i = $(this).next().attr("value")-1 ; 
		        			if(i<=0){
		        				$(this).attr("disabled","true");
		        				var checked =$(this).parent().parent().parent().parent().prev().prev().prev().prev().children().children();
		        				checked.removeAttr("checked");
		        			}
		        			$(this).next().attr("value",i);
		        			var price =$(this).parent().parent().parent().parent().prev().children().children().children().next();
		        			var totalPrice=$(this).parent().parent().parent().parent().next().children().children();
		        			totalPrice.text(price.text()*i);
		        			showTotalAndPrice();
		        		})   
		        		
		        		$(".add.am-btn").click(function(){
		        			var i = parseInt($(this).prev().attr("value"))+1;
		        			if(i>0){
		        				$(this).prev().prev().removeAttr("disabled");
		        				var checked =$(this).parent().parent().parent().parent().prev().prev().prev().prev().children().children();
		        				checked.prop("checked","checked");  
		        			}
		        			$(this).prev().attr("value",i);  
		        			var price =$(this).parent().parent().parent().parent().prev().children().children().children().next();
		        			var totalPrice=$(this).parent().parent().parent().parent().next().children().children();
		        			totalPrice.text(price.text()*i);
		        			showTotalAndPrice();  
		        		}) 
		        		//刷新已选商品数量和总价格
		        		function showTotalAndPrice(){
							$("#J_SelectedItemsCount").text($(".check:checked").length);  //已选商品数量
							//计算商品总价格
							var eachShopTotal=$(".J_ItemSum.number");
							var check=$(".check");  
							var sum =0;
							for(var i=0;i<eachShopTotal.length;i++){
								if(check.eq(i).prop("checked")==true){
									sum=sum+parseFloat(eachShopTotal.eq(i).text());
								}
							}
							$("#J_Total").text(sum);//显示总价格
		        		}
		        	}else{
		        		//载入缓存失败图片
	//	        		var div = $(".ml-22");
	//	        		div.empty();
	//	        		div.append('<img src="images/loading.gif" style="width:20px"/>');
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
	
	
	/**
	 * 点击支付异步发送需支付的商品列表和数量
	 */    
	$("#J_Go").click(function(){
		var check=$(".check");  
		var num=$(".text_box"); 
		var itemId=$(".itemId");
	//	var data={};
		var ids=[];
		var nums=[];    
		alert(ids);    
		for(var i = 0;i<itemId.length;i++){   
			if(check.eq(i).prop("checked")==true){
				ids.push(parseInt(itemId.eq(i).val()));
				nums.push(parseInt(num.eq(i).val()));     
			}        
		}               
	//	data['catItemId']=catItemId;      
	//	data['number']=number;              
	//	ids=JSON.stringify(ids);                 
	//	nums=JSON.stringify(nums);         
//		window.location.replace("http://localhost:8080/orangelala/carToPay.html?ids="+ids+"&nums="+nums);    
		window.location.replace("http://localhost:8080/orangelala/carToPay.html?ids="+escape(JSON.stringify(ids))+"&nums="+escape(JSON.stringify(nums)));      
//		window.location.replace("http://localhost:8080/orangelala/carToPay.html?ids=%5B679533,679533,1188043,562379,536563%5D&nums=%5B5,1,2,4,1%5D");      
		
		
	})
	   
	
	        
	
})


