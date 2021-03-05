public class LinkedListMain {
  public static void main(String[] args) {
    System.out.println("Running LinkedList...");
    LinkedList<Integer> list = new LinkedList<>();
    list.add(3);
    list.add(7);
    list.add(10);
    list.add(2);
    list.add(3);
    list.add(10);
    System.out.println("Linked list: " + list);
    System.out.println("Linked list size: " + list.size());
    System.out.println("Linked list has 2?: " + list.has(2));
    System.out.println("Linked list has 999?: " + list.has(999));
    System.out.println("Linked list remove 2 (first occurrence): " + list.remove(2));
    System.out.println("Linked list: " + list);
    list.remove(10);
    System.out.println("Linked list: " + list);
    list.addToEnd(16);
    System.out.println("Linked list: " + list);
    System.out.println("Linked list add 19 after 7: " + list.addAfter(19, 7));
    System.out.println("Linked list: " + list);
    System.out.println("Linked list add 123 after 999 (it is not added, returns false): " + list.addAfter(123, 999));
    System.out.println("Linked list: " + list);
    System.out.println("Linked list replace 19 by 21 (first occurrence): " + list.replace(19, 21));
    System.out.println("Linked list: " + list);
  }
  
  // Linked List
  public static class LinkedList<T> {
    private Node<T> root = null;
    private int size = 0;
    
    public void add(T value) {
      Node<T> node = new Node(value);
      if (root == null) {
        root = node;
      } else {
        node.setNext(root);
        root = node;
      }
      size++;
    }
    
    public void addToEnd(T value) {
      Node<T> newNode = new Node(value);
      if (root == null) {
        root = newNode;
      } else {
        Node<T> current = root;
        while (current.next() != null) {
          current = current.next();
        }
        current.setNext(newNode);
      }
      size++;
    }
    
    public boolean addAfter(T newValue, T precedentValue) {
      Node<T> precedentNode = getNodeByValue(precedentValue);
      if (precedentNode == null) {
        return false;
      }
      Node<T> newNode = new Node(newValue);
      newNode.setNext(precedentNode.next());
      precedentNode.setNext(newNode);
      size++;
      return true;
    }
    
    public boolean replace(T previousValue, T newValue) {
      Node<T> node = getNodeByValue(previousValue);
      if (node == null) {
        return false;
      }
      node.setValue(newValue);
      return true;
    }
    
    public boolean remove(T value) {
      if (root.getValue().equals(value)) {
        root = root.next();
        return true;
      }
      
      Node<T> current = root;            
      Node<T> parent = null;
      while (current != null) {
        if (current.getValue().equals(value)) {
          parent.setNext(current.next());
          return true;
        }
        parent = current;
        current = current.next();
      }
      return false;
    }
    
    public boolean has(T value) {
      return getNodeByValue(value) != null;
    }
    
    public boolean isEmpty() {
      return root == null;
    }
    
    private Node<T> getNodeByValue(T value) {
      Node<T> current = root;
      Node<T> target = new Node<>(value);
      while (current != null) {
        if (current.equals(target)) {
          return current;
        }
        current = current.next();
      }
      return null;
    }
    
    public int size() {
      return size;
    }
    
    public String toString() {
      String listAsString = "[ ";
      Node<T> current = root;
      while (current != null) {
        String lastToken = current.next() != null ? ", " : "";
        listAsString += current.getValue() + lastToken;
        current = current.next();
      }
      return listAsString += " ]";
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
