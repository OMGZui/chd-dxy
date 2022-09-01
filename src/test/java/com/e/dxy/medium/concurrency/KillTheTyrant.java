package com.e.dxy.medium.concurrency;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 8/31/22 11:33 AM
 */
public class KillTheTyrant {
    private int blood = 100;

    public int decreaseBlood() {
        synchronized (this){
            blood = blood - 5;
            return blood;
        }
    }

    public boolean isAlive() {
        return blood > 0;
    }

    public static void main(String[] args) {
        final KillTheTyrant killTheTyrant = new KillTheTyrant();
        Thread MasterYiThread = new Thread() {
            public void run() {
                while (killTheTyrant.isAlive()) {
                    try {
                        int remainBlood = killTheTyrant.decreaseBlood();
                        if (remainBlood == 0) {
                            System.out.println("MasterYi kill the tyrant");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread YasuoThread = new Thread() {
            public void run() {
                while (killTheTyrant.isAlive()) {
                    try {
                        int remainBlood = killTheTyrant.decreaseBlood();
                        if (remainBlood == 0) {
                            System.out.println("Yasuo kill the tyrant");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        YasuoThread.start();
        MasterYiThread.start();
    }
}
