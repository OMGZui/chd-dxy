package com.e.dxy.domain;

import com.alibaba.fastjson.JSON;
import com.e.dxy.domain.demo.Effective01;
import com.e.dxy.domain.demo.Effective02;
import org.junit.jupiter.api.Test;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 5/5/22 10:01 PM
 */
public class EffectiveTest {
    @Test
    public void effective01(){
        Effective01 effective01 = Effective01.of("dog");
        System.out.println(JSON.toJSON(effective01));
    }

    @Test
    public void effective02(){
        Effective02 effective02 = new Effective02.Builder().name("dog").age(18).sex(true).build();
        System.out.println(JSON.toJSON(effective02));
    }
}
