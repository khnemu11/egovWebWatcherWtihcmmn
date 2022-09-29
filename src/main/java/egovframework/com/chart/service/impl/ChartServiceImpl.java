package egovframework.com.chart.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
        SiteService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(ChartServiceImpl.class);

//    @Resource(name="siteMapper")
//    private SiteMapper siteDAO;
//    
	@Resource(name = "chartDAO")
	private ChartDAO chartDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSiteIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * site을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SiteVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertSite(SiteVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	setInsert(vo);
    	chartDAO.insertSite(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
    }

    /**
	 * site을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SiteVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSite(SiteVO vo) throws Exception {
    	setUpdate(vo);
        chartDAO.updateSite(vo);
    }

    /**
	 * site을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SiteVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSite(SiteVO vo) throws Exception {
    	setDelete(vo);
        chartDAO.deleteSite(vo);
    }

    /**
	 * site을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SiteVO
	 * @return 조회한 site
	 * @exception Exception
	 */
    public SiteVO selectSite(SiteVO vo) throws Exception {
        SiteVO resultVO = chartDAO.selectSite(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * site 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return site 목록
	 * @exception Exception
	 */
    public List<?> selectSiteList(DefaultVO searchVO) throws Exception {
    	LOGGER.info("dao start");
        return chartDAO.selectSiteList(searchVO);
    }

    /**
	 * site 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return site 총 갯수
	 * @exception
	 */
    public int selectSiteListTotCnt(DefaultVO searchVO) {
		return chartDAO.selectSiteListTotCnt(searchVO);
	}

	@Override
	public List<?> selectSiteListBySeq(SiteVO vo) throws Exception {
		return chartDAO.selectSiteListBySeq(vo);
	}


	public int selectSiteListBySeqTotCnt(DefaultVO searchVO) {
		return chartDAO.selectSiteListBySeqTotCnt(searchVO);
	}
    
}
