package ahpu.libra.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private String work_num;
	private String ad_name;
	private String ad_password;
	public String getWord_num() {
		return work_num;
	}
	public void setWord_num(String word_num) {
		this.work_num = word_num;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	
	
}
