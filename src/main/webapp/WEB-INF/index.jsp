<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>导航页面</title>
  <link href="/resources/fe/lib/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="/resources/fe/lib/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
  <link rel="stylesheet" href="/resources/fe/wsfe/1.0.0/prd/styles/wsfe.css">
  <!--[if lt IE 9]>
  <script type="text/javascript" src="http://apps.bdimg.com/libs/html5shiv/r29/html5.min.js"></script>
  <![endif]-->
</head>
<body>
    <header class="ws-header">
      <div class="pull-left">
          <a href="#" class="ws-logo"><img src="/resources/fe/wsfe/img/logo.png" /></a>
          <ul class="top-nav">
              <li><a href="javascript:void(0);" class="current">概览</a></li>
              <li><a href="javascript:void(0);">资源</a></li>
              <li><a href="javascript:void(0);">监控</a></li>
              <li><a href="javascript:void(0);">告警</a></li>
              <li><a href="javascript:void(0);">自助配置</a></li>
              <li><a href="javascript:void(0);">运营统计</a></li>
          </ul>
      </div>
    </header>
    <!--ws-main表示内容主区域-->
    <div class="row-fluid ws-main">
      <!--ws-sidebar是左侧导航栏的类，必填-->
      <!--ws-submenu用来设置左边区域的margin-top以及解决两栏布局的等高性-->
      <aside class="span4 span-first ws-sidebar ws-submenu">
        <ul class="ul-item">
          <li><a href="#" class="current">概览</a></li>
          <li>
            <a href="javascript:;" class="close">自助配置</a>
            <ul>
              <li><a href="#">带宽</a></li>
              <li><a href="#" class="current">流量</a></li>
              <li><a href="#">请求数</a></li>
            </ul>
          </li>
          <li>
            <a href="javascript:;" class="open">统计分析</a>
            <ul>
              <li><a href="#">带宽</a></li>
              <li><a href="#" class="current">流量</a></li>
              <li><a href="#">请求数</a></li>
            </ul>
          </li>
        </ul>
      </aside>
      <div class="span20 ws-content">
        <!--右边主区域内容-->
        <!-- ws-content 用来设置右边区域的margin-top以及解决两栏布局的等高性并且margin-top:20px-->
      </div>
    </div>
    <footer></footer>
    <script type="text/javascript" src="//img.chinanetcenter.com/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="//img.chinanetcenter.com/lib/bui/1.1.21/seed-min.js"></script>
    <script type="text/javascript" src="//img.chinanetcenter.com/wsfe/1.0.0/prd/scripts/wsfe.js"></script>
</body>
</html>
    