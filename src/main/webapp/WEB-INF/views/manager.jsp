<%--
  Created by IntelliJ IDEA.
  User: baiqy
  Date: 2017/7/31
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
    <title>管理员管理</title>
    <link href="<%=request.getContextPath()%>/resources/js/dpl.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/js/bui.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="wsfe.css">--%>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/js/wsfe.css">
    <style type="text/css">

        table
        {
            border-collapse: collapse;
            border-spacing: 0;
            margin-right: auto;
            margin-left: auto;
            width: 600px;
        }
        th, td
        {
            border: 2px solid black;
            font-size: 12px;
            font-weight: normal;
            text-align: center;
            vertical-align: middle;
            height: 20px;
        }
        th {
            background-color: Gray;
        }

        .hide {
            align-self: center;
            text-align: center;
            vertical-align: middle;
            alignment-baseline: center;
        }
        span {
            color:blue;
            /*text-align: center;*/
            /*vertical-align: middle;*/
        }
        body {
            background-color: #fff;
        }
    </style>
</head>
<body>
    <br><br><br><br>
        &nbsp;&nbsp;<div class="demo-content"><div>
            &nbsp;&nbsp;<input type="button" id="addManager" class="button button-primary" value="新增">
    </div>
        <br>
            <form id="form0">
            <div class="row">
                <div class="span16">
                    <div id="grid">
                    </div>
                </div>
            </div>
            </form>
            <%--<script src="http://g.tbcdn.cn/fi/bui/jquery-1.8.1.min.js"></script>--%>
            <%--<script src="http://g.alicdn.com/bui/bui/1.1.21/bui.js"></script>--%>
            <%--<script src="http://g.alicdn.com/bui/bui/1.1.21/seed-min.js"></script>--%>
                <%--<script src="http://g.tbcdn.cn/fi/bui/jquery-1.8.1.min.js"></script>--%>
                <script src="http://g.tbcdn.cn/fi/bui/jquery-1.8.1.min.js"></script>
                <script src="http://g.alicdn.com/bui/seajs/2.3.0/sea.js"></script>
                <script src="http://g.alicdn.com/bui/bui/1.1.21/config.js"></script>
            <script type="text/javascript">
                var grid = null;
                var store = null;
                BUI.use(['bui/grid','bui/data','bui/overlay'],function (Grid,Data,Overlay) {
//                    var Grid = BUI.Grid,
//                        Data = BUI.Data,
                      var columns = [
                            {title : '姓名', width:200, name:"name",dataIndex:"name"},
                            {id: '123',title : '邮箱',dataIndex :"email", width:200, name:"email"},
                            {title : '操作',width:200,renderer:function (value, obj) {
                                return '<span class="grid-command btn1">删除</span>'
                            }
                            }
                        ];
                    store = new Data.Store({
                        autoLoad: true, //自动加载数据
                        autoSync: true,
                        pageSize:2,	// 配置分页数目
                        params:{
                            pageIndex:0,
                            limit:2,
                            start:0
                        },
                        proxy: {
                            url: 'manager.data',
                            method: 'post'
//                            dataType:'jsonp'
                        }
                    });
//                    store.load({
//                        pageIndex:store.get('pageIndex'),
//                            limit:store.get('limit'),
//                            start:store.get('start')}
//                            );
                    grid = new Grid.Grid({
                            render: '#grid',
                            forceFit: true,
                            columns: columns,
                            loadMask: false, //加载数据时显示屏蔽层
                            store: store,
                            listeners: {
                                'cellclick': function (ev) {
                                    var record = ev.record,//点击行的记录
                                        field = ev.field,//点击对应列的dataIndex
                                        target = $(ev.domTarget);//点击的元素
                                    if (target.hasClass('btn1')) {
                                        var msg = "您是否确定删除";
                                        store.get('proxy').set('url', 'manager.delData');
                                        BUI.Message.Alert(msg, function () {
                                            store.load({del: record.name,pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')});
                                        });
                                    }
                                    if (target.hasClass('btn2')) {
                                        document.getElementById("addName").value = record.name;
                                        document.getElementById("email").value = record.email;
                                        document.getElementById("addName").disabled = true;
                                            var dialog = new Overlay.Dialog({
                                                title: '编辑管理员',
                                                width: 500,
                                                height: 250,
                                                contentId: 'content',
                                                closeAction: 'destroy',
                                                success: function () {
                                                    if (!document.getElementById('password').value == document.getElementById('passwordConfirm').value) {
                                                        BUI.Message.Show({
                                                            msg: '确认密码与原密码不同',
                                                            mask:true,
                                                            zIndex : 999999
                                                        });
                                                        return;
                                                    }
                                                    store.get('proxy').set('url', 'manager.delManagerData');
                                                    store.load({del: record.name,pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')});
                                                    $.ajax({
                                                            url:'manager.addData',
                                                            data : {name: document.getElementById("addName").value,
                                                                email: document.getElementById("email").value,
                                                                password: document.getElementById("password").value,
                                                                pageIndex:store.get('pageIndex'),
                                                                limit:store.get('pageSize'),
                                                                start:store.get('start')
                                                            },
                                                            type: "POST",
                                                            "contentType": "application/x-www-form-urlencoded; charset=utf-8",
                                                            dataType: "json",
                                                            async: false,
                                                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                                                alert(XMLHttpRequest.status);
                                                            },
                                                            success: function (data) {
//                                                                grid.addItem({
//                                                                    name: document.getElementById("addName").value,
//                                                                    email: document.getElementById("email").value
//                                                                });
//                                                                store.get('proxy').set('url', 'manager.getData');
//                                                                store.load({pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')});
                                                                store.get('proxy').set('url', 'manager.data');
                                                                store.load({pageIndex:store.get('pageIndex'),limit:store.get('pageSize'),start:store.get('start')});
                                                            }
                                                        }
                                                    );
//                                                    var store1 = new Data.Store({
//                                                        autoLoad: false, //自动加载数据
//                                                        autoSync: false,
//                                                        pageSize:2,
//                                                        proxy: {
//                                                            url: 'manager.addData',
//                                                            method: 'post'
//                                                        }
//                                                    });
//                                                    store1.load({
//                                                        name: document.getElementById("addName").value,
//                                                        email: document.getElementById("email").value,
//                                                        password: document.getElementById("password").value
//                                                    });
                                                    //                                                                store.get('proxy').set('url', 'manager.getData');
//                                                                store.load({pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')});
//                                                    store.get('proxy').set('url', 'manager.data');
//                                                    store.load({pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')});
//                                                    grid.addItem({
//                                                        name: document.getElementById("addName").value,
//                                                        email: document.getElementById("email").value
//                                                    });
                                                    document.getElementById("addName").value = "";
                                                    document.getElementById("email").value = "";
                                                    document.getElementById("password").value = "";
                                                    document.getElementById("passwordConfirm").value = "";
                                                    this.close();

                                                },
                                                cancel: function () {
                                                    document.getElementById("addName").value = "";
                                                    document.getElementById("email").value = "";
                                                    document.getElementById("password").value = "";
                                                    document.getElementById("passwordConfirm").value = "";
                                                }
                                            });
                                            dialog.show();
                                    }
                                }
                            },
                            bbar: {
                                // pagingBar:表明包含分页栏
                                pagingBar: true
                            }
                        }
                    );
                    grid.render();
                });
            </script>
    </div>
            <%--<div class="control-group">--%>
                <%--<label class="control-label"><s>*</s>店铺名称：</label>--%>
                <%--<div class="controls">--%>
                    <%--<input name="sname" type="text" class="input-large" data-rules="{required : true}">--%>
                <%--</div>--%>
            <%--</div>--%>
    <div id="content" class="hide">
        <form id = "form1"  name = "form1" action="" class="form-horizontal">
            <div class="row">
            <div class="control-group">
            <label class="control-label"><s>*</s>管理员姓名：</label>
            <div class="controls">
                <%--<input type="text" id="addName" name="name" class="span8 span-width control-text input-large"  data-rules="{required : true}">--%>
                    <input type="text" id="addName" name="name" class="input-normal control-text"  data-rules="{required : true}">
            </div>
            </div>
            <div class="control-group">
            <label class="control-label"><s>*</s>管理员邮箱：</label>
            <div class="controls">
                <input type="text" id="email" name="email" class="input-normal control-text"   data-rules="{required : true}">
            </div>
            </div>
                <div class="control-group">
                    <label class="control-label"><s>*</s>管理员密码：</label>
                    <div class="controls">
                        <input type="password"  id="password" name="password" class="input-normal control-text"   data-rules="{required : true}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label"><s>*</s>管理员密码确认：</label>
                    <div class="controls">
                        <input type="password" id="passwordConfirm" name="passwordConfirm" class="input-normal control-text"  data-rules="{required : true}">
                    </div>
                </div>
            </div>
            </form>
            <%--<script src="http://g.tbcdn.cn/fi/bui/jquery-1.8.1.min.js"></script>--%>
            <%--<script src="http://g.alicdn.com/bui/seajs/2.3.0/sea.js"></script>--%>
            <%--<script src="http://g.alicdn.com/bui/bui/1.1.21/config.js"></script>--%>
        <%--<script src="http://g.alicdn.com/bui/bui/1.1.21/seed-min.js"></script>--%>
        <!-- script start -->
        <script type="text/javascript">
            BUI.use('bui/form',function(Form){
                new Form.Form({
                    srcNode : '#form1'
                }).render();
            });
            BUI.use(['bui/overlay','bui/data','bui/message'],function(Overlay,Data,Message){
                $('#addManager').on('click',function () {
//                        document.getElementById("addName").disabled = false;
//                        new Form.Form({
//                            srcNode : '#form1'
//                        }).render();
                document.getElementById("addName").disabled = false;
                var dialog = new Overlay.Dialog({
                    title:'添加管理员',
                    width:500,
                    height:250,
//                    y:100,
                    contentId:'content',
                    closeAction : 'destroy',
                    success:function () {
                        if (document.getElementById('password').value != document.getElementById('passwordConfirm').value) {
                            BUI.Message.Show({
                                msg: '确认密码与原密码不同',
                                mask:true,
                                zIndex : 999999
                        });
                            return;
                        }
                        if (validate_form() && !validate_dulName(document.getElementById("addName").value)) {
                            $.ajax({
                                url:'manager.addData',
                                data : {name: document.getElementById("addName").value,
                                    email: document.getElementById("email").value,
                                    password: document.getElementById("password").value,
                                    pageIndex:store.get('pageIndex'),
                                    limit:store.get('pageSize'),
                                    start:store.get('start')
                                },
                                    type: "POST",
                                    "contentType": "application/x-www-form-urlencoded; charset=utf-8",
                                    dataType: "json",
                                    async: false,
                                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                                        alert(XMLHttpRequest.status);
                                        alert(XMLHttpRequest.readyState);
                                    },
                                    success: function (data) {
                                        store.get('proxy').set('url', 'manager.data');
                                        store.load({pageIndex:store.get('pageIndex'),limit:store.get('limit'),start:store.get('start')});
//                                        grid.addItem({
//                                            name: document.getElementById("addName").value,
//                                            email: document.getElementById("email").value
//                                        });
//                                        store.get('proxy').set('url', 'manager.getData');
//                                        store.load({
//                                            pageIndex:store.get('pageIndex'),
//                                            limit:store.get('limit'),
//                                            start:store.get('start')});
                                    }
                                }
                            );
//                            grid.render();
//                            alert(store.getTotalCount());
                            document.getElementById("addName").value = "";
                            document.getElementById("email").value = "";
                            document.getElementById("password").value = "";
                            document.getElementById("passwordConfirm").value = "";
                            this.close();
                        }
                    },
                    cancel:function () {
                        document.getElementById("addName").value = "";
                        document.getElementById("email").value = "";
                        document.getElementById("password").value = "";
                        document.getElementById("passwordConfirm").value = "";
                        this.close();
                    }
                });
                    dialog.show();
                });
            });
            function validate_dulName(name) {
                var result = false;
                $.ajax({
                    type: "POST",
//            contentType: 'application/json;charset=utf-8', //设置请求头信息,,,返回json字符串
                    "contentType": "application/x-www-form-urlencoded; charset=utf-8",
                    dataType: "json",
                    url: "manager.getData.void",
                    async:false,
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
//                    alert(XMLHttpRequest.readyState);
//                    alert(textStatus);
                },
                success: function (data) {
                    $.each(data,function(index,param){
                        if (name == param.name) {
                        var msg = "重复的名字";
                            BUI.Message.Show({
                                msg: msg,
                                mask:true,
                                zIndex : 999999
                            });
                        result = true;
                    }
                    });
                }
            }
                );
                    return result;
            }

            function validate_email(value,alerttxt) {
                var nullPattern = new RegExp("\\S*");
                var nullTxt  = "e-mail 不能为空";
                if (!nullPattern.test(value) || value=="" || value==null) {
                    BUI.Message.Show({
                        msg: nullTxt,
                        mask:true,
                        zIndex : 999999
                    });
                    return false;
                }
                var apos=value.indexOf("@");
                var dotpos=value.lastIndexOf(".");

                if (apos<1||dotpos-apos<2) {
                    BUI.Message.Show({
                        msg: alerttxt,
                        mask:true,
                        zIndex : 999999
                    });
                    return false;
                }
                else {
                    return true;
                }

            }
            function validate_name(value,alerttxt) {
                var nullPattern = new RegExp("\\S*");
                var nullTxt  = "名字不能为空";

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
                        msg: alerttxt,
                        mask:true,
                        zIndex : 999999
                    });
                    return false;
                }
                else {
                    return true;
                }
            }
            function validate_password(value,alerttxt) {
                var nullPattern = new RegExp("\\S*");
                var nullTxt  = "密码不能为空";
                //#if (nullPattern.test(value) || value=="" || value==null) {
                if (!value.match(nullPattern) || value=="" || value==null) {
                    BUI.Message.Show({
                        msg: nullTxt,
                        mask:true,
                        zIndex : 999999
                    });
                    return false;
                }
//            var passwordPattern = new RegExp("\\S");
                if (value.toString().length > 15){
                    BUI.Message.Show({
                        msg: alerttxt,
                        mask:true,
                        zIndex : 999999
                    });
                    return false;
                }
                else {
                    return true;
                }
            }
            function validate_form() {
                var name=document.getElementById("addName").value;
                var email=document.getElementById("email").value;
                var password=document.getElementById("password").value;
                var result = true;
                if (validate_name(name, "Not a valid name!") == false) {
                    result = false;
                    return false;
                }
                if (validate_password(password, "Not a valid password!") == false) {
//                password.focus();
                    result = false;
                    return false;
                }
                if (validate_email(email, "Not a valid email address!") == false) {
//                email.focus();
                    result = false;
                    return false;
                }
                return result;
            }
        </script>
    </div>

