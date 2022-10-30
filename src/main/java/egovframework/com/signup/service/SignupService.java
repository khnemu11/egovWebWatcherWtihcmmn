package egovframework.com.signup.service;

import egovframework.com.user.service.UserVO;

public interface SignupService {
	public int insertTuser (UserVO vo) throws Exception;
	
	public int insertTarclogin (UserVO vo) throws Exception;
	
	public int insertUserAuth (long seq) throws Exception;
	
	public Long selectSignupEmail (SignupVO vo) throws Exception;
	
	public Long selectUserEmail (SignupVO vo) throws Exception;
	
	public Long selectUserLoginId (UserVO vo) throws Exception;
	
	public Long selectUserSeq (SignupVO vo) throws Exception;
}
