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
		<title>客户管理</title>
		<jsp:include page="../shared/manager_headtitle.jsp"></jsp:include>
		<link href="<%=basePath%>content/bootstrap/bootstrap.min.css"
			rel="stylesheet">
		<link href="<%=basePath%>content/css/content.css" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../shared/manager_head.jsp"></jsp:include>
		<div class="manager_main">
			<div class="content">
				<div class="bigbox">
					<!-- Begin of  #Inner -->
					<div class="contentBox2">
						
							<div class="contentBoxTop2">
								<h3>
									${companyInfo.company_name}
								</h3>
							</div>
							<div class="innerContent">
								<div>
									<div>
										客户ID:
										<span>${companyInfo.company_id}</span>
									</div>
									<div>
										客户代码:
										<span>${companyInfo.company_code}</span>
									</div>
									<div>
										客户许可证号:
										<span>${companyInfo.company_license}</span>
									</div>
									<div>
										客户地址:
										<span>${companyInfo.company_address}</span>
									</div>
									<div>
										客户联系方式:
										<span>${companyInfo.company_tel}</span>
									</div>
									<div>
										客户公司性质:
										<span>${companyInfo.company_content}</span>
									</div>
								</div>
		
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
