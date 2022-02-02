package LinkedList;

public interface List<T> {
    void insert(T x);
    LinkedList<T> remove();
    int size();
    default boolean isEmpty(){
        return size() == 0;
    }
}
