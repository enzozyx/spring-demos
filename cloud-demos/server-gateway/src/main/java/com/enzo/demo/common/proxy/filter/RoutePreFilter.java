package com.enzo.demo.common.proxy.filter;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-15:42
 */
@Component
public class RoutePreFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(RoutePreFilter.class);
    /**
     *
     * @return 可选值: pre  routing  post  error
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        log.info("--->token:" + accessToken);
        log.info("ok");
        return null;
    }
}
