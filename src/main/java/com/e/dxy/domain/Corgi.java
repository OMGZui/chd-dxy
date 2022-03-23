package com.e.dxy.domain;

import java.util.ArrayList;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 3/15/22 10:12 PM
 */
public class Corgi extends Dog implements DogInterface
{
    private String play;

    public Corgi(String name, int age, String behavior) {
        super(name, age, behavior);
    }

    public void setPlay(String p) {
        this.play = p;
    }

    @Override
    public String bite() {
        return getClass().getName() + "咬人";
    }

    public String getPlay() {
        return this.out + "，爱" + this.play;
    }

    public static class CorgiGG {
        public static String getCorgiGG() {
            return "内部柯基类";
        }
    }

    public Integer check() throws Exception {
        int x = 5 / 0;
        return x;
    }

    public static void main(String[] args) {

        Corgi corgi = new Corgi("柯基", 2, "吃骨头");
        Corgi corgi1 = new Corgi("柯基", 2, "吃骨头");
        Animal corgi2 = new Corgi("柯基", 2, "吃骨头");
        corgi.setPlay("王者荣耀");
        System.out.println(corgi.getOut());
        System.out.println(corgi.getPlay());
        System.out.println(corgi.getDesc());

        System.out.println(corgi1.getClass() == corgi2.getClass());
        System.out.println(corgi1.hashCode());
        System.out.println(corgi2.hashCode());
        System.out.println(corgi1.toString());

        ArrayList<Animal> dogs = new ArrayList<>();
        dogs.add(corgi1);
        dogs.add(corgi2);

        for (Animal dog : dogs) {
            System.out.println(dog);
        }

        AnimalEnum animalEnum = Enum.valueOf(AnimalEnum.class, "DOG");
        System.out.println(animalEnum.getAnimal());
        System.out.println(AnimalEnum.DOG.getAnimal());
        System.out.println(AnimalEnum.DOG.toString());


        System.out.println(corgi.bite());

        System.out.println(CorgiGG.getCorgiGG());

        try {
            int x = corgi.check();
            System.out.println(x);
        } catch (Exception e) {
            System.out.println(e);
        }

//        (String s1, String s2) -> {
//        (String s1, String s2) -> {
//            return s1.length() - s2.length();
//        };

    }
}
