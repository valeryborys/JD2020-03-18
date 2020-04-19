package by.it.novikov.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

class ListA<T> implements List<T> {
    private T[] elems = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elems.length) {
            elems = Arrays.copyOf(elems, size * 3 / 2 + 1);
        }
        elems[size++] = t;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (size == elems.length) {
            elems = Arrays.copyOf(elems, size * 3 / 2 + 1);
        }
       System.arraycopy(elems, index, elems, index + 1, size - index);
        elems[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
       int index = indexOf(o);
       if (index>-1) {
           remove(index);
       }
        return (index>-1);
    }

    @Override
    public T remove(int index) {
        T deletable = elems[index];
        System.arraycopy(elems, index+1, elems, index, size-1-index);
        size--;
        return deletable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elems[i]);
            delimiter = ", ";
        }
       sb.append("]");
        return sb.toString();
    }

    @Override
    public T get(int index) {
        return elems[index];
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
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
    public T set(int index, T element) {
        return null;
    }


    @Override
    public int indexOf(Object o) {
        if (o==null){
            for (int i = 0; i < elems.length; i++) {
                if (elems[i] == null){
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < elems.length; i++) {
                if (elems[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
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