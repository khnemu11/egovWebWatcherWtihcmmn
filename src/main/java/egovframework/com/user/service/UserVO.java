package egovframework.com.user.service;

import egovframework.com.cmmn.CommonVO;

public class UserVO extends CommonVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String keyword;
    private String email;
    private String name;
    private String dispName;
    private String company;
    private String tel;
    private String language;
    private String loginId;
    private String password;
    private String passwordConfirm;
    /*
    private String gender;
    private long dob;
    private int dobYear;
    private int dobMonth;
    private int dobDay;
     */

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
    public String getDispName() {
        return dispName;
    }
    public void setDispName(String dispName) {
        this.dispName = dispName;
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
}
