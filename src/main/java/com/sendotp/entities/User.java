package com.sendotp.entities;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Transient
	Random random = new Random();
	
	@Max(value = 30, message = "Invalid UCID")
	@Column(unique = true)
	private String ucid;
	
	@Size(min = 10, max = 10, message = "Invalid Mobile Number")
	private String mob_no;
	private String expire_time;
	private  String otp;  
	
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

	public User(String ucid, String mob_no, String expire_time) {
		super();
		this.ucid = ucid;
		this.mob_no = mob_no;
		this.expire_time = expire_time;
		int number = random.nextInt(999999);
		this.otp = String.format("%06d", number);
	}
	
	public User() {
		super();
	}

	
}
