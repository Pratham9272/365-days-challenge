class FrontMiddleBackQueue {
  LinkedList<Integer> left, right;

  public FrontMiddleBackQueue() {
      left = new LinkedList<>();
      right = new LinkedList<>();
  }

  private void balance() {
      while (left.size() > right.size()) {
          right.addFirst(left.removeLast());
      }
      while (left.size() + 1 < right.size()) {
          left.addLast(right.removeFirst());
      }
  }

  public void pushFront(int val) {
      left.addFirst(val);
      balance();
  }

  public void pushMiddle(int val) {
      if (left.size() < right.size()) {
          left.addLast(val);
      } else {
          right.addFirst(val);
      }
  }

  public void pushBack(int val) {
      right.addLast(val);
      balance();
  }

  public int popFront() {
      if (left.isEmpty() && right.isEmpty()) return -1;
      int val;
      if (!left.isEmpty()) {
          val = left.removeFirst();
      } else {
          val = right.removeFirst();
      }
      balance();
      return val;
  }

  public int popMiddle() {
      if (left.isEmpty() && right.isEmpty()) return -1;
      int val;
      if (left.size() == right.size()) {
          val = left.removeLast();
      } else {
          val = right.removeFirst();
      }
      return val;
  }

  public int popBack() {
      if (left.isEmpty() && right.isEmpty()) return -1;
      int val = right.removeLast();
      balance();
      return val;
  }
}


/**
* Your FrontMiddleBackQueue object will be instantiated and called as such:
* FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
* obj.pushFront(val);
* obj.pushMiddle(val);
* obj.pushBack(val);
* int param_4 = obj.popFront();
* int param_5 = obj.popMiddle();
* int param_6 = obj.popBack();
*/