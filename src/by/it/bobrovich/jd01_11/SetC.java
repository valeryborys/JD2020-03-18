package by.it.bobrovich.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    int size = 0;

    @Override
    public boolean add(T t) {
        if (!contains(t)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
            }
            elements[size++] = t;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o))
                    elements[i] = null;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            if(!contains(t)){
                add(t);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimitr = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimitr).append(elements[i]);
            delimitr = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
