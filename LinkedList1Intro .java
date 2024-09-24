class LinkedList1Intro {

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
     public static int size;

     //Add the element in first place
     public void addFirst(int data) {
        Node newNode = new Node(data); 
        size++;
        if(head == null) {
            head = tail = newNode;
            return; 

        }
        newNode.next = head;
        head = newNode;
     }

     //Add element at 
     public void addLast(int data) {

        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

     }

     public void print() {
        Node temp = head;

        if(head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
     }

     public void addMiddle (int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

     }

     public int removeFirst () {
        if(size == 0) {
            System.out.println("Linked ist is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;

        }
        int val = head.data;
        size--;
        head = head.next;
        return val;
     }

     public int removeLast () {
        if(size == 0) {
            System.out.println("Linked List is empty0");
        }

        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;

        }
        int val = prev.next.data;
        prev.next= null;
        tail = prev;
        size--;
        return val;
     }

     public void reverse() {

        if(head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node curr =  tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    } 

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }

        if(head.data == key)  {
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }

        return idx+1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }


    public void deleteNthFromEnd (int N) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(N == sz) {
            head = head.next; //removeFirst
            return;
        }

        int i = 1;
        int iToFind = sz-N;
        Node prev =head;
        while(i < iToFind) {
            prev = prev.next;
            i++; 

        }
        prev.next = prev.next.next;

       }

       //slow-fast approach
       public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //slow is my midNode   
       }

       public boolean checkPalindrome() {
            if(head == null || head.next == null) {
                return true;
            }

            // step 1: find mid
            Node midNode = findMid(head);

            //step 2: reverse 2nd half
            Node prev = null;
            Node curr = midNode;
            Node next;

            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            Node right = prev;
            Node left = head;

            //step 3: Check left half and right half
            while(right != null) {
                if(left.data != right.data) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
       }

       public static  boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;

            }
        }

        return false;

       }

       public static void removeCycle() {
        //detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if(fast == slow) {
                    cycle = true;
                    break;

                }

            }

            if(cycle == false) {
                return;
            }
             //find meeting point
             slow = head;
             Node prev = null;
             while(slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
             }

             //remove cycle
             prev.next = null;
       }



    public static void main(String[] args) {
        // LinkedList1Intro ll = new LinkedList1Intro();
        // ll.print();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addLast(2);
        // ll.addLast(1);
        /* 
        ll.addMiddle(2, 11);
        ll.print();
        ll.removeFirst();
        ll.removeFirst();
        System.out.println("After removal");
        ll.print();
        ll.reverse();
        System.out.println("After reverseing the numbers");
        ll.print();
        //System.out.println("The removed element is:" +  );
        System.out.println("After search operation");
        System.out.println(ll.recSearch(11));
        System.out.println(ll.recSearch(0));

        System.out.println("After deletion from Nth");
        ll.deleteNthFromEnd(1);
        ll.print();
        System.out.println("Linked List size is: " + ll.size);
        */

        //System.out.println(ll.checkPalindrome());


        head = new Node(1);
        head.next = new Node(2);
        Node temp = new Node(6);
        head.next = temp;  
        head.next.next = new Node(3);
        head.next.next.next = head;
        //1 -> 2-> 3-> -> 1

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

         
    }
}

