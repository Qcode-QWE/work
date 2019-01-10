//显示商品栏一级标签@RequestMapping("/home/itemCat/subnav")
$(function(){
	var url = "home/itemCat/subnav.html";
		
		var a=[1,74,161,249,290,296,378,438,495,558,580,633,699,749,865,903];
		//设置数组模式
		$.ajax(
			{
				type: "post",
				timeout : 5000,    //设置超时时间5秒钟
		        url: url,
		        data: {"id":a},  
		        traditional: true,
		        cache: false,
		        async : true,    //async必须设置为async:true，timeout才生效；如果设置为async:false，则锁住浏览器，禁止一切操作，直到请求有返回结果。
		        dataType: "json",
		        success: function (data)
		        {
		        	if(data.status==200){
		        		var one = $(".ml-22");  //<a class="ml-22" title="饼干、膨化">饼干/膨化</a>
		        		for(var i = 0;i<one.length;i++){
		        			one.eq(i).attr("title",data.data[i]["name"]);
		        			one.eq(i).text(data.data[i]["name"]);
		        			findTwoAndThreeByOne(data.data[i]["id"],i); //根据一级标签查找二三级标签
		        		}
		        		
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

//根据一级标签查找二三级标签
//<div class="sort-side">
//	<dl class="dl-sort">
//		<dt><span title="蛋糕">蛋糕</span></dt>  //二级标签
//		<dd><a title="蒸蛋糕" href="#"><span>蒸蛋糕</span></a></dd>  //三级标签.......
//	</dl>
//	<dl class="dl-sort">
//		<dt><span title="蛋糕">点心</span></dt>
//		<dd><a title="蒸蛋糕" href="#"><span>蒸蛋糕</span></a></dd>
//		</dl>
//	</div>
//</div>
function findTwoAndThreeByOne(id,num){
	var url = "home/itemCat/subnavTwo.html";
	//设置数组模式
	$.ajax(
		{
			type: "get",
			timeout :5000,
	        url: url,     
	        data: {"id":id},
	        traditional: true,
	        cache: false,
	        async : true,
	        dataType: "json",
	        success: function (data)
	        {
	        	var two = $(".sort-side").eq(num);
	        	two.empty();
	        	for(var twoLen=0;twoLen<data.data.subnavTwo.length;twoLen++){
	        		var txt1=$("<dl class='dl-sort'></dl>");
	        		two.append(txt1);
	        		var txt2=$("<dt></dt>");
	        		txt1.append(txt2);
	        		var txt3=$("<span title='' id=''></span>");
        			txt3.attr('title',data.data.subnavTwo[twoLen].name );
        			txt3.attr('id',data.data.subnavTwo[twoLen].id );
        			txt3.text(data.data.subnavTwo[twoLen].name);
        			txt2.append(txt3);
        			
	        		for(var threeLen=0;threeLen<data.data.subnavThree[data.data.subnavTwo[twoLen].name].length;threeLen++){
	        			var subnavThree=data.data.subnavThree[data.data.subnavTwo[twoLen].name];
	        			var txt4=$("<dd></dd>");    
 	        			var txt5=$("<a title='' href='#' id=''></a>");
	        			txt5.attr('title',subnavThree[threeLen].name );
	        			txt5.attr('id',subnavThree[threeLen].id );
	        			txt5.text(subnavThree[threeLen].name);
	        			var txt6=$("<span ></span>");
	        			txt6.text(subnavThree[threeLen].name);
	        			txt5.append(txt6);
	        			txt4.append(txt5);
	        			txt1.append(txt4);
	        		}
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
}

//显示大广告图片@RequestMapping("/home/content/shuffling")
//<ul class="am-slides">
//<li class="banner1"><a href=""><img src="" /></a></li>
//<li class="banner2"><a href=""><img src="" /></a></li>
//<li class="banner3"><a href=""><img src="" /></a></li>
//<li class="banner4"><a href=""><img src="" /></a></li>
//</ul>
$(function(){
	var url = "home/content/shuffling.html";
	var data ={"id":89};
	$.ajax({
		type: "get",
		timeout : 5000,  
        url: url,
        data: data,
        traditional: true,
        cache: false,  
        async : true,
        dataType: "json",
        success:function(data){
        	console.log(data);
        	var slides = $(".am-slides").children();      
        	for(var i=0;i<data.data.length;i++){    
        		slides.eq(i).children().attr("href",data.data[i].url);
        		slides.eq(i).children().children().attr("src","/"+data.data[i].pic);
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
	})
	
})

//秒杀
$(function(){
	//秒杀点击
	function killClick() {
		var h = $(".hh").html();
		var m = $(".mm").html();
		var s = $(".ss").html();
		alert(0);
		//判断秒杀是否开始
		if(h=="00"&&m=="00"&&s=="00"){
			//判断能否秒杀
			var url = "home/secondsKill/itemAble.html";
			var id = $(this).attr("name");
			data = {"id":id,"num":1};
			$.ajax({
				type: "get",
				timeout : 5000,  
		        url: url,
		        data: data,
		        traditional: true,
		        cache: false,  
		        async : true,
		        dataType: "json",
		        success:function(data){
		        	console.log(data);
		        	if(data==0){
		        		//还没开始
		        		alert("秒杀还没开始");
		        	}else if(data==1){
		        		alert("秒杀失败");
		        	}else if(data==2){
		        		window.location.replace("http://localhost:8080/orangelala/ItemtoPay.html?id="+id+"&num="+1);
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
			})
		}else {
			alert("秒杀还没开始");
		}	
	}
})








