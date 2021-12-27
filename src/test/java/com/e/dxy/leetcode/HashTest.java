package com.e.dxy.leetcode;

import com.e.dxy.base.User;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashTest {

    @Test
    public void hashTable(){
        Map<Integer, User.UserBuilder> userInfo = new Hashtable<>();
        userInfo.put(9527, User.builder().name("张三").age(24).sex(1));
        userInfo.put(1200, User.builder().name("李四").age(25).sex(1));
        userInfo.put(6665, User.builder().name("王凤").age(19).sex(2));
        User.UserBuilder user = userInfo.get(6665);

//        HashMap<Integer, Integer> m = new LinkedHashMap<>();
//        m.put(3, 11);
//        m.put(1, 12);
//        m.put(5, 23);
//        m.put(2, 22);
//
//        // 3 1 5 2
//        for (Map.Entry e : m.entrySet()) {
//            System.out.println(e.getKey());
//        }


        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        // 1 2 3 5
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }

}
