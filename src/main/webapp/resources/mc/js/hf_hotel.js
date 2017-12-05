// JavaScript Document
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//仓库财务
// JavaScript Document
  
//仓库-物品-查询-按钮
$(function(){
    $("#ware_item_find1").click(function(){
		$("#ware_item_find_table").empty();
		//加表头
		$("#ware_item_find_table").append("<tr><th>告警号</th><th>组件名</th><th>持续时间</th><th>最后时间</th><th>次数</th><th>参数</th><th>服务器类型</th><th>服务类型</th><th>所在机房</th><th>所属组</th><th>操作</th></tr>");
		
		var assembly_name=$("#ware_item_add_price1").val();
		var start_date=$("#ware_item_find_date3").val();
		var end_date=$("#ware_item_find_date4").val();

        var jsondata = "assembly_name="+assembly_name+"&start_time="+start_date+"&end_time="+end_date;	
        $.ajax({
			cache: true,
			type: "POST",
			url:"message.data",
			data:jsondata,// 你的formid
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					js = eval(data.data)   		
					for(var i=0;i<js.length;i++)
					{ 		
						var deal = "已解决";
						if(js[i].action == "0")
						{
							deal = "处理解决"
						}
						$("#ware_item_find_table").append("<tr><td>"+js[i].message_id+" </td><td>"+data.data2[js[i].assembly_id]+" </td><td>"+js[i].continue_time+" </td><td>"+js[i].last_time+" </td><td>"+js[i].times+" </td><td>"+js[i].parameters+" </td><td>"+js[i].server_type+" </td><td>"+js[i].service_type+" </td><td>"+js[i].room+" </td><td>"+js[i].group_name+" </td><td>"+deal+" </td></tr>");
					}
				}else{
					alert(data['message']);
				}
		    }
		});
	});
  });
  
  
//函数-把空格都丢掉
function splitword(text)
{
	var reg = /^\s+|\s+$/g;				//正则表达式 好厉害！！！！！！
    var twname = text.replace(reg,"");
    var regg = /\s+/g;
    var midname = twname.replace(regg," ");
    var arr = midname.split(" ");
	return arr;
	}

//仓库-物品-新增-出模态框
$(function(){
    $("#ware_item_add2").click(function(){
		var t1=$("#ware_item_add_name1").val();
		var t2=$("#ware_item_add_price1").val();
		var t3=$("#ware_item_add_standard1").val();
		var t4=$("#ware_item_add_dw1").val();
		var t5=$("#ware_item_add_date1").val();
		var t6=$("#ware_item_add_lnum1").val();
		var t7=$("#ware_item_add_locate1 option:selected").text();
		var t8=$("#ware_item_add_supply1 option:selected").text();
		if((t1 == "")||(t2 == "")||(t3 == "")||(t4 == "")||(t5 == "")||(t6 == ""))
		{alert('新增输入不能为空');}
		else{
      	$("#ware_item_m1").modal("toggle");
		$("#ware_item_add_name2").val(t1);
		$("#ware_item_add_price2").val(t2);
		$("#ware_item_add_standard2").val(t3);
		$("#ware_item_add_dw2").val(t4);
		$("#ware_item_add_date2").val(t5);
		$("#ware_item_add_lnum2").val(t6);
		$("#ware_item_add_locate2").val(t7);
		$("#ware_item_add_supply2").val(t8);
		}
    });
  });
  

$(function(){
    $("#ware_supply_add_add3").click(function(){
    	var t1=$("#ware_item_find_id2").val();
		var t2=$("#ware_item_find_price2").val();
		var t3=$("#ware_item_find_standard2").val();
		var t4=$("input[name='ware_item_find_dw2']:checked").val();
		var jsondata = "message_id="+t1+"&action_reason="+t2+"&action_desc="+t3+"&action="+t4;
		$.ajax({
			cache: true,
			type: "POST",
			url:"action.data",
			data:jsondata,
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					window.location.reload();
				}else{
					alert(data['message']);
				}
		    }
		});
    });
});

