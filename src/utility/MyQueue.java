package utility;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    private Node<E> first, last;
    private int size;

    public MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(E item) {
        Node<E> newNode = new Node<E>(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E front = first.data;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return front;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return first.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    public String toString() {
        String result = "";
        Node<E> current = first;
        while (current != null) {
            result = result + (current.data.toString() + " ");
            current = current.next;
        }
        return result;
    }



    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }



    private class QueueIterator implements Iterator<E> {
        private Node<E> current;

        public QueueIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
