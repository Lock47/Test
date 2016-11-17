package com.logistics.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.logistics.interceptor.MemberInterceptor;
import com.logistics.mapper.MenuMapper;
import com.logistics.model.MenuInfo;
import com.logistics.model.UserInfo;
import com.logistics.util.BarcodeHelper;

@Controller
@RequestMapping("/admin")
public class AdminController {

	MenuMapper menuMapper = new MenuMapper();

	@RequestMapping("/")
	public String Index() {
		return "redirect:/admin/index";
	}

	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserInfo u = (UserInfo) session
				.getAttribute(MemberInterceptor.SESSION_MEMBER);

		String logname = u.getManager_name();
		int roleid = u.getRole_id();

		ModelAndView view = new ModelAndView("admin/index");

		List<MenuInfo> menulist = menuMapper.getTopMenu(roleid);

		view.addObject("menulist", menulist);

		view.addObject("welcome", logname);

		return view;
	}

//	@RequestMapping("/testcode")
//	public String testcode(HttpServletRequest request) throws IOException {
//		// ModelAndView view=new ModelAndView("admin/codetest");
//
//		String myCode = "TR0220101X090001";
//
//		String mypath = "upload\\code";
//
//		String path = BarcodeHelper.createBarCode15(request, mypath, myCode);
//
//		System.out.println(path);
//
//		return "admin/codetest";
//	}

}
