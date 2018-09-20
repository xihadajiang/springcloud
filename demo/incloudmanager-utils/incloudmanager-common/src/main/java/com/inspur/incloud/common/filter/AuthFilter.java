package com.inspur.incloud.common.filter;

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

import com.inspur.incloud.common.OperationResult;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String token = httpRequest.getHeader("token");
        OperationResult opeResult = new OperationResult();
        if (!"filterDemo".equals(token)) {
        	opeResult.setFlag(false);
        	opeResult.setErrCode("00000001");
        	opeResult.setErrMessageZh("你写的token不对");
        	opeResult.setErrMessageEn("you write an error token");
        	response.setContentType("application/json");
        	response.getWriter().print(opeResult.toString());
        	return;
        }
        
        chain.doFilter(httpRequest, httpResponse);
        return;

	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
