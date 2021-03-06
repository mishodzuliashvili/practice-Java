package DoublyLinkedList;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        private final T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +"}";
        }

        public T getElement() {
            return element;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    private final Node<T> head;
    private final Node<T> tail;
    private int size = 0;

    public DoublyLinkedList() {
        this.head = new Node<>(null,null,null);
        this.tail = new Node<>(null,head,null);
        this.head.setNext(this.tail);
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return getSize() == 0;
    }

    public T first(){
        if(isEmpty()) return null;
        return head.getNext().getElement();
    }
    public T last(){
        if(isEmpty()) return null;
        return tail.getPrev().getElement();
    }

    public void addFirst(T e){
        addE(e,head,head.getNext());
    }
    public void addLast(T e){
        addE(e,tail.getPrev(),tail);
    }
    private void addE(T e, Node<T> prev, Node<T> next){
        Node<T> k = new Node<>(e,prev,next);
        prev.setNext(k);
        next.setPrev(k);
        ++size;
    }

    public T removeFirst(){
        return removeE(head.getNext());
    }
    public T removeLast(){
        return removeE(tail.getPrev());
    }
    private T removeE(Node<T> el){
        if (isEmpty()) return null;
        el.getPrev().setNext(el.getNext());
        el.getNext().setPrev(el.getPrev());
        --size;
        return el.getElement();
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head.getNext() +
                ", tail=" + tail.getPrev() +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        var a = new DoublyLinkedList<Integer>();
        System.out.println(a);
        System.out.println(a.isEmpty());
        a.addFirst(5);
        a.addFirst(7);
        a.addFirst(9);
        a.addFirst(11);
        System.out.println(a);
        a.addLast(8);
        System.out.println(a);
        a.removeFirst();
        System.out.println(a);
        a.removeLast();
        System.out.println(a);
    }
}
