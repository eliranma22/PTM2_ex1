package test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyActiveObject extends AbstractActiveObject {

    private BlockingQueue<Runnable> q;

    public MyActiveObject(){
        super();
        q = new LinkedBlockingQueue<Runnable>();
    }

    @Override
    protected Runnable take() throws InterruptedException {
        return this.q.take();
    }

    @Override
    protected void add(Runnable r) {
        this.q.add(r);
    }
}
