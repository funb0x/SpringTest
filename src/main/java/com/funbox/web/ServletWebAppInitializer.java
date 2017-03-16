package com.funbox.web;

import com.funbox.sevlet.FrontServlet;
import com.funbox.sevlet.HelperServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Анна on 04.03.2017.
 */
public class ServletWebAppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("ServletWebAppInitializer onStartup");
        ServletRegistration.Dynamic dynamic = servletContext.addServlet(FrontServlet.class.getName(), FrontServlet.class);
        dynamic.addMapping("/front");

        ServletRegistration.Dynamic helperDynamic = servletContext.addServlet(HelperServlet.class.getName(), HelperServlet.class);
        helperDynamic.addMapping("/helper");

    }
}
