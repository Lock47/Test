<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 引入自定义分页标签 -->
<%@ taglib prefix="page" uri="/mvcPager"%>
<!-- 引入标准标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>合同管理</title>
		<jsp:include page="../shared/manager_headtitle.jsp"></jsp:include>
		<link href="<%=basePath%>content/bootstrap/bootstrap.min.css"
			rel="stylesheet">
		<link href="<%=basePath%>content/css/content.css"
			rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../shared/manager_head.jsp"></jsp:include>
		<div class="manager_main">
			<div class="content">
				<div class="bigbox">
					<!-- Begin of  #Inner -->
					<div class="contentBox2">
					<c:forEach var="cinfo" items="${list}">
						<div class="contentBoxTop2">
							<h3>
								${cinfo.contract_name}
							</h3>
						</div>
						<div class="innerContent">
						
						<span>${cinfo.contract_content}</span></br>
						<div class="righttext">
						<div>
						     托运方:<span>${cinfo.contract_customer}</span>
						</div>
						<div >
						     承运方:<span>${cinfo.contract_carrier}</span>
						</div>
						<div > 
						     签订时间:<span>${cinfo.contract_signdate}</span>
						</div>
						<div >
						     到期时间:<span>${cinfo.contract_duedate}</span>
						</div>
						</div>
						</c:forEach>
						</div>
					</div>
					<!-- End of  #Inner -->
				</div>
			</div>

			<!-- End of  #contentlist -->
		</div>
		</div>
		</div>
		<jsp:include page="../shared/manager_footer.jsp"></jsp:include>
	</body>
</html>
