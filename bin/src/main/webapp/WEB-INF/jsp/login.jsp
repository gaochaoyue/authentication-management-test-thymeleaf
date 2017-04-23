<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}/">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>用户登录</title>
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="static/css/font-awesome.css">
  <link rel="stylesheet" href="static/css/compositive.css">
  <link rel="stylesheet" href="static/css/common.css">
  <!-- 以下注释内容不能删除，兼容IE使用 -->
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <!-- 以上注释内容不能删除，兼容IE使用 -->
  <style>
  	<!-- 权限登录界面-->
		.login-style-limits{
		    height:240px;
		    margin-top: 140px;
		    padding-top: 50px;
		}
		
		.login-btn-limits{
		    width:108px;
		    height:30px;
		    margin-left:64px;
		    line-height: 30px;
		    background:#6cc213!important;
		    color: #ffffff;
		    border-radius: 5px;
		    border: none;
		    outline: none;
		}

  </style>
</head>
<body>
<header class="clearfix">
  <div class="systemHeader">
    <div class="headText"></div>
  </div>
</header>
<!-- 登录页面内容区 开始 -->
<div class="login-content container clearfix">
  <div class="row">
    <div class="col-lg-7 col-md-7 col-sm-8 col-xs-8  login-bg">
      <img src="static/images/login/loginbg-limits.png">
    </div>
    <div class="col-lg-5 col-md-5 col-sm-4 col-xs-4">
	      <form id="form1" name="form1" action="/manager/login" method="post" class="login-style login-style-limits">
	        <div class="input-group">
	          <span class="input-group-addon">
	            <img src="static/images/login/usericon.jpg" class="info-icon" alt="">
	          </span>
	          <input type="text" id="managerName" name="managerName" class="form-control" placeholder="用户名">
	        </div>
	        <div class="input-group">
	          <span class="input-group-addon">
	            <img src="static/images/login/lockicon.jpg" class="info-icon" alt="">
	          </span>
	          <input type="password" id="password" name="password" class="form-control" placeholder="密码">
	        </div>
	        <input class="login-btn-limits" type="submit" value="登录">
	      </form>
    </div>
  </div>
</div>
</body>
</html>