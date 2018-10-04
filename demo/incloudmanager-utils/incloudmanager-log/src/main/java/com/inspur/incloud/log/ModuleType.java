package com.inspur.incloud.log;

/**
 * The Enum ModuleType.
 */
public enum ModuleType {

    /** 系统管理. */
    ibase("ibase"),
    /** 云资源管理. */
    iresource("iresource"),
    /** 云服务. */
    icloudservice("icloudservice"),
    /** 业务管理. **/
    iworkflow("iworkflow"),
    /** 计费管理. **/
    icharge("icharge"),
    /** 智能监控. **/
    imonitor("imonitor"),
    /** 运维管理. **/
    iaot("iaot"),
    /** CloudDB-MongoDB. **/
    CloudDBMongoDB("CloudDB-MongoDB"),
    /** CloudDB-RDS. **/
    CloudDBRDS("CloudDB-RDS");


    
    /** The value. */
    private String value;

    /**
     * Instantiates a new module type.
     *
     * @param val the val
     */
    private ModuleType(String val) {
        this.value = val;
    }
    
    /**
     * 获取错误码数值.
     * @return 错误码数值
     */
    public String getValue() {
        return value;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return (this.value + "");
    }
}
