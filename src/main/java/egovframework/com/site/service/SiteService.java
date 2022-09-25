package egovframework.com.site.service;

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
public interface SiteService {
	
	/**
	 * site을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SiteVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    void insertSite(SiteVO vo) throws Exception;
    
    /**
	 * site을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SiteVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSite(SiteVO vo) throws Exception;
    
    /**
	 * site을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SiteVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSite(SiteVO vo) throws Exception;
    
    /**
	 * site을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SiteVO
	 * @return 조회한 site
	 * @exception Exception
	 */
    SiteVO selectSite(SiteVO vo) throws Exception;
    
    /**
	 * site 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return site 목록
	 * @exception Exception
	 */
    List<?> selectSiteList(DefaultVO searchVO) throws Exception;
    
    List<?> selectSiteListBySeq(SiteVO vo) throws Exception;
    /**
	 * site 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return site 총 갯수
	 * @exception
	 */
    int selectSiteListTotCnt(DefaultVO searchVO);

	int selectSiteListBySeqTotCnt(DefaultVO searchVO);
    
}
