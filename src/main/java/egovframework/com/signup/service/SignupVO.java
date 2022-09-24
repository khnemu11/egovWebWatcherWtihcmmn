package egovframework.com.signup.service;

import egovframework.com.cmmn.CommonVO;

public class SignupVO extends CommonVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long seq;
    private String email;
    private String url;
    private String captcha;
    
    public long getSeq() {
        return seq;
    }
    public void setSeq(long seq) {
        this.seq = seq;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCaptcha() {
        return captcha;
    }
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
