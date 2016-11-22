package com.logistics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.logistics.interceptor.MemberInterceptor;
import com.logistics.mapper.CityMapper;
import com.logistics.mapper.DepartmentMapper;
import com.logistics.mapper.MenuMapper;
import com.logistics.mapper.UserMapper;
import com.logistics.model.CityInfo;
import com.logistics.model.DepartmentInfo;
import com.logistics.model.MenuInfo;
import com.logistics.model.UserInfo;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {
	MenuMapper menuMapper = new MenuMapper();
	CityMapper citym = new CityMapper();
	DepartmentMapper dm = new DepartmentMapper();
	UserMapper userm=new UserMapper();

	// 默认首页
	@RequestMapping("/")
	public String Index() {

		return "redirect:department/index";
	}

	// 首页
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		// 初始化菜单
		String view = initMenu(request, "department/index");

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
		List<MenuInfo> siderlist = menuMapper.getSecondMenu(role_id, 6);
		// 将取到的数据传递到前端页面，使用jstl调用
		request.setAttribute("menulist", menulist);
		request.setAttribute("siderlist", siderlist);
		// 登录的用户名放入这个对象中，传递给前端
		request.setAttribute("welcome", logname);
		request.setAttribute("manager_id", manager_id);

		return pager;
	}

	// 新增二级分拣中心
	@RequestMapping("/addcenter")
	public String addcenter(HttpServletRequest request) {
		// 初始化菜单
		String view = initMenu(request, "department/addcenter");
		// 初始化城市下拉列表
		// 初始化下拉菜单
		List<CityInfo> citylist = citym.getCityList();
		List<CityInfo> arealist = citym.getAreaByCityId(1);
		List<UserInfo> userlist=userm.getNoSetCenterManagerList();
		request.setAttribute("citylist", citylist);
		request.setAttribute("arealist", arealist);
		request.setAttribute("userlist", userlist);
		
		return view;
	}

	// 新增二级分拣中心数据提交
	@RequestMapping("/createCenter")
	public String createCenter(DepartmentInfo ci) {
		// 创建成功后跳转的页面地址
		String view = "redirect:/department/managercenter";
		// 添加数据
		if (dm.createCenter(ci)) {
			// 创建成功
			JOptionPane.showMessageDialog(null, "创建成功!");
		} else {
			// 创建失败
			JOptionPane.showMessageDialog(null, "创建失败!");
		}
		return view;
	}

	// 管理二级分拣中心
	@RequestMapping("/managercenter")
	public String managercenter(HttpServletRequest request, Model model,
			@RequestParam(required = false) String searchInfo,
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize) {
		// 初始化菜单
		String view = initMenu(request, "department/managercenter");
		// 添加分页相关信息
		// 创建Map，来存放我们的数据，
		Map<String, Object> map = new HashMap<String, Object>();
		// 其实这个searchInfo就是我们动态查询时的查询条件，这里无用
		map.put("searchInfo", searchInfo);
		// 取出数据总数，
		Integer totalCount = dm.getCenterAndManagerListCount();
		// 初始化分页数据，map对应的model，pageNum对应当前页，pageSize为每页显示的数据，totalCount为数据总行数
		this.initPage(map, pageNum, pageSize, totalCount);
		// list为我们的需要显示的数据List ，获取的返回值是我们常用的List<实体类>形式
		List list = dm.getCenterList(map);//getCenterAndManagerList(map);
		// list为我们的需要显示的数据List
		// 初始化结果
		this.initResult(model, list, map);
		return view;
	}
}
