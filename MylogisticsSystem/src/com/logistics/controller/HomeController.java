package com.logistics.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
// 代表当前action全部在根目录下
public class HomeController {
	// 设置首页
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("index");
		view.addObject("welcome", "hello mvc");
		request.setAttribute("home", "hello mvc");
		// index=index.jsp
		return view;
	}

}
