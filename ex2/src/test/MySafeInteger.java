package test;

public class MySafeInteger implements SafeInteger {

    private int value;
    private volatile boolean isLocked = false;

    public MySafeInteger(int val){
        this.value = val;
    }

    public MySafeInteger(){
        this.value = 0;
    }

    private SafeInteger atomicAction(Runnable r){
        this.requestLock();
        r.run();
        new Thread(r).start();
        this.releaseLock();
        return this;
    }

    @Override
    public SafeInteger increment() {
        return atomicAction(()->{this.value++;});
    }

    @Override
    public SafeInteger decrement() {
        return atomicAction(()->{this.value--;});
    }

    @Override
    public SafeInteger add(int add) {
        return atomicAction(()->{this.value+=add;});
    }

    @Override
    public SafeInteger pow(int pow) {
        return atomicAction(()->{this.value = (int)Math.pow(this.value, pow);});
    }

    @Override
    public SafeInteger mul(int mul) {
        return atomicAction(()->{this.value *= mul;});
    }

    @Override
    public int getValue() {
        return this.value;
    }

    synchronized private void requestLock(){
        if(!this.isLocked) {
            this.isLocked = true;
            return;
        }

        try{
            this.wait();
        } catch (InterruptedException ignored) {}
        this.requestLock();
    }

    synchronized private void releaseLock(){
        this.isLocked = false;
        this.notify();
    }
}
