<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>后台管理页面-发布公告</title>
		<link rel="stylesheet" type="text/css" href="content/css/content.css" />
		<link rel="stylesheet" type="text/css" href="content/css/manager.css" />
		<script src="content/js/jquery.validate.min.js" type="text/javascript"></script>
		<script src="kindeditor/kindeditor-min.js" type="text/javascript"></script>
		<script type="text/javascript">
			var editor;

			KindEditor.ready(function(K) {
				editor = K.create('#Announce_Content', {
					uploadJson: '/Announce/UploadImage', //(Announce为Controller,UploadImage为Action，下同)
					allowUpload: true, //允许上传图片 
					resizeType:1 

				});
			});
		</script>

	</head>

	<body>
		<!-- Save for Web Slices (设计.psd) -->
		<div id="__01" class="mainbody">
			<div class="header">
				<div class="header_logo">
				</div>
				<div class="header_logInfo">
					欢迎您 <strong>eaglet</strong>! [
					<a href="/Account/LogOff">退出</a>
					] |
					<a href="/">首页</a>
				</div>
			</div>
			<div class="manager_nav_bg">
				<div class="manager_nav">
					<ul id="menu">
						<li>
							<a href="/Manager">管理首页</a>
						</li>
						<li>
							<a href="/Article">客户管理</a>
						</li>
						<li>
							<a href="/Production/Default">合同管理</a>
						</li>
						<li>
							<a href="/Department">订单管理</a>
						</li>
						<li>
							<a href="/Service">成本管理</a>
						</li>
						<li>
							<a href="/Synthetical">机构管理</a>
						</li>
						<li>
							<a href="/System/Default">系统管理</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="manager_main">
				<div class="content">
					<div class="leftbox">
						<!-- Begin of  #contentlist -->
						<div class="contentBox">
							<div class="contentBoxTop">
								<h3>
                    发布公告</h3>
							</div>
							<div class="innerContent">
								<table class="aTable">
									<tr>
										<td class="aTitle"> 标题 </td>

									</tr>
									<tr>
										<td> <input class="text-box aTitlInput" id="Announce_Title" name="Announce_Title" type="text" value="" />
</td>

									</tr>
									<tr>
										<td class="aTitle"> 内容 </td>

									</tr>
									<tr>
										<td> <textarea cols="20" id="Announce_Content" name="Announce_Content"  style="width:680px; height:400px;">
</textarea>
										</td>

									</tr>
									<tr class="aSubmit">
										<td> <input type="submit" class="from_sub" value="保存" /></td>

									</tr>
								</table>

								<!-- End of  #contentlist -->
							</div>
						</div>

					</div>
					<div class="rightbox">
						
						<div class="itembox">
							<div class="rightBoxesTop">
								<h3>
            管理目录</h3>
							</div>
							<div class="rightContent">
								<ul id="sidebarLinks">
									<li>
										<a href="#">发布公告</a>
									</li>
									<li>
										<a href="#">公告管理</a>
									</li>
								</ul>
							</div>
						</div>

					</div>
				</div>

			</div>
			<div class="manager_footer">
				<div class="manager_footer_left">
					本系统由eaglet设计开发 版本号：Building 20150121</div>
				<div class="manager_footer_right">
					Open System Copyright &copy; 2015 Eaglet.All Rights Reserved.</div>
			</div>
		</div>
		<!-- End Save for Web Slices -->

	</body>

</html>