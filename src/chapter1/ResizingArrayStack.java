package chapter1;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T> {

    private T[] array; // stack back array
    private int n; // stack size

    public ResizingArrayStack(int cap) {
        array = (T[]) new Object[cap];
    }

    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayStackIterator();
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T ele) {
        if (n == array.length) {
            resize(array.length * 2);
        }
        array[n++] = ele;
    }

    public T pop() {
        T t = array[--n];
        if (n == array.length / 4) {
            resize(array.length / 2);
        }
        return t;
    }

    private void resize(int newSize) {
        T[] tmp = (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            tmp[i] = array[i];
        }
        array = tmp;
    }


    public class ResizingArrayStackIterator implements Iterator<T> {
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return n == 0;
        }

        @Override
        public T next() {
            return array[--n];
        }
    }
}
