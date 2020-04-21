package by.it.bobrovich.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public T remove(int index) {
        T removeElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        elements[--size] = null;
        return removeElement;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T removeElement = elements[index];
        elements[index] = element;
        return removeElement;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        if (size < c.size() + elements.length) {
            elements = Arrays.copyOf(elements, size + c.size() + 1);
        }

        System.arraycopy(a, 0, elements, size, c.size());
        size += c.size();
        return true;
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
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
