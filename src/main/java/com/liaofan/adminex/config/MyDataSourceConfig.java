package com.liaofan.adminex.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class MyDataSourceConfig {
    //@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.zaxxer.hikari.HikariDataSource",
    //			matchIfMissing = true)
    //默认的配置是容器中没有,才会生效.
    //只要自己写了就会默认生效
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();

        /**
         * 配置文件已经存在了.就可以直接使用注解来引入配置文件中的设置
         */
        //加入监控
        druidDataSource.setFilters("stat,wall,session");
//        druidDataSource.setUsername();
//        druidDataSource.setUrl();
//        druidDataSource.setPassword();
        return druidDataSource;
    }

    /**
     * WebStatFilter 配置Druid连接池的防火墙
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return webStatFilterFilterRegistrationBean;
    }

    /**
     * 配置Druid的监控页
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","admin");
        return statViewServletServletRegistrationBean;


    }
}
