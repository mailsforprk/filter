package org.prk.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class MasterData {

	
	private Long filedId;
	private String filedName;
	
	@Id
	public Long getFiledId() {
		return filedId;
	}
	public void setFiledId(Long filedId) {
		this.filedId = filedId;
	}
	public String getFiledName() {
		return filedName;
	}
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	} 
}
