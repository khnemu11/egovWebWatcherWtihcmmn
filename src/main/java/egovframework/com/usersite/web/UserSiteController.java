package egovframework.com.usersite.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.login.service.LoginService;
import egovframework.com.login.service.LoginVO;
import egovframework.com.site.service.SiteService;
import egovframework.com.user.service.UserService;
import egovframework.com.usersite.service.UserSiteService;
import egovframework.com.usersite.service.UserSiteVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class UserSiteController {
	@Resource(name = "userSiteService")
	UserSiteService userSiteService;

	@Resource(name = "userService")
	UserService userService;
	
	@Resource(name = "siteService")
	SiteService siteService;
	
	@Resource(name = "userLoginService")
	LoginService loginService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	Logger logger = LogManager.getRootLogger();

	@RequestMapping(value = "/user/userSite.do")
	public String UserSite(@ModelAttribute("userSiteVO") UserSiteVO userSiteVO, ModelMap model) throws Exception {
//		// 미인증 사용자에 대한 보안처리
//		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
//		if (!isAuthenticated) {
//			return "index";
//		}
		logger.info(userSiteVO.getSearchCondition() + " " + userSiteVO.getSearchKeyword());
		/** EgovPropertyService */
		userSiteVO.setPageUnit(propertiesService.getInt("pageUnit"));
		userSiteVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(userSiteVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(userSiteVO.getPageUnit());
		paginationInfo.setPageSize(userSiteVO.getPageSize());

		userSiteVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		userSiteVO.setLastIndex(paginationInfo.getLastRecordIndex());
		userSiteVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> userSiteList = userSiteService.selectUserSiteList(userSiteVO);
		logger.info(userSiteService.selectUserSiteList(userSiteVO));
		logger.info("hello " + userSiteList);
		model.addAttribute("resultList", userSiteList);

		int totCnt = userSiteService.selectSiteListTotCnt(userSiteVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "egovframework/com/usersite/UserList";
	}

	@RequestMapping("/user/userDelete.do")
	public String deleteUser(@RequestParam("checkedIdForDel") String checkedIdForDel,
			@ModelAttribute("userSiteVO") UserSiteVO userSiteVO, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
//		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
//		if (!isAuthenticated) {
//			return "index";
//		}
		logger.info("delete");
		userSiteService.deleteUser(checkedIdForDel, userSiteVO);
		userSiteService.deleteLogin(checkedIdForDel, userSiteVO);
		userSiteService.deleteSite(checkedIdForDel, userSiteVO);
		
		// Exception 없이 진행시pageTitle 등록성공메시지
		model.addAttribute("resultMsg", "success.common.delete");
		return "forward:/user/userSite.do";
	}
	
	// 특정 유저 정보
	@RequestMapping("/user/userInfo.do")
	public String updateUserView(@RequestParam("userSeq") String seq, @ModelAttribute("userSiteVO") UserSiteVO userSiteVO, Model model) throws Exception {

		// 미인증 사용자에 대한 보안처리
//		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
//		if (!isAuthenticated) {
//			return "index";
//		}
		logger.info("hhh");
		
		userSiteVO.setSeq(Integer.parseInt(seq));
		userSiteVO = userSiteService.selectUserUseSeq(userSiteVO);
		model.addAttribute("userSiteVO", userSiteVO);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setUserSeq(Integer.parseInt(seq));
		
		loginVO = loginService.selectLoginId(loginVO);
		userSiteVO.setLoginId(loginVO.getLoginId());
		
		return "egovframework/com/usersite/UserInfo";
	}
	
	// 유저 업데이트
	@RequestMapping("/user/userUpdate.do")
	public String updateUser(@ModelAttribute("userSiteVO") UserSiteVO userSiteVO, BindingResult bindingResult, Model model, RedirectAttributes rttr) throws Exception {

//		// 미인증 사용자에 대한 보안처리
//		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
//		if (!isAuthenticated) {
//			return "index";
//		}
		logger.info("bb");
		beanValidator.validate(userSiteVO, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.info("error");
			return "egovframework/com/usersite/UserInfo";
		} else {
			logger.info("no error");
			userSiteService.updateUser(userSiteVO);
			LoginVO loginVO = new LoginVO();
			loginVO.setPassword(userSiteVO.getPassword());
			loginVO.setDispname(userSiteVO.getDispname());
			userSiteService.updateLogin(loginVO);
			
			//Exception 없이 진행시 수정성공메시지
			rttr.addFlashAttribute("resultMsg", "success.common.update");
			
			return "redirect:/user/userSite.do";
		}
	}
}
