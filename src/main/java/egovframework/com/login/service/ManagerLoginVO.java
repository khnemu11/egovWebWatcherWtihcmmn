package egovframework.com.login.service;

import egovframework.com.cmmn.CommonVO;

public class ManagerLoginVO extends CommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginId;
    private String dispName;
    private Long staffSeq;
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public String getDispName() {
        return dispName;
    }
    public void setDispName(String dispName) {
        this.dispName = dispName;
    }
    public Long getStaffSeq() {
        return staffSeq;
    }
    public void setStaffSeq(Long staffSeq) {
        this.staffSeq = staffSeq;
    }
}
