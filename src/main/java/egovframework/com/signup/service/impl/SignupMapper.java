package egovframework.com.signup.service.impl;

import egovframework.com.signup.service.SignupVO;
import egovframework.com.user.service.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("signupMapper")
public interface SignupMapper {
	int insertTuser(UserVO vo) throws Exception;
	
	int insertTarclogin(UserVO vo) throws Exception;
	
	long selectSignupEmail(SignupVO vo) throws Exception;
	
	long selectUserEmail(SignupVO vo) throws Exception;
	
	long selectUserLoginId(SignupVO vo) throws Exception;
	
	long selectUserSeq(SignupVO vo) throws Exception;
}
