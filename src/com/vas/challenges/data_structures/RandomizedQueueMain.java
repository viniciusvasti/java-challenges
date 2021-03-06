import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Math;

public class RandomizedQueueMain<T> implements Iterable<T> {
  public static void main(String[] args) {
    RandomizedQueueMain<String> randomPeopleQueue = new RandomizedQueueMain<>();
    randomPeopleQueue.enqueue("Raquel");
    randomPeopleQueue.enqueue("Vinicius");
    randomPeopleQueue.enqueue("Arthur");
    randomPeopleQueue.enqueue("Claudia");
    randomPeopleQueue.enqueue("Geldo");
    randomPeopleQueue.enqueue("Victor");
    for (String s : randomPeopleQueue) {
      System.out.println("Print from iterator: " + s);
    }
    System.out.println("Randomized Queue: " + randomPeopleQueue);
    System.out.println("Randomized Queue sample: " + randomPeopleQueue.sample());
    System.out.println("Randomized Queue sample: " + randomPeopleQueue.sample());
    System.out.println("Randomized Queue sample: " + randomPeopleQueue.sample());
    System.out.println("Randomized Queue dequeue: " + randomPeopleQueue.dequeue());
    System.out.println("Randomized Queue: " + randomPeopleQueue);
    System.out.println("Randomized Queue dequeue: " + randomPeopleQueue.dequeue());
    System.out.println("Randomized Queue: " + randomPeopleQueue);
    System.out.println("Randomized Queue dequeue: " + randomPeopleQueue.dequeue());
    System.out.println("Randomized Queue: " + randomPeopleQueue);
    System.out.println("Randomized Queue dequeue: " + randomPeopleQueue.dequeue());
    System.out.println("Randomized Queue: " + randomPeopleQueue);
    System.out.println("Randomized Queue size: " + randomPeopleQueue.size());
    for (String s : randomPeopleQueue) {
      System.out.println("Print from iterator: " + s);
    }
  }
  
  private static final int INITIAL_CAPACITY = 5;
  // size is used to track the end of the queue, since it is most of time under the array capacity/length
  private int size = 0;
  private T[] items;

  public RandomizedQueueMain() {
    items = (T[]) new Object[INITIAL_CAPACITY];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  // If the array is full, it's necessary to increase its capacity
  public void enqueue(T item) {
    if (item == null) {
      throw new IllegalArgumentException("The value can't be null.");
    }
    if (size == items.length) {
      resizeUp();
    }
    items[size++] = item;
  }

  public T sample() {
    if (isEmpty()) {
      throw new NoSuchElementException("The randomized queue is empty.");
    }
    int randomIndex = (int) (Math.random() * size);
    return items[randomIndex];
  }

  // If the array usage is under 25% percent of its capacity
  // it's necessary to decrease its capacity for saving memory
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("The randomized queue is empty.");
    }
    int randomIndex = (int) (Math.random() * size);
    T value = items[randomIndex];

    // In order to keep the array organized, that is, without empty middle slots
    // the slot of the removed item is assigned to the last item
    items[randomIndex] = items[--size];
    if (size <= items.length / 4) {
      resizeDown();
    }
    return value;
  }
  
  // Array is resized up by creating a new array with 2x the capacity
  // and copying each element, then referencing items array to the new bigger array
  private void resizeUp() {
    T[] newItems = (T[]) new Object[items.length * 2];
    for (int i = 0; i < size; i++) {
      newItems[i] = (T) items[i];
    }
    items = newItems;
  }
  
  // Array is resized down by creating a new array with half of the capacity
  // and copying each element, then referencing items array to the new smaller array
  private void resizeDown() {
    T[] newItems = (T[]) new Object[items.length / 2];
    for (int i = 0; i < size; i++) {
      newItems[i] = (T) items[i];
    }
    items = newItems;
  }

  public Iterator<T> iterator() {
    return new RandomizedQueueIterator<>();
  }
  
  public String toString() {
    String str = "[ ";
    for (int i = 0; i < size; i++) {
      str += items[i] + " ";
    }
    return str + "]";
  }
  
  private class RandomizedQueueIterator<T> implements Iterator<T> {
    private T[] itemsCopy;
    private int sizeCopy = 0;

    public RandomizedQueueIterator() {
      sizeCopy = size;
      itemsCopy = (T[]) new Object[sizeCopy];
      for (int i = 0; i < sizeCopy; i++) {
        itemsCopy[i] = (T) items[i];
      }
    }
    
    public boolean hasNext() {
      return sizeCopy > 0;
    }
    
    public T next() {
      if (size == 0) {
        throw new NoSuchElementException("There is no more items to return.");
      }
      int randomIndex = (int) (Math.random() * sizeCopy);
      T value = itemsCopy[randomIndex];
      itemsCopy[randomIndex] = itemsCopy[--sizeCopy];
      return value;
    }
    
    public void remove() {
      throw new UnsupportedOperationException("Remove is not supported by the iterator.");
    }
  }
  
  private class Node<T> {
    T value;
  }
}
