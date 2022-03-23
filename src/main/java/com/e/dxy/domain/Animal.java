package com.e.dxy.domain;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 3/19/22 10:00 PM
 */
public abstract class Animal {
    private String cry;

    public String getCry() {
        return cry;
    }

    public abstract String getDesc();

    public void setCry(String cry) {
        this.cry = cry;
    }
}
