package egovframework.com.chart.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.chart.service.ChartService;
import egovframework.com.chart.service.ChartVO;
import egovframework.com.cmm.CommonServiceImpl;
import egovframework.com.site.service.DefaultVO;
import egovframework.com.site.service.SiteService;
import egovframework.com.site.service.SiteVO;
/**
 * @Class Name : SiteServiceImpl.java
 * @Description : Site Business Implement class
 * @Modification Information
 *
 * @author 김수현
 * @since 2022-09-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("chartService")
public class ChartServiceImpl extends CommonServiceImpl implements
        ChartService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ChartServiceImpl.class);
  
	@Resource(name = "chartDAO")
	private ChartDAO chartDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSiteIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;


	@Override
	public List<ChartVO> selectChartList(ChartVO chartVO) throws Exception {
		return chartDAO.selectChartList(chartVO);
	}
    
}
