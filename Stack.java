public class Stack
{
    Node top;
    int size=0;
    
    public void push(int p) {
        Node n = new Node(p);
        n.next = top;
        top = n;
        size++;
    }
    
    /**
     * Integer is a java wrapper class
     */
    public Integer peek() {
        if (top == null) return null;
        return top.value;
    }
    
    public Integer pop() {
        if (top == null) return null;
        Node oldtop = top;
        top = top.next;
        oldtop.next = null;
        size--;
        return oldtop.value;
    
    }

    public Integer length() {
      return size;
    }
    public class Node
    {
        int value;
        Node next;

        public Node(int x) {
            value = x;
        }
    }
}