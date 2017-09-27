package com.nduyhai.jms.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQConnectionFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ActiveMQCustomizer implements ActiveMQConnectionFactoryCustomizer {
    /**
     * More infor at http://activemq.apache.org/how-to-deal-with-large-number-of-threads-in-clients.html
     * @param factory
     */
    @Override
    public void customize(ActiveMQConnectionFactory factory) {
        factory.setMaxThreadPoolSize(10);
        factory.setRejectedTaskHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        factory.setAlwaysSessionAsync(false);
    }
}
