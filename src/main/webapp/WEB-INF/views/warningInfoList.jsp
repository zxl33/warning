<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta charset="utf-8" />
		<title>告警信息列表@@@</title>
  <link href="//img.chinanetcenter.com/lib/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="//img.chinanetcenter.com/lib/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
  <link rel="stylesheet" href="//img.chinanetcenter.com/wsicon/wsicon.css">
  <link rel="stylesheet" href="//img.chinanetcenter.com/warningInfoSystem/prd/styles/wsfe.css">
	</head>
	<body>
    <%@include file="../header.jsp" %>
    <div class="row-fluid ws-main">
      <%@include file="../side-bar.jsp" %>
      <div class="span20 ws-content">
        <div class="panel">
          <div class="panel-body">
          <form id="search-form" class="form-horizontal search-form" action="demo/simple/list" method="get">
            <div class="row-fluid">
              <div class="span24">
                <div class="control-group span8">
                  <label class="control-label" for="">组件名</label>
                  <div class="controls"><input name='componentName' class="input-normal control-text" type="text" placeholder='请输入组件名'></div>
                </div>
                <div class="control-group js-dateRange-container m-single-error">
                  <label class="control-label" for=""><s>*</s>时间</label>
                  <div id="id-date-range" class="controls bui-form-group">
                    <input id="id-date-from" name='startDateTime' class="js-startDate-calendar calendar calendar-time" type="text">
                    <span class="time-separator">~</span>
                    <input id="js-date-to" name='endDateTime' class="js-endDate-calendar calendar calendar-time" type="text">
                  </div>
                </div>
              </div>
            </div>
            <div class='row-fluid'>
              <div class="form-actions span4 offset8">
                <button type='submit' class="button button-default">搜索</button>
              </div>
            </div>
          </form>
            <div id="grid"></div>
          </div>
        </div>
      </div>
    </div>
    <%@include file="../footer.jsp" %>
    <div id="js-deal-with-dialog" class='hide'>
      <form class="form-horizontal" action="demo/simple/dealWith" method='post'>
        <input class="js-id-input" type="hidden" name='id'>
        <div class="row-fluid">
          <div class="control-group">
            <label class="control-label" >原因：</label>
              <div class="controls"><input name='reason' class="js-reason-label input-normal control-text" type="text"></div>
          </div>
          <div class='control-group'>
            <label class="control-label" >描述：</label>
            <div class="controls"><input name='description' class="js-description-label input-normal control-text" type="text"></div>
          </div>
          <div class="control-group">
            <label class="control-label" for="">解决：</label>
              <div class='controls js-dealWithOrNot-label'>
                <label class="checkbox" for=""><input name='dealWithOrNot' type="radio" value=true>是</label>
                <label class="checkbox" for=""><input name='dealWithOrNot' type="radio" value=false>否</label>
              </div>
          </div>
        </div>
      </form>
    </div>
    <script src="https://cdn.bootcss.com/Faker/3.1.0/faker.js"></script>
    <script type="text/javascript">
      var DEV = false;
    </script>
    <script type="text/javascript" src="//img.chinanetcenter.com/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="//img.chinanetcenter.com/lib/bui/1.1.21/seed-min.js"></script>
    <script type="text/javascript" src="//img.chinanetcenter.com/warningInfoSystem/prd/scripts/wsfe.js"></script>
    <script src="//img.chinanetcenter.com/warningInfoSystem/prd/scripts/modules/simple/warningInfoListPage@13edsd123e33w.js"></script>
    <script type="text/javascript">
      new wsfe.simple.WarningInfoListPage();
    </script>
	</body>
</html>
