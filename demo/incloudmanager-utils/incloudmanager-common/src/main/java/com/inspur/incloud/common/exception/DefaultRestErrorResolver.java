package com.inspur.incloud.common.exception;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspur.incloud.common.OperationResult;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
 
@ControllerAdvice
public class DefaultRestErrorResolver {
    private Logger LOG = LoggerFactory.getLogger(DefaultRestErrorResolver.class);
    /** 接口类型不匹配. */
    public static final long ERROR_SPRING_TYPE_MISMATCH = 10400L;
    /** 未知. */
    public static final long ERROR_SPRING_UNKNOW = 10401L;
    /** 非法路径. */
    public static final long ERROR_SPRING_UNKNOWURL = 10404L;

    /** The Constant LOG. */
    /** 预先定义的所有异常类型. */
    private Map<String, String> exceptionMappings = Collections.emptyMap();

    /** 配置文件中自定义扩展错误. */
    private Map<String, String> exceptionMappingDefinitions = Collections.emptyMap();
 
    /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param resp
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public OperationResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOG.error("", e);
        OperationResult r = buildError(req, e);
        return r;
    }
    
    private OperationResult buildError(HttpServletRequest request, Exception excep) {
        OperationResult result = new OperationResult();
        try {
            if (TypeMismatchException.class.isAssignableFrom(excep.getClass())) {
                result.setErrCode(String.valueOf(ERROR_SPRING_TYPE_MISMATCH));
                TypeMismatchException exception = (TypeMismatchException) excep;
                Throwable root = null;
                if (exception.getRootCause() == null) {
                    root = exception;
                } else {
                    root = exception.getRootCause();
                }
                LOG.debug(root.getMessage());
                String message = root.getMessage().split("\n")[0];
                result.setResData(message);
            } else if (org.springframework.web.HttpRequestMethodNotSupportedException.class.isAssignableFrom(
                    excep.getClass())) {
                result.setErrCode(String.valueOf(ERROR_SPRING_TYPE_MISMATCH));
                HttpRequestMethodNotSupportedException exception = (HttpRequestMethodNotSupportedException) excep;
                Throwable root = null;
                if (exception.getRootCause() == null) {
                    root = exception;
                } else {
                    root = exception.getRootCause();
                }
                LOG.debug(root.getMessage());
                String message = root.getMessage().split("\n")[0];
                result.setResData(message);
            } else if (org.springframework.web.bind.MissingServletRequestParameterException.class.isAssignableFrom(
                    excep.getClass())) {
                result.setErrCode(String.valueOf(ERROR_SPRING_TYPE_MISMATCH));
                MissingServletRequestParameterException exception = (MissingServletRequestParameterException) excep;
                Throwable root = null;
                if (exception.getRootCause() == null) {
                    root = exception;
                } else {
                    root = exception.getRootCause();
                }
                LOG.debug(root.getMessage());
                String message = root.getMessage().split("\n")[0];
                result.setResData(message);
            } else if (org.springframework.http.converter.HttpMessageNotReadableException.class.isAssignableFrom(
                    excep.getClass())) {
                result.setErrCode(String.valueOf(ERROR_SPRING_TYPE_MISMATCH));
                HttpMessageNotReadableException exception = (HttpMessageNotReadableException) excep;
                Throwable root = null;
                if (exception.getRootCause() == null) {
                    root = exception;
                } else {
                    root = exception.getRootCause();
                }
                LOG.debug(root.getMessage());
                String message = root.getMessage().split("\n")[0];
                result.setResData(message);
            } else {
                Exception exception = (Exception) excep;
                LOG.debug("处理用户请求中出现异常：" + exception.getMessage());
                LOG.error("请求出现的异常：" + excep.getClass(), excep);
                result.setErrCode(String.valueOf(ERROR_SPRING_UNKNOW));
                result.setResData(exception.getMessage());
            }
        } catch (Exception e) {
            LOG.error("公共异常所在的模块：" + request.getContextPath(), e);
        }
        result.setFlag(false);
        return result;
    }
}

