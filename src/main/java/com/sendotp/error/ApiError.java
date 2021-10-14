package com.sendotp.error;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
 
	private long id;
	private String ucid;
	private String mob_no;
	private String expire_time;
	private  String otp;
	
	Map<String, String> validationErrors;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUcid() {
		return ucid;
	}

	public void setUcid(String ucid) {
		this.ucid = ucid;
	}

	public String getMob_no() {
		return mob_no;
	}

	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}

	public String getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(String expire_time) {
		this.expire_time = expire_time;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public ApiError(long id, String ucid, String mob_no, String expire_time, String otp,
			Map<String, String> validationErrors) {
		super();
		this.id = id;
		this.ucid = ucid;
		this.mob_no = mob_no;
		this.expire_time = expire_time;
		this.otp = otp;
		this.validationErrors = validationErrors;
	}

	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiError(int i, String message, String servletPath) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ApiError [id=" + id + ", ucid=" + ucid + ", mob_no=" + mob_no + ", expire_time=" + expire_time
				+ ", otp=" + otp + ", validationErrors=" + validationErrors + "]";
	}
	
}
