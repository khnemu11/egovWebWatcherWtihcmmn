package egovframework.com.chart.service;

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
public class ChartVO extends CommonVO {
	private static final long serialVersionUID = 1L;

	private long siteSeq;
	private String result;
	private long resptime;
	private String resultText;
	private String from;
	private String to;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public long getSiteSeq() {
		return siteSeq;
	}

	public void setSiteSeq(long siteSeq) {
		this.siteSeq = siteSeq;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getResptime() {
		return resptime;
	}

	public void setResptime(long resptime) {
		this.resptime = resptime;
	}

	public String getResultText() {
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

}
