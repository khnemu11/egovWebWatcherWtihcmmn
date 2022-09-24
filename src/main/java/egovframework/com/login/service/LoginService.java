package egovframework.com.login.service;

import java.util.List;

public interface LoginService {
	public long selectLoginSeq(LoginVO vo) throws Exception;
	public List<LoginVO> selectLogin(LoginVO vo) throws Exception;
	public long selectLoginCheck(LoginVO vo) throws Exception;
	public int updateLoginFail(LoginVO vo) throws Exception;
}
