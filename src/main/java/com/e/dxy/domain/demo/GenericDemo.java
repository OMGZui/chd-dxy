package com.e.dxy.domain.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 3/25/22 3:51 PM
 */
@Slf4j
public class GenericDemo {

    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            log.info("泛型测试 类型相同");
        }

        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Generic<String> genericString = new Generic<String>("keyValue");
        Generic generic1 = new Generic("keyValue");
        Generic generic2 = new Generic(123456);

        log.info("genericInteger key is " + genericInteger.getKey());
        log.info("genericString key is " + genericString.getKey());
        log.info("generic1 key is " + generic1.getKey());
        log.info("generic2 key is " + generic2.getKey());


        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> pair = minMax(words);
        log.info("min is " + pair.getFirst());
        log.info("max is " + pair.getSecond());

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);

        log.info("list contains " + list.contains(1));
        log.info("list get " + list.get(1));

        HashMap map = new HashMap(10);
        map.put("k", "v");
        map.put("a", "b");
        map.put("c", "D");

        log.info("map get " + map.get("c"));
        log.info("map containsKey " + map.containsKey("k"));
        log.info("map values " + map.values());
        log.info("map keySet " + map.keySet());
    }


    public static Pair<String> minMax(String[] s){
        if (s == null || s.length == 0){
            return null;
        }

        String min = s[0];
        String max = s[0];

        for (int i = 0; i < s.length; i++){
            if (min.compareTo(s[i]) > 0){
                min = s[i];
            }
            if (max.compareTo(s[i]) < 0){
                max = s[i];
            }
        }
        return new Pair<>(min, max);
    }
}
