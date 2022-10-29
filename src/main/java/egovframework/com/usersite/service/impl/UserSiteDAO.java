package egovframework.com.usersite.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.login.service.LoginVO;
import egovframework.com.usersite.service.UserSiteVO;

@Repository("userSiteDAO")
public class UserSiteDAO extends EgovComAbstractDAO {
	public List<UserSiteVO> selectUserSiteList(UserSiteVO userSiteVO) throws Exception {
		List<UserSiteVO> result = selectList("UserSiteDAO.selectUserSiteList", userSiteVO);
		return result;
	}

	public int selectSiteListTotCnt(UserSiteVO userSiteVO) throws Exception {
		int result = selectOne("UserSiteDAO.selectSiteListTotCnt", userSiteVO);
		return result;
	}

	public void deleteUser(UserSiteVO userSiteVO) throws Exception {
		
		update("UserSiteDAO.deleteUser", userSiteVO);
	}

	public void deleteLogin(UserSiteVO userSiteVO) throws Exception {
		update("UserSiteDAO.deleteLogin", userSiteVO);
	}

	public void deleteSite(UserSiteVO userSiteVO) throws Exception {
		update("UserSiteDAO.deleteSite", userSiteVO);
	}
	
	public UserSiteVO selectUserUseSeq(UserSiteVO userSiteVO) throws Exception{
		return selectOne("UserSiteDAO.selectUserUseSeq", userSiteVO);
	}
	
	public void updateUser(UserSiteVO userSiteVO) throws Exception{
		update("UserSiteDAO.updateUser", userSiteVO);
	}
	
	public void updateLogin(LoginVO loginVO) throws Exception{
		update("UserSiteDAO.updateLogin", loginVO);
	}
}
