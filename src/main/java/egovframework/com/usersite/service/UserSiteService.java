package egovframework.com.usersite.service;

import java.util.List;

import egovframework.com.login.service.LoginVO;

public interface UserSiteService {
	public List<UserSiteVO> selectUserSiteList(UserSiteVO userSiteVO) throws Exception;

	public int selectSiteListTotCnt(UserSiteVO userSiteVO) throws Exception;
	
	public void deleteUser(String checkedIdForDel, UserSiteVO userSiteVO) throws Exception;
	
	public void deleteLogin(String checkedIdForDel, UserSiteVO userSiteVO) throws Exception;
	
	public void deleteSite(String checkedIdForDel, UserSiteVO userSiteVO) throws Exception;
	
	public UserSiteVO selectUserUseSeq(UserSiteVO userSiteVO) throws Exception;
	
	public void updateUser(UserSiteVO userSiteVO) throws Exception;
	
	public void updateLogin(LoginVO loginVO) throws Exception;
}
