package com.e.dxy.domain.demo;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 3/25/22 4:38 PM
 */
public class Pair<T> {

    private T first;
    private T second;


    public Pair(){
        first = second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue) {
        this.first = newValue;
    }

    public void setSecond(T newValue) {
        this.second = newValue;
    }
}
