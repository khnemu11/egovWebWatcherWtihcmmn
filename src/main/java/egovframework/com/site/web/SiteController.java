package egovframework.com.site.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.dsjdf.jdf.Logger;

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
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=SiteVO.class)
public class SiteController {

    @Resource(name = "siteService")
    private SiteService siteService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * site 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SiteDefaultVO
	 * @return "/site/SiteList"
	 * @exception Exception
	 */
    @RequestMapping(value="/site/SiteList.do")
    public String selectSiteList(@ModelAttribute("searchVO") SiteDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
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
        System.out.println("site size : "+siteList.size());
        model.addAttribute("resultList", siteList);
        
        int totCnt = siteService.selectSiteListTotCnt(searchVO);
        System.out.println("total count : "+totCnt);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        System.out.println("end site list");
        return "egovframework/com/site/SiteList";
    } 
    
    @RequestMapping("/site/addSiteView.do")
    public String addSiteView(
            @ModelAttribute("searchVO") SiteDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("siteVO", new SiteVO());
        return "egovframework/com/site/SiteRegister";
    }
    
    @RequestMapping("/site/addSite.do")
    public String addSite(
            SiteVO siteVO,
            @ModelAttribute("searchVO") SiteDefaultVO searchVO, SessionStatus status)
            throws Exception {
        siteService.insertSite(siteVO);
        status.setComplete();
        return "forward:/site/SiteList.do";
    }
    
    @RequestMapping("/site/updateSiteView.do")
    public String updateSiteView(
            @RequestParam("seq") int seq ,
            @ModelAttribute("searchVO") SiteDefaultVO searchVO, Model model)
            throws Exception {
        SiteVO siteVO = new SiteVO();
        siteVO.setSeq(seq);        
        // 변수명은 CoC 에 따라 siteVO
        model.addAttribute(selectSite(siteVO, searchVO));
        return "egovframework/com/site/SiteRegister";
    }

    @RequestMapping("/site/selectSite.do")
    public @ModelAttribute("siteVO")
    SiteVO selectSite(
            SiteVO siteVO,
            @ModelAttribute("searchVO") SiteDefaultVO searchVO) throws Exception {
        return siteService.selectSite(siteVO);
    }

    @RequestMapping("/site/updateSite.do")
    public String updateSite(
            SiteVO siteVO,
            @ModelAttribute("searchVO") SiteDefaultVO searchVO, SessionStatus status)
            throws Exception {
        siteService.updateSite(siteVO);
        status.setComplete();
        return "forward:/site/SiteList.do";
    }
    
    @RequestMapping("/site/deleteSite.do")
    public String deleteSite(
            SiteVO siteVO,
            @ModelAttribute("searchVO") SiteDefaultVO searchVO, SessionStatus status)
            throws Exception {
        siteService.deleteSite(siteVO);
        status.setComplete();
        return "forward:/site/SiteList.do";
    }

}
