package org.prk.domain;

import java.util.Date;  

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class ParentDomain {

	@Column(name="created_timestamp",updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimeStamp;
	@Column(name="updated_timestamp", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTimeStamp;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="update_by")
	private String updatedBy;
	
	
	@PrePersist
	  protected void onCreate() {
		createdTimeStamp = new Date();
	  }

	  @PreUpdate
	  protected void onUpdate() {
		  updateTimeStamp = new Date();
	  }
	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	public void setUpdateTimeStamp(Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
