package com.inspur.incloud.apigateway.Filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;
import com.inspur.incloud.iauth.client.tokens.TokensApi;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
public class IncloudZuulFilter extends ZuulFilter {
	
	private static final Logger Logger = LoggerFactory.getLogger(IncloudZuulFilter.class);
	
	@Autowired
	ZuulProperties properties;
	
	@Autowired
	private TokensApi tokensApi;

	public Object run() throws ZuulException {
		boolean isSuccess = true;
		Integer code = 200;
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
        String host = request.getRemoteHost();
        Logger.info("print the host ip: " + host);
        String token = request.getHeader("X-Auth-Token");
        String keepAlive = request.getHeader("X-Auth-Keep-Alive");
        String lang = request.getHeader("X-Accept-Language");
        Logger.debug("X-Auth-Token: " + token);
        Logger.debug("X-Auth-Keep-Alive: " + keepAlive);
        if(StringUtils.isEmpty(token)) {
        	isSuccess = false;
        } else {
        	boolean isKeepAlive = true;
        	if("false".equalsIgnoreCase(keepAlive)) {
        		isKeepAlive = false;
        	}
        	OperationResult<UserInforModel> result = tokensApi.checkTokenPower(token, isKeepAlive);
        	if (null == result){
        		isSuccess = false;
        	}
        	isSuccess = result.isFlag();
        }
        if(!isSuccess) {
        	 context.setSendZuulResponse(false);
        	 context.getResponse().setContentType("application/json;charset=UTF-8");
        	 context.setResponseStatusCode(code);
        	 OperationResult opeResult = new OperationResult();
        	 opeResult.setFlag(false);
        	 opeResult.setErrCode("TOKEN_ILLEGAL");
        	 if ("en_US".equals(lang)) {
        		 opeResult.setErrMessage("illegal token " + token);
        	 } else {
        		 opeResult.setErrMessage("无效的token "+ token);
        	 }
        	ObjectMapper mapper = new ObjectMapper();
        	try {
				String json = mapper.writeValueAsString(opeResult);
				context.setResponseBody(json);
			} catch (JsonProcessingException e) {
				Logger.error(e.getMessage(), e);
			}
        }
        return null;
	}

	public boolean shouldFilter() {
		boolean isNeedFilter = true;
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
        String url = request.getRequestURI();
        if(StringUtils.isNotEmpty(url) && url.contains("/v2/api-docs")) {
        	return false;
        }
		return isNeedFilter;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return ROUTE_TYPE;
	}

}
