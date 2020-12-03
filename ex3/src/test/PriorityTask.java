package test;

public class PriorityTask implements Runnable, Comparable<PriorityTask>{

    protected Runnable r;
    protected int priority;

    public PriorityTask(Runnable r, int priority){
        this.r = r;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        r.run();
    }

    public int getPriority(){
        return this.priority;
    }

    public void setPriority(int priority){
        this.priority = Math.min(Math.max(priority, 0), 10);
    }

    @Override
    public int compareTo(PriorityTask o) {
        return o.getPriority()-this.getPriority();
    }
}
