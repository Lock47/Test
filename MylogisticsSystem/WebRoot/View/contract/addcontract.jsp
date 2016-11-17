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
<title>添加合同</title>
<link rel="stylesheet" type="text/css" href="content/css/contract.css"/>
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
						<h3>添加合同</h3>
						
					</div>
					<div class="innerContent">
					<form action="<%=basePath%>contract/createContract" method="post">
						<table class="sysTable" style="text-align: left;">
				        <tr>
				        	<td class="sTitle"><span class="important">*</span>合同ID:
				        		<td>
				        			<input type="text" name="contract_id" style="width: 200px;" />
				        		</td>
				        	</td>
				        	<td><span class="important">*</span>合同名称:
				        		<td>
				        			<input type="text" name="contract_name" style="width: 200px;" />
				        		</td>
				        	</td>
				        	
				        </tr>
				        <tr>
				        	<td><span class="important">*</span>合同金额:
				        		<td>
				        			<input type="text" name="contract_money" style="width: 200px;" />
				        		</td>
				        	</td>
				        </tr>
				        
				        <tr>
				        	<td class="sTitle"><span class="important">*</span>合同内容:</td>
				        	<td colspan="3"> 
				        		<textarea id="contract_content" name="contract_content"  style="width:500px; height:200px;">
				        		</textarea>
							</td>
				        </tr>
				        <tr>
				        <tr>
				        	<td class="sTitle"><span class="important">*</span>托运方:
				        		<td>
				        			<input type="text" name="contract_customer" style="width: 200px;" />
				        		</td>
				        	</td>
				        	<td><span class="important">*</span>承运方:
				        		<td>
				        			<input type="text" name="contract_carrier" style="width: 200px;" />
				        		</td>
				        	</td>
				        </tr>
				        				        <tr>
				        	<td class="sTitle"><span class="important">*</span>托运方Tel:
				        		<td>
				        			<input type="text" name="contract_customertel" style="width: 200px;" />
				        		</td>
				        	</td>
				        	<td><span class="important">*</span>承运方Tel:
				        		<td>
				        			<input type="text" name="contract_carriertel" style="width: 200px;" />
				        		</td>
				        	</td>
				        </tr>
				        <tr>
				        	<td class="sTitle"><span class="important">*</span>签订时间:
				        	   <td>
				        	   <input name="contract_signdate" type="text" value="2016-11-15"/>
				        	   </td>
				        	</td>
				        	<td class="sTitle"><span class="important">*</span>到期时间:
				        	   <td>
				        	   <input name="contract_duedate" type="text" value="2017-11-15"/>
				        	   </td>
				        	</td>
				        </tr>
				        <tr class="sSubmit">
								<td Colspan="4"><input type="submit" class="from_sub"
									value="保存" /></td>
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
