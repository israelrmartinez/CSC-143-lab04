package utility;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {
    public E first;
    private ListNode last;
    int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean add(E item) {
        return false;
    }

    public void add(int index, E item) {
        ListNode newest = new ListNode(item);
        if (size == 0) {
            first = newest;
        } else {
            last.next = newest;
        }
        last = newest;
        size++;
    }

    public void append(E item) {

    }

    public void checkIndex(int index) {

    }

    public boolean contains(E item) {
        return false;
    }

    public void clear() {

    }

    private E detach(int index) {

    }

    public E get(int index) {

    }

    public int indexOf(E item) {
        int index = 0;
        ListNode current = first;
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

    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<E> iterator() {

    }

    private Node node(int index) {

    }

    public E remove(int index) {

    }

    public boolean remove(E item) {

    }

    public E set(int index, E item) {

    }

    public int size() {
        int count = 0;
        ListNode current = front;
        while(current != null) {
            current = current.next;
            count++;
        }
        size = count;
        return size;
    }

    public String toString() {
        if (first == null) {
            return "[]";
        } else {
            String result = "[" + first.data;
            ListNode current = first.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
}
