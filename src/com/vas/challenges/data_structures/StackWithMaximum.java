/**
 * Stack with max. Create a data structure that efficiently supports the stack operations (push and pop)
 * and also a return-the-maximum operation. Assume the elements are real numbers so that you can compare them.
 */

public class Stack {
  public static void main(String[] args) {
    System.out.println("Running Stack...");
    Stack stack = new Stack();
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.push(3.0);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.push(7.0);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.push(10.0);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.push(2.0);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.push(3.0);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.push(10.0);
    System.out.println("Stack stack maximum: " + stack.maximum());
    System.out.println("Stack stack: " + stack);
    stack.pop();
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.pop();
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.pop();
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack maximum: " + stack.maximum());
    stack.pop();
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack maximum: " + stack.maximum());
  }
  
  private Node top = null;
  private Double maximum = null;
  private int size = 0;
  
  public void push(Double value) {
    Node newNode = new Node(value);
    newNode.next = top;
    top = newNode;
    size++;
    if (maximum == null || value.compareTo(maximum) > 0) {
      maximum = value;
    }
  }
  
  public Double peek() {
    return isEmpty() ? null : top.value;
  }
  
  public Double pop() {
    if (isEmpty()) {
      return null;
    }
    Double value = top.value;
    top = top.next;
    size--;
    if (value.equals(maximum)) {
      recalculateMaximum();
    }
    return value;
  }
  
  private void recalculateMaximum() {
    Node current = top;
    maximum = 0.0;
    while (current != null) {
      if (current.value.compareTo(maximum) > 0) {
        maximum = current.value;
      }
      current = current.next;
    }
  }
  
  public Double maximum() {
    return maximum;
  }
  
  public boolean isEmpty() {
    return top == null;
  }    
  
  public String toString() {
    String listAsString = "";
    Node current = top;
    while (current != null) {
      listAsString += "\n"+current.value;
      current = current.next;
    }
    return listAsString;
  }
  
  public class Node {
    private Node next = null;
    private Double value;
    
    public Node(Double value) {
      this.value = value;
    }
  }
}
