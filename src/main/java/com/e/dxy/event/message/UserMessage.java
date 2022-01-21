package com.e.dxy.event.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 1/21/22 11:02 AM
 */
@Getter
@Setter
@Builder
public class UserMessage implements Serializable {

    public static final String TOPIC = "T_USER";

    public static final String TAG = "TAG__USER";

    private Integer id;

}
