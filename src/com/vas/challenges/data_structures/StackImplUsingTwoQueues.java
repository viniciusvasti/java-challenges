public class StackImplUsingTwoQueues {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(1);
    stack.push(2);
    stack.push(4);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  public static class Stack<T> {
    private Queue<T> queue1 = new Queue<>();
    private Queue<T> queue2 = new Queue<>();
    
    public void push(T value) {
      while (queue1.hasNext()) {
        queue2.enqueue(queue1.dequeue());
      }
      queue1.enqueue(value);
      while (queue2.hasNext()) {
        queue1.enqueue(queue2.dequeue());
      }
    }
    
    public T pop() {
      return queue1.dequeue();
    }
  }
  
  public static class Queue<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    
    public void enqueue(T value) {
      Node<T> node = new Node<>(value);
      if (head == null) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
      }
      tail = node;
    }
    
    public T dequeue() {
      if (head == null) return null;
      T value = head.value;
      head = head.next;
      return value;
    }
    
    public boolean hasNext() {
      return head != null;
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
