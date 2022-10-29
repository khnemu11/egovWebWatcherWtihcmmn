package egovframework.com.filter.service;

public interface AuthFilterService {
	public long selectRole(AuthVO authVO);
	public String selectAuth(AuthVO authVo);
}
