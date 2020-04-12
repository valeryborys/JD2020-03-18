package by.it.lemesh.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private int size = 0;
    private T[] elements = (T[]) new Object[]{};

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
        }
        elements[size++] = t;
        return false;
    }

    @Override
    public T remove(int i) {
        T del = elements[i];
        System.arraycopy(elements, i + 1, elements, i, size - i - 1);
        size--;
        return del;
    }

    @Override
    public T get(int i) {
        return elements[i];
    }

    @Override
    public T set(int i, T t) {
        T del = elements[i];
        elements[i] = t;
        return del;
    }

    @Override
    public void add(int i, T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
        }
        System.arraycopy(elements, i, elements, i + 1, size - i);
        elements[i] = t;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        T[] arr = (T[]) collection.toArray();
        if ((elements.length - size) < arr.length) {
            elements = Arrays.copyOf(elements, size + arr.length);
        }
        System.arraycopy(arr, 0, elements, size, arr.length);
        size += arr.length;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String dilimeter = "";
        for (int i = 0; i < size; i++) {
            sb.append(dilimeter).append(elements[i]);
            dilimeter = ", ";
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
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
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
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
}
