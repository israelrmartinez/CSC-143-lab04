package utility;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {

    public static final int DEFAULT_CAPACITY = 10;

    E[] data;
    int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        String message = "Capacity cannot be negative";
        if (capacity < 0)
            throw new IllegalArgumentException(message);

        this.data = (E[]) new Object[capacity];
        size = capacity;
    }

    public boolean add(E item) {
        int oldSize = size;
        ensureCapacity(size + 1);
        data[size++] = item;
        return size == (oldSize + 1);
    }

    public void add(int index, E item) {
        checkIndex(index);
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    private void checkIndex(int index) {
        int min = 0;
        int max = data.length - 1;
        if (index < min || index > max) {
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            int newCapacity = data.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator(this);
    }

    public E remove(int index) {
        checkIndex(index);
        for (int i = index; i <= size - 2; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return data[index];
    }

    public boolean remove(E item) {
        for (int i = 0; i < size; i++) {
            E temp = this.get(i);
            if (temp.equals(item)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    public E set(int index, E item) {
        checkIndex(index);
        data[index] = item;
        return data[index];
    }

    public void shiftLeft(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            data[i - 1] = data[i];
        }
    }

    public void shiftRight(int index) {
        checkIndex(index);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += data[0];
            for (int i = 1; i < size; i++) {
                result += ", " + data[i];
            }
        }
        result += "]";
        return result;
    }

    private class ArrayListIterator implements Iterator<E> {
        int index;
        boolean removeOK;

        public ArrayListIterator() {
            index = 0;
            removeOK = false;
        }

        public boolean hasNext() {
            return index < size();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index++;
            return ArrayList.this.get(index - 1);
        }

        public void remove() {
            removeOK = ArrayList.this.remove(ArrayList.this.get(index));
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(index - 1);
            index--;
        }
    }
}
