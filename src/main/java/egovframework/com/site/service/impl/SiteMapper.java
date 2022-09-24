package egovframework.com.site.service.impl;

import java.util.List;

import egovframework.com.site.service.SiteVO;
import egovframework.com.site.service.SiteDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : SiteMapper.java
 * @Description : Site Mapper Class
 * @Modification Information
 *
 * @author 김수현
 * @since 2022*09-24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("siteMapper")
public interface SiteMapper {

	/**
	 * site을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SiteVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertSite(SiteVO vo) throws Exception;

    /**
	 * site을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SiteVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSite(SiteVO vo) throws Exception;

    /**
	 * site을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SiteVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSite(SiteVO vo) throws Exception;

    /**
	 * site을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SiteVO
	 * @return 조회한 site
	 * @exception Exception
	 */
    public SiteVO selectSite(SiteVO vo) throws Exception;

    /**
	 * site 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return site 목록
	 * @exception Exception
	 */
    public List<?> selectSiteList(SiteDefaultVO searchVO) throws Exception;

    /**
	 * site 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return site 총 갯수
	 * @exception
	 */
    public int selectSiteListTotCnt(SiteDefaultVO searchVO);

}
