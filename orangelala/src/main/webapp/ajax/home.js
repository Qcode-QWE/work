$(function(){
	var url = "home/itemCat/subnav.html";
		
		var a=[1,74,161,249,290,296,378,438,495,558,580,633,699,749,865,903];
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
		        	
		        	if(data.status==200){
		        		var one = $(".ml-22");  //<a class="ml-22" title="饼干、膨化">饼干/膨化</a>
		        		for(var i = 0;i<one.length;i++){
		        			one.eq(i).attr("title",data.data[i]["name"]);
		        			one.eq(i).text(data.data[i]["name"]);
		        			findTwoByOne(data.data[i]["id"],i);
		        		}
		        		
		        	}
		        },
		        error:function () {      
		            alert("请求失败！");
		        }
			}
		);
})


function findTwoByOne(id,num){
	var url = "home/itemCat/subnavTwo.html";
	//设置数组模式
	$.ajax(
		{
			type: "get",
	        url: url,
	        data: {"id":id},
	        traditional: true,
	        cache: false,
	        async : false,
	        dataType: "json",
	        success: function (data)
	        {
	        	console.log(data);
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
	        error:function () {      
	            alert("请求失败！");
	        }
		}
	);
}