</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.js"></script>
<script src="http://g.alicdn.com/bui/bui/1.1.21/seed-min.js"></script>
<script src="http://g.alicdn.com/bui/bui/1.1.21/bui-min.js"></script>
<script>

    jQuery.prototype.serializeObjectToJson=function(){
        var obj=new Object();
        $.each(this.serializeArray(),function(index,param){
            if(!(param.name in obj)){
                obj[param.name]=param.value;
            }
        });
        return obj;
    };

    function sleep(d){
        for(var t = Date.now();Date.now() - t <= d;);
    }

//    function find() {
//        $.ajax({
//            data : $("#form").serializeObjectToJson(),
//            type: "POST",
//            "contentType": "application/x-www-form-urlencoded; charset=utf-8",
//            dataType: "json",
//            url: "manager",
//            error: function (XMLHttpRequest, textStatus, errorThrown) {
//                alert(XMLHttpRequest.status);
//                alert(XMLHttpRequest.readyState);
//                alert(textStatus);
//            },
//            success: function (data) {
//                tableData(data);
//            }
//        }
//        )
//    }
//    function tableData(str){
//
//        var jsonObject=eval(str);
//        var table = document.getElementById("table");
//        var tr=document.createElement('tr');
//        var thName = document.createElement('th');
//        var thEmail=document.createElement('th');
//        var thAction=document.createElement('th');
//
//        thName.innerHTML = "姓名";
//        thEmail.innerHTML = "邮箱";
//        thAction.innerHTML = "删除";
//
//        tr.appendChild(thName);
//        tr.appendChild(thEmail);
//        tr.appendChild(thAction);
//        table.appendChild(tr);
//
//        for(var i=0;i<jsonObject.length;i++){
//            tr=document.createElement('tr');
//            var tdName = document.createElement('td');
//            var tdEmail = document.createElement('td');
//            var tdDel = document.createElement('td');
//
//            tdName.id = i + "_check";
//            tdEmail.id = i + "_email";
//            tdName.id = i + "_name";
//
//            tdName.innerHTML=jsonObject[i].name;
//            tdEmail.innerHTML=jsonObject[i].email;
//            tdDel.innerHTML="<span onmouseover=\"this.style.cursor='hand'\">删除</span>";
//
//            tr.appendChild(tdName);
//            tr.appendChild(tdEmail);
//            tr.appendChild(tdDel);
//            table.appendChild(tr);
//        }
//    }
</script>
</html>
