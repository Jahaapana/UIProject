package web;

import java.util.Date;

import javax.persistence.*;

import constants.Constants;

@Entity
@Table(name="ALL_TEXT_T", schema="jahaa")
public class CreateText {
	
	@Id
	@Column(name="TXT_ID")
	@GeneratedValue
	private int id;
	
	@Column(name="TXT_LABEL", unique=true)
	private String label;
	
	@Column(name="TXT_REASON")
	private String description;

	@Column(name="TXT_LANG")
	private String language = Constants.CREATE_TEXT_LANGUAGE;

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="UPDATED_ON")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	public CreateText() {

	}

	public CreateText(String label, String description) {
		this.label = label;
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String lable) {
		this.label = lable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
