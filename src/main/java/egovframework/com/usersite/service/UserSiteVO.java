package egovframework.com.usersite.service;

import egovframework.com.cmm.CommonVO;

public class UserSiteVO extends CommonVO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// UserVO
	private int seq;
	private String keyword;
    private String email;
	private String name;
    private String dispname;
    private String company;
    private String tel;
    private String language;
    private String loginId;
    private String password;
    private String passwordConfirm;
	
	
    // SiteVO
	/** user_seq */
	private long userSeq;
	/** url */
	private java.lang.String url;
	/** file_name */
	private java.lang.String fileName;
	/** file_path */
	private java.lang.String fileId;

	
	
    public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDispname() {
		return dispname;
	}
	public void setDispname(String dispname) {
		this.dispname = dispname;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public long getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(long userSeq) {
		this.userSeq = userSeq;
	}
	public java.lang.String getUrl() {
		return url;
	}
	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	public java.lang.String getFileName() {
		return fileName;
	}
	public void setFileName(java.lang.String fileName) {
		this.fileName = fileName;
	}
	public java.lang.String getFileId() {
		return fileId;
	}
	public void setFileId(java.lang.String fileId) {
		this.fileId = fileId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
