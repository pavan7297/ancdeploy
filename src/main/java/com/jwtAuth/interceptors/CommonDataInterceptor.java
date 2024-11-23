package com.jwtAuth.interceptors;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import com.jwtAuth.utils.CommonConstants;
import com.jwtAuth.utils.IsEmptyUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonDataInterceptor extends WebRequestHandlerInterceptorAdapter{
	
	public CommonDataInterceptor(WebRequestInterceptor requestInterceptor) {
		super(requestInterceptor);
		// TODO Auto-generated constructor stub
	}

	private static long REQUEST_COUNT=1;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        String tenatID=request.getHeader("X-TENANT-ID");
        log.info(tenatID+":::::::::::: tenatID " + tenatID); 
        if(!IsEmptyUtil.isNotBlank(tenatID)) {
        	tenatID=CommonConstants.DEFAULT_TEANTID;
        }
        String strRequestID="Req"+REQUEST_COUNT;
        log.info("CommonDataInterceptor.preHandle ---> "+strRequestID);
        log.info(strRequestID+":::::::::::: Request URL: " + request.getRequestURL());
        log.info(strRequestID+":::::::::::: Request IP: " + request.getRemoteHost());
        log.info(strRequestID+":::::::::::: Start Time: " + getCurrentDateAndTime(startTime)); 
        request.setAttribute("startTime", startTime); 
        request.setAttribute("reqid",strRequestID);
        REQUEST_COUNT++;
        return true;
    }
 
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
            Object handler, ModelAndView modelAndView) throws Exception { 
//    	log.info("postHandle ---> "+request.getRequestURL()); 
    }
 
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
            Object handler, Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        String sessionid=(String) request.getAttribute("reqid");        
        long endTime = System.currentTimeMillis();
        log.info(sessionid+":::::::::::: AfterCompletion of Time Taken For Excecution: " + (endTime - startTime)+" ms");
    }
    
    private String getCurrentDateAndTime(long yourmilliseconds) {
    	SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.DATABASE_DATE_FORMAT);    
    	Date resultdate = new Date(yourmilliseconds);
//    	System.out.println(sdf.format(resultdate));
    	return sdf.format(resultdate);
    }
}

