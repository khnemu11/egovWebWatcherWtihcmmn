/*
site.url * Copyright 2008-2009 the original author or authors.
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

import org.apache.commons.lang3.builder.ToStringBuilder;

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
public class CommonVO extends SampleDefaultVO {

	/**
	 *  serialVersion UID
	 */
	private static final long serialVersionUID = -858838578081269359L;

	private long seq;
	private int cdate;
	private int ctime;
	private int udate;
	private int utime;
	private int ddate;
	private int dtime;
	private int version;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long userSeq) {
		this.seq = userSeq;
	}

	public int getCdate() {
		return cdate;
	}

	public void setCdate(int cdate) {
		this.cdate = cdate;
	}

	public int getCtime() {
		return ctime;
	}

	public void setCtime(int ctime) {
		this.ctime = ctime;
	}

	public int getUdate() {
		return udate;
	}

	public void setUdate(int udate) {
		this.udate = udate;
	}

	public int getUtime() {
		return utime;
	}

	public void setUtime(int utime) {
		this.utime = utime;
	}

	public int getDdate() {
		return ddate;
	}

	public void setDdate(int ddate) {
		this.ddate = ddate;
	}

	public int getDtime() {
		return dtime;
	}

	public void setDtime(int dtime) {
		this.dtime = dtime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
