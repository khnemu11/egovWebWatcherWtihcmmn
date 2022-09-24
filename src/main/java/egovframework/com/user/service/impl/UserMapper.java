package egovframework.com.user.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.com.cmm.LoginVO;
import egovframework.com.user.service.UserVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("userMapper")
public interface UserMapper {
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
