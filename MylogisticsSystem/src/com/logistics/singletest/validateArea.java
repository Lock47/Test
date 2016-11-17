package com.logistics.singletest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.logistics.mapper.CityMapper;
import com.logistics.model.CityInfo;

public class validateArea {

	@Test
	public void test() {
		CityMapper cm=new CityMapper();
		List<CityInfo> cl= cm.getAreaByCityId(1);
		for(CityInfo ci:cl){
			System.out.println(ci.getCity_name());
		}
	}

}
