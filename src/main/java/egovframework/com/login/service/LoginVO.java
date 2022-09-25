package egovframework.com.login.service;

import java.sql.Timestamp;

import egovframework.com.cmmn.CommonVO;

public class LoginVO extends CommonVO  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginId;
    private String password;
    private String dispname;
    private Timestamp blockdate;
    private String ip;
    private int failcount;
    private int failcounttotal;
    private int failcountlimit;
    private int lockflag;
    private int failblocktime;
    private String loginipaddress;
    private Timestamp latestlogindatetime;
    private String language;
    private Timestamp currentTime;

    public Timestamp getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public int getFailcount() {
        return failcount;
    }
    public void setFailcount(int failcount) {
        this.failcount = failcount;
    }
    public int getFailcounttotal() {
        return failcounttotal;
    }
    public void setFailcounttotal(int failcounttotal) {
        this.failcounttotal = failcounttotal;
    }
    public int getFailcountlimit() {
        return failcountlimit;
    }
    public void setFailcountlimit(int failcountlimit) {
        this.failcountlimit = failcountlimit;
    }
    public int getLockflag() {
        return lockflag;
    }
    public void setLockflag(int lockflag) {
        this.lockflag = lockflag;
    }
    public int getFailblocktime() {
        return failblocktime;
    }
    public void setFailblocktime(int failblocktime) {
        this.failblocktime = failblocktime;
    }
    public String getLoginipaddress() {
        return loginipaddress;
    }
    public void setLoginipaddress(String loginipaddress) {
        this.loginipaddress = loginipaddress;
    }
    public Timestamp getLatestlogindatetime() {
        return latestlogindatetime;
    }
    public void setLatestlogindatetime(Timestamp latestlogindatetime) {
        this.latestlogindatetime = latestlogindatetime;
    }
    public Timestamp getBlockdate() {
        return blockdate;
    }
    public void setBlockdate(Timestamp blockdate) {
        this.blockdate = blockdate;
    }
    public String getDispname() {
        return dispname;
    }
    public void setDispname(String dispname) {
        this.dispname = dispname;
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
	@Override
	public String toString() {
		return "LoginVO [loginId=" + loginId + ", password=" + password + ", dispname=" + dispname + ", blockdate="
				+ blockdate + ", ip=" + ip + ", failcount=" + failcount + ", failcounttotal=" + failcounttotal
				+ ", failcountlimit=" + failcountlimit + ", lockflag=" + lockflag + ", failblocktime=" + failblocktime
				+ ", loginipaddress=" + loginipaddress + ", latestlogindatetime=" + latestlogindatetime + ", language="
				+ language + ", currentTime=" + currentTime + "]";
	}
}
