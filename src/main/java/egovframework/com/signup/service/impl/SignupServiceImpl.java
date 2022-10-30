package egovframework.com.signup.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmmn.CommonServiceImpl;
import egovframework.com.signup.service.SignupService;
import egovframework.com.signup.service.SignupVO;
import egovframework.com.user.service.UserVO;

@Service("signupService")
public class SignupServiceImpl extends CommonServiceImpl implements SignupService{
	@Resource(name = "signupDAO")
	private SignupDAO signupDAO;

	@Override
	public int insertTuser(UserVO vo) throws Exception {
		setInsert(vo);
		return signupDAO.insertTuser(vo);
	}

	@Override
	public int insertTarclogin(UserVO vo) throws Exception {
		setInsert(vo);
		return signupDAO.insertTarclogin(vo);
	}

	@Override
	public Long selectSignupEmail(SignupVO vo) throws Exception {
		return signupDAO.selectSignupEmail(vo);
	}

	@Override
	public Long selectUserEmail(SignupVO vo) throws Exception {
		return signupDAO.selectUserEmail(vo);

	}

	@Override
	public Long selectUserLoginId(UserVO vo) throws Exception {
		return signupDAO.selectUserLoginId(vo);

	}

	@Override
	public Long selectUserSeq(SignupVO vo) throws Exception {
		return signupDAO.selectUserSeq(vo);

	}

	@Override
	public int insertUserAuth(long seq) throws Exception {
		return signupDAO.insertTuserAuth(seq);
	}

}
