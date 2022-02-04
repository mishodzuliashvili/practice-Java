package CircularlyLinkedList;

public class CircularlyLinkedList<T> {
    private static class Node<T>{
        private final T element;
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

    private Node<T> last;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public int getSize(){return size;}
    public boolean isEmpty(){return getSize() == 0;}
    public T first(){
        if(isEmpty()) return null;
        return last.getNext().getElement();
    }
    public T last(){
        if(isEmpty()) return null;
        return last.getElement();
    }
    public void rotate(){
        if(last != null) last = last.getNext();
    }
    public void addLast(T e){
        addFirst(e);
        last = last.getNext();
        ++size;
    }
    public void addFirst(T e){
        if(size == 0) {
            last = new Node<>(e, null);
            last.setNext(last);
        }
        last.setNext(new Node<>(e,last.getNext()));
        ++size;
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        T res = last.getNext().getElement();
        if(last == last.getNext()) last = null;
        else last.setNext(last.getNext().getNext());
        --size;
        return res;
    }


    public static void main(String[] args) {
        //
        // !!! i think this code is right, but it needs some test !!!
        //
        var ll = new CircularlyLinkedList<Integer>();
        System.out.println(ll.getSize());
        System.out.println(ll.isEmpty());
        System.out.println(ll.removeFirst());
        ll.addFirst(5);
        //System.out.println(ll);
        //
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
