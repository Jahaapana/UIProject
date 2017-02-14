package web;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="LABLE_T", schema="jahaa")
public class ScreenTextMapping implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="L_FUNC_CODE")
	private String screenCode;
	
	@Transient
	private String screenName;
	
	@Id
	@Column(name="L_JSP_CODE")
	private String screenTextCode;
	
	@Id
	@Column(name="L_ID")
	private String textCode;
	
	@Column(name="L_TYPE")
	private String textType;
	
	@Column(name="CREATED_ON")
	private Date createdDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_ON")
	private Date updatedDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	public ScreenTextMapping() {
	}
	
	public ScreenTextMapping(String screenCode, String screenName,
			String screenTextCode, String textCode, String textType,
			Date createdDate, String createdBy, Date updatedDate,
			String updatedBy) {
		super();
		this.screenCode = screenCode;
		this.screenName = screenName;
		this.screenTextCode = screenTextCode;
		this.textCode = textCode;
		this.textType = textType;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	public String getScreenCode() {
		return screenCode;
	}
	public void setScreenCode(String screenCode) {
		this.screenCode = screenCode;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getScreenTextCode() {
		return screenTextCode;
	}
	public void setScreenTextCode(String screenTextCode) {
		this.screenTextCode = screenTextCode;
	}
	public String getTextCode() {
		return textCode;
	}
	public void setTextCode(String textCode) {
		this.textCode = textCode;
	}
	public String getTextType() {
		return textType;
	}
	public void setTextType(String textType) {
		this.textType = textType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
