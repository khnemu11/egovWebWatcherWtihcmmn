package egovframework.com.email.service;

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
public interface EmailService {
	
    int selectEmailTotCnt(DefaultVO searchVO);
}
