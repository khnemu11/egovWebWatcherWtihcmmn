package egovframework.com.login.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.login.service.LoginVO;

@Repository("userLoginDAO")
public class LoginDAO extends EgovComAbstractDAO {
	public long selectLoginSeq(LoginVO vo) {
		return selectOne("UserLoginDAO.selectLoginSeq", vo);
	}
	
	public LoginVO selectLogin(LoginVO vo) {
		return selectOne("UserLoginDAO.selectLogin", vo);
	}
	
	public long selectLoginCheck(LoginVO vo) {
		return selectOne("UserLoginDAO.selectLoginCheck", vo);
	}
	
	public int updateLoginFail(LoginVO vo) {
		return update("UserLoginDAO.updateLoginFail", vo);
	}
	
	public LoginVO selectLoginId(LoginVO vo) {
		return selectOne("UserLoginDAO.selectLoginId", vo);
	}
}
