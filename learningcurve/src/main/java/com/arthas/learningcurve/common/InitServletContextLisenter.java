package com.arthas.learningcurve.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Arthas on 16/4/7.
 */
public class InitServletContextLisenter implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        InitAction.init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
