<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta charset="utf-8" />
    <title>组件操作</title>
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
          <div class="panel-body">
            <form id="personOnDuty" class="form-horizontal search-form" action="searchMember" method='get'>
              <div class='row-fluid'>
                <div class="control-group">
                  <label class="control-label" for="">组件名:</label>
                  <div class="controls"><input class="input-normal control-text" readonly='readonly' type="text" name='componentName'></div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="">负责人:</label>
                  <div class="controls"><input class="input-normal control-text" type="text" readonly='readonly' name='pm'></div>
                </div>
              </div>
            </form>
            <h3>值班人员:</h3>
            <div id="personOnDutyGrid"></div>
            <form id="schedule" class="form-horizontal search-form" action="getDutiesByID" method='get'></form>
            <h3>排班表:</h3>
            <div id="scheduleGrid"></div>
          </div>
        </div>
      </div>
    </div>  
    <div id="js-on-duty-add-dialog" class="hide">
      <form class="form-horizontal" action="addMember" method='post'>
        <input type="hidden" name='assemblyId'>
        <div class="control-group">
          <label class="control-label" for="">姓名:</label>
          <div class="controls"><input class="input-normal control-text" type="text" data-rules='{required: true}' data-messages='{required: "姓名不能为空"}' name='name'></div>
        </div>
        <div class="control-group">
          <label class="control-label" for="">邮箱:</label>
          <div class="controls"><input class="input-normal control-text" type="text" name='email' data-rules='{email: true}'></div>
        </div>
      </form>
    </div>
    <%@include file="../footer.jsp" %>
    <script src="https://cdn.bootcss.com/ramda/0.24.1/ramda.js"></script>
    <script src='//img.chinanetcenter.com/lib/moment/2.13.0/moment.js'></script>
    <script src="https://cdn.bootcss.com/Faker/3.1.0/faker.js"></script>
    <script type="text/javascript">
var locale = 'zh_CN'
var DEV = false;
var lashes = window.location.href.split('/');
window.globalConfig = {
  api: {
    delete: 'deleteMember',//删除组件值班人员
    save: 'updateDuty',               //保存值班表
    simpleOnDuty: 'selectMemberByID',                   //获取值班表中下拉框的请求
    componentInfo: 'assembly/getNameAndLeader',       //获取组件的姓名和负责人
  },
  id: typeof Number(lashes[lashes.length-1]) === 'number' ? Number(lashes[lashes.length-1]) : 5,
}
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="//img.chinanetcenter.com/lib/bui/1.1.21/bui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/dev/scripts/wsfe.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/modules/simple/PersonOnDutyListPage.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/modules/simple/ScheduleListPage.js"></script>
    <script type="text/javascript">
$.get(window.globalConfig.api.componentInfo, {id: window.globalConfig.id}, (data) => {
  var data = data.data;
  $('[name=componentName]').val(data.componentInfo);
  $('[name=pm]').val(data.pm);
})
new wsfe.simple.PersonOnDutyListPage();
new wsfe.simple.ScheduleListPage();
    </script>
  </body>
</html>
