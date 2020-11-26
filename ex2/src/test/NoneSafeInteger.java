package test;

public class NoneSafeInteger implements SafeInteger{
    private int value;

    public NoneSafeInteger(int val){
        this.value = val;
    }

    public NoneSafeInteger(){
        this.value = 0;
    }


    @Override
    public SafeInteger increment() {
        this.value++;
        return this;
    }

    @Override
    public SafeInteger decrement() {
        this.value--;
        return this;
    }

    @Override
    public SafeInteger add(int add) {
        this.value += add;
        return this;
    }

    @Override
    public SafeInteger pow(int pow) {
        this.value = (int)Math.pow(this.value, pow);
        return this;
    }

    @Override
    public SafeInteger mul(int mul) {
        this.value *= mul;
        return this;
    }

    @Override
    public int getValue() {
        return this.value;
    }

}
