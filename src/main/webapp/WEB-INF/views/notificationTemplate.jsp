<%--
  Created by IntelliJ IDEA.
  User: baiqy
  Date: 2017/8/4
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>通知模板管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <link rel="stylesheet" href="http://10.8.203.190/wsfe/1.0.0/prd/styles/wsfe.css">
    <%--<style type="text/css">--%>
    <style type="text/css">
        body {
            background-color: #fff;
        }
    </style>
</head>
<body>
<br>
<br>
<br>
<br>
<%--<div style="display:table-cell; vertical-align: middle;text-align: center;" id = "center"></div>--%>
<h1>通知模板管理</h1>
<%--<form id="form0">--%>
    <br>
    &nbsp;&nbsp;<div class="demo-content"><div>
    &nbsp;&nbsp;<input type="button" id="addNotify" class="button button-primary" value="新增">
</div>
    <br><br>
    <form id="form0">
        <div class="row">
            <div class="span16">
                <div id="grid">
                </div>
            </div>
        </div>
    </form>
    <div id="checkTem" class="hide">
<form id = "form2" class="form-horizontal">
<br>
<h1>查看模板</h1>
<br>
<div class="row details-row">
        <label class = "span8">
            名称：
        </label>
    <br>
    <p id="nameTXT" class="span8"></p>
    <label class="span8">
        类型：
    </label>
    <br>
    <p id="typeTXT" class="span8"></p>
    <label class="span8">
        内容：
    </label>
    <br>
    <p id="contentTXT" class="span8"></p>
</div>
</form>
    </div>

