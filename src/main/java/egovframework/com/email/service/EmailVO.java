package egovframework.com.email.service;

import org.springframework.web.multipart.MultipartFile;

import egovframework.com.cmm.CommonVO;

/**
 * @Class Name : SiteVO.java
 * @Description : Site VO class
 * @Modification Information
 *
 * @author 김수현
 * @since 2022*09-24
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */
public class EmailVO extends CommonVO {
	private static final long serialVersionUID = 1L;

	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailVO [email=" + email + "]";
	}

}
