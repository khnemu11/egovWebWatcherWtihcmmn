package egovframework.com.signup.web;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.login.service.LoginService;
import egovframework.com.login.service.LoginVO;
import egovframework.com.signup.service.SignupService;
import egovframework.com.user.service.UserService;
import egovframework.com.user.service.UserVO;
import egovframework.com.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SignupController {
	@Resource(name = "signupService")
	SignupService signupService;
	
	@Resource(name = "userService")
	UserService userService;
	
	@Resource(name = "userLoginService")
	LoginService loginService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	Logger logger = LogManager.getRootLogger();

	@RequestMapping("/signup.do")
	public String signupInput(@ModelAttribute("userVO") UserVO userVO, Model m) {
		
		
		return "egovframework/com/signup/signupInputForUser";
	}
	
	
	@RequestMapping(value = "/signupOk.do", method = RequestMethod.POST)
	public String registerOk(@ModelAttribute("userVO") UserVO userVO, @ModelAttribute("loginVO") LoginVO loginVO, BindingResult bindingResult, Model m) throws Exception {
		logger.info("start");
		
		beanValidator.validate(userVO, bindingResult);
		if(bindingResult.hasErrors()) {

			return "egovframework/com/signup/signupInputForUser";
		}
		logger.info("end");

		// 1. 비밀번호 암호화 
		String enPassword = EgovFileScrty.encryptPassword(userVO.getPassword(), userVO.getLoginId());
		String enPasswordConfirm = EgovFileScrty.encryptPassword(userVO.getPasswordConfirm(), userVO.getLoginId());
		userVO.setPassword(enPassword);
		userVO.setPasswordConfirm(enPasswordConfirm);
		
		// 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인
		long userCount = loginService.selectLoginCheck(loginVO);
		if(userCount > 0) {
			logger.info("second1");

			m.addAttribute("message", "로그인 아이디가 이미 존재합니다.");
			return "egovframework/com/signup/signupInputForUser";
		}
		
		String password = userVO.getPassword();
		String passwordConfirm = userVO.getPasswordConfirm();
		if(!password.equals(passwordConfirm)) {
			logger.info("second2");

			m.addAttribute("message", "비밀번호와 비밀번호 확인이 같지 않습니다.");
			return "egovframework/com/signup/signupInputForUser";
		}
		logger.info("end");

		String returnUrl = "";
		
		// TODO: SQLException 처리
		int insertTuser = signupService.insertTuser(userVO);
		long userSeq = userService.selectUserSeq(userVO);
		userVO.setSeq(userSeq);
		int insertTarclogin = signupService.insertTarclogin(userVO);
		
		userVO.setPassword("");
		userVO.setPasswordConfirm("");		
				
		if(insertTuser > 0 && insertTarclogin > 0) {
			return "redirect:/login.do";
		}else {
			returnUrl = "signupfail";
		}
		
		return returnUrl;
	}
}
