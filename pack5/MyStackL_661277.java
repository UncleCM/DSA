package solutions.pack5;
public class MyStackL_661277 {
    public class Node {
        String value;
        Node next;
        public Node(String d) {
        value = d;
        next = null;
        }
    }
    private Node top;
    public MyStackL_661277() {
    top = null;
    }
    public void push(String d) {
    /* your code */
    Node p = new Node (d);
    p.next = top;
    top = p;
    }
    public String pop() {
    /* your code */ 
    if (top == null) {
        return null;
    }
    String d = top.value;
    top = top.next;
    return d;
}
    // Top()
    public String peek() {
    /* your code */
    if (top == null) {
        return null;
    }
    return top.value;
}  
    public boolean isFull() {
        return false;
        }
        public boolean isEmpty() {
        return top == null;
        }
        
    @Override
    public String toString() {
    StringBuilder sb = new
    StringBuilder();
    sb.append("Top->");
    Node temp = top;
    while (temp != null) {
        sb.append(temp.value).append("->");
        temp = temp.next;
        }
        sb.append("Bottom");
        return sb.toString();
    }
}
