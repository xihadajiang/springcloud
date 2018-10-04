package com.inspur.incloud.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.inspur.incloud.common.OperationResult;
import com.inspur.incloud.common.UserSession;
import com.inspur.incloud.common.message.errorcode.ErrorCodeMessageUtil;
import com.inspur.incloud.iauth.client.model.user.UserInforModel;
import com.inspur.incloud.iauth.client.tokens.TokensApi;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TokensApi tokensApi;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			logger.debug("iauth filter begin");
			HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        String token = httpRequest.getHeader("X-Auth-Token");
	        OperationResult<UserInforModel> opeResult = new OperationResult<UserInforModel>();
	        opeResult= tokensApi.checkTokenPower(token, false);
	        if (!opeResult.isFlag()) {
	        	/*opeResult.setFlag(false);
	        	opeResult.setErrCode("00000001");
	        	opeResult.setErrMessageZh("你写的token不对");
	        	opeResult.setErrMessageEn("you write an error token");*/
	        	chain.doFilter(httpRequest, httpResponse);
	        	return;
	        }
	        UserInforModel user = opeResult.getResData();
	        UserSession session = new UserSession();
	        session.setUserId(user.getId());
	        session.setUserName(user.getName());
	        request.setAttribute("userSession", session);
	        chain.doFilter(httpRequest, httpResponse);
	        return;
		} catch (Exception e) {
    		logger.error(e.getMessage(), e);
    	}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
