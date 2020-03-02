package kr.or.ksmart.springboot34_mybatis.domain;

public class Member {
	private String mId;
	private String mPw;
	private String mLevel;
	private String mName;
	private String mEmail;
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmLevel() {
		return mLevel;
	}
	public void setmLevel(String mLevel) {
		this.mLevel = mLevel;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPw=" + mPw + ", mLevel=" + mLevel + ", mName=" + mName + ", mEmail=" + mEmail
				+ "]";
	}
	
	
	
}
