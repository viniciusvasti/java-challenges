public class StackMain {
  public static void main(String[] args) {
    System.out.println("Running Stack...");
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(7);
    stack.push(10);
    stack.push(2);
    stack.push(3);
    stack.push(10);
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack peek: " + stack.peek());
    System.out.println("Stack stack pop: " + stack.pop());
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack pop: " + stack.pop());
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack pop: " + stack.pop());
    System.out.println("Stack stack: " + stack);
    System.out.println("Stack stack pop: " + stack.pop());
    System.out.println("Stack stack: " + stack);
  }
  
  // Stack
  public static class Stack<T> {
    private Node<T> top = null;
    private int size = 0;
    
    public void push(T value) {
      Node<T> newNode = new Node(value);
      newNode.setNext(top);
      top = newNode;
      size++;
    }
    
    public T peek() {
      return top == null ? null : top.getValue();
    }
    
    public T pop() {
      if (top == null) {
        return null;
      }
      T value = top.getValue();
      top = top.next();
      size--;
      return value;
    }
    
    public boolean isEmpty() {
      return top == null;
    }    
    
    public String toString() {
      String listAsString = "";
      Node<T> current = top;
      while (current != null) {
        listAsString += "\n"+current.getValue();
        current = current.next();
      }
      return listAsString;
    }
  }

  
  // Linked List Node
  public static class Node<T> {
    private Node<T> next = null;
    private T value;
    
    public Node(T value) {
      setValue(value);
    }
    
    public boolean hasNext() {
      return next != null;
    }
    
    public Node<T> next() {
      return next;
    }
    
    public void setNext(Node<T> next) {
      this.next = next;
    }
    
    public T getValue() {
      return value;
    }
    
    public void setValue(T value) {
      this.value = value;
    }
    
    public String toString() {
      return value.toString();
    }
    
    public boolean equals(Node<T> node) {
      return value.equals(node.getValue());
    }
  }
}
