package com.joy.lottery.listener;

import com.joy.lottery.cache.BaseData;
import com.joy.lottery.dao.TestDao;
import com.joy.lottery.service.TestService;
import com.joy.lottery.util.ApplicationContextUtil;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LoadBaseDataListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        /*
            TODO 加载基础数据
         */
        Configuration configuration = null;
        try {
            configuration = new PropertiesConfiguration("config.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        BaseData.setBaseDataPath(configuration.getString("basedata.path"));
        BaseData.setWorkspacePath(configuration.getString("workspace.path"));

        System.out.println(BaseData.getBaseDataPath());
        System.out.println(BaseData.getWorkspacePath());

        ApplicationContext applicationContext = ApplicationContextUtil.
                getApplicationContext(event.getServletContext());
        TestService testService = (TestService) applicationContext.getBean("testService");
        System.out.println("contextInitialized:" + testService.test());
    }

    public void contextDestroyed(ServletContextEvent event) {
        /*
            TODO 把抽奖进度保存到工作空间
         */
        ApplicationContext applicationContext = ApplicationContextUtil.
                getApplicationContext(event.getServletContext());
        TestDao testDao = (TestDao) applicationContext.getBean("testDao");
        System.out.println("contextDestroyed:" + testDao.test());
    }

}
