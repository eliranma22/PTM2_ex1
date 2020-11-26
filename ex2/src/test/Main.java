package test;

public class Main {

        public static void test(Runnable r, int amount) {
            System.out.println(Thread.currentThread().getName() + " - Stated.");
            for(int i=0;i < amount;i++) r.run();
            System.out.println(Thread.currentThread().getName() + " - Finished.");
        }

        public static void run(SafeInteger myint) throws InterruptedException {
            Thread t1 = new Thread(()->test(()->myint.increment(), 10000), "t1");
            Thread t2 = new Thread(()->test(()->myint.increment(), 5322), "t2");
            Thread t3 = new Thread(()->test(()->myint.increment(), 14678), "t3");
            Thread t4 = new Thread(()->test(()->myint.increment(), 10000), "t4");
            // myint = 40,000
            Thread t5 = new Thread(()->test(()->myint.decrement(), 38500), "t5");
            Thread t6 = new Thread(()->test(()->myint.decrement(), 413), "t6");
            Thread t7 = new Thread(()->test(()->myint.add(-1), 587), "t7");
            // myint = 500
            Thread t8 = new Thread(()->test(()->myint.mul(2), 2), "t8");
            // myint = ??? guess the result.

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t7.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();

            System.out.println("Guess this value - "+myint.getValue());

            t5.join();
            t6.join();
            t7.join();

            if(myint.getValue() == 500)
                System.out.println("t1-t7 finish successfully.");

            t8.start();
            test(()->myint.mul(2), 4);
            t8.join();

            if(myint.getValue() == 32000)
                System.err.println("finish successfully, value is: "+myint.getValue());
            else
                System.err.println("wrong value "+myint.getValue());

        }


        public static void main(String[] args) throws InterruptedException {

            SafeInteger myint = new MySafeInteger(0);
            SafeInteger noneSafeInt = new NoneSafeInteger(0);

            System.out.println("Start with safe integer");
            run(myint);
            System.out.println("*******************************************************");
            System.out.println("Start with NONE safe integer");
            run(noneSafeInt);

        }

    }