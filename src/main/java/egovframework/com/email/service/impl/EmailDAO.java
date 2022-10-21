package egovframework.com.email.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.site.service.DefaultVO;
import egovframework.com.site.service.SiteVO;

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

@Repository("emailDAO")
public class EmailDAO extends EgovComAbstractDAO {
	/**
	 * site 총 갯수를 조회한다. @param searchMap - 조회할 정보가 담긴 Map @return site 총
	 * 갯수 @exception
	 */
	public int selectEmailTotCnt(DefaultVO searchVO) {
		return (Integer) selectOne("emailDAO.selectEmailTotCnt", searchVO);
	}

}
