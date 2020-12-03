package test;

abstract public class AbstractActiveObject implements ActiveObject {

    protected Thread t;
    protected volatile boolean stop = true;
    protected Runnable r;

    public AbstractActiveObject(){
        r = ()->loop();
        t = new Thread(r);
    }

    private void loop(){
        while(!this.stop){
            try {
                this.take().run();
            } catch (InterruptedException e) {}
        }
        try {

            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {}
        this.loop();

    }

    @Override
    public void execute(Runnable r) {
        this.add(r);
    }

    @Override
    public void start() {

        if(!t.isAlive())
            t.start();
        else if(this.stop) {
            this.stop = false;
            synchronized (this) {
                this.notify();
            }
        }

        this.stop = false;

    }

    @Override
    public void stop() {
        this.add(()->stop=true);
    }

    protected abstract Runnable take() throws InterruptedException;
    protected abstract void add(Runnable r);

}
