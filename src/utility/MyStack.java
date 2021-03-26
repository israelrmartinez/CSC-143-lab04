package utility;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private Node<E> front;
    int size;

    public MyStack() {
        this.front = null;
        size = 0;
    }

    public void push(E item) {
        Node<E> newNode = new Node(item);
        newNode.next = front;
        front = newNode;
        size++;
    }

    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E top = front.data;
        front = front.next;
        size--;
        return top;
    }

    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = front;
        while (current != null) {
            sb.insert(0, current.data);
            sb.insert(0, ' ');
            current = current.next;
        }
        sb.insert(0, "bottom");
        sb.append(" top");
        return sb.toString();
    }



    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }



    private class StackIterator implements Iterator<E> {
        private Node<E> current;

        public StackIterator() {
            current = front;
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
