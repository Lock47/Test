package com.logistics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/system")
public class ManagerController {
	@RequestMapping("/")
	public String Index() {
		return "redirect:/system/index";
	}

	// ��ҳ
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/index");
		//��ȡ�����Ͳ���
		
		//��ȡϵͳ��Ϣ
		return view;
	}
}
