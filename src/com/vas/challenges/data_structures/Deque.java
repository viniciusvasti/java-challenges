import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generalization of a stack and a queue that supports adding and removing
 * items from either the front or the back of the data structure.
 * 
 * Corner cases. Throw a java.lang.NullPointerException if the client attempts
 * to add a null item; throw a java.util.NoSuchElementException if the client
 * attempts to remove an item from an empty deque; throw a
 * java.lang.UnsupportedOperationException if the client calls the remove()
 * method in the iterator; throw a java.util.NoSuchElementException if the
 * client calls the next() method in the iterator and there are no more items
 * to return.
 * 
 * Performance requirements.   Your deque implementation must support each
 * deque operation in constant worst-case time. A deque containing n items must
 * use at most 48n + 192 bytes of memory. and use space proportional to the
 * number of items currently in the deque. Additionally, your iterator
 * implementation must support each operation (including construction) in
 * constant worst-case time.
 * 
 */

public class Deque<T> implements Iterable<T> {
  public static void main(String[] args) {
    System.out.println("Running DequeueMain...");
    Deque<Integer> deque = new Deque<>();
    System.out.println("Deque size: "+deque.size());
    deque.addFirst(5);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addLast(1);
    deque.addLast(4);
    deque.addLast(7);    
    System.out.println(deque.toString());
    System.out.println("Deque size: "+deque.size());
    System.out.println("First and last: "+deque.firstAndLast());
    System.out.println("Removing first: "+deque.removeFirst());
    System.out.println("After remove first: "+deque.toString());
    System.out.println("Deque size: "+deque.size());
    System.out.println("First and last: "+deque.firstAndLast());
    System.out.println("Removing last: "+deque.removeLast());
    System.out.println("After remove last: "+deque.toString());
    System.out.println("Deque size: "+deque.size());
    System.out.println("First and last: "+deque.firstAndLast());

    System.out.println("");
    System.out.println("### Corner cases ###");
    
    try {
      deque.addFirst(null);
    } catch (IllegalArgumentException ex) {
      System.out.println("Calling addFisrt with null value arg: "+ex.getMessage());
    }
    
    try {
      deque.addLast(null);
    } catch (IllegalArgumentException ex) {
      System.out.println("Calling addLast with null value arg: "+ex.getMessage());
    }

    Deque<Integer> deque2 = new Deque<>();
    try {
      deque2.removeFirst();
    } catch (NoSuchElementException ex) {
      System.out.println("Calling removeFirst over an empty Deque: "+ex.getMessage());
    }
    try {
      deque2.removeLast();
    } catch (NoSuchElementException ex) {
      System.out.println("Calling removeLast over an empty Deque: "+ex.getMessage());
    }
    try {
      Iterator<Integer> it = deque2.iterator();
      while (true) {
        it.next();
      }
    } catch (NoSuchElementException ex) {
      System.out.println("Calling iterator next() while there are no more items to return: "+ex.getMessage());
    }
    try {
      Iterator<Integer> it = deque2.iterator();
      it.remove();
    } catch (UnsupportedOperationException ex) {
      System.out.println("Calling iterator remove() any time: "+ex.getMessage());
    }
    
    System.out.println("### Removing operations over single element deque ###");
    deque2.addFirst(2);
    System.out.println(deque2.toString());
    System.out.println("First and last: "+deque2.firstAndLast());   
    deque2.removeFirst();
    System.out.println(deque2.toString());
    System.out.println("First and last: "+deque2.firstAndLast());   
    deque2.addFirst(2);
    deque2.removeLast();
    System.out.println(deque2.toString());
    System.out.println("First and last: "+deque2.firstAndLast());   
    deque2.addLast(2);
    deque2.removeFirst();
    System.out.println(deque2.toString());
    System.out.println("First and last: "+deque2.firstAndLast());   
    deque2.addLast(2);
    deque2.removeLast();
    System.out.println(deque2.toString());
    System.out.println("First and last: "+deque2.firstAndLast());  
    deque2.addFirst(2);
    System.out.println(deque2.toString());
    System.out.println("First and last: "+deque2.firstAndLast());   
  }
  
  private Node<T> front = null;
  private Node<T> back = null;
  private Node<T> secondLast = null;
  private int size = 0;

  public Deque() {}

  public boolean isEmpty() {
    return front == null;
  }

  public int size() {
    return size;
  }

  public void addFirst(T value) {
    if (value == null) {
      throw new IllegalArgumentException("Argument value can't be null");
    }
    Node<T> node = new Node<>(value);
    if (isEmpty()) {
      back = node;
    } else {
      node.next = front;
    }
    front = node;
    size++;
  }

  public void addLast(T value) {
    if (value == null) {
      throw new IllegalArgumentException("Argument value can't be null");
    }
    Node<T> node = new Node<>(value);
    if (isEmpty()) {
      front = node;
    } else {
      back.next = node;
    }
    secondLast = back;
    back = node;
    size++;
  }

  public T removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("The deque is empty");
    }
    T value = front.value;
    front = front.next;
    if (front == null) {
      back = null;
      secondLast = null;
    }
    size--;
    return value;
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("The deque is empty");
    }
    T value = back.value;
    if (secondLast != null) {
      secondLast.next = null;
    }
    back = secondLast;
    if (back == null) {
      front = null;
    }
    size--;
    return value;
  }

  // return an iterator over items in order from front to back
  public Iterator<T> iterator() {
    return new DequeIterator<T>(front);
  }
  
  public String toString() {
    String str = "[ ";
    for (T i : this) {
      str += i + " ";
    }
    return str + "]";
  }
  
  public String firstAndLast() {
    return (front != null ? front.value : "null") + " | " + (back != null ? back.value : "null");
  }
  
  private class DequeIterator<T> implements Iterator<T> {
    private Node<T> current;
    
    public DequeIterator(Node<T> current) {
      this.current = current;
    }
    
    public boolean hasNext() {
      return current != null;
    }
    
    public T next() {
      if (current == null) {
        throw new NoSuchElementException("There aren't more items to return");
      }
      T value = current.value;
      current = current.next;
      return value;
    }
    
    public void remove() {
      throw new UnsupportedOperationException("Remove through an iterator isn't supported");
    }
  }
  
  private class Node<T> {
    private T value;
    private Node<T> next;
    public Node(T value) {
      this.value = value;
    }
  }
}