//仓库-物品-表格-点击出模态
$(function(){
    $("#ware_item_find_table").on("click","tr",function(){
	var text = $(this).text();
    var arr = splitword(text);
	$("#ware_item_m2").modal("toggle");
	$("#ware_item_find_id2").val(arr[0]);
	var jsondata = "id="+arr[0];
	$.ajax({
		cache: true,
		type: "POST",
		url:"single.message.data",
		data:jsondata,
		async: false,
	    error: function(request) {
	        alert("Connection error");
	    },
	    success: function(data) {
			if(data['success']){
				$("#ware_item_find_price2").val(data['data']['action_reason']);
				$("#ware_item_find_standard2").val(data['data']['action_describe']);
				$(":radio[name='ware_item_find_dw2'][value='" + data['data']['action'] + "']").prop("checked", "checked");
			}else{
				alert(data['message']);
			}
	    }
	});
	});
  });

function message_onload(){
	$.ajax({
		cache: true,
		type: "POST",
		url:"message.data",
		data:null,// 你的formid
		async: false,
	    error: function(request) {
	        alert("Connection error");
	    },
	    success: function(data) {
			if(data['success']){
				js = eval(data.data)   		
				for(var i=0;i<js.length;i++)
				{ 		
					var deal = "已解决";
					if(js[i].action == "0")
					{
						deal = "处理解决"
					}
					$("#ware_item_find_table").append("<tr><td>"+js[i].message_id+" </td><td>"+data.data2[js[i].assembly_id]+" </td><td>"+js[i].continue_time+" </td><td>"+js[i].last_time+" </td><td>"+js[i].times+" </td><td>"+js[i].parameters+" </td><td>"+js[i].server_type+" </td><td>"+js[i].service_type+" </td><td>"+js[i].room+" </td><td>"+js[i].group_name+" </td><td>"+deal+" </td></tr>");
				}
			}else{
				alert(data['message']);
			}
	    }
	});
}

  function food_load(){
	  var a= account();
	     if(a){
	     }else{

			  window.location="../../huangzeqin/login/login.html";
	     }
	     $("#user_name5").text(a);
}

function account()
{
	var result = "";
	$.ajaxSettings.async = false;
	$.getJSON('../../huangzeqin/send_acc.php',null, function(json){
     var js=json.op;
     result=js;
	});
	return result;
}


//系统登录
$(function(){
	$("#login_enter").click(function(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"login/check",
			data:$('#login_form').serialize(),// 你的formid
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					window.location.href = 'managerHelper';
				}else{
					alert(data['message']);
					}
			    }
			});
	});
});

//管理员-列表-加载
function manager_onload()
{
	$.ajax({
		cache: true,
		type: "POST",
		url:"manager.data",
		data:null,// 你的formid
		async: false,
	    error: function(request) {
	        alert("Connection error");
	    },
	    success: function(data) {
			if(data['success']){
				js = eval(data.data)   		
				for(var i=0;i<js.length;i++)
				{ 		
					$("#ware_supply_table").append("<tr><td>"+js[i].manager_id+" </td><td>"+js[i].name+" </td><td>"+js[i].email+" </td><td><a>删除</a></td>");
				}
			}else{
				alert(data['message']);
			}
	    }
	});
}

//管理员-新增
$(function(){
    $("#ware_supply_add1").click(function(){
		var t1=$("#ware_supply_add_sup1").val();
		var t2=$("#ware_supply_add_name1").val();
		var t3=$("#ware_supply_add_tel1").val();
		var t4=$("#ware_supply_add_add1").val();
		if((t1 == "")||(t2 == "")||(t3 == "")||(t4 == ""))
		{alert('新增输入不能为空');}
		else{
      	$("#ware_supply_m1").modal("toggle");
		$("#ware_supply_add_sup2").val(t1);
		$("#ware_supply_add_name2").val(t2);
		$("#ware_supply_add_tel2").val(t3);
		$("#ware_supply_add_add2").val(t4);
		}
    });
  });

//管理员-删除
$(function(){
    $("#ware_supply_table").on("click","tr",function(){
	var text = $(this).text();
    var arr = splitword(text);
	$("#ware_supply_m2").modal("toggle");
	$("#ware_supply_find_id2").val(arr[0]);
	$("#ware_supply_find_sup2").val(arr[1]);
	$("#ware_supply_find_name2").val(arr[2]);
	$("#ware_supply_find_tel2").val(arr[3]);
	$("#ware_supply_find_add2").val(arr[4]);
	$("#ware_supply_find_id8").val(arr[0]);
	});
  });

