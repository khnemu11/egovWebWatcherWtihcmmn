package egovframework.com.login.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.login.service.ManagerLoginVO;

@Repository("managerLoginDAO")
public class ManagerLoginDAO extends EgovComAbstractDAO {
	public List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) {
		return selectOne("ManagerLogin.selectManagerLogin", vo);
	}
}
