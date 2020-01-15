package com.cloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wei.li
 * on 2019/3/12
 * 通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
 * 然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
 * 通过ctx.setResponseBody(body)返回body内容
 */
@Component
public class MyFilter extends ZuulFilter {

    @Autowired
    JedisUtil jedisUtil;


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
        return false;
    }

    /**
     * operatorId、token放在header里面
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
//        //获取request上下文
//        RequestContext currentContext = RequestContext.getCurrentContext();
//        //获取request域
//        HttpServletRequest request = currentContext.getRequest();
//        String URI = request.getRequestURI();
//        boolean hasError = false;
//        if(!URI.equals("/api-setting/Login")) {
//            int operatorId = Integer.valueOf(request.getHeader("operatorId"));
//            String tokenNow = request.getHeader("token");
//            String tokenSave = jedisUtil.get("token_"+operatorId);
//            if(tokenNow == null || tokenSave == null || !tokenNow.equals(tokenSave)) { //验证失败
//                hasError = true;
//            }
//            boolean exits = jedisUtil.sismember("blacklist_"+operatorId, URI);
//            if(!exits) {
//                hasError = true;
//            }
//        }
//        if(hasError) {
//            currentContext.setSendZuulResponse(false);
//            currentContext.setResponseStatusCode(401);
//        }
        return null;
    }
}
