package com.crystalark.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public final class GatewayLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("ZUUL API GATEWAY : request -> {}, request URI -> {}", request, request.getRequestURI());
        return null;
    }

    @Override
    public String filterType() {
        return "pre";	// Logging pre request
    }

    @Override
    public int filterOrder() {
        return 1; //Set priority to 1
    }
}