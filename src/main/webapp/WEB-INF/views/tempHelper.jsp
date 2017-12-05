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
         <div class="row-fluid">
         <div class="span24">
        <iframe style="width: 100%; height: 800px;" src="/springMVC/temp2/temp2"></iframe>
        </div>
        </div>
        </div>
        </div>
       
      </div>
    </div>
    <%@include file="../footer.jsp" %>
    <script src="https://cdn.bootcss.com/Faker/3.1.0/faker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/seed-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/wsfe.js"></script>
   
  </body>
</html>
