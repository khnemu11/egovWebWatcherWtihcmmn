package egovframework.com.usersite.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.CommonServiceImpl;
import egovframework.com.login.service.LoginVO;
import egovframework.com.usersite.service.UserSiteService;
import egovframework.com.usersite.service.UserSiteVO;
import egovframework.com.utl.fcc.service.EgovStringUtil;

@Service("userSiteService")
public class UserSiteServiceImpl extends CommonServiceImpl implements UserSiteService{
	@Resource(name="userSiteDAO")
	UserSiteDAO userSiteDAO;
		
	@Override
	public List<UserSiteVO> selectUserSiteList(UserSiteVO userSiteVO) throws Exception {
		return userSiteDAO.selectUserSiteList(userSiteVO);
	}
	
	@Override
	public int selectSiteListTotCnt(UserSiteVO userSiteVO) throws Exception {
		return userSiteDAO.selectSiteListTotCnt(userSiteVO);
	}

	@Override
	public void deleteUser(String checkedIdForDel, UserSiteVO userSiteVO) throws Exception {
		String [] delId = EgovStringUtil.isNullToString(checkedIdForDel).split(",");
		for (int i=0; i<delId.length ; i++){
			String [] id = delId[i].split(":");
			int seq = Integer.parseInt(id[0]);
			
			userSiteVO.setSeq(seq);
			setDelete(userSiteVO);
;
			userSiteDAO.deleteUser(userSiteVO);
		}
	}

	@Override
	public void deleteLogin(String checkedIdForDel, UserSiteVO userSiteVO) throws Exception {
		String [] delId = EgovStringUtil.isNullToString(checkedIdForDel).split(",");
		for (int i=0; i<delId.length ; i++){
			String [] id = delId[i].split(":");
			int seq = Integer.parseInt(id[0]);
			
			userSiteVO.setSeq(seq);
			setDelete(userSiteVO);

			userSiteDAO.deleteLogin(userSiteVO);
		}
	}
	@Override
	public void deleteSite(String checkedIdForDel, UserSiteVO userSiteVO) throws Exception {
		String [] delId = EgovStringUtil.isNullToString(checkedIdForDel).split(",");
		for (int i=0; i<delId.length ; i++){
			String [] id = delId[i].split(":");		
			int userSeq = Integer.parseInt(id[0]);
			
			userSiteVO.setUserSeq(userSeq);
			setDelete(userSiteVO);

			userSiteDAO.deleteSite(userSiteVO);
		}
	}

	@Override
	public UserSiteVO selectUserUseSeq(UserSiteVO userSiteVO) throws Exception {
		return userSiteDAO.selectUserUseSeq(userSiteVO);
	}

	@Override
	public void updateUser(UserSiteVO userSiteVO) throws Exception {
		userSiteDAO.updateUser(userSiteVO);
	}

	@Override
	public void updateLogin(LoginVO loginVO) throws Exception {
		userSiteDAO.updateLogin(loginVO);		
	}
}
