package egovframework.com.login.service.impl;

import java.util.List;

import egovframework.com.login.service.LoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userLoginMapper")
public interface LoginMapper {
	int selectLoginSeq(LoginVO vo) throws Exception;
	
	List<LoginVO> selectLogin(LoginVO vo) throws Exception;
	
	long selectLoginCheck(LoginVO vo) throws Exception;
		
	int updateLoginFail(LoginVO vo) throws Exception;
}
