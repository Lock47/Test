<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>后台管理页面-公告管理</title>
		<link rel="stylesheet" type="text/css" href="content/css/content.css" />
		<link rel="stylesheet" type="text/css" href="content/css/manager.css" />
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
                    公告列表</h3>
            </div>
            <div class="innerContent">
                <table class="sTable">
                    <tr>
                        <th>
                            <input type="checkbox" value="全选" onclick="ChooseAll()" />
                        </th>
                        <th>
                            公告标题
                        </th>
                        <th>
                            发布时间
                        </th>
                        <th>
                            作者
                        </th>
                    </tr>
                        <tr class="oddRow">
                            <td class="check_list">
                                <input type="checkbox" id="list" name="list" />
                            </td>
                            <td class="list_title">
                                <a href="/Announce/Details/6" title="The New WebSite Test">The New WebSite Test</a>
                            </td>
                            <td class="list_time">
                                2014-11-27 14:48
                            </td>
                            <td>
                                eaglet
                            </td>
                            <td class="editItem">
                                <ul class="editlist">
                                    <li class="iconEdit"><a href="#">编辑</a>
                                    </li>
                                    <li class="iconDel"><a href="#">删除</a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                        <tr class="oddRow">
                            <td class="check_list">
                                <input type="checkbox" id="list" name="list" />
                            </td>
                            <td class="list_title">
                                <a href="/Announce/Details/16" title="新版网站测试">新版网站测试</a>
                            </td>
                            <td class="list_time">
                                2014-11-27 14:47
                            </td>
                            <td>
                                eaglet
                            </td>
                            <td class="editItem">
                                <ul class="editlist">
                                    <li class="iconEdit"><a href="/Announce/Edit/16">编辑</a>
                                    </li>
                                    <li class="iconDel"><a href="/Announce/Delete/16">删除</a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                </table>
                
<!--MvcPager 1.5 for ASP.NET MVC 3.0 © 2009-2011 Webdiyer (http://www.webdiyer.com)-->
<div><a disabled="disabled">首页</a>&nbsp;&nbsp;<a disabled="disabled">上一页</a>&nbsp;&nbsp;1&nbsp;&nbsp;<a disabled="disabled">下一页</a>&nbsp;&nbsp;<a disabled="disabled">尾页</a></div>
<!--MvcPager 1.5 for ASP.NET MVC 3.0 © 2009-2011 Webdiyer (http://www.webdiyer.com)-->

                <!-- End of  #contentlist -->
            </div>
        </div>


					</div>
					<div class="rightbox">
						<br />
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
									<li>
										<a href="#">创建用户</a>
									</li>
									<li>
										<a href="#">用户管理</a>
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
