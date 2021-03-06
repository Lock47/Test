package com.logistics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.logistics.interceptor.MemberInterceptor;
import com.logistics.mapper.CompanyMapper;
import com.logistics.mapper.MenuMapper;
import com.logistics.mapper.UserMapper;
import com.logistics.model.AnnounceInfo;
import com.logistics.model.CompanyInfo;
import com.logistics.model.ContractInfo;
import com.logistics.model.MenuInfo;
import com.logistics.model.UserInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
	// 引入常用的方法对象并实例化
	MenuMapper menuMapper = new MenuMapper();
	CompanyMapper cm = new CompanyMapper();
	UserMapper userm = new UserMapper();

	// 首页
	@RequestMapping("/")
	public String Index() {
		return "redirect:/customer/index";
	}

	// 管理首页
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		// 获取session内的用户信息
		HttpSession session = request.getSession();
		UserInfo u = (UserInfo) session
				.getAttribute(MemberInterceptor.SESSION_MEMBER);
		String logname = u.getManager_name();
		int role_id = u.getRole_id();
		// 注意这里的index.jsp在admin文件夹下的
		ModelAndView view = new ModelAndView("customer/index");
		// 测试生成菜单，默认权限为1-总管理员
		List<MenuInfo> menulist = menuMapper.getTopMenu(role_id);
		List<MenuInfo> siderlist = menuMapper.getSecondMenu(role_id, 2);
		// 将取到的数据传递到前端页面，使用jstl调用
		view.addObject("menulist", menulist);
		view.addObject("siderlist", siderlist);
		// 登录的用户名放入这个对象中，传递给前端
		view.addObject("welcome", logname);

		return view;
	}

	public String initMenu(HttpServletRequest request, String pager) {
		// 获取session内的用户信息
		HttpSession session = request.getSession();
		UserInfo u = (UserInfo) session
				.getAttribute(MemberInterceptor.SESSION_MEMBER);
		// 登录管理用户名
		String logname = u.getManager_name();
		int role_id = u.getRole_id();
		int manager_id = u.getManager_id();
		// ModelAndView view;
		// 权限判断
		if (!menuMapper.validateMenu(role_id, "admin/index")) {
			// 无权访问
			// view =new ModelAndView("error/503");
			return "redirect:/error/503";
		}

		// 测试生成菜单，默认权限为1-总管理员
		List<MenuInfo> menulist = menuMapper.getTopMenu(role_id);
		List<MenuInfo> siderlist = menuMapper.getSecondMenu(role_id, 2);
		// 将取到的数据传递到前端页面，使用jstl调用
		request.setAttribute("menulist", menulist);
		request.setAttribute("siderlist", siderlist);
		// 登录的用户名放入这个对象中，传递给前端
		request.setAttribute("welcome", logname);
		request.setAttribute("manager_id", manager_id);

		return pager;
	}

	// 新增客户
	@RequestMapping("/addcustomer")
	public String addcenter(HttpServletRequest request) {
		// 初始化菜单
		String view = initMenu(request, "customer/addcustomer");

		List<UserInfo> userlist = userm.getNoSetCenterManagerList();

		request.setAttribute("userlist", userlist);

		return view;
	}

	// 新增客户
	@RequestMapping("/createCustomer")
	public String addcenter(CompanyInfo ci) {
		// 初始化菜单
		String view = "redirect:/customer/managecustomer";
		// 添加数据
		if (cm.createCompany(ci)) {
			// 创建成功
			JOptionPane.showMessageDialog(null, "创建成功!");
			return view;
		} else {
			// 创建失败
			JOptionPane.showMessageDialog(null, "创建失败!");
			return "redirect:/customer/addcustomer";
		}
	}

	// 管理合同
	@RequestMapping("/managecustomer")
	public String managercenter(HttpServletRequest request, Model model,
			@RequestParam(required = false) String searchInfo,
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize) {
		// 初始化菜单
		String view = initMenu(request, "customer/managecustomer");
		// 添加分页相关信息
		// 创建Map，来存放我们的数据，
		Map<String, Object> map = new HashMap<String, Object>();
		// 其实这个searchInfo就是我们动态查询时的查询条件，这里无用
		map.put("searchInfo", searchInfo);
		// 取出数据总数，
		Integer totalCount = cm.getCompanyListCount();
		// 初始化分页数据，map对应的model，pageNum对应当前页，pageSize为每页显示的数据，totalCount为数据总行数
		this.initPage(map, pageNum, pageSize, totalCount);
		// list为我们的需要显示的数据List ，获取的返回值是我们常用的List<实体类>形式
		List list = cm.getCompanyList(map);
		// list为我们的需要显示的数据List
		// 初始化结果
		this.initResult(model, list, map);
		return view;
	}

	// 删除客户数据
	@RequestMapping("/delData")
	public String delCompanyInfo(HttpServletRequest request, CompanyInfo ci) {
		// 删除成功后跳转的页面地址
		String view = "redirect:/customer/managecustomer";
		// 删除数据
		int companyid = Integer.valueOf(request.getParameter("id"));
		if (cm.delCompanyInfo(companyid)) {
			// 删除成功
			JOptionPane.showMessageDialog(null, "删除成功!");
			return view;
		} else {
			// 删除失败
			JOptionPane.showMessageDialog(null, "删除失败!");
			return "redirect:/customer/managecustomer";
		}
	}

	// 查询客户
	@RequestMapping("/querycustomer")
	public String Querycustomer(HttpServletRequest request) {
		// 初始化菜单
		String view = initMenu(request, "customer/querycustomer");

		List<UserInfo> userlist = userm.getNoSetCenterManagerList();
		request.setAttribute("userlist", userlist);

		return view;
	}

	@RequestMapping("/query")
	public String Query(HttpServletRequest request, Model model,
			@RequestParam(required = false) String searchInfo,
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize) {
		// 初始化菜单
		String view = initMenu(request, "customer/queryres");

		List<UserInfo> userlist = userm.getNoSetCenterManagerList();
		request.setAttribute("userlist", userlist);

		Map<String, Object> map = new HashMap<String, Object>();
		// 其实这个searchInfo就是我们动态查询时的查询条件，这里无用
		map.put("searchInfo", searchInfo);

		Integer totalCount = cm.getCompanyListCount();
		// 初始化分页数据，map对应的model，pageNum对应当前页，pageSize为每页显示的数据，totalCount为数据总行数
		this.initPage(map, pageNum, pageSize, totalCount);
		// list为我们的需要显示的数据List ，获取的返回值是我们常用的List<实体类>形式

		String type = request.getParameter("select_type");
		String text = request.getParameter("select_text");

		if (type.equals("ID")) {
			List list = cm.getCompanyListByID(text);// getContractList(map);
			// list为我们的需要显示的数据List
			// 初始化结果
			this.initResult(model, list, map);
			return view;
		} else if (type.equals("Tel")) {
			List list = cm.getCompanyListByTel(text);// getContractList(map);
			// list为我们的需要显示的数据List
			// 初始化结果
			this.initResult(model, list, map);
			return view;
		} else if (type.equals("Email")) {
			JOptionPane.showMessageDialog(null, "没有客户邮箱!");
			view = initMenu(request, "customer/querycustomer");
			return view;
		}
		return view;
	}
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model,
			@RequestParam(required = false) String searchInfo) {
		// 初始化菜单
		String view = initMenu(request, "customer/detail");
		int id =Integer.valueOf(request.getParameter("id"));
		
		CompanyInfo ci = cm.getCompanyInfo(id);
		request.setAttribute("companyInfo", ci);
		return view;
	}
	
	//根据id更新页面
	@RequestMapping("/update/{id}")
	public String update(HttpServletRequest request,@PathVariable int id){
		//初始化菜单
		String view=initMenu(request, "customer/update");
		//加载我的更新的数据
		CompanyInfo ci = cm.getCompanyInfo2(id);
		request.setAttribute("companyInfo", ci);
		
		return view;
	}
	
	//执行更新方法
	@RequestMapping("/updatedata")
	public String updateData(CompanyInfo ci){
		String view = "";
		//执行更新方法
		if(cm.updateCompany(ci)){
			//更新成功执行操作
			JOptionPane.showMessageDialog(null, "更新成功!");
			view="redirect:/customer/managecustomer";
		}
		else
		{
			JOptionPane.showMessageDialog(null, "更新失败!");
			view="redirect:/customer/managecustomer";
		}
		return view;
	}
}
