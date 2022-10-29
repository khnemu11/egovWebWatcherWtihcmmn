package egovframework.com.filter.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmmn.CommonServiceImpl;
import egovframework.com.filter.service.AuthFilterService;
import egovframework.com.filter.service.AuthVO;
import oracle.net.aso.a;

@Service("authService")
public class AuthFilterServiceImpl extends CommonServiceImpl implements AuthFilterService{
	@Resource(name = "authDAO")
	AuthDAO authDAO;

	@Override
	public long selectRole(AuthVO authVO) {
		if(authVO.getAuth().equals("ROLE_USER")) {
			return authDAO.selectUserRole(authVO);
		}
		else if(authVO.getAuth().equals("ROLE_ADMIN")){
			return authDAO.selectAdminRole(authVO);
		}
		else{
			return authDAO.selectAnonymousRole(authVO);
		}
	}

	@Override
	public String selectAuth(AuthVO authVo) {
		return authDAO.selectAuth(authVo);
	}


}
