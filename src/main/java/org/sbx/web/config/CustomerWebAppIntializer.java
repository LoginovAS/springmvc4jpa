package org.sbx.web.config;

import org.sbx.app.config.DatabaseConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by loginov_a_s on 20.06.2017.
 */
public class CustomerWebAppIntializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();

        webContext.register(DatabaseConfig.class);
        webContext.register(CustomerWebMVCConfig.class);
        webContext.setServletContext(servletContext);
        ServletRegistration.Dynamic reg = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webContext));

        reg.setLoadOnStartup(1);
        reg.addMapping("*.action");

    }
}
