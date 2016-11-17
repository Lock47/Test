package com.logistics.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.mapper.CityMapper;
import com.logistics.model.CityInfo;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	CityMapper cm = new CityMapper();

	// 测试页面
	@RequestMapping("/index")
	public String Index(HttpServletRequest request) {
		// 初始化下拉菜单
		List<CityInfo> citylist = cm.getCityList();
		List<CityInfo> arealist = cm.getAreaByCityId(1);
		request.setAttribute("citylist", citylist);
		request.setAttribute("arealist", arealist);
		return "test/index";
	}

	@ResponseBody
	@RequestMapping(value = "/getAreaJsonDataByCityId", produces = "application/json")
	private List<CityInfo> getCityList(int city_id) {
		// 转化成json数据
		List<CityInfo> ci = cm.getAreaByCityId(city_id);
		return ci;
	}

	// 分页测试
	@RequestMapping("/list")
	public String test(Model model,
			@RequestParam(required = false) String searchInfo,
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false) Integer pageSize) {
		// 我们这里四个参数分别为装载我们数据的model，条件查询内容，当前所在页码，每页显示多少行
		// 创建Map，来存放我们的数据，
		Map<String, Object> map = new HashMap<String, Object>();
		// 这里的searchInfo是查询方法 在这里用不到，比如我们需要根据条件来查询我们的数据，这个就需要了
		// 其实这个searchInfo就是我们动态查询时的查询条件，这里无用
		map.put("searchInfo", searchInfo);

		// 取出数据总数，
		Integer totalCount = cm.getCityTotal();

		// 初始化分页数据，map对应的model，pageNum对应当前页，pageSize为每页显示的数据，totalCount为数据总行数
		this.initPage(map, pageNum, pageSize, totalCount);
		System.out.println(pageNum);
		System.out.println(pageSize);
		System.out.println(totalCount);

		// list为我们的需要显示的数据List ，获取的返回值是我们常用的List<实体类>形式
		List list = cm.getCityMap(map);
		// list为我们的需要显示的数据List
		// 初始化结果
		this.initResult(model, list, map);

		return "test/testListPager";
	}

}
