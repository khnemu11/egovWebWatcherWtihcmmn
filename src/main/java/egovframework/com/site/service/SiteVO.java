package egovframework.com.site.service;

import org.springframework.web.multipart.MultipartFile;

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
public class SiteVO extends SiteDefaultVO {
	private static final long serialVersionUID = 1L;

	/** seq */
	private int seq;

	/** user_seq */
	private int userSeq;

	/** url */
	private java.lang.String url;

	/** version */
	private java.lang.String version;

	/** file_name */
	private java.lang.String fileName;

	/** file_path */
	private java.lang.String fileId;

	/** ctime */
	private int ctime;

	/** cdate */
	private int cdate;

	/** utime */
	private int utime;

	/** udate */
	private int udate;

	/** dtime */
	private int dtime;

	/** ddate */
	private int ddate;

	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getUserSeq() {
		return this.userSeq;
	}

	public void setUserSeq(int userSeq2) {
		this.userSeq = userSeq2;
	}

	public java.lang.String getUrl() {
		return this.url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.String getVersion() {
		return this.version;
	}

	public void setVersion(java.lang.String version) {
		this.version = version;
	}

	public java.lang.String getFileName() {
		return this.fileName;
	}

	public void setFileName(java.lang.String fileName) {
		this.fileName = fileName;
	}

	public java.lang.String getFileId() {
		return this.fileId;
	}

	public void setFileId(java.lang.String filePath) {
		this.fileId = filePath;
	}

	public int getCtime() {
		return this.ctime;
	}

	public void setCtime(int ctime) {
		this.ctime = ctime;
	}

	public int getCdate() {
		return this.cdate;
	}

	public void setCdate(int cdate) {
		this.cdate = cdate;
	}

	public int getUtime() {
		return this.utime;
	}

	public void setUtime(int utime) {
		this.utime = utime;
	}

	public int getUdate() {
		return this.udate;
	}

	public void setUdate(int udate) {
		this.udate = udate;
	}

	public int getDtime() {
		return this.dtime;
	}

	public void setDtime(int dtime) {
		this.dtime = dtime;
	}

	public int getDdate() {
		return this.ddate;
	}

	public void setDdate(int ddate) {
		this.ddate = ddate;
	}

	@Override
	public String toString() {
		return "SiteVO [seq=" + seq + ", userSeq=" + userSeq + ", url=" + url + ", version=" + version + ", fileName="
				+ fileName + ", fileID=" + fileId + ", ctime=" + ctime + ", cdate=" + cdate + ", utime=" + utime
				+ ", udate=" + udate + ", dtime=" + dtime + ", ddate=" + ddate + ", file=" + file + "]";
	}

}
