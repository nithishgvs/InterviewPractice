package interview.stacksandqueues;

class MinStack {

  Element topElement;

  class Element {

    private int data;
    private int minValue;
    private Element next;

    public Element(int data, int minValue, Element next) {
      this.data = data;
      this.minValue = minValue;
      this.next = next;
    }
  }


  public MinStack() {

  }

  public void push(int val) {
    if (topElement == null) {
      Element element = new Element(val, val, null);
      topElement = element;
    } else {
      Element element = new Element(val, Math.min(topElement.minValue, val), topElement);
      topElement = element;
    }
  }

  public void pop() {
    Element next = topElement.next;
    topElement = next;
  }

  public int top() {
    return topElement.data;
  }

  public int getMin() {
    return topElement.minValue;
  }
}


