package com.e.dxy.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@Builder
public class UserVO {

    @ApiModelProperty(value = "用户ID", required = true, example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名", required = true, example = "路人甲")
    private String username;

    @ApiModelProperty(value = "用户密码", example = "123456")
    private String password;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
