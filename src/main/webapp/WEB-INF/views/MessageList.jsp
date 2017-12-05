<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8" />
    <title>组件列表</title>
      <link href="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/wsicon/wsicon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/dev/styles/wsfe.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/dev/styles/ui-extend.css">
  </head>
  <body>
    <%@include file="../header.jsp" %>
    <div class="row-fluid ws-main">
     <%@include file="../side-bar.jsp" %>
      <div class="span20 ws-content">
        <div class="panel">
         <div class='panel-body'>
         <form id="search-form" class="form-horizontal search-form" action="" method='get'>
              <div class="row-fluid">
                <div class="span24">
                  <div class="control-group span8">
                    <label class="control-label" for="componentName">组件:</label>
                    <div class="controls"><input name='componentName' id='comonentName' placeholder='输入组件名以查询' class="input-normal control-text" type="text"></div>
                  </div>
                  <div class="control-group span8">
                    <label class="control-label" for="time">时间范围:</label>
                    <div class="controls"><input type="text" placeholder='开始时间' class="calendar" />-至-<input type="text" placeholder='结束时间' class="calendar" /></div>
                  </div>
                  <div class="form-actions span8"><button class="button button-default" type='submit' style="margin-left:100px">搜索</button></div>
                </div>
              </div>
            </form>
        </div>
        </div>
        <div class="panel">
          <div class="panel-body">
            <div id="grid"></div>
          </div>
        </div>
       
      </div>
    </div>
    <%@include file="../footer.jsp" %>
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/seed-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/wsfe.js"></script>   
   <script src="http://g.alicdn.com/bui/bui/1.1.21/bui.js"></script>
 
<!-- script start --> 
    <script type="text/javascript">
          var Calendar = BUI.Calendar
          var datepicker = new Calendar.DatePicker({
            trigger:'.calendar',
            autoRender : true
          });
    </script>
    <script type="text/javascript">  
            BUI.use(['bui/grid', 'bui/data'], function (Grid, Data) {  
              var Grid = Grid,  
              Store = Data.Store,  
              columns = [  
                   { dataIndex: 'ClassName', title: '告警号名', width:'10%'},  
                   { dataIndex: 'ClassName', title: '组件名', width:'10%'}, 
                   { dataIndex: 'ClassName', title: '持续时间', width:'10%' }, 
                   { dataIndex: 'ClassName', title: '最后时间', width: '10%'}, 
                   { dataIndex: 'ClassName', title: '次数', width:'5%' }, 
                   { dataIndex: 'ClassName', title: '参数', width: '5%'}, 
                   { dataIndex: 'ClassName', title: '服务器类型', width:'10%' }, 
                   { dataIndex: 'ClassName', title: '服务类型', width: '10%' }, 
                   { dataIndex: 'ClassName', title: '所在机房', width:'10%'},
                   { dataIndex: 'ClassName', title: '所属组', width:'10%' },
                   { dataIndex: 'ID', title: '操作', width:'10%'}],               
                store = new Store({  
                    url: 'message/message.data',  
                    autoLoad: true,  
                    pageSize: 1 // 需要在store中 配置pageSize  
                }),  
                  grid = new Grid.Grid({                        
                      render: '#grid',  
                      columns: columns,  
                      loadMask: true,  
                      // 底部工具栏  
                      bbar: {  
                          // pagingBar:表明包含分页栏  
                          /*pagingBar: { 
                              xclass: 'pagingBar'                    
                          }*/  
                          pagingBar: true  
                      },  
                      store: store  
                  });  
                grid.render();  
            });  
            function getHeight(percent) { return $(window).height() * percent; }  
    </script>  
  
  </body>
</html>