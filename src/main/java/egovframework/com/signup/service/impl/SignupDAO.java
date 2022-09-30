package egovframework.com.signup.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.signup.service.SignupVO;
import egovframework.com.user.service.UserVO;

@Repository("signupDAO")
public class SignupDAO extends EgovComAbstractDAO {
	
	public int insertTuser (UserVO vo) throws Exception {
		int result = insert("SignupDAO.insertTuser", vo);
		return result;
	}
	
	public int insertTarclogin (UserVO vo) throws Exception {
		int result = insert("SignupDAO.insertTarclogin", vo);
		return result;
	}
	
	public long selectSignupEmail (SignupVO vo) throws Exception{
		long result = selectOne("SignupDAO.selectSignupEmail", vo);
		return result;
	}
	
	public long selectUserEmail (SignupVO vo) throws Exception{
		long result = selectOne("SignupDAO.selectUserEmail", vo);
		return result;
	}
	
	public long selectUserLoginId (UserVO vo) throws Exception{
		long result = selectOne("SignupDAO.selectUserLoginId", vo);
		return result;
	}
	
	public long selectUserSeq (SignupVO vo) throws Exception{
		long result = selectOne("SignupDAO.selectUserSeq", vo);
		return result;
	}
	
}
