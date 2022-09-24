package egovframework.com.login.service.impl;

import java.util.List;

import egovframework.com.login.service.ManagerLoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("managerLoginMapper")
public interface ManagerLoginMapper {
	List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) throws Exception;
}
