<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<script type="text/javascript">

</script>


		<title>客户查询</title>

		<script src="<%=basePath%>content/js/jquery.min.js"></script>
		<script src="<%=basePath%>content/js/bootstrap.min.js"></script>


		<jsp:include page="../shared/manager_headtitle.jsp"></jsp:include>
		<body>
			<jsp:include page="../shared/manager_head.jsp"></jsp:include>
			<div class="manager_main">
				<div class="content">
					<div class="leftbox">
						<!-- Begin of  #contentlist -->
						<div class="contentBox">
							<div class="contentBoxTop">
								<h3>
									查询客户
								</h3>
							</div>
							<div class="innerContent" style="height: 120px">
								<form action="<%=basePath%>customer/query"
									method="post">
									<tr>
										<div class="Select"
											style="float: left; margin-top: 5px; margin-left: 10px">
											<select class="selectpicker" name="select_type">
												<option>
													ID
												</option>
												<option>
													Tel
												</option>
												<option>
													Email
												</option>
											</select>
										</div>
										<div class="form-group"
											style="float: left; padding-left: 20px">
											<input type="text" class="form-control" id="SelectType"
												placeholder="Enter Type" name="select_text" />
										</div>
									</tr>
									<button type="submit" class="btn btn-default"
										style="margin-left: 20px">
										查询
									</button>
								</form>
							</div>
						</div>
					</div>
					<jsp:include page="../shared/manager_siderbar.jsp"></jsp:include>
				</div>
			</div>
			<jsp:include page="../shared/manager_footer.jsp"></jsp:include>

		</body>
</html>
