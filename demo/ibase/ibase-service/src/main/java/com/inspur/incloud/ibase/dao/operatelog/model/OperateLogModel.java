package com.inspur.incloud.ibase.dao.operatelog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_ba_syslog")
public class OperateLogModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "syslog_id",updatable = false, nullable = false)
	private String sysLogId;
	
    @Column(name = "user_id")
	private String userId;
	
    @Column(name = "domain_id")
	private String domainId;
	
    @Column(name = "org_id")
	private String orgId;
	
    @Column(name = "log_date", nullable = false)
	private Date logDate;

	public String getSysLogId() {
		return sysLogId;
	}

	public void setSysLogId(String sysLogId) {
		this.sysLogId = sysLogId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	
	

}
