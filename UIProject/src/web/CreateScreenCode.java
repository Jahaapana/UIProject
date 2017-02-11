package web;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="FUNCTION_T", schema="jahaa")
public class CreateScreenCode {
	
	/*@Column(name="FUN_CODE", unique=true)*/
	
	@Id
	@Column(name="FUN_CODE")
	private String screenCode;
	
	@Column(name="FUN_NAME")
	private String screenName;
	
	@Column(name="FUN_DESC")
	private String description;
	
	@Column(name="FUN_TYPE")
	private String screenType;
	
	@Column(name="FUN_SEL")
	private boolean cTypeSelect;
	
	@Column(name="FUN_INS")
	private boolean cTypeInsert;
	
	@Column(name="FUN_UPD")
	private boolean cTypeUpdate;
	
	@Column(name="FUN_DEL")
	private boolean cTypeDelete;
	
	@Column(name="CREATED_ON")
	private Date createdDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_ON")
	private Date updatedDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="FUN_ACTIVE")
	private String  isActive;
	
	@Transient
	private String Code_Name;
	
	public CreateScreenCode() {
	}
	
	public CreateScreenCode(String screenCode, String screenName,
			String description, String screenType, boolean cTypeSelect,
			boolean cTypeInsert, boolean cTypeUpdate, boolean cTypeDelete,
			Date createdDate, String createdBy, Date updatedDate,
			String updatedBy, String isActive, String code_Name) {
		super();
		this.screenCode = screenCode;
		this.screenName = screenName;
		this.description = description;
		this.screenType = screenType;
		this.cTypeSelect = cTypeSelect;
		this.cTypeInsert = cTypeInsert;
		this.cTypeUpdate = cTypeUpdate;
		this.cTypeDelete = cTypeDelete;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
		Code_Name = code_Name;
	}

	public String getCode_Name(){
		return this.screenCode+"."+this.screenName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public boolean iscTypeSelect() {
		return cTypeSelect;
	}
	public void setcTypeSelect(boolean cTypeSelect) {
		this.cTypeSelect = cTypeSelect;
	}
	public boolean iscTypeInsert() {
		return cTypeInsert;
	}
	public void setcTypeInsert(boolean cTypeInsert) {
		this.cTypeInsert = cTypeInsert;
	}
	public boolean iscTypeUpdate() {
		return cTypeUpdate;
	}
	public void setcTypeUpdate(boolean cTypeUpdate) {
		this.cTypeUpdate = cTypeUpdate;
	}
	public boolean iscTypeDelete() {
		return cTypeDelete;
	}
	public void setcTypeDelete(boolean cTypeDelete) {
		this.cTypeDelete = cTypeDelete;
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
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
