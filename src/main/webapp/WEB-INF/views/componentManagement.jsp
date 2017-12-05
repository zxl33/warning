<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8" />
    <title>组件管理</title>
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
            <form id="search-form" class="form-horizontal search-form" action="assembly/assemblyManagerListSearch" method='get'>
              <div class="row-fluid">
                <div class="span24">
                  <div class="control-group span8">
                    <label class="control-label" for="componentName">组件:</label>
                    <div class="controls"><input name='componentName' id='comonentName' placeholder='输入组件名以查询' class="input-normal control-text" type="text"></div>
                  </div>
                  <div class="control-group span8">
                    <label class="control-label" for="pm">负责人:</label>
                    <div class="controls"><input id='pm' name='pm' class="input-normal control-text" type="text" placeholder='输入负责人姓名'></div>
                  </div>
                  <div class="form-actions span8"><button class="button button-default" type='submit'>搜索</button></div>
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
        <div id="js-component-check-dialog" class="hide">
          <form class="form-horizontal" action="" method='get'>
            <input type="hidden" name='id'>
            <div class="control-group">
              <label class="control-label" for="componentChineseName">组件中文名:</label>
              <div class="controls"><input name='componentChineseName' class="input-normal control-text" readonly='readonly' id='componentChineseName' type="text"></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="componentEnglishName">组件英文名:</label>
              <div class="controls"><input readonly='readonly' name='componentEnglishName' class="input-normal control-text" type="text" id='componentEnglishName'></div>
            </div>
            <div class="control-group">
              <label class="control-label" >负责人:</label>
              <div class="controls"><input class="input-normal control-text"  name='pm' readonly='readonly' type="text"></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">负责人邮箱:</label>
              <div class="controls"><input class="input-normal control-text" data-rules='{email: true}' name='email' readonly='readonly' type=""></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">告警推送方式:</label>
              <div class="controls"><input readonly='readonly' class="input-normal control-text" name='broadcastWays' type="text"></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">邮件模板:</label>
              <div class="controls"><input  class="input-normal control-text" name='mailTemplate' type="text"></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">短信模板:</label>
              <div class="controls"><input  class="input-normal control-text" name='messageTemplate' type="text"></div>
            </div>
          </form>
        </div>
        <div id="js-component-edit-dialog" class="hide">
          <form class="form-horizontal" method="post" action="">
            <input type="hidden" name='id' >
            <div class="control-group">
              <label class="control-label" for="componentChineseName">组件中文名:</label>
              <div class="controls"><input name='componentChineseName' class="input-normal control-text"  id='componentChineseName' type="text"></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="componentEnglishName">组件英文名:</label>
              <div class="controls"><input  name='componentEnglishName' class="input-normal control-text" type="text" id='componentEnglishName'></div>
            </div>
            <div class="control-group">
              <label class="control-label" >负责人:</label>
              <div class="controls"><input class="input-normal control-text"  name='pm'  type="text"></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">负责人邮箱:</label>
              <div class="controls"><input data-rules='{email: true}' class="input-normal control-text" name='email'  type="email"></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">告警推送方式:</label>
              <div class="controls">
                <label class="checkbox" for=""><input value=<%=1 %>  type="checkbox" name='broadcastWays'>邮件</label>
				<label class="checkbox" for=""><input type="checkbox" value=2  name='broadcastWays'>短信</label>
				<label class="checkbox" for=""><input type="checkbox" value=3  name='broadcastWays'>APP</label>
				<label class="checkbox" for=""><input type="checkbox" value=4  name='broadcastWays'>公众号</label>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">邮件模板:</label>
              <div class="controls"><input class="input-normal control-text js-selects" type="text"  placeholder='请从列表中选择邮件模板' name='mailTemplate'></div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">短信模板:</label>
              <div class="controls"><input class="input-normal control-text js-selects" type="text"  placeholder='请从列表中选择短信模板' name='messageTemplate'></div>
            </div>
          </form>
        </div>
      </div>
    </div>
   <%@include file="../footer.jsp" %>
    <script src="https://cdn.bootcss.com/Faker/3.1.0/faker.js"></script>
    <script type="text/javascript">
var locale = 'zh_CN'
var DEV = false;
window.globalConfig = {
  api: {
    componentDelete: 'assembly/deleteAssembly',
    componentEditUrl: 'assembly/updateAssembly',
    componentAddUrl: 'assembly/addAssembly',
    mailTemplate:'connect/mail.temp',
    	messageTemplate:'connect/note.temp',
  }
}

    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/seed-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/wsfe.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/modules/simple/componentManagementListPage.js"></script>
    <script type="text/javascript">
new wsfe.simple.ComponentManagementListPage();
    </script>
  </body>
</html>
