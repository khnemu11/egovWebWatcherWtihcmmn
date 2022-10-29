package egovframework.com.filter.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.filter.service.AuthVO;

@Repository("authDAO")
public class AuthDAO extends EgovComAbstractDAO {
	public long selectAdminRole(AuthVO vo) {
		return selectOne("authDAO.selectAdminRole", vo);
	}
	public long selectUserRole(AuthVO vo) {
		return selectOne("authDAO.selectUserRole", vo);
	}
	public long selectAnonymousRole(AuthVO vo) {
		return selectOne("authDAO.selectAnonymousRole", vo);
	}
	public String selectAuth(AuthVO vo) {
		return selectOne("authDAO.selectAuth", vo);
	}
}
