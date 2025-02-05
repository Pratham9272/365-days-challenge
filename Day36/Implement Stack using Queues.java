class MyStack {
  private Queue<Integer> q1;
  private Queue<Integer> q2;

  public MyStack() {
      q1 = new LinkedList<>();
      q2 = new LinkedList<>();
  }
  
  public void push(int x) {
      q1.add(x);
  }
  
  public int pop() {
      while (q1.size() > 1) {
          q2.add(q1.poll());
      }
      int topElement = q1.poll();
      Queue<Integer> temp = q1;
      q1 = q2;
      q2 = temp;
      return topElement;
  }
  
  public int top() {
      while (q1.size() > 1) {
          q2.add(q1.poll());
      }
      int topElement = q1.peek();
      q2.add(q1.poll());
      Queue<Integer> temp = q1;
      q1 = q2;
      q2 = temp;
      return topElement;
  }
  
  public boolean empty() {
      return q1.isEmpty();
  }
}
