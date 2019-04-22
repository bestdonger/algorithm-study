package chapter1;

import java.util.Iterator;

public class LinkedListBag<T> implements Iterable<T> {
    private class Node {
        T element;
        Node next;
    }

    private Node first;
    private int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(T t) {
        Node oldFirst = first;
        first = new Node();
        first.element = t;
        first.next = oldFirst;
        n++;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListBagIterator();
    }

    private class LinkedListBagIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.element;
            current = current.next;
            return t;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
