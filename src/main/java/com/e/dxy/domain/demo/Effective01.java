package com.e.dxy.domain.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 5/5/22 9:56 PM
 */
@Getter
@Setter
@Entity
public class Effective01 implements Serializable {

    private String name;

    public static Effective01 of(String name){
        Effective01 effective01 = new Effective01();
        effective01.name = name;
        return effective01;
    }
}
