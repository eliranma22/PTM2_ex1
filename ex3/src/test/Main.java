package test;

public class Main {

    public static void test_myActiveObject(ActiveObject m) throws InterruptedException {

        int start = Thread.activeCount();

        for(int i=0;i<10;i++) { final int j = i; m.execute(()->System.out.println("Mission "+j)); }

        m.start();
        m.stop();

        Thread.sleep(1000);
        System.err.println("***********");

        if(Thread.activeCount()-start != 1)
            System.out.println("Thread count is wrong.");

        m.start();
        if(Thread.activeCount()-start != 1)
            System.out.println("Thread count is wrong.");

        for(int i=0;i<10;i++) { final int j = i; m.execute(()->System.out.println("Mission "+j)); }
        m.stop();

    }

    public static void test_PriorityTask(MyPriorityActiveObject m) throws InterruptedException {
        int start = Thread.activeCount();

        for(int i=0;i<10;i++) { final int j = i; m.execute(new PriorityTask(()->System.out.println("Mission "+j), j)); }

        m.start();
        m.stop();

        Thread.sleep(1000);
        System.err.println("***********");

        m.start();

        if(Thread.activeCount()-start != 1)
            System.out.println("Thread count is wrong.");

        for(int i=0;i<10;i++) { final int j = i; m.execute(new PriorityTask(()->System.out.println("Mission "+j), j)); }

        Thread.sleep(1000);
        m.stop();


    }

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        test_myActiveObject(new MyActiveObject());
        test_myActiveObject(new MyPriorityActiveObject());
        test_PriorityTask(new MyPriorityActiveObject());
    }
}
