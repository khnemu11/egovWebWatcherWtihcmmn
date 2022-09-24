package egovframework.com.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmmn.CommonServiceImpl;
import egovframework.com.login.service.LoginVO;
import egovframework.com.user.service.UserService;
import egovframework.com.user.service.UserVO;


@Service("userService")
public class UserServiceImpl extends CommonServiceImpl implements UserService {
	@Resource(name = "userDAO")
	private UserDAO userDAO;
	
	@Override
	public long selectUserEmail(UserVO vo) throws Exception {
		return userDAO.selectUserEmail(vo);
	}

	@Override
	public long selectUserEmailUpdate(UserVO vo) throws Exception {
		return userDAO.selectUserEmail(vo);
	}

	@Override
	public long selectUserLoginId(LoginVO vo) throws Exception {
		return userDAO.selectUserLoginId(vo);
	}

	@Override
	public long selectUserLoginIdUpdate(LoginVO vo) throws Exception {
		return userDAO.selectUserLoginIdUpdate(vo);
	}

	@Override
	public long selectUserSeq(UserVO vo) throws Exception {
		return userDAO.selectUserSeq(vo);
	}

	@Override
	public int insertTuser(UserVO vo) throws Exception {
		return userDAO.insertTuser(vo);
	}

	@Override
	public int insertTarclogin(LoginVO vo) throws Exception {
		return userDAO.insertTarclogin(vo);
	}

	@Override
	public long selectUserListCount(UserVO vo) throws Exception {
		return userDAO.selectUserListCount(vo);
	}

	@Override
	public List<Map<String, String>> selectUserList(UserVO vo) throws Exception {
		return userDAO.selectUserList(vo);
	}

	@Override
	public int updateTuser(UserVO vo) throws Exception {
		return userDAO.updateTuser(vo);
	}

	@Override
	public int updateTarclogin(LoginVO vo) throws Exception {
		return userDAO.updateTarclogin(vo);
	}

	@Override
	public int deleteTuser(UserVO vo) throws Exception {
		return userDAO.deleteTuser(vo);
	}

	@Override
	public int deleteTarclogin(LoginVO vo) throws Exception {
		return userDAO.deleteTarclogin(vo);
	}
}
