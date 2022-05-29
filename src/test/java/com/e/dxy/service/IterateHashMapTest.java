package com.e.dxy.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 5/29/22 1:29 PM
 */
public class IterateHashMapTest {
    public final static Integer SIZE = 1000000;

    public Map<Integer, Integer> map = toMap();

    public Map<Integer, Integer> toMap(){
        map = new HashMap<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            map.put(i, i);
        }
        return map;
    }

    /** 1. Using iterator and Map.Entry **/
    @Test
    public void test1_UsingWhileAndMapEntry(){
        long i = 0;
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = it.next();
            i += pair.getKey() + pair.getValue();
        }
        System.out.println(i);
    }

    /** 2. Using foreach and Map.Entry **/
    @Test
    public void test2_UsingForEachAndMapEntry(){
        long i = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            i += pair.getKey() + pair.getValue();
        }
        System.out.println(i);
    }

    /** 3. Using foreach from Java 8 **/
    @Test
    public void test3_UsingForEachAndJava8(){
        final long[] i = {0};
        map.forEach((k, v) -> i[0] += k + v);
        System.out.println(i[0]);
    }

    /** 4. Using keySet and foreach **/
    @Test
    public void test4_UsingKeySetAndForEach(){
        long i = 0;
        for (Integer key : map.keySet()) {
            i += key + map.get(key);
        }
        System.out.println(i);
    }

    /** 5. Using keySet and iterator **/
    @Test
    public void test5_UsingKeySetAndIterator(){
        long i = 0;
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            i += key + map.get(key);
        }
        System.out.println(i);
    }

    /** 6. Using for and Map.Entry **/
    @Test
    public void test6_UsingForAndIterator(){
        long i = 0;
        for (Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator(); entries.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = entries.next();
            i += entry.getKey() + entry.getValue();
        }
        System.out.println(i);
    }

    /** 7. Using Java 8 Stream Api **/
    @Test
    public void test7_UsingJava8StreamApi(){
        System.out.println(map.entrySet().stream().mapToLong(e -> e.getKey() + e.getValue()).sum());
    }

    /** 8. Using Java 8 Stream Api parallel  **/
    @Test
    public void test8_UsingJava8StreamApiParallel(){
        System.out.println(map.entrySet().parallelStream().mapToLong(e -> e.getKey() + e.getValue()).sum());
    }
}