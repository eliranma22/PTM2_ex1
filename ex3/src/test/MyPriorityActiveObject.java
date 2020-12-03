package test;

import java.util.concurrent.PriorityBlockingQueue;

public class MyPriorityActiveObject extends AbstractActiveObject {

    protected PriorityBlockingQueue<PriorityTask> q;

    public MyPriorityActiveObject(){
        super();
        q = new PriorityBlockingQueue<>();
    }

    @Override
    protected Runnable take() throws InterruptedException {
        return q.take();
    }

    @Override
    protected void add(Runnable r) {
        PriorityTask t;

        if(r instanceof PriorityTask)
            t = (PriorityTask)r;
        else
            t = new PriorityTask(r, 0);
        q.add(t);
    }
}
