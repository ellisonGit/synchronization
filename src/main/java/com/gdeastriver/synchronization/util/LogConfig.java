package com.gdeastriver.synchronization.util;

import com.alipay.api.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * User: Ellison
 * Date: 2019-06-04
 * Time: 9:42
 * Modified:
 */

@Configuration public class LogConfig {
        private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

        @Bean
        public Person logMethod() {
            LOG.info("==========print log==========");
            return new Person();

    }
}
