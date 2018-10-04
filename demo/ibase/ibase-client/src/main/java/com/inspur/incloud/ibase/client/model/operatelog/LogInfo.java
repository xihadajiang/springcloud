package com.inspur.incloud.ibase.client.model.operatelog;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
@ApiModel(value="日志信息")
public class LogInfo implements Serializable {

	private static final long serialVersionUID = 3069109598819793639L;
	/**
	 * 系统日志ID. 自动生成,写日志时，不需要赋值. 不需要国际化.
	 */
	private String syslogId;

	/**
	 * 用户ID. 不需要国际化
	 */
	private String userId;

	/**
	 * 组织ID. 不需要国际化
	 */
	private String orgId;

	/**
	 * 操作时间.自动记录，不需要调用者赋值，以服务端时间为准. 不需要国际化
	 */
	private Date logDate;

	/**
	 * 日志信息. key为国际化的关键字,List为message中占位符中的变量,list中放基本类型，比如int,char,String。
	 * 不允许放自定义对象. 国际化.
	 */
	private String description;
	/**
	 * 日志详细描述。 不进行国际化.
	 */
	private String details;

	/**
	 * 事件类型. 0：操作日志 1：系统日志 2：安全日志
	 */
	private Integer eventType;

	/**
	 * 事件级别. 0：低 1：中 2：高 默认为中级
	 */
	private Integer eventLevel = 1;

	/**
	 * 事件源. 不进行国际化.
	 */
	private String eventSource;
	/**
	 * 操作终端IP. 不需要国际化.
	 */
	private String operationIP;
	/**
	 * 操作对象.传递message中的key 国际化.
	 */
	private String target;

	/** 操作对象 id. */
	private String targetID;

	/** 操作对象操作类型. */
	private String targetOperType;

	/** 操作对象所有者id. */
	private String targetOwnerID;

	/** 操作对象所在组织id. */
	private String targetOrgID;

	/** 操作对象所在资源域 id. */
	private String targetDomainID;

	/** 操作结果. */
	private String operResult;

	/**
	 * 语言类型.
	 */
	private String language;

	/**
	 * 模块名.
	 */
	private String module;

	/** domain name. */
	private String domainId;

	/**
	 * Gets the details.
	 * 
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Sets the details.
	 * 
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		// 数据库保存4000字节的描述信息，对于超过3900的字节进行截断。修改监控模块批量导入资源时，写操作报jdbc失败的错误
		final int num3900 = 3900;
		final int num3899 = 3899;
		if (null != details && details.length() > num3900) {
			details = details.substring(0, num3899);
		}
		this.details = details;
	}

	/**
	 * 获取操作日志.
	 * 
	 * @return 操作日志.
	 */
	public Date getLogDate() {
		return logDate;
	}

	/**
	 * 设置操作时间.
	 * 
	 * @param logDate 操作时间.
	 */
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	/**
	 * 获取日志信息.
	 * 
	 * @return 日志信息.
	 */
	public String getSyslogId() {
		return this.syslogId;
	}

	/**
	 * 获取系统日志标识.
	 * 
	 * @param syslogId 系统日志标识.
	 */
	public void setSyslogId(String syslogId) {
		this.syslogId = syslogId;
	}

	/**
	 * 获取用户标识.
	 * 
	 * @return 用户标识.
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * 用户标识.
	 * 
	 * @param userId 用户标识.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 获取事件源类型.
	 * 
	 * @return 事件源类型.
	 */
	public Integer getEventType() {
		return eventType;
	}

	/**
	 * 设置事件源类型.
	 * 
	 * @param eventType 事件源类型.
	 */
	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	/**
	 * 获取事件源类型.
	 * 
	 * @return 事件源类型.
	 */
	public Integer getEventLevel() {
		return eventLevel;
	}

	/**
	 * 设置事件级别.
	 * 
	 * @param eventLevel 事件级别.
	 */
	public void setEventLevel(Integer eventLevel) {
		this.eventLevel = eventLevel;
	}

	/**
	 * 获取操作终端IP.
	 * 
	 * @return 操作终端IP.
	 */
	public String getOperationIP() {
		return operationIP;
	}

	/**
	 * 设置操作终端IP.
	 * 
	 * @param operationId 操作终端IP.
	 */
	public void setOperationIP(String operationId) {
		this.operationIP = operationId;
	}

