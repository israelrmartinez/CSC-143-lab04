package utility;

import java.util.NoSuchElementException;

public interface Iterator<E> {
    public boolean hasNext();
    public E next();
    public void remove();
}
