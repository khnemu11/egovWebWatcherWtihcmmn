package egovframework.com.user.service;

import java.util.List;
import java.util.Map;

import egovframework.com.login.service.LoginVO;

public interface UserService {
	long selectUserEmail(UserVO vo) throws Exception;
	
	long selectUserEmailUpdate(UserVO vo) throws Exception;
	
	long selectUserLoginId(LoginVO vo) throws Exception;
	
	long selectUserLoginIdUpdate(LoginVO vo) throws Exception;

	long selectUserSeq(UserVO vo) throws Exception;
	
	int insertTuser(UserVO vo) throws Exception;

	int insertTarclogin(LoginVO vo) throws Exception;

	
	
	long selectUserListCount(UserVO vo) throws Exception;

	List<Map<String, String>> selectUserList(UserVO vo) throws Exception;

	int updateTuser(UserVO vo) throws Exception;
	
	int updateTarclogin(LoginVO vo) throws Exception;

	int deleteTuser(UserVO vo) throws Exception;

	int deleteTarclogin(LoginVO vo) throws Exception;
}
