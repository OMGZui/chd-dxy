package com.e.dxy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@FieldNameConstants
@Table(name = "users")
public class UserDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    private String username;

    private String password = "123456";

    @Column(name = "create_time")
    private LocalTime createTime = LocalTime.now();

    @Override
    public String toString() {
        return "UserDomain{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", create_time=" + createTime +
                "}";
    }
}
