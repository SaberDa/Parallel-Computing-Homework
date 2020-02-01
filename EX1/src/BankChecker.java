public class BankChecker {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        int times = 300;
        int moneyPerBill = 100;

        Customer c1 = new Customer(bankAccount, times, moneyPerBill);
        Customer c2 = new Customer(bankAccount, times, moneyPerBill);

        Thread t1 = new Thread(c1, "张三在柜台取钱");
        Thread t2 = new Thread(c2, "李四在ATM取钱");
        t1.start();
        t2.start();
    }

    static class BankAccount {
        private int sum = 20_000;

        boolean reduce(int n) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (BankAccount.this) {
                if (sum - n >= 0) {
                    sum = sum - n;
                } else {
                    System.out.println("bank's money is not enough !");
                    return false;
                }
                System.out.println(Thread.currentThread().getName() + "，sum=" + sum);
            }
            return true;
        }
    }

    static class Customer implements Runnable {
        private BankAccount bankAccount;
        private int time;
        private int moneyPerBill;

        Customer(BankAccount bankAccount, int time, int money) {
            this.bankAccount = bankAccount;
            this.time = time;
            this.moneyPerBill = money;
        }

        @Override
        public void run() {
            //noinspection StatementWithEmptyBody
            while (bankAccount.reduce(moneyPerBill)) {}
        }
    }

}