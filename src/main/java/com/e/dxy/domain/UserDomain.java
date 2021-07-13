package com.e.dxy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@FieldNameConstants
@Table(name = "users")
public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    private String username;

    private String password = "123456";

    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();

}
