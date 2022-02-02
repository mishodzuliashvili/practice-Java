package CounterClass;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(7);
        System.out.println(counter.getCount()); // 7
        counter.reset(); // 7 -> 0
        System.out.println(counter.getCount()); // 0
        counter.increment(); // 0 -> + 1
        System.out.println(counter.getCount()); // 1
        counter.increment(4); // 1 -> + 4
        System.out.println(counter.getCount()); // 5
        counter.increment(2,3,4,5,6);  // 5 -> + 2 + 3 + 5 + 6
        System.out.println(counter.getCount()); // 25
    }
}