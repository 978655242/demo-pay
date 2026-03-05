/**
 * Copyright © 2004-2018 LianlianPay.All Rights Reserved.
 */
/**
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.tups;

import com.tups.mpay.share.config.FacadeConfig;
import com.llpay.framework.autoconfigure.AutoconfigPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 项目启动类
 * 
 * @author yudi
 * @version $Id: Application1.java, v 0.1 2019年06月14日 上午11:34:20
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.tups"}, exclude = {DataSourceAutoConfiguration.class},
    scanBasePackageClasses = {Application.class, AutoconfigPackage.class})
@Import(FacadeConfig.class)
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static volatile boolean running = true;

    public static void main(String[] args) {
        try {
            Runtime.getRuntime().addShutdownHook(new Thread() {

                @Override
                public void run() {
                    synchronized (Application.class) {
                        running = false;
                        Application.class.notify();
                    }
                }
            });
            System.setProperty("spring.devtools.restart.enabled", "false");
            System.setProperty("spring.boot.mainclass", Application.class.getName());
            SpringApplication.run(Application.class, args);
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
            System.exit(1);
        }

        synchronized (Application.class) {
            while (running) {
                try {
                    Application.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

    /**
     * @Bean public EmbeddedServletContainerFactory servletContainer() { JettyEmbeddedServletContainerFactory factory =
     *       new JettyEmbeddedServletContainerFactory(); return factory; }
     */

    @Override
    public void run(String... args) throws Exception {
        // do anything after SpringApplication process successfully.
    }

}
