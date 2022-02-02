package LinkedList;

public class LinkedList<T> implements List<T>{
    private T value;
    private LinkedList<T> next;
    public LinkedList(){}
    private LinkedList(T value, LinkedList<T> next) {
        this.value = value;
        this.next = next;
    }
    @Override
    public void insert(T x) {
        if(value == null) value = x;
        else next = new LinkedList<T>(x,next);
    }
    @Override
    public LinkedList<T> remove() {
        var result = next;
        next = next.next;
        return result;
    }

    @Override
    public int size() {
        int result = 1;
        if (value == null) return 0;
        for (var x = next; x != null; x = x.next) result++;
        return result;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
