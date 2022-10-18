package egovframework.com.login.service;

public interface LoginService {
	public long selectLoginSeq(LoginVO vo) throws Exception;

	public LoginVO selectLogin(LoginVO vo) throws Exception;

	public long selectLoginCheck(LoginVO vo) throws Exception;

	public int updateLoginFail(LoginVO vo) throws Exception;
}
