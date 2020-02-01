import java.util.Random;

public class sellTickets {

    public static void main(String[] args) {
        Sell sell = new Sell();
        Thread t1 = new Thread(sell, "售票员1");
        Thread t2 = new Thread(sell, "售票员2");
        Thread t3 = new Thread(sell, "售票员3");
        Thread t4 = new Thread(sell, "售票员4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(Thread.activeCount());
    }
}

class Sell implements Runnable {
    private int tickets = 30;
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets + "票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
