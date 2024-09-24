
// public class LLReverse5 {

//     public static class Node {
//         int data;
//         Node next; 

//         public Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }
//     public static Node head;
//     public static Node tail;


//     public void reverse() {
//        if(head == null || head.next == null) {
//             return;
//         }
//         Node prev = null;
//         Node curr = tail = head;
//         Node next;

//         while (curr != null) {
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next; 
//         }
//         head = prev;
//     }

//     public Node reverseRecursive(Node head) {
        
//         if(head  == null || head.next == null) {
//             return head;
//         }
//         Node newHead = reverseRecursive(head.next);
//         head.next.next = head;
//         head.next = null;

//         return newHead;

//     }

//     public static int getLength(Node head) {
//         int len = 0;
//         Node temp = head;

//         while(temp != null) {
//             temp = temp.next;
//             len++;
//         }
//         return len;
//     }



//     public static Node reverseKnodes (Node head, int k) {
//         if(head == null) {
//             System.out.println("LL is empty");
//             return null;
//         } 

//         int len = getLength(head);

//         if(k > len) {
//             System.out.println("Enter valid value og k");
//             return head;
//         }

//         //Reverse first k nodes 
//         Node prev = null;
//         Node curr =  head;
//         Node next = curr.next;
//         Node forward = curr.next;
//         int count = 0;

//         while (count < k) {
//             forward = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = forward; 
//             count++;
//         }
//         if(forward != null) {
//             head.next = reverseKnodes(forward, k);
//         }
//         return prev;
//     }


//     public void print() {
//         Node temp = head;

//         if(head == null) {
//             System.out.println("Linked List is empty");
//             return;
//         }
//         while(temp != null) {
//             System.out.println(temp.data);
//             temp = temp.next;
//         }
//      }

//     public static void main(String[] args) {
//         LLReverse5 ll = new LLReverse5();

//         ll.head = new Node(1);
//         ll.head.next = new Node(2);
//         ll.head.next.next = new Node(4);
//         ll.head.next.next.next = new Node(5);
//         ll.head.next.next.next.next = new Node(6);
//         ll.head.next.next.next.next.next = new Node(7);
//         ll.head.next.next.next.next.next.next = new Node(8);
//         ll.head.next.next.next.next.next.next.next = new Node(9);
//         ll.print();
//         //ll.reverse();
//         //ll.head = ll.reverseRecursive(ll.head);
//         reverseKnodes(head, 3);
//         ll.print();





//     }
// }


public class LLReverse5 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // Method to reverse the list iteratively
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Method to reverse the list recursively
    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // Static method to get the length of the linked list
    public static int getLength(Node head) {
        int len = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    // Static method to reverse 'k' nodes in a linked list
    public static Node reverseKnodes(Node head, int k) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return null;
        }

        int len = getLength(head);
        if (k > len) {
            System.out.println("Enter a valid value of k");
            return head;
        }

        // Reverse first k nodes
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // After reversing, next is now the head of the remaining list
        if (next != null) {
            head.next = reverseKnodes(next, k);
        }

        // prev is the new head after reversing the first k nodes
        return prev;
    } 

    // Method to print the list
    public void print() {
        Node temp = head;

        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LLReverse5 ll = new LLReverse5();

        // Creating a linked list with 9 nodes
        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(4);
        ll.head.next.next.next = new Node(5);
        ll.head.next.next.next.next = new Node(6);
        ll.head.next.next.next.next.next = new Node(7);
        ll.head.next.next.next.next.next.next = new Node(8);
        ll.head.next.next.next.next.next.next.next = new Node(9);

        // Print original list
        System.out.println("Original List:");
        ll.print();

        // Reverse k nodes at a time
        head = reverseKnodes(head, 3);

        // Print modified list after reversing
        System.out.println("List after reversing 3 nodes at a time:");
        ll.print();
    }
}