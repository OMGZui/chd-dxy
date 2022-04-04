package com.e.dxy.domain.demo;


/**
 * <p></p>
 *
 * @author omgzui
 * @date 3/25/22 3:57 PM
 */
public class Generic<T> {
    private T key;

    public Generic(T key){
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
