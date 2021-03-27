package utility;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
    private Node<E> first, last;
    private int size;


    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean add(E item) {
        int oldSize = size;
        append(item);
        size++;
        return size == (oldSize + 1);
    }

    public void add(int index, E item) {
        checkIndex(index);
        if (index == 0) {
            first = new Node(item, first);
        } else {
            Node<E> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node(item, current.next);
        }
        size++;
    }

    public void append(E item) {
        if (first == null) {
            first = new Node(item, last);
        } else {
            Node<E> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(item);
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    public void clear() {
        first.next = last;
        last.prev = first;
        size = 0;
    }

    private E detach(int index) {
        checkIndex(index);
        Node<E> current = node(index);
        Node<E> prev = current.prev;
        Node<E> next = current.next;
        E data = current.data;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            current.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            current.next = null;
        }

        return current.data;
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int indexOf(E item) {
        int index = 0;
        Node<E> current = first;
        while (current != null) {
            if (current.data == item) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    private void insertBefore(int index, E item) {
        Node<E> current = node(index);
        Node<E> prev = current.prev;
        Node<E> newNode = new Node<E>(item, current, prev);
        current.prev = newNode;

        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private Node<E> node(int index) {
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public E remove(int index) {
        checkIndex(index);
        size--;
        if (index == 0) {
            E item = first.data;
            first = first.next;
            return item;
        } else {
            Node<E> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            E item = current.next.data;
            current.next = current.next.next;
            return item;
        }
    }

    public boolean remove(E item) {
        if (first == null) {
            return false;
        }
        size--;
        if (first.data == item) {
            first = first.next;
            return true;
        } else {
            Node<E> current = first;
            while (current.next != null) {
                if (current.next.data == item) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    public E set(int index, E item) {
        checkIndex(index);
        Node<E> current = node(index);
        E previous = current.data;
        current.data = item;
        return previous;
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (first == null) {
            return "[]";
        } else {
            String result = "[" + first.data;
            Node<E> current = first.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }



    private static class Node<E> {
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }



    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current;
        private boolean removeOK;

        public LinkedListIterator() {
            current = first.next;
            removeOK = false;
        }

        public boolean hasNext() {
            return current != last;
        }
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            Node<E> prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}
