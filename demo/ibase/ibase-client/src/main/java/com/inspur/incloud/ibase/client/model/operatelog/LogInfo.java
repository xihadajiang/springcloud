package com.inspur.incloud.ibase.client.model.operatelog;

import java.io.Serializable;

public class LogInfo implements Serializable{

	private static final long serialVersionUID = 3069109598819793639L;
	
	/**
	 * operResult
	 *     操作结果。 false:失败；true：成功。
	 */
	private boolean operResult;
	
	/**
	 * target
	 *     目标
	 */
	private String target;
	
	/**
	 * description
	 *     描述信息
	 */
	private String description;
	
	/**
	 * details
	 *     详细信息
	 */
	private String details;
	
	private String module;
	
	/**
	 * 事件类型：
	 * 0：操作日志
	 * 1：系统日志
	 * 2：安全日志
	 */
	private Integer eventType;
	
	/**
	 * 事件级别：
	 * 0：低
	 * 1：中
	 * 2：高
	 */
	private Integer eventLevel;
	
	public boolean isOperResult() {
		return operResult;
	}

	public void setOperResult(boolean operResult) {
		this.operResult = operResult;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getEventLevel() {
		return eventLevel;
	}

	public void setEventLevel(Integer eventLevel) {
		this.eventLevel = eventLevel;
	}

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
