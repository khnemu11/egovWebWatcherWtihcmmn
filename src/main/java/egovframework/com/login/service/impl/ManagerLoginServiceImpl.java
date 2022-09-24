package egovframework.com.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmmn.CommonServiceImpl;
import egovframework.com.login.service.ManagerLoginService;
import egovframework.com.login.service.ManagerLoginVO;

@Service("managerLoginService")
public class ManagerLoginServiceImpl extends CommonServiceImpl implements ManagerLoginService{
	@Resource(name = "managerLoginDAO")
	ManagerLoginDAO managerLoginDAO;

	@Override
	public List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) throws Exception {
		return managerLoginDAO.selectManagerLogin(vo);
	}	
}
