/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.com.cmmn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : SampleDefaultVO.java
 * @Description : SampleDefaultVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class CommonServiceImpl extends EgovAbstractServiceImpl {

	public void setInsert(CommonVO sample) {
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HHmmss");
		
		sample.setCdate(Integer.valueOf(now.format(dateformat)));		
		sample.setCtime(Integer.valueOf(now.format(timeformat)));
	}
	public void setUpdate(CommonVO sample) {
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HHmmss");
		
		sample.setUdate(Integer.valueOf(now.format(dateformat)));		
		sample.setUtime(Integer.valueOf(now.format(timeformat)));
	}
	public void setDelete(CommonVO sample) {
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMMdd");
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HHmmss");
		
		sample.setDdate(Integer.valueOf(now.format(dateformat)));		
		sample.setDtime(Integer.valueOf(now.format(timeformat)));
	}
}
