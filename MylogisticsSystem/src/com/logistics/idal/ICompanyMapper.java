package com.logistics.idal;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.logistics.model.CompanyInfo;

public interface ICompanyMapper {
    
	@Select("CALL getCompanyInfo()")
	@Options(statementType = StatementType.CALLABLE)
	public CompanyInfo getCompanyInfo();
}
