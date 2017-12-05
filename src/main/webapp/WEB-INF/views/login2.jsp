<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>告警推送系统</title>

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/resources/mc/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/mc/js/hf_hotel.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body >
    <div class="container" style="margin:30px 40px 120px 40px;">
		<div id="myCarousel" class="carousel slide col-lg-7">
		   <!-- 轮播（Carousel）指标 -->
		   <ol class="carousel-indicators">
		      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		      <li data-target="#myCarousel" data-slide-to="1"></li>
		   </ol>
		   <!-- 轮播（Carousel）项目 -->
		   <div class="carousel-inner">
		      <div class="item active" style="height:350px;">
		         <img src="<%=request.getContextPath()%>/resources/mc/Image/head-1.jpg" alt="First slide">
		      </div>
		      <div class="item" style="height:350px;">
		         <img src="<%=request.getContextPath()%>/resources/mc/Image/head-2.jpg" alt="Second slide">
		      </div>
		   </div>
		   <!-- 轮播（Carousel）导航 -->
		   <a class="carousel-control left" href="#myCarousel"
		      data-slide="prev">&lsaquo;</a>
		   <a class="carousel-control right" href="#myCarousel"
		      data-slide="next">&rsaquo;</a>
		</div>
		<div class="col-lg-1 "></br></div>
        <div class="col-lg-4">
        	<div style="margin=0 20px 0 20px;">
		      <form action="" method="post" id="login_form">
		        <h2 >登陆</h2>
		        <label for="login_id" class="sr-only">账号</label>
		        <input type="text" id="email" name="email" class="form-control" placeholder="账号" required autofocus>
		        <label for="login_password" class="sr-only">密码</label>
		        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
		        <div class="form-group">
				        验证码：<input id="authCode" class="" name="authCode" type="text"/>
				        <!--这里img标签的src属性的值为后台实现图片验证码方法的请求地址-->
				        <label><img type="image" src="authCode" id="codeImage" onclick="changeCode()" title="图片看不清？点击重新得到验证码" style="cursor:pointer;"/></label>
				        <label><a onclick="changeCode()">换一张</a></label>
				</div>
		      </form>
		      <button class="btn btn-lg btn-primary btn-block" id="login_enter">登陆</button>
	        </div>
        </div>
    </div> <!-- /container -->
  </body>
 </html>
