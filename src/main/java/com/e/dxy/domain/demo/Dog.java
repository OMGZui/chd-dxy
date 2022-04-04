package com.e.dxy.domain.demo;

public class Dog extends Animal {
    // 定义数据
    private String name;
    private String behavior;
    private int age;
    public String out;
    private final static String swan = "小天鹅";

    // 构造器
    public Dog(String name, int age, String behavior) {
        this.name = name;
        this.age = age;
        this.behavior = behavior;
        this.setOut();
    }

    @Override
    public String getDesc() {
        return "叫";
    }

    // 定义方法
    public void setOut() {
        out = name + "今年" + age + "岁，喜欢" + behavior;
    }

    public String getOut() {
        return out;
    }

    public static String getSwan() {
        return swan;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + name
                + "age=" + age
                + "behavior=" + behavior
                + "]";
    }

    // main方法Java程序的入口方法
    public static void main(String[] args) {
        // 对象是类的一个实例，new关键字就是进行实例化
        Dog dog = new Dog("小黑", 2, "吃骨头");
        System.out.println(dog.getOut());
        System.out.println(Dog.getSwan());
        System.out.println(System.currentTimeMillis() / 1000 * 1000);
    }
}