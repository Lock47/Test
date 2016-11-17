package com.logistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.idal.ICityMapper;
import com.logistics.model.CityInfo;

@Service("CityService")
public class CityService {

	public CityService() {

	}

	@Autowired
	private ICityMapper cityMapper;

	public List<CityInfo> name() {
		return cityMapper.getCityList();
	}
}
