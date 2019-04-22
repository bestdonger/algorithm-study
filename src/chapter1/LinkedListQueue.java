package chapter1;

public class LinkedListQueue<T> {
    private class Node {
        T element;
        Node next;
    }

    private Node first;
    private Node last;
    private int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.element = t;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public T dequeue() {
        T t = first.element;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return t;
    }
}
