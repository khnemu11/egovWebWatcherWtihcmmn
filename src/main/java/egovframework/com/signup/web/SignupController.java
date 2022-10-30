package egovframework.com.signup.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.login.service.LoginService;
import egovframework.com.signup.service.SignupService;
import egovframework.com.user.service.UserService;
import egovframework.com.user.service.UserVO;
import egovframework.com.uss.umt.service.EgovUserManageService;
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

	@Resource(name = "userManageService")
	private EgovUserManageService userManageService;

	Logger logger = LogManager.getRootLogger();

	@RequestMapping("/signup/{emailAuth}.do")
	public String signupInput(@PathVariable int emailAuth, @ModelAttribute("userVO") UserVO userVO, Model m,
			HttpSession session) {
		try {
			if (session.getAttribute("emailAuth") == null || !session.getAttribute("emailAuth").equals(emailAuth)) {
				return "egovframework/com/error/invalidAccess";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "egovframework/com/error/invalidAccess";
		}
		return "egovframework/com/signup/signupInputForUser";
	}

	@RequestMapping(value = "/signup/signupOk.do", method = RequestMethod.POST)
	public String registerOk(@ModelAttribute("userVO") UserVO userVO, BindingResult bindingResult, Model m,
			HttpSession session) throws Exception {
		String returnUrl = "";

		beanValidator.validate(userVO, bindingResult);
		if (bindingResult.hasErrors()) {
			return "egovframework/com/signup/signupInputForUser";
		}

		// login 아이디가 중복되지 않는지 확인
		long usedCnt = signupService.selectUserLoginId(userVO);
		if (usedCnt > 0) {
			m.addAttribute("error", "signup.login.id.duplicate");
			return "egovframework/com/signup/signupInputForUser";
		}

		// password와 passwordConfirm 비교
		if (!userVO.getPassword().equals(userVO.getPasswordConfirm())) {
			m.addAttribute("error", "signup.password.validate.different");
			return "egovframework/com/signup/signupInputForUser";
		}

		// 비밀번호 암호화
		String enPassword = EgovFileScrty.encryptPassword(userVO.getPassword(), userVO.getLoginId());
		String enPasswordConfirm = EgovFileScrty.encryptPassword(userVO.getPasswordConfirm(), userVO.getLoginId());

		userVO.setPassword(enPassword);
		userVO.setPasswordConfirm(enPasswordConfirm);

		// TODO: SQLException 처리, transaction 해야
		int insertTuser = signupService.insertTuser(userVO);
		try {
			long userSeq = userService.selectUserSeq(userVO);
			userVO.setSeq(userSeq);
			int insertTarclogin = signupService.insertTarclogin(userVO);
			signupService.insertTarclogin(userVO);
			
			if (insertTuser > 0 && insertTarclogin > 0) {
				return "redirect:/login.do";
			} else {
				returnUrl = "signupfail";
			}
			
			signupService.insertUserAuth(userVO.getSeq());
			
			if (session.getAttribute("emailAuth") != null) {
				session.removeAttribute("emailAuth");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "egovframework/com/error/invalidAccess";
		}

		return returnUrl;
	}

	@RequestMapping(value = "/signup/checkLoginIdDplctAjax.do")
	public ModelAndView checkLoginIdDplctAjax(@ModelAttribute("loginVO") UserVO userVO,
			@RequestParam Map<String, Object> commandMap) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");

		String loginId = (String) commandMap.get("loginId");
		logger.info(loginId);
		userVO.setLoginId(loginId);
		// checkId = new String(checkId.getBytes("ISO-8859-1"), "UTF-8");

		long usedCnt = signupService.selectUserLoginId(userVO);
		modelAndView.addObject("usedCnt", usedCnt);

		return modelAndView;
	}

}
