package com.e.dxy.medium.concurrency;

import com.google.common.collect.Lists;

import java.util.LinkedList;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 9/21/22 6:21 PM
 */
public class ProducerConsumerProblem {
    private static final LinkedList<String> wildMonsterArea = Lists.newLinkedList();

    public static class WildMonsterProducer implements Runnable{
        @Override
        public void run() {
            try {
                this.createWildMonster();
            } catch (InterruptedException e){
                System.out.println("Wild monster delivery has been interrupted");
            }
        }

        public void createWildMonster() throws InterruptedException{
            for (int i = 0;;i++){
                synchronized (wildMonsterArea){
                    if (wildMonsterArea.size() == 0){
                        wildMonsterArea.add("wild#" + i);
                        System.out.println(wildMonsterArea.getLast());
                        wildMonsterArea.notify();
                    }
                }
                Thread.sleep(1000);
            }
        }
    }

    public static class MasterYiThread implements Runnable{
        @Override
        public void run() {
            try {
                this.attackWildMonster();
            } catch (InterruptedException e){
                System.out.println("The jungler is interrupted");
            }
        }


        public void attackWildMonster() throws InterruptedException{
            while (true){
                synchronized (wildMonsterArea){
                    if (wildMonsterArea.size() == 0){
                        wildMonsterArea.wait();
                    }
                    String wildMonster = wildMonsterArea.getLast();
                    wildMonsterArea.remove(wildMonster);
                    System.out.println("Get wild#" + wildMonster);
                }
            }
        }
    }


    public static void main(String[] args) {
        Thread wildMonsterProducerThread = new Thread(new WildMonsterProducer());
        Thread masterYiThread = new Thread(new MasterYiThread());

        wildMonsterProducerThread.start();
        masterYiThread.start();
    }

}
