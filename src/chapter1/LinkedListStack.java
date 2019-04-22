package chapter1;

public class LinkedListStack<T> {
    private class Node {
        T element;
        Node next;
    }

    private Node first;
    private int n;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(T t) {
        Node oldFirst = first;
        first = new Node();
        first.element = t;
        first.next = oldFirst;
        n++;
    }

    public T pop() {
        T t = first.element;
        first = first.next;
        n--;
        return t;
    }

    public static void main(String[] args) {

    }
}
