package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean getFirstBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        FilterDispatcher filter = new FilterDispatcher();
        bean.setName("struts2");
        bean.setFilter(filter);
        bean.addInitParameter("actionPackages", "com.lq");
        bean.setOrder(0);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

    @Bean
    public FilterRegistrationBean getSecondBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        ActionContextCleanUp filter = new ActionContextCleanUp();
        bean.setName("struts-cleanup");
        bean.setFilter(filter);
        bean.setOrder(1);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

    @Bean
    public FilterRegistrationBean getThirdBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        PageFilter filter = new PageFilter();
        bean.setName("sitemesh");
        bean.setFilter(filter);
        bean.setOrder(2);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
