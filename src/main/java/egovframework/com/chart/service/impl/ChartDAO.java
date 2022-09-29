package egovframework.com.chart.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.chart.service.ChartVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

/**
 * @Class Name : SiteDAO.java
 * @Description : Site DAO Class
 * @Modification Information
 *
 * @author 김수현
 * @since 2022*09-24
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Repository("chartDAO")
public class ChartDAO extends EgovComAbstractDAO {
	public List<ChartVO> selectChartList(ChartVO chartVO) throws Exception {
		return selectList("chartDAO.selectChartList", chartVO);
	}

}
