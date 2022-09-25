package egovframework.com.site.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.site.service.SiteDefaultVO;
import egovframework.com.site.service.SiteService;
import egovframework.com.site.service.SiteVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : SiteController.java
 * @Description : Site Controller class
 * @Modification Information
 *
 * @author 김수현
 * @since 2022-09-24
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes({ "userSeq" })
public class SiteController {
	Logger logger = LogManager.getRootLogger();

	@Resource(name = "siteService")
	private SiteService siteService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	// bean vaildator
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * site 목록을 조회한다. (pageing)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 SiteDefaultVO
	 * @return "/site/SiteList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/site/SiteList.do")
	public String selectSiteList(@ModelAttribute("searchVO") SiteDefaultVO searchVO, ModelMap model) throws Exception {
		logger.info("start select site list");
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> siteList = siteService.selectSiteList(searchVO);
		logger.info("site size : " + siteList.size());
		model.addAttribute("resultList", siteList);

		int totCnt = siteService.selectSiteListTotCnt(searchVO);
		logger.info("total count : " + totCnt);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		logger.info("end select site list");

		return "egovframework/com/site/SiteList";
	}

	@RequestMapping(value = "/site/SiteList/{userSeq}.do")
	public String selectSiteListBySeq(@PathVariable int userSeq, @ModelAttribute("searchVO") SiteDefaultVO searchVO,
			ModelMap model) throws Exception {
		logger.info("start select site list");
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		searchVO.setSearchKeyword(String.valueOf(userSeq));

		SiteVO vo = new SiteVO();
		vo.setUserSeq(userSeq);

		List<?> siteList = siteService.selectSiteListBySeq(vo);
		logger.info("site size : " + siteList.size());
		model.addAttribute("resultList", siteList);
		model.addAttribute("userSeq", userSeq);
		int totCnt = siteService.selectSiteListBySeqTotCnt(vo);
		logger.info("total count : " + totCnt);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		logger.info("end select site list");

		return "egovframework/com/site/SiteList";
	}

	@RequestMapping("/site/addSiteView.do")
	public String addSiteView(@ModelAttribute("searchVO") SiteDefaultVO searchVO, Model model, @SessionAttribute("userSeq") int userSeq)
			throws Exception {
		logger.info("addSiteView Start");
		model.addAttribute("siteVO", new SiteVO());
		logger.info("siteVO : " + (new SiteVO()).toString());
		logger.info("addSiteView End");
		return "egovframework/com/site/SiteRegister";
	}

	@RequestMapping("/site/addSite.do")
	public String addSite(@ModelAttribute("siteVO") SiteVO siteVO, SessionStatus status,
			@SessionAttribute("userSeq") int userSeq, BindingResult bindingResult, Model model) throws Exception {
		logger.info("addSite Start");
		siteVO.setFileName(
				siteVO.getFile().getOriginalFilename().length() == 0 ? null : siteVO.getFile().getOriginalFilename());
		logger.info(siteVO.toString());

		beanValidator.validate(siteVO, bindingResult);
		if (bindingResult.hasErrors()) {
			logger.info("field error");

			model.addAttribute("searchVO", siteVO);

			return "egovframework/com/site/SiteRegister";
		}

		siteVO.setUserSeq(userSeq);
//		siteService.insertSite(siteVO);
//		status.setComplete();

		logger.info("addSite end");
		return "forward:/site/SiteList/" + userSeq + ".do";
	}

	@RequestMapping("/site/updateSiteView.do")
	public String updateSiteView(@RequestParam("seq") int seq, @ModelAttribute("searchVO") SiteDefaultVO searchVO,
			Model model) throws Exception {
		SiteVO siteVO = new SiteVO();
		siteVO.setSeq(seq);
		// 변수명은 CoC 에 따라 siteVO
		model.addAttribute(selectSite(siteVO, searchVO));
		return "egovframework/com/site/SiteRegister";
	}

	@RequestMapping("/site/selectSite.do")
	public @ModelAttribute("siteVO") SiteVO selectSite(SiteVO siteVO,
			@ModelAttribute("searchVO") SiteDefaultVO searchVO) throws Exception {
		return siteService.selectSite(siteVO);
	}

	@RequestMapping("/site/updateSite.do")
	public String updateSite(SiteVO siteVO, @ModelAttribute("searchVO") SiteDefaultVO searchVO, SessionStatus status)
			throws Exception {
		siteService.updateSite(siteVO);
		status.setComplete();
		return "forward:/site/SiteList.do";
	}

	@RequestMapping("/site/deleteSite.do")
	public String deleteSite(SiteVO siteVO, @ModelAttribute("searchVO") SiteDefaultVO searchVO, SessionStatus status)
			throws Exception {
		siteService.deleteSite(siteVO);
		status.setComplete();
		return "forward:/site/SiteList.do";
	}

}
