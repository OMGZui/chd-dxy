package com.e.dxy.listener;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 2/16/22 8:37 PM
 */
@Component
@Slf4j
public class ApolloChangeListener {
    @ApolloConfig
    private Config config;

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent configChangeEvent){
        Set<String> keys = config.getPropertyNames();
        for (String key : keys) {
            log.info("key=[{}], value=[{}]", key, config.getProperty(key, ""));
        }
    }
}
