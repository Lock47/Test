package com.logistics.singletest;


import org.junit.Test;

import com.logistics.mapper.MenuMapper;


public class validatemenutest {
	@Test
	public void test(){
		MenuMapper mm=new MenuMapper();
		if(mm.validateMenu(0, "admin/index")){
			System.out.println("有权限访问");
		}
		else{
			System.out.println("无权限访问");
		}
	}
}
