package egovframework.com.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmmn.CommonServiceImpl;
import egovframework.com.login.service.LoginService;
import egovframework.com.login.service.LoginVO;

@Service("userLoginService")
public class LoginServiceImpl extends CommonServiceImpl implements LoginService {
	@Resource(name = "userLoginDAO")
	private LoginDAO loginDAO;

	@Override
	public long selectLoginSeq(LoginVO vo) throws Exception {
		return loginDAO.selectLoginSeq(vo);
	}

	@Override
	public LoginVO selectLogin(LoginVO vo) throws Exception {
		return loginDAO.selectLogin(vo);
	}

	@Override
	public long selectLoginCheck(LoginVO vo) throws Exception {
		return loginDAO.selectLoginCheck(vo);
	}

	@Override
	public int updateLoginFail(LoginVO vo) throws Exception {
		setUpdate(vo);
		return loginDAO.updateLoginFail(vo);
	}

	@Override
	public LoginVO selectLoginId(LoginVO vo) throws Exception {
		return loginDAO.selectLoginId(vo);
	}


}
