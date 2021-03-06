public class StackArithmeticExpressionEvaluation {
  public static void main(String[] args) {
    System.out.println("result " + evaluateArithmeticExpression("(1 + ((2 + 3) * (4 * 5)))"));
  }
  
  public static int evaluateArithmeticExpression(String infixExp) {
    char[] infixExpAsArray = infixExp.toCharArray();
    Stack<Integer> operandsStack = new Stack<>();
    Stack<Character> operatorsStack = new Stack<>();
    int result = 0;
    
    for (int i = 0; i < infixExpAsArray.length; i++) {
      char c = infixExpAsArray[i];
      if (isOperand(c)) {
        operandsStack.push(Character.getNumericValue(c));
      }
      if (isOperator(c)) {
        operatorsStack.push(c);
      }
      if (c == ')') {
        char operator = operatorsStack.pop();
        int operand1 = operandsStack.pop();
        int operand2 = operandsStack.pop();
        System.out.println("calculating " + operator +" "+ operand1 +" "+ operand2);
        result = calculate(operator, operand1, operand2);
        operandsStack.push(result);
      }
    }
    return result;
  }
    
  private static int calculate(char operator, int operand1, int operand2) {
    switch (operator) {
      case '+':
        return operand1 + operand2;
      case '-':
        return operand1 - operand2;
      case '*':
        return operand1 * operand2;
      case '/':
        return operand1 / operand2;
    }
    return 0;
  }
  
  private static boolean isOperand(char c) {
    return c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
      || c == '5' || c == '6' || c == '7' || c == '8' || c == '7';
  }
  
  private static boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }
  
  private static class Stack<T> {
    private Node<T> top = null;
    
    public void push(T value) {
      System.out.println("pushing " + value);
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