//模板-列表-加载
function temp_onload()
{
	$.ajax({
		cache: true,
		type: "POST",
		url:"temp.data",
		data:null,// 你的formid
		async: false,
	    error: function(request) {
	        alert("Connection error");
	    },
	    success: function(data) {
			if(data['success']){
				js = eval(data.data)   		
				for(var i=0;i<js.length;i++)
				{ 	
					var typeString = "短信";
					if(js[i].type == '0')
						{
						typeString = "邮箱";
						}
					var contentString = js[i].content;
					if(contentString.length > 5)
						{
						contentString = contentString.substr(0,5);
						}
					$("#ware_io_find_table").append("<tr><td>"+js[i].temp_id+" </td><td>"+js[i].name+" </td><td>"+typeString+" </td><td>"+contentString+" </td><td><a class='abtn' id='temp_look'>查看</a><a id='temp_delete'>删除</a></td>");
					
				}
				btn_temp_look();
				btn_temp_delete();
			}else{
				alert(data['message']);
			}
	    }
	});
}

function btn_temp_look()
{
	$("body").on("click", "#temp_look", function() {
		$("#ware_io_m2").modal("toggle");
		var text = $(this).parent().parent().text();
		var arr = splitword(text);
		jsondata = "name="+arr[1];
		$.ajax({
			cache: true,
			type: "POST",
			url:"temp.look",
			data:jsondata,// 你的formid
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					$("#ware_io_find_id2").val(arr[0]);
					$("#ware_io_find_type2").val(arr[1]);
					$("#ware_io_find_name2").val(arr[2]);
					$("#ware_io_find_num2").val(data['data']['content']);
				}else{
					alert(data['message']);
				}
		    }
		});
	});
}

function btn_temp_delete()
{
	$("body").on("click", "#temp_delete", function() {
		$("#ware_io_m3").modal("toggle");
		var text = $(this).parent().parent().text();
		var arr = splitword(text);
		$("#temp_delete_id").val(arr[0]);
		$("#temp_delete_name").val(arr[1]);
	});
}

//模板-新增
$(function(){
    $("#ware_io_add2").click(function(){


      	$("#ware_io_m1").modal("toggle");

		
    });
  });

//管理员-新增
$(function(){
	$("#manager_add_btn").click(function(){
		var myReg = /^[\u4e00-\u9fa5]{1,10}$/;
        if (myReg.test($("#manager_add_name").val())) {
        } else {
            alert("输入姓名错误");
            exit;
        }
        var email=$("#manager_add_email").val();
        if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/))
		{
        	alert("邮箱格式错误");
        	exit;
		}
        var password=$("#manager_add_password").val();
        var password_again=$("#manager_add_password_again").val();
        if(password != password_again)
        {
        	alert("两次输入密码不相同");
        	exit;
        }
        if(!password.match(/^[a-zA-Z0-9]{6,15}$/))
        {
        	alert("密码格式不正确");
        	exit;
        }
        
		$.ajax({
			cache: true,
			type: "POST",
			url:"manager.add",
			data:$('#manager_add_form').serialize(),// 你的formid
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					alert(data['message']);
					window.location.reload();
				}else{
					alert(data['message']);
				}
		    }
		});
	})
})

//管理员-删除
$(function(){
	$("#manager_delete_btn").click(function(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"manager.delete",
			data:"id="+$('#ware_supply_find_id2').val(),// 你的formid
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					alert(data['message']);
					window.location.reload();
				}else{
					alert(data['message']);
				}
		    }
		});
	})
})

//模板-删除
$(function(){
	$("#temp_delete_btn").click(function(){
		$.ajax({
			cache: true,
			type: "POST",
			url:"temp.delete",
			data:"id="+$('#temp_delete_id').val(),// 你的formid
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					alert(data['message']);
					window.location.reload();
				}else{
					alert(data['message']);
				}
		    }
		});
	});
});

//模板-新增-保存
$(function(){
	$("#temp_add_btn").click(function(){
		var name=$("#ware_io_add_type2").val();
        if(!name.match(/^(\S){1,10}$/))
		{
        	alert("名称格式错误");
        	return;
		}
        var content=$("#ware_io_add_type2").val();
        if(content.length>200)
		{
        	alert("内容格式错误");
        	return;
		}
		
		$.ajax({
			cache: true,
			type: "POST",
			url:"temp.add",
			data:"name="+$('#ware_io_add_type2').val()+"&type="+$("#ware_io_add_type1").val()+"&content="+$("#ware_io_add_num2").val(),
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
				if(data['success']){
					alert(data['message']);
					window.location.reload();
				}else{
					alert(data['message']);
				}
		    }
		});
	});
});


//验证码
function changeCode(){
    $('#codeImage').attr('src','authCode?abc='+Math.random());//链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
}