<%--<script src="http://g.tbcdn.cn/fi/bui/jquery-1.8.1.min.js"></script>--%>
<script src="http://g.alicdn.com/bui/bui/1.1.21/bui.js"></script>
<script src="http://g.tbcdn.cn/fi/bui/jquery-1.8.1.min.js"></script>
<script src="http://g.alicdn.com/bui/seajs/2.3.0/sea.js"></script>
<script src="http://g.alicdn.com/bui/bui/1.1.21/config.js"></script>
<script type="text/javascript">
    var grid = null,
        store = null;
    BUI.use(['bui/grid','bui/data','bui/overlay'],function (Grid, Data,Overlay) {
        var columns = [
            {title : '名称', width:200, name:"name",dataIndex:"name"},
            {title : '类型',dataIndex :"type", width:200, name:"type"},
            {title : '内容',dataIndex :"content", width:200, name:"content"},
            {title : '操作',width:200,renderer:function (value, obj) {
                return '<span class="grid-command btn1">删除</span> <span class="grid-command btn2">查看</span>'
            }
            }
        ];
        store = new Data.Store({
            autoLoad:true, //自动加载数据
            autoSync:true,
            pageSize:2,	// 配置分页数目
            params:{
                pageIndex:0,
                limit:2,
                start:0
            },
            proxy:{
                url : 'notification.data',
                method:'post'
            }
        });

        grid = new Grid.Grid({
            render: '#grid',
            forceFit: true,
            columns: columns,
            loadMask: false, //加载数据时显示屏蔽层
            store: store,
            bbar:{
                // pagingBar:表明包含分页栏
                pagingBar:true
            },
            listeners: {
                'cellclick': function (ev) {
                    var record = ev.record,//点击行的记录
                        field = ev.field,//点击对应列的dataIndex
                        target = $(ev.domTarget);//点击的元素
                    if (target.hasClass('btn1')) {
                        var msg = "您是否确定删除";
                        store.get('proxy').set('url', 'notification.del');
                        BUI.Message.Alert(msg,function() {store.load({del: record.name,pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')})});
                    }
                    if (target.hasClass('btn2')) {
                        //弹出窗口
                        $.ajax({
                            url:'notification.check',
                            data:{name: record.name, type: record.type, content: record.content},
                            type:'POST',
                            success: function (data) {
                                document.getElementById("nameTXT").innerHTML =data.name;
                                document.getElementById("typeTXT").innerHTML =data.type;
                                document.getElementById("contentTXT").innerHTML =data.content;
                            }
                        });
//                        store.get('proxy').set('url', 'notification.check');
//                        store.load({name: record.name, type: record.type, content: record.content});
//                        var data = store.find("name", record.name);
//                        BUI.use('bui/overlay', function (Overlay) {
                        var dialog = new Overlay.Dialog({
                            title: '查看模板',
                            width: 360,
                            height: 350,
//                                elCls : 'custom-dialog',
                            contentId: 'checkTem',
                            closeAction: 'destroy',
                            success: function () {
                                this.close();
                            }
                            });
//                            dialog.center();
                        dialog.show();
                    }
                }
            }
        });
        grid.render();
    })
</script></div>


<div id="content" class="hide">
    <form id = "form1" name = "form1" action="" class="form-horizontal">
    <br>
    <h1>新增模板</h1>
        <div class="row">
        <div class="control-group">
        <label class="control-label"><s>*</s>名称：</label>
        <div class="controls">
            <input type="text" id="addName" name="name" class="input-normal control-text" data-rules="{required : true}">
        </div>
        </div>
        <div class="control-group">
            <label class="control-label"><s>*</s>类型：</label>
        <div class="controls bui-form-group-select" data-type="type">
            <select class="input-small"  name = "type" id="addType"><option value="邮箱"  selected = "selected">邮箱</option><option value="短信">短信</option></select>&nbsp;&nbsp;
        </div>
        </div>
        <div class="control-group">
            <label class="control-label">内容：</label>
            <div class="controls  control-row-auto">
                <textarea name="" id="addContent" class="control-row4 input-large"></textarea>
        </div>
        </div>
    </div>
    </form>
</div>

<script type="text/javascript">
//jQuery.prototype.serializeObjectToJson=function(){
//var obj=new Object();
//$.each(this.serializeArray(),function(index,param){
//if(!(param.name in obj)){
//obj[param.name]=param.value;
//}
//});
//return obj;
//};
//    BUI.use('bui/form',function(Form){
//        new Form.Form({
//            srcNode : '#form1'
//        }).render();
//    });
document.getElementById("addType").value = "邮箱";
    BUI.use(['bui/overlay','bui/form'],function(Overlay,Form){
                var form=new Form.Form({
                    srcNode:'#form1'
                }).render();
    $('#addNotify').on('click',function () {
    var dialog = new Overlay.Dialog({
        title:'新增模板',
        width:500,
        height:400,
        contentId:'content',
        closeAction : 'destroy',
        success:function () {
            var addName = document.getElementById("addName").value;
            if (validate_name(addName) && !validate_dulName(addName)) {
            	var typeData = false;
            	if (document.getElementById("addType").value == "邮箱" ) {
            		typeData = false;
            		}
            	else{
            		typeData = true;
            	}
            
            	}
            
                $.ajax({
                        url:'notification.add',
                        data :{
                        name: document.getElementById("addName").value,
                        type: typeData,
                        content: document.getElementById("addContent").value,
                            limit:store.get('limit'),
                            start:store.get('start'),
                            pageIndex:store.get('pageIndex')
                    },
                        type: "POST",
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",
                        dataType: "json",
                        async: false,
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            alert(XMLHttpRequest.status);
                            alert(XMLHttpRequest.readyState);
                        },
                        success: function (data) {
                            grid.addItem({
                                name: document.getElementById("addName").value,
                                type: document.getElementById("addType").value,
                                content: cutTo5(document.getElementById("addContent").value)
                            });
                            store.get('proxy').set('url', 'notification.data');
                            store.load({pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')});
                        }
                    }
                );
//                var store1 = new Data.Store({
//                    autoLoad: true, //自动加载数据
//                    autoSync: true,
//                    params: {
//                        name: document.getElementById("addName").value,
//                        type: document.getElementById("addType").value,
//                        content: document.getElementById("addContent").value
//                    },
//                    proxy: {
//                        url: 'notification.add',
//                        method: 'post'
////                            dataType:'jsonp'
//                    }
//                });
            document.getElementById("addName").value="";
            document.getElementById("addType").value="";
            document.getElementById("addContent").value="";
            this.close();
        
            },
        cancel:function () {
            document.getElementById("addName").value="";
            document.getElementById("addType").value="";
            document.getElementById("addContent").value="";
            this.close();
    }
});
    dialog.show();
});
});

    function cutTo5(string) {
        if (!string.toString().length<5) {
        var result = string.toString().slice(0,5);
    }
        return result;
    }

//    function validate_dulName(name) {
//        var msg = "重复的名字";
//        for (var i=0;i<store.getCount();i++) {
//            if (store.findByIndex(i)["name"] == name) {
//                BUI.Message.Show({
//                    msg: msg,
//                    mask:true,
//                    zIndex : 999999
//                });
//                return true;
//            }
//        }
//            return false;
//    }
    function validate_dulName(name) {
        var res = false;
        $.ajax({
            url:'notification.nameValidate',
            data:{name:name},
            type:'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            async: false,
            success:function (data) {
            res = data["dul"];
        }
    });
        if (res) {
            var msg = "重复的名字";
            BUI.Message.Show({
                    msg: msg,
                    mask:true,
                    zIndex : 999999
                });
        }
        return res;
}

    function validate_name(value) {
        var nullPattern = new RegExp("\\S*");
        var nullTxt  = "name should not be null";
            //#if (nullPattern.test(value) || value=="" || value==null) {
        if (!value.match(nullPattern) || value=="" || value==null) {
            BUI.Message.Show({
                msg: nullTxt,
                mask:true,
                zIndex : 999999
            });
            return false;
        }
        var namePattern = new RegExp("\\w{0,10}");
        if (!namePattern.test(value)){
            BUI.Message.Show({
                msg: "名字不可用",
                mask:true,
                zIndex : 999999
            });
        return false;
        }
        else {
            return true;
        }
    }
</script>

</body>
</html>
