public class QueueImplUsingTwoStacks {
  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(3);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(4);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }
  
  private static class Queue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();
  
    public void enqueue(T value) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
      stack1.push(value);
      while (!stack2.isEmpty()) {
        stack1.push(stack2.pop());
      }
    }
    
    public T dequeue() {
      return stack1.pop();
    }
  }
  
  private static class Stack<T> {
    private Node<T> top = null;
    
    public void push(T value) {
      Node<T> node = new Node<>(value);
      if (top != null) {
        node.next = top;
      }
      top = node;
    }
    
    public T pop() {
      T value = top.value;
      top = top.next;
      return value;
    }
    
    public T peak() {
      return top.value;
    }
    
    public boolean isEmpty() {
      return top == null;
    }
  }
  
  private static class Node<T> {
    T value;
    Node<T> next;
    public Node(T value) {
      this.value = value;
    }
  }
}
