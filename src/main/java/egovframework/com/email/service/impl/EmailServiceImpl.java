package egovframework.com.email.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.CommonServiceImpl;
import egovframework.com.email.service.EmailService;
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
 *      Copyright (C) All right reserved.
 */

@Service("emailService")
public class EmailServiceImpl extends CommonServiceImpl implements EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Resource(name = "emailDAO")
	private EmailDAO siteDAO;

	@Override
	public int selectEmailTotCnt(DefaultVO searchVO) {
		return siteDAO.selectEmailTotCnt(searchVO);
	}

}
