<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>添加客户</title>
		<link rel="stylesheet" type="text/css" href="content/css/contract.css" />
		<script src="<%=basePath%>content/js/jquery.min.js"
			type="text/javascript"></script>
		<jsp:include page="../shared/manager_headtitle.jsp"></jsp:include>

		<script type="text/javascript">
	
</script>
	</head>
	<body>
		<jsp:include page="../shared/manager_head.jsp"></jsp:include>
		<div class="manager_main">
			<div class="content">
				<div class="leftbox">
					<!-- Begin of  #contentlist -->
					<div class="contentBox">
						<div class="contentBoxTop">
							<h3>
								添加客户
							</h3>

						</div>
						<div class="innerContent">
							<form action="<%=basePath%>customer/createCustomer" method="post">
								<table class="sysTable" style="text-align: left;">
									<tr>
										<td class="sTitle">
											<span class="important">*</span>客户ID:
											<td>
												<input type="text" name="company_id" style="width: 200px;" />
											</td>
										</td>
										<td>
											<span class="important">*</span>客户名称:
											<td>
												<input type="text" name="company_name" style="width: 200px;" />
											</td>
										</td>

									</tr>
									<tr>
										<td>
											<span class="important">*</span>客户CODE:
											<td>
												<input type="text" name="company_code" style="width: 200px;" />
											</td>
										</td>
									</tr>
									<tr>
										<tr>
											<td class="sTitle">
												<span class="important">*</span>客户公司许可证号:
												<td>
													<input type="text" name="company_license"
														style="width: 200px;" />
												</td>
											</td>
											<td>
												<span class="important">*</span>客户公司地址:
												<td>
													<input type="text" name="company_address"
														style="width: 200px;" />
												</td>
											</td>
										</tr>
										<tr>
											<td class="sTitle">
												<span class="important">*</span>客户Tel:
												<td>
													<input type="text" name="company_tel" style="width: 200px;" />
												</td>
											</td>
											<td>
												<span class="important">*</span>客户公司性质:
												<td>
													<input type="text" name="company_content"
														style="width: 200px;" />
												</td>
											</td>
										</tr>
										<tr class="sSubmit">
											<td Colspan="4">
												<input type="submit" class="from_sub" value="保存" />
											</td>
										</tr>
									</tr>
								</table>
							</form>
							<!-- End of  #contentlist -->
						</div>
					</div>
				</div>
				<jsp:include page="../shared/manager_siderbar.jsp"></jsp:include>
			</div>
		</div>
		<jsp:include page="../shared/manager_footer.jsp"></jsp:include>
	</body>
</html>
