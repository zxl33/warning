<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8" />
    <title>管理员管理</title>
     <link href="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/wsicon/wsicon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/dev/styles/wsfe.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/dev/styles/ui-extend.css">
  </head>
  <body>
  <%@include file="../header.jsp" %>
   <!--  <include src='../header.jsp'></include>-->
    <div class="row-fluid ws-main">
    <%@include file="../side-bar.jsp" %>
  <!--  <include src='../side-bar.jsp'></include> --> 
      <div class="span20 ws-content">
        <div class="panel">
          <div class="panel-body">
            <form id="search-form" method='get' class="form-horizontal search-form" action="demo/simple/adminList"></form>
            <div id="grid"></div>
          </div>
        </div>
      </div>
    </div>
    <div id="js-admin-add-dialog" class='hide'>
      <form class='form-horizontal' method='post' action='demo/simple/adminAdd'>
        <div class="control-group">
          <label class="control-label" for="">姓名:</label>
          <div class="controls"><input class="input-normal control-text" type="姓名" name='name' data-rules='{required: true}'></div>
        </div>
        <div class="control-group">
          <label class="control-label" for="">邮箱:</label>
          <div class="controls"><input name='email' data-rules='{email: true}' class="input-normal control-text" type="text"></div>
        </div>
        <div class="control-group">
          <label class="control-label" for="">密码:</label>
          <div class="controls"><input name='password' class="input-normal control-text" data-rules='{required: true}' type="text"></div>
        </div>
        <div class="control-group">
          <label class="control-label" for="forCheck">确认密码:</label>
          <div class="controls"><input class="input-normal control-text" id='forCheck' data-rules='{required: true}' type="text" ></div>
        </div>
      </form>
    </div>
    <%@include file="../footer.jsp" %>
    <script src='${pageContext.request.contextPath}/resources/fe/lib/lodash/4.17.4/lodash.min.js'></script>
    <script src='${pageContext.request.contextPath}/resources/fe/lib/lodash/4.17.4/lodash.fp.js'></script>
    <script src="https://cdn.bootcss.com/Faker/3.1.0/faker.js"></script>
    <script src='${pageContext.request.contextPath}/resources/fe/lib/moment/2.13.0/moment.js'></script>
    <script type="text/javascript">
var locale = 'zh_CN'
var DEV = false;
window.globalConfig = {
  api: {
    adminDelete: 'demo/simple/adminDelete',
  },
}
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/seed-min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/wsfe.js"></script>
	<script src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/modules/simple/componentManagementListPage.js"></script>
	<script type="text/javascript">
new wsfe.simple.adminListPage();
    </script>
  </body>
</html>
