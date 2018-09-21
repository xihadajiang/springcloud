package com.inspur.incloud.common;

import java.io.Serializable;

/**
 * 过滤器拦截的用户信息放入到session中.
 * @author lvxianguo
 */
public class UserSession implements Serializable {

    /** 序列化. */
    private static final long serialVersionUID = 1L;

    /** 用户信息. */
    private String userId;
    /** 用户名. */
    private String userName;
    /** 当前登录资源域 id. */
    private String domainId;
    /** 当前登录组织惟一标识. */
    private String orgId;
    /** 当前登录角色惟一标识. */
    private String roleId;
    /** 客户端请求ip. */
    private String ip;
    /** 角色类型.0：超级管理员，1：资源域管理员，2:组织管理员，3：组织用户. */
    private Integer roleType;
    /** 组织类型. 1:组织 2:项目 */
    private Integer orgType;
    /** 操作下级组织(项目)资源权限. */
    boolean operateSubOrgResRight;
    /** ISM是否选了全部. */
    private boolean isIsmAll;
    /**
     * 用户uuid.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 用户名.
     *
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the userName.
     *
     * @param userName the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 当前登录用户资源域ID.
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
     * Gets the org id.
     *
     * @return the org id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * Sets the org id.
     *
     * @param orgId the new org id
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 当前登录角色ID.
     *
     * @return the role id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 登陆IP.
     *
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 登陆IP.
     *
     * @param ip the new ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 当前登录用户角色类型.0：超级管理员，1：资源域管理员，2:组织管理员，3：组织用户.
     *
     * @return the role type
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * Sets the role type.
     *
     * @param roleType the new role type
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * get the role LoginOrgType.
     * @return
     */
    public Integer getOrgType() {
        return orgType;
    }

    /**
     * set the role LoginOrgType.
     * @return
     */
    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    /**
     * has the role OperateSubOrgResRight.
     * @return
     */
    public boolean hasOperateSubOrgResRight() {
        return operateSubOrgResRight;
    }

    /**
     * set the role OperateSubOrgResRight.
     * @return
     */
    public void setOperateSubOrgResRight(boolean operateSubOrgResRight) {
        this.operateSubOrgResRight = operateSubOrgResRight;
    }

    /**
     * @return the isIsmAll
     */
    public boolean getIsIsmAll() {
        return isIsmAll;
    }

    /**
     * @param isIsmAll the isIsmAll to set
     */
    public void setIsIsmAll(boolean isIsmAll) {
        this.isIsmAll = isIsmAll;
    }
}