	/**
	 * 获取操作对象.
	 * 
	 * @return 操作对象.
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 设置操作对象.
	 * 
	 * @param onObject 操作对象.
	 */
	public void setTarget(String onObject) {
		this.target = onObject;
	}

	/**
	 * 操作对象 id.
	 *
	 * @return the target id
	 */
	public String getTargetID() {
		return targetID;
	}

	/**
	 * 设置操作对象 id.
	 *
	 * @param targetID the new target id
	 */
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}

	/**
	 * 操作对象所有者id.
	 *
	 * @return the target owner id
	 */
	public String getTargetOwnerID() {
		return targetOwnerID;
	}

	/**
	 * 设置操作者所有者id.
	 *
	 * @param targetOwnerID the new target owner id
	 */
	public void setTargetOwnerID(String targetOwnerID) {
		this.targetOwnerID = targetOwnerID;
	}

	/**
	 * 操作对象所在组织 id.
	 *
	 * @return the target org id
	 */
	public String getTargetOrgID() {
		return targetOrgID;
	}

	/**
	 * 设置操作对象所在组织id.
	 *
	 * @param targetOrgID the new target org id
	 */
	public void setTargetOrgID(String targetOrgID) {
		this.targetOrgID = targetOrgID;
	}

	/**
	 * 操作对象所在资源域 id.
	 *
	 * @return the target domain id
	 */
	public String getTargetDomainID() {
		return targetDomainID;
	}

	/**
	 * 设置操作对象所在资源域 id.
	 *
	 * @param targetDomainID the new target domain id
	 */
	public void setTargetDomainID(String targetDomainID) {
		this.targetDomainID = targetDomainID;
	}

	/**
	 * Gets the target oper type.
	 *
	 * @return the target oper type
	 */
	public String getTargetOperType() {
		return targetOperType;
	}

	/**
	 * Sets the target oper type.
	 *
	 * @param targetOperType the new target oper type
	 */
	public void setTargetOperType(String targetOperType) {
		this.targetOperType = targetOperType;
	}

	/**
	 * 获取事件源.
	 * 
	 * @return 事件源.
	 */
	public String getEventSource() {
		return eventSource;
	}

	/**
	 * 设置事件源：0：本地源；1：云服务源.
	 * 
	 * @param eventSource 新的事件源.
	 */
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}

	/**
	 * 获取操作结果.
	 * 
	 * @return 操作结果.
	 */
	public String getOperResult() {
		return operResult;
	}

	/**
	 * 设置操作结果的属性.
	 * 
	 * @param operResult 操作结果的属性.
	 */
	public void setOperResult(String operResult) {
		this.operResult = operResult;
	}

	/**
	 * 获取组织标识.
	 * 
	 * @return 组织标识.
	 */
	public String getOrgId() {
		return this.orgId;
	}

	/**
	 * 设置组织标识.
	 * 
	 * @param orgId 设置组织id.
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * 简要描述.
	 * 
	 * @return 简要描述.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 简要描述.
	 * 
	 * @param description 简要描述.
	 */
	public void setDescription(String description) {
		final int num3900 = 3900;
		final int num3899 = 3899;

		if (null != description && description.length() > num3900) {
			description = description.substring(0, num3899);
		}
		this.description = description;
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * 
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the module.
	 * 
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * Sets the module.
	 * 
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * Gets the domain id.
	 * 
	 * @return the domain id
	 */
	public String getDomainId() {
		return domainId;
	}

	/**
	 * Sets the domain id.
	 * 
	 * @param domainId the new domain id
	 */
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	/**
	 * To string.
	 * 
	 * @return tostring
	 */
	@Override
	public String toString() {
		return "DbSyslog [syslogId=" + syslogId + ", userId=" + userId + ", orgId=" + orgId + ", domainId=" + domainId
				+ ", logDate=" + logDate + ", description=" + description + ", details=" + details + ", eventType="
				+ eventType + ", eventLevel=" + eventLevel + ", eventSource=" + eventSource + ", operationIP="
				+ operationIP + ", target=" + target + ", targetID=" + targetID + ", targetOperType=" + targetOperType
				+ ", operResult=" + operResult + ", language=" + language + ", module=" + module + "]";
	}
}
