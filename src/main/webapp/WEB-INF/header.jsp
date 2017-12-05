<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<header class="ws-header">
  <div class="pull-left">
    <a href="#" class="ws-logo"><img src="${pageContext.request.contextPath}/resources/mc/Image/head.png" /></a>
    <ul class="top-nav">
      <li><a href="javascript:void(0);" class="current">告警信息模块</a></li>
      <li><a href="javascript:void(0);">组件模块</a></li>
      <li><a href="javascript:void(0);">管理中心</a></li>
    </ul>
  </div>
  <div class="ws-user-info">
    <span class='user-logo'></span>
    <span class='user-name'></span>
    <span class='wsicon wsicon-down-arrow user-oper-btn'></span>
    <span class='user-oper-div js-user-oper'>
      <span class="wsicon wsicon-up-arrow u-arrow"></span>
      <ul>
        <!-- 用户操作 -->
       <li><a href="">用户</a></li>
        <li><a href="/springMVC/login">退出</a></li>
      </ul>
    </span>
  </div>
</header>