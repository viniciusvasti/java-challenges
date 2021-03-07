public class Queue<T> {
  public static void main(String[] args) {
    System.out.println("Running Queue...");
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(3);
    queue.enqueue(7);
    queue.enqueue(10);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(10);
    System.out.println("Queue: " + queue);
    System.out.println("Queue peek: " + queue.peek());
    System.out.println("Queue dequeue: " + queue.dequeue());
    System.out.println("Queue: " + queue);
    System.out.println("Queue dequeue: " + queue.dequeue());
    System.out.println("Queue: " + queue);
    System.out.println("Queue dequeue: " + queue.dequeue());
    System.out.println("Queue: " + queue);
    System.out.println("Queue dequeue: " + queue.dequeue());
    System.out.println("Queue: " + queue);
  }
  
  private Node<T> head = null;
  private Node<T> tail = null;
  private int size = 0;
  
  public void enqueue(T value) {
    Node<T> newNode = new Node<>(value);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);
    }
    tail = newNode;
    size++;
  }
  
  public T dequeue() {
    if (isEmpty()) {
      return null;
    }
    
    T value = head.getValue();
    head = head.next();
    size--;
    return value;
  }
  
  public T peek() {
    if (isEmpty()) {
      return null;
    }
    
    return head.getValue();
  }
  
  public boolean isEmpty() {
    return head == null;
  }    
  
  public String toString() {
    String listAsString = "[ ";
    Node<T> current = head;
    while (current != null) {
      String lastToken = current.next() != null ? ", " : "";
      listAsString += current.getValue() + lastToken;
      current = current.next();
    }
    return listAsString += " ]";
  }

  
  // Linked List Node
  public class Node<T> {
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
