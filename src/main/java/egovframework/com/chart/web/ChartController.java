package egovframework.com.chart.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.chart.service.ChartService;
import egovframework.com.chart.service.ChartVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.rte.fdl.property.EgovPropertyService;

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
@SessionAttributes({ "userSeq", "siteSeq" })
public class ChartController {
	Logger logger = LogManager.getRootLogger();

	@Resource(name = "EgovFileMngService")
	private EgovFileMngService fileMngService;

	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;

	@Resource(name = "chartService")
	private ChartService chartService;
//	@Resource(name = "siteService")
//	private SiteService siteService;

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
	@RequestMapping(value = "/chart/chartDatePick/{siteSeq}.do")
	public String selectChartDatePick(@PathVariable("siteSeq") int siteSeq, Model model,
			@SessionAttribute("userSeq") int userSeq) throws Exception {
		logger.info("start select site list");
		/** EgovPropertyService.sample */

		model.addAttribute("siteSeq", siteSeq);
		logger.info("user seq : " + userSeq);
		logger.info("site seq : " + siteSeq);
		logger.info("end select site list");

		return "egovframework/com/chart/ChartDatePick";
	}

	@RequestMapping(value = "/chart/chartLoad.do")
	public ModelAndView selectChartLoad(@RequestParam(value = "from") String from,
			@RequestParam(value = "to") String to, @SessionAttribute("siteSeq") int siteSeq, Model model)
			throws Exception {
		logger.info("start chartLoad ");
		/** EgovPropertyService.sample */

		ChartVO searchVO = new ChartVO();

		searchVO.setFrom(from.replace("-", ""));
		searchVO.setTo(to.replace("-", ""));
		searchVO.setSiteSeq(siteSeq);
		logger.info("from "+searchVO.getFrom()+" to "+searchVO.getTo());
		
		List<ChartVO> dataList = chartService.selectChartList(searchVO);
		logger.info(dataList.toString());
		for (int i = 0; i < dataList.size(); i++) {
			String date = String.valueOf(dataList.get(i).getCdate());
			String time = String.valueOf(dataList.get(i).getCtime());

			LocalDateTime localdatetime = LocalDateTime.parse(date + time.substring(0, 6),
					DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			logger.info(localdatetime.toString());
			dataList.get(i).setTime(localdatetime.toString());
		}

		logger.info(dataList.toString());
		ModelAndView jsonView = new ModelAndView("jsonView");

		jsonView.addObject("data", dataList);

		logger.info("end chartLoad");

		return jsonView;
	}
}
