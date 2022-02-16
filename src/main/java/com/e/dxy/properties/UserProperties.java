package com.e.dxy.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 2/16/22 3:39 PM
 */
@Component
@ConfigurationProperties(prefix = "user")
@Setter
@Getter
public class UserProperties {
    private Integer time;
}
