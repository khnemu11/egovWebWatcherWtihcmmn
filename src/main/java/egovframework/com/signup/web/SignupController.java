package egovframework.com.signup.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.signup.service.SignupService;
import egovframework.com.user.service.UserService;
import egovframework.com.user.service.UserVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SignupController {
	@Resource(name = "signupService")
	SignupService signupService;
	
	@Resource(name = "userService")
	UserService userService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	
	@RequestMapping("/signup.do")
	public String signupInput(Model m) {
		
		
		return "egovframework/com/signup/signupInputForUser";
	}
	
	
	@RequestMapping(value = "/signupOk.do", method=RequestMethod.POST)
	public String registerOk(UserVO user) throws Exception {
		String returnUrl = "";
		
		// TODO: SQLException 처리
		int insertTuser = signupService.insertTuser(user);
		long userSeq = userService.selectUserSeq(user);
		user.setSeq(userSeq);
		int insertTarclogin = signupService.insertTarclogin(user);
		
				
				
		if(insertTuser > 0 && insertTarclogin > 0) {
			return "redirect:/login.do";
		}else {
			returnUrl = "signupfail";
		}
		
		return returnUrl;
	}
}
