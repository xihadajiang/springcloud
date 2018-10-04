/**
 * <P> Copyright © 2011 Inspur Group Co.,Ltd.  版权所有 浪潮集团有限公司 </p>
 */
package com.inspur.incloud.log;
/**
 * 事件类型.
 * @author liujunpeng
 *
 */
public enum EventType {
    /** The operation log. 0：操作日志*/
    OPERATION_LOG,

    /** The system log. 1：系统日志*/
    SYSTEM_LOG,

    /** The security log. 2：安全日志*/
    SECURITY_LOG;
}

