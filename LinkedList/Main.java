package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.insert((int)(Math.random()*10));
        }
        System.out.println(list);
        for (int i = 0; i < 3; i++) {
            list.remove();
        }
        System.out.println(list);
        System.out.println(list.size());
        // Output:
        //LinkedList{value=9, next=LinkedList{value=5, next=LinkedList{value=7, next=LinkedList{value=7, next=LinkedList{value=7, next=LinkedList{value=0, next=LinkedList{value=4, next=LinkedList{value=6, next=LinkedList{value=0, next=LinkedList{value=6, next=null}}}}}}}}}}
        //LinkedList{value=9, next=LinkedList{value=7, next=LinkedList{value=0, next=LinkedList{value=4, next=LinkedList{value=6, next=LinkedList{value=0, next=LinkedList{value=6, next=null}}}}}}}
        //7
    }
}
