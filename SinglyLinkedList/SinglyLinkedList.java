package SinglyLinkedList;

public class SinglyLinkedList<T> {
    private static class Node<T>{
        private T element;
        private Node<T> next;
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
        public T getElement() {
            return element;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int getSize(){return size;}
    public boolean isEmpty(){return getSize() == 0;}
    public T first(){
        if(isEmpty()) return null;
        return first.getElement();
    }
    public T last(){
        if(isEmpty()) return null;
        return last.getElement();
    }
    public void addLast(T e){
        var r = new Node<>(e,null);
        if(isEmpty()) first = last = r;
        else last.setNext(r);
        last = r;
        ++size;
    }
    public void addFirst(T e){
        first = new Node<>(e,first);
        if (size == 0) last = first;
        ++size;
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        T res = first.getElement();
        first = first.getNext();
        --size;
        if(size == 0) last = null;
        return res;
    }

    public static void main(String[] args) {
        var ll = new SinglyLinkedList<Integer>();
        System.out.println(ll.getSize());
        System.out.println(ll.isEmpty());
        System.out.println(ll.removeFirst());
        ll.addFirst(5);
        ll.addFirst(6);
        ll.addFirst(7);
        ll.addLast(9);
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
        System.out.println(ll.last());
        System.out.println(ll.first());
    }
}
