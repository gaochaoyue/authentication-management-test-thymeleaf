<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}/">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="style/alogin.css" rel="stylesheet" type="text/css" />
<title>用户登录</title>
<script type="text/javascript">
	/* function loadimage(){
		document.getElementById("randImage").src="images/image.jsp?"+Math.random();
	} */
</script>
</head>
<body>
<form id="form1" name="form1" action="/manager/login" method="post">
	<div class="MAIN">
		<ul>
			<li class="top"></li>
			<li class="top2"></li>
			<li class="topA"></li>
			<li class="topB">
				<span> 
					<!-- <a href="http://www.java1234.com" target="_blank"> --><img src="images/login/loginbg_xiuzheng.png" alt="" style="" /></a>
					
				</span>
			</li>
			<li class="topC"></li>
			<li class="topD">
			<ul class="login">
				<br>
				<br>
				<li><span class="left">用户名：</span> <span style=""> <input id="managerName" name="managerName" type="text" class="txt" value="${managerName }" /> </span></li>
				<li><span class="left">密&nbsp;&nbsp;&nbsp;码：</span> <span style=""> <input id="password" name="password" type="password" class="txt" value="${password }" onkeydown= "if(event.keyCode==13)form1.submit()"/> </span></li>
			</ul>
			</li>
			<li class="topE"></li>
			<li class="middle_A"></li>
			<li class="middle_B"></li>
			<li class="middle_C"><span class="btn"> <img alt="" src="static/images/login/btnlogin.gif" onclick="javascript:document.getElementById('form1').submit()"/> </span>&nbsp;&nbsp;<span ><font color="red">${error }</font></span></li>
			<li class="middle_D"></li>
			<li class="bottom_A"></li>
		</ul>
	</div>
</form>
</body>
</html>