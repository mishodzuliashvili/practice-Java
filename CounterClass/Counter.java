package CounterClass;

public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    public void reset(){
        count = 0;
    }
    public void increment(int ...args){
        if (args.length == 0) count++;
        for (int arg : args) count += arg;
    }
}
