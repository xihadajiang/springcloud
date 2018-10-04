package com.inspur.incloud.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspur.incloud.common.UserSession;
import com.inspur.incloud.ibase.client.model.operatelog.LogInfo;
import com.inspur.incloud.ibase.client.operatelog.OperateLogApi;
import com.inspur.incloud.log.util.OperateLogCodeMessageUtil;

/**
 * 系统日志service层实现.
 */
@Service("logService")
public class SyslogServiceImpl implements SyslogService {

    /**
     * 日志记录器.
     */
    private final Logger logger =  LoggerFactory.getLogger(this.getClass());


    /** The Constant modulename. */
    private static final String MODULENAME = "module";
    
    @Autowired
    private OperateLogApi operateLogApi;
    /**
     * 系统日志，事件级别为中.
     * @param userSession
     *            ,包括userId,orgId,ip.
     * @param operResult
     *            操作结果。false:失败； true：成功
     * @param target
     *            目标
     * @param descriptionKey
     *            简要描述的在消息资源文件中的key。
     * @param descriptions
     *            简要描述中的变量数组。
     * @param details
     *            详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    public boolean addSysLog(UserSession userSession, boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details) {

        return addSysLog(userSession, EventLevel.MIDDEL.ordinal(), operResult, target, descriptionKey, descriptions,
                details);
    }

    /**
     * Adds the sys log.
     * @param userSession
     *            the user session
     * @param eventLevel
     *            the event level
     * @param operResult
     *            the oper result
     * @param target
     *            the target
     * @param descriptionKey
     *            the description key
     * @param descriptions
     *            the descriptions
     * @param details
     *            the details
     * @return true, if successful
     */
    public boolean addSysLog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String descriptionKey, Object[] descriptions, String details) {
        return this.addSysLog(userSession, eventLevel, operResult, target, descriptionKey, descriptions, details, null);
    }
    /**
     * Adds the sys log.
     *
     * @param userSession the user session
     * @param eventLevel the event level
     * @param operResult the oper result
     * @param target the target
     * @param descriptionKey the description key
     * @param descriptions the descriptions
     * @param details the details
     * @param moduleType the module type
     * @return true, if successful
     */
    public boolean addSysLog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String descriptionKey, Object[] descriptions, String details, ModuleType moduleType) {
        if (null == userSession) {
            userSession = new UserSession();
        }
        List<LogInfo> logs = new ArrayList<LogInfo>();
        for (Locale locale : OperateLogCodeMessageUtil.getProviderLocale()) {
            try {
            	LogInfo syslog = new LogInfo();
                String module = null;
                if (moduleType != null) {
                    module = moduleType.toString();
                } else {
                    module = OperateLogCodeMessageUtil.getMessage(MODULENAME,null,locale.toString());
                }
                syslog.setModule(module);
                syslog.setEventType(EventType.SYSTEM_LOG.ordinal());
                syslog.setUserId(userSession.getUserId());
                syslog.setOrgId(userSession.getOrgId());
                syslog.setDomainId(userSession.getDomainId());
                syslog.setEventLevel(eventLevel);
                syslog.setOperationIP(userSession.getIp());
                if (operResult) {
                    syslog.setOperResult("1");
                } else {
                    syslog.setOperResult("0");
                }
                syslog.setTarget(OperateLogCodeMessageUtil.getMessage(target,null,locale.toString()));
                syslog.setLogDate(new Date());
                syslog.setDescription(OperateLogCodeMessageUtil.getMessage(descriptionKey,descriptions,locale.toString()));
                syslog.setLanguage(locale.toString());
                syslog.setDetails(details);
                syslog.setEventSource("0");
                logs.add(syslog);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        try {
        	return operateLogApi.addOperateLog(logs);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * Adds the operlog.
     * @param userSession
     *            the user session
     * @param operResult
     *            the oper result
     * @param target
     *            the target
     * @param descriptionKey
     *            the description key
     * @param descriptions
     *            the descriptions
     * @param details
     *            the details
     * @return true, if successful
     */
    public boolean addOperlog(UserSession userSession, boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details) {
        return addOperlog(userSession, EventLevel.MIDDEL.ordinal(), operResult, target, descriptionKey, descriptions,
                details);
    }

    /**
     * Adds the operlog.
     * @param userSession
     *            the user session
     * @param eventLevel
     *            the event level
     * @param operResult
     *            the oper result
     * @param target
     *            the target
     * @param descriptionKey
     *            the description key
     * @param descriptions
     *            the descriptions
     * @param details
     *            the details
     * @return true, if successful
     */
    public boolean addOperlog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String descriptionKey, Object[] descriptions, String details) {
        return this.addOperlog(userSession, eventLevel, operResult, target, null, null, descriptionKey, descriptions,
                details);
    }
    /**
     * Adds the operlog.
     *
     * @param userSession the user session
     * @param eventLevel the event level
     * @param operResult the oper result
     * @param target the target
     * @param descriptionKey the description key
     * @param descriptions the descriptions
     * @param details the details
     * @param moduleType the module type
     * @return true, if successful
     */
    public boolean addOperlog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String descriptionKey, Object[] descriptions, String details, ModuleType moduleType) {
        return this.addOperlog(userSession, eventLevel, operResult, target, null, null, descriptionKey, descriptions,
                details, moduleType);
    }

    /**
     * Adds the operlog.
     *
     * @param userSession the user session
     * @param eventLevel the event level
     * @param operResult the oper result
     * @param target the target
     * @param targetID the target id
     * @param targetOperType the target oper type
     * @param descriptionKey the description key
     * @param descriptions the descriptions
     * @param details the details
     * @return true, if successful
     */
    public boolean addOperlog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String targetID, String targetOperType, String descriptionKey, Object[] descriptions, String details) {
        return this.addOperlog(userSession, eventLevel, operResult, target, targetID, targetOperType, descriptionKey,
                descriptions, details, null);
    }
    /**
     * Adds the operlog.
     *
     * @param userSession the user session
     * @param eventLevel the event level
     * @param operResult the oper result
     * @param target the target
     * @param targetID the target id
     * @param targetOperType the target oper type
     * @param descriptionKey the description key
     * @param descriptions the descriptions
     * @param details the details
     * @param moduleType the module type
     * @return true, if successful
     */
    public boolean addOperlog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String targetID, String targetOperType, String descriptionKey, Object[] descriptions, String details,
            ModuleType moduleType) {
        if (null == userSession) {
            userSession = new UserSession();
        }
        List<LogInfo> logs = new ArrayList<LogInfo>();
        for (Locale locale : OperateLogCodeMessageUtil.getProviderLocale()) {
            try {
                LogInfo syslog = new LogInfo();
                String module = null;
                if (moduleType != null) {
                    module = moduleType.toString();
                } else {
                    module = OperateLogCodeMessageUtil.getMessage(MODULENAME,null,locale.toString());
                }
                syslog.setModule(module);
                syslog.setEventType(EventType.OPERATION_LOG.ordinal());
                syslog.setUserId(userSession.getUserId());
                syslog.setOrgId(userSession.getOrgId());
                syslog.setDomainId(userSession.getDomainId());
                syslog.setEventLevel(eventLevel);
                syslog.setOperationIP(userSession.getIp());
                if (operResult) {
                    syslog.setOperResult("1");
                } else {
                    syslog.setOperResult("0");
                }
                syslog.setTarget(OperateLogCodeMessageUtil.getMessage(target,null,locale.toString()));
                syslog.setTargetID(targetID);
                syslog.setTargetOperType(targetOperType);
                syslog.setLogDate(new Date());
                syslog.setDescription(OperateLogCodeMessageUtil.getMessage(descriptionKey,descriptions,locale.toString()));
                syslog.setLanguage(locale.toString());
                syslog.setDetails(details);
                syslog.setEventSource("0");
                logger.info(syslog.toString());
                logs.add(syslog);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        try {
        	return operateLogApi.addOperateLog(logs);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * Adds the security log.
     * @param userSession
     *            the user session
     * @param operResult
     *            the oper result
     * @param target
     *            the target
     * @param descriptionKey
     *            the description key
     * @param descriptions
     *            the descriptions
     * @param details
     *            the details
     * @return true, if successful
     */
    public boolean addSecurityLog(UserSession userSession, boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details) {
        return addSecurityLog(userSession, EventLevel.MIDDEL.ordinal(), operResult, target, descriptionKey,
                descriptions, details);

    }

    /**
     * Adds the security log.
     * @param userSession
     *            the user session
     * @param eventLevel
     *            the event level
     * @param operResult
     *            the oper result
     * @param target
     *            the target
     * @param descriptionKey
     *            the description key
     * @param descriptions
     *            the descriptions
     * @param details
     *            the details
     * @return true, if successful
     */
    public boolean addSecurityLog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String descriptionKey, Object[] descriptions, String details) {
        return this.addSecurityLog(userSession, eventLevel, operResult, target, descriptionKey, descriptions, details,
                null);
    }
    /**
     * Adds the security log.
     *
     * @param userSession the user session
     * @param eventLevel the event level
     * @param operResult the oper result
     * @param target the target
     * @param descriptionKey the description key
     * @param descriptions the descriptions
     * @param details the details
     * @param moduleType the module type
     * @return true, if successful
     */
    public boolean addSecurityLog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String descriptionKey, Object[] descriptions, String details, ModuleType moduleType) {
        if (null == userSession) {
            userSession = new UserSession();
        }
        List<LogInfo> logs = new ArrayList<LogInfo>();
        for (Locale locale : OperateLogCodeMessageUtil.getProviderLocale()) {
            try {
                LogInfo syslog = new LogInfo();
                String module = null;
                if (moduleType != null) {
                    module = moduleType.toString();
                } else {
                	module = OperateLogCodeMessageUtil.getMessage(MODULENAME,null,locale.toString());
                }
                syslog.setModule(module);
                syslog.setEventType(EventType.SECURITY_LOG.ordinal());
                syslog.setUserId(userSession.getUserId());
                syslog.setOrgId(userSession.getOrgId());
                syslog.setDomainId(userSession.getDomainId());
                syslog.setEventLevel(eventLevel);
                syslog.setOperationIP(userSession.getIp());
                if (operResult) {
                    syslog.setOperResult("1");
                } else {
                    syslog.setOperResult("0");
                }
                syslog.setTarget(OperateLogCodeMessageUtil.getMessage(target,null,locale.toString()));
                syslog.setLogDate(new Date());
                syslog.setDescription(OperateLogCodeMessageUtil.getMessage(descriptionKey,descriptions,locale.toString()));
                syslog.setLanguage(locale.toString());
                syslog.setDetails(details);
                syslog.setEventSource("0");
                logs.add(syslog);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        try {
        	return operateLogApi.addOperateLog(logs);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * Gets the language.
     * @param locale
     *            the locale
     * @return the language
     */
    private String getLanguage(Locale locale) {
        StringBuffer language = new StringBuffer();
        language.append(locale.getLanguage());
        String conntry = locale.getCountry();
        if (null != conntry && !"".equals(conntry)) {
            language.append("_" + conntry);
        }
        return language.toString();
    }
    
    /* (non-Javadoc)
     * @see com.inspur.incloud.log.SyslogService#addServiceOperlog(com.inspur.incloud.common.UserSession, int, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[], java.lang.String, java.lang.String)
     */
    @Override
    public boolean addServiceOperlog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String targetID,String targetOwnerID, String targetOrgID, String targetDomainID, String descriptionKey, Object[] descriptions, String details,
            String serviceCatalogID) {
        if (null == userSession) {
            userSession = new UserSession();
        }
        String targetOperType = null;
        List<LogInfo> logs = new ArrayList<LogInfo>();
        for (Locale locale : OperateLogCodeMessageUtil.getProviderLocale()) {
            try {
                LogInfo syslog = new LogInfo();
                String module = serviceCatalogID;
                syslog.setModule(module);
                syslog.setEventType(EventType.OPERATION_LOG.ordinal());
                syslog.setUserId(userSession.getUserId());
                syslog.setOrgId(userSession.getOrgId());
                syslog.setDomainId(userSession.getDomainId());
                syslog.setEventLevel(eventLevel);
                syslog.setOperationIP(userSession.getIp());
                if (operResult) {
                    syslog.setOperResult("1");
                } else {
                    syslog.setOperResult("0");
                }
                syslog.setTarget(OperateLogCodeMessageUtil.getMessage(target,null,locale.toString()));
                syslog.setLogDate(new Date());
                syslog.setDescription(OperateLogCodeMessageUtil.getMessage(descriptionKey,descriptions,locale.toString()));
                syslog.setLanguage(locale.toString());
                syslog.setDetails(details);
                syslog.setTargetID(targetID);
                syslog.setTargetOperType(targetOperType);
                syslog.setTargetOwnerID(targetOwnerID);
                syslog.setTargetOrgID(targetOrgID);
                syslog.setTargetDomainID(targetDomainID);
                syslog.setEventSource("1");
                logs.add(syslog);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        try {
        	return operateLogApi.addOperateLog(logs);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        
    }
}
