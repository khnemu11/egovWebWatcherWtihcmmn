package egovframework.com.chart.service;

import java.util.List;
import egovframework.com.site.service.DefaultVO;
import egovframework.com.site.service.SiteVO;

/**
 * @Class Name : SiteService.java
 * @Description : Site Business class
 * @Modification Information
 *
 * @author 김수현
 * @since 2022-09-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ChartService {
    /**
	 * site 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return site 목록
	 * @exception Exception
	 */
    List<ChartVO> selectChartList(ChartVO chartVO) throws Exception;
 
}
