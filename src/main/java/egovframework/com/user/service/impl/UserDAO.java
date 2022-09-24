package egovframework.com.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.login.service.LoginVO;
import egovframework.com.user.service.UserVO;

@Repository("userDAO")
public class UserDAO extends EgovComAbstractDAO {

	public long selectUserEmail(UserVO vo) throws Exception {
		long result = selectOne("UserDAO.selectSignupEmail", vo);
		return result;
	}
	
	public long selectUserEmailUpdate(UserVO vo) throws Exception {
		long result = selectOne("UserDAO.selectUserEmailUpdate", vo);
		return result;
	}
	
	public long selectUserLoginId(LoginVO vo) throws Exception {
		long result = selectOne("UserDAO.selectUserLoginId", vo);
		return result;
	}
	
	public long selectUserLoginIdUpdate(LoginVO vo) throws Exception {
		long result = selectOne("UserDAO.selectUserLoginIdUpdate", vo);
		return result;
	}
	
	public long selectUserSeq(UserVO vo) throws Exception {
		long result = selectOne("UserDAO.selectUserSeq", vo);
		return result;
	}
	
	public int insertTuser(UserVO vo) throws Exception {
		int result = selectOne("UserDAO.insertTuser", vo);
		return result;
	}

	public int insertTarclogin(LoginVO vo) throws Exception {
		int result = selectOne("UserDAO.insertTarclogin", vo);
		return result;
	}
	

	
	
	
	public long selectUserListCount(UserVO vo) throws Exception {
		long result = selectOne("UserDAO.selectUserListCount", vo);
		return result;
	}
	
	List<Map<String, String>> selectUserList(UserVO vo) throws Exception {
		List<Map<String, String>> result = selectList("UserDAO.selectUserList", vo);
		return result;
	}
	
	public int updateTuser(UserVO vo) throws Exception {
		int result = selectOne("UserDAO.updateTuser", vo);
		return result;
	}
	
	public int updateTarclogin(LoginVO vo) throws Exception {
		int result = selectOne("UserDAO.updateTarclogin", vo);
		return result;
	}

	public int deleteTuser(UserVO vo) throws Exception {
		int result = selectOne("UserDAO.deleteTuser", vo);
		return result;
	}

	public int deleteTarclogin(LoginVO vo) throws Exception {
		int result = selectOne("UserDAO.deleteTarclogin", vo);
		return result;
	}
	
	
}
