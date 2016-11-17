package com.logistics.singletest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.logistics.model.CityInfo;
import com.logistics.service.CityService;

public class validateService {

	private CityService cityService;

	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	@Test
	public void test() {
		List<CityInfo> cl = cityService.name();

		for (CityInfo ci : cl) {
			System.out.println(ci.getCity_name());
		}
	}

}
