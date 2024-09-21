import java.util.LinkedList;

public class LLCollections {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.addLast(1);
        ll.addFirst(2);

        System.out.println(ll);

        ll.removeLast();
        System.out.println(ll);
    }
    
}
