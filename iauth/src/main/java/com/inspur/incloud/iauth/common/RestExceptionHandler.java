package com.inspur.incloud.iauth.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kaenry on 2016/9/20.
 * RestExceptionHandler
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> RestResult<T> runtimeExceptionHandler(Exception e) {
    	LOGGER.error(e.getMessage(), e);
        String errCode = "10"+HttpStatus.BAD_REQUEST;
        RestResult<T> result = RestResult.newInstance();
        result.setFlag(false);
        result.setResData((T) e.getMessage());
        result.setErrCode(errCode);
        return result;
    }


}
