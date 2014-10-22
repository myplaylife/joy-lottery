package com.joy.lottery.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Created by zhangjingbo on 14-10-22.
 */
public class ApplicationContextUtil {

    public static ApplicationContext getApplicationContext(ServletContext context) {
        return (ApplicationContext) context.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }
}
