package com.logistics.singletest;

import java.util.List;

import org.junit.Test;

import com.logistics.mapper.MenuMapper;
import com.logistics.model.MenuInfo;

public class menuTest {
	@Test
	public void test(){
		MenuMapper mm=new MenuMapper();
		List<MenuInfo> ml=mm.getTopMenu(0);
		for(MenuInfo m:ml){
			System.out.println(m.getMenuContent());
		}
	}
}
