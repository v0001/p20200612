package com.example.vo;

public class MemberVO {
	
	private String userid = null;
	private String password = null;
	private String username = null;
	private String phone = null;
	private String userage = null;
	private String joindate = null;

	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserage() {
		return userage;
	}
	public void setUserage(String userage) {
		this.userage = userage;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", username=" + username + ", phone=" + phone
				+ ", userage=" + userage + "]";
	}

	

}
