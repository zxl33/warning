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
          <div class="panel-body">
            <form id="search-form" class="form-horizontal search-form" action="assembly/assemblySearch" method='get'>
              <div class="row-fluid">
                <div class="span24">
                  <div class="control-group span8">
                    <label class="control-label" for="componentName">组件:</label>
                    <div class="controls"><input name='componentName' class="input-normal control-text" type="text" id='componentName' placeholder='输入组件名以查询'></div>
                  </div>
                  <div class="control-group span8">
                    <label class="control-label" for="pm">负责人:</label>
                    <div class="controls">
                      <input name='pm' class="input-normal control-text" type="text" id='pm' placeholder='输入负责人姓名'></div>
                  </div>
                  <div class="form-actions span8"><button class="button button-default" type='submit' >搜索</button></div>
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
        <div id="js-on-duty-change-dialog" class='hide'>
          <form class='form-horizontal' action='testList/duty/updateDutyToday' method='post'>
            <input name="id" type="hidden">
            <div class="control-group">
              <label class="control-label" for="">0:00~7.59</label>
              <div class="controls">
                <input name='nightOnDuty' class="input-normal control-text js-selects"  readonly='readonly' placeholder='请从列表中选择值班人' type="text">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">8:00~15:59</label>
              <div class="controls">
                <input name='morningOnDuty' class="input-normal control-text js-selects"   readonly='readonly' placeholder='请从列表中选择值班人' type="text">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="">16:00~23:59</label>
              <div class="controls">
                <input name='eveningOnDuty' class="input-normal control-text js-selects"  readonly='readonly' placeholder='请从列表中选择值班人' type="text">
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <%@include file="../footer.jsp" %>
    <script src="https://cdn.bootcss.com/Faker/3.1.0/faker.js"></script>
    <script type="text/javascript">
var locale = 'zh_CN'
var DEV =false;
window.globalConfig = {
		  api: {
		    onDuty: 'demo/simple/componentEdit/selectMemberByID2',
		  },
		}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/lib/jquery/1.8.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/seed-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/wsfe.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/modules/simple/componentListPage.js"></script>

<script type="text/javascript">
    new wsfe.simple.ComponentListPage();
    </script>
  </body>
</html>
