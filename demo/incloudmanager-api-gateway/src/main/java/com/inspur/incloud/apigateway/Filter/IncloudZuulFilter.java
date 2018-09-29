package com.inspur.incloud.apigateway.Filter;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;
import com.inspur.incloud.iauth.client.tokens.TokensApi;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class IncloudZuulFilter extends ZuulFilter {
	
	private static final Logger Logger = LoggerFactory.getLogger(IncloudZuulFilter.class);
	
	@Autowired
	ZuulProperties properties;
	
	@Autowired
	private TokensApi tokensApi;

	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
        String host = request.getRemoteHost();
        String url = request.getRequestURI();
        if(StringUtils.isNotEmpty(url) && url.contains("/v2/api-docs")) {
        	return null;
        }
        Collection<ZuulRoute> routers = properties.getRoutes().values();
        for (ZuulRoute router : routers) {
        	String path = router.getPath();
        	if (StringUtils.isNotEmpty(path) && StringUtils.isNotEmpty(url)) {
        		if (!url.startsWith(path.substring(0, path.lastIndexOf("**")))) {
        			return null;
        		}
        	}
        }
        Logger.info("print the host ip: " + host);
        //验证token是否合法
        boolean isSuccess = true;
        Integer code = 10000001;
        String token = request.getHeader("X-Auth-Token");
        Logger.info("****************" + token);
        if(StringUtils.isEmpty(token)) {
        	isSuccess = false;
        }
        OperationResult<UserInforModel> result = tokensApi.checkTokenPower(token, false);
        if (null == result){
        	isSuccess = false;
        }
        isSuccess = result.isFlag();
        if(!isSuccess) {
        	 context.setSendZuulResponse(false);
        	 context.getResponse().setContentType("text/html;charset=UTF-8");
        	 context.setResponseStatusCode(code);
        	 context.setResponseBody(String.format("{\"result\":\"%s!\"}", "token is errorr"));
        } else {
        	
        }
        return null;
	}

	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
