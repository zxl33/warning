<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="span4 span-first ws-sidebar ws-submenu">
  <ul class="ul-item">
    <li>
    	<a href="javascript:;" class="open">告警信息模块</a>
    	<ul><li><a href="/springMVC/messageHelper">告警信息列表</a></li></ul>
    	</li>
    <li>
      <a href="javascript:;" class="open">组件模块</a>
      <ul>
        <li><a href="/springMVC/testList">组件列表</a></li>
        <li><a href="/springMVC/testCO">组件操作</a></li>
      </ul>
    </li>
    <li>
      <a href="javascript:;" class="close">管理中心模块</a>
      <ul>
        <li><a href="/springMVC/testCM" class="current">组件管理</a></li>
        <li><a href="/springMVC/managerHelper">管理员管理</a></li>
        <li><a href="/springMVC/tempHelper">通知模版管理</a></li>
      </ul>
    </li>
  </ul>
</aside>
