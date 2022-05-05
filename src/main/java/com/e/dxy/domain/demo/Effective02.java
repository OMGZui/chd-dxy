package com.e.dxy.domain.demo;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 5/5/22 10:18 PM
 */
public class Effective02 implements Serializable {
    private String name;
    private Integer age;
    private Boolean sex;

    private Effective02(Builder builder){
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private Boolean sex;

        public Builder name(String val){
            name = val;
            return this;
        }

        public Builder age(Integer val){
            age = val;
            return this;
        }

        public Builder sex(Boolean val){
            sex = val;
            return this;
        }

        public Effective02 build(){
            return new Effective02(this);
        }
    }
}
