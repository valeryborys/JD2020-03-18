package by.it.tolstik.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            stringBuilder.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean add(T t) {
        for (int i = 0; i < size; i++) {
            if (!t.equals(elements[i])) {
                if (size == elements.length) {
                    elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
                }
                elements[size++] = t;
                return false;
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
    public boolean contains(Object o) {
        return false;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
