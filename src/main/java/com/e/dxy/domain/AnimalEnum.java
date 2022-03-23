package com.e.dxy.domain;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 3/20/22 10:22 PM
 */
public enum AnimalEnum {
    DOG("dog");

    private String animal;

    AnimalEnum(String animal) {
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

}
