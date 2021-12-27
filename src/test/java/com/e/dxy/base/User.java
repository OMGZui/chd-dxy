package com.e.dxy.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

    public String name;
    public Integer age;
    public Integer sex;

}
