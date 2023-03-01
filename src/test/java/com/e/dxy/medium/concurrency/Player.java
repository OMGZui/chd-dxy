package com.e.dxy.medium.concurrency;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 9/21/22 5:43 PM
 */
public class Player {

    public void fight(){
        System.out.println("The ultimate move is not ready, cooling down...");
        synchronized (this){
            try{
                this.wait();
                System.out.println("The big move is ready, attack!");
            }catch (InterruptedException e){
                System.out.println("The cooldown of the ultimate move has been interrupted!");
            }
        }

    }

    public void refreshSkills(){
        System.out.println("Refreshing skills...");
        synchronized (this){
            this.notifyAll();
            System.out.println("Skills have been refreshed!");
        }
    }

    // 自定义错误处理
    static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("ERROR！Thread name: " + t.getName() + ", Thread Message：" + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Player Garen = new Player();

        Thread GarenFightThread = new Thread(Garen::fight);
        Thread GarenSkillRefreshThread = new Thread(Garen::refreshSkills);

        GarenSkillRefreshThread.start();
        GarenSkillRefreshThread.join();
        GarenFightThread.start();

        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        GarenFightThread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        throw new NullPointerException();
    }
}
