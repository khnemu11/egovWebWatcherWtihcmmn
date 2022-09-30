package egovframework.com.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
import egovframework.com.login.service.ManagerLoginService;
import egovframework.com.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class LoginController {
	@Resource(name = "userLoginService")
	LoginService loginService;
	
	@Resource(name = "managerLoginService")
	ManagerLoginService managerLoginService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	Logger logger = LogManager.getRootLogger();

	
	
	@RequestMapping(value = "/login.do")
	public String login(@ModelAttribute("loginVO") LoginVO loginVO, Model m) {
		
		
		
		return "egovframework/com/login/login";
	}

	@RequestMapping(value = "/loginOk.do", method = RequestMethod.POST)
	public String loginOk(@ModelAttribute("loginVO") LoginVO loginVO, BindingResult bindingResult, Model m, HttpSession session) throws Exception {
		if(session.getAttribute("userSeq") != null) {
			session.removeAttribute("userSeq");
		}
		
		beanValidator.validate(loginVO, bindingResult);
		if(bindingResult.hasErrors()) {
			return "egovframework/com/login/login";
		}

		
		String returnUrl = "";
		
		// 비밀번호 암호
		String enPassword = EgovFileScrty.encryptPassword(loginVO.getPassword(), loginVO.getLoginId());
		loginVO.setPassword(enPassword);
		
		// 로그인 검사 
		long count = loginService.selectLoginCheck(loginVO);
		if(count > 0) {
			long userSeq = loginService.selectLoginSeq(loginVO);
			session.setAttribute("userSeq", userSeq);
			returnUrl = "redirect:/site/SiteList/" + userSeq + ".do";
		}else {
			returnUrl = "logfail";
		}
		
		return returnUrl;
	}
	
	
	
	@RequestMapping(value = "/managerlogin.do")
	public String managerLogin(Model m) {
		
		return "egovframework/com/login/managerlogin";
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("userSeq");
		return "egovframework/com/login/login";
	}
}
