<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8" />
    <title>组件管理</title>
    <link href="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/wsicon/wsicon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/dev/styles/wsfe.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/dev/styles/ui-extend.css"> 
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/danmu/css/danmuplayer.css">
  
	  
 
  </head>
  <body>

    <%@include file="../header.jsp" %>
    <div class="row-fluid ws-main">
     <div class="panel">
     <div class="panel-body style="margin-top:50px>"
     <div id="danmup" class="danmu" style="margin-left:250px" ></div>
	</div>
     </div>
     </div>
    
     <%@include file="../footer.jsp" %>
    <script src="https://cdn.bootcss.com/Faker/3.1.0/faker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/lib/jquery/1.8.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/fe/lib/bui/1.1.21/seed-min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/fe/warningInfoSystem/prd/scripts/wsfe.js"></script>
	<script src="${pageContext.request.contextPath}/resources/danmu/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/danmu/js/danmuplayer.js"></script>

	</script>
    <script type="text/javascript">
    $("#danmup").danmuplayer({
    	  src:"${pageContext.request.contextPath}/resources/recycle.mp4",       //视频源
    	  width:800,            //视频宽度
    	  height:445,           //视频高度
    	  url_to_post_danmu: '/springMVC/rabbit/storeDanmu',
    	  url_to_get_danmu: '/springMVC/rabbit/getDanmu'
    	});
    </script>

</body>
</html>