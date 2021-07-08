package com.e.dxy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel(value = "用户Model")
@Entity
@Table(name = "users")
public class UserModel {

    @ApiModelProperty(value = "用户ID", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    @NotNull(message = "username不能为空")
    @ApiModelProperty(value = "用户名", required = true, example = "路人甲")
    @Column(nullable = false)
    private String username;

    @ApiModelProperty(value = "用户密码", example = "123456")
    @Column(nullable = false)
    private String password = "123456";

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime = LocalDateTime.now();
}
