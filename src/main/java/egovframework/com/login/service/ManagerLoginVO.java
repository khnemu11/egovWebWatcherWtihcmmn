package egovframework.com.login.service;

import egovframework.com.cmmn.CommonVO;

public class ManagerLoginVO extends CommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginId;
    private String dispname;
    private Long staffSeq;
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getDispname() {
        return dispname;
    }
    public void setDispname(String dispname) {
        this.dispname = dispname;
    }
    public Long getStaffSeq() {
        return staffSeq;
    }
    public void setStaffSeq(Long staffSeq) {
        this.staffSeq = staffSeq;
    }
}
