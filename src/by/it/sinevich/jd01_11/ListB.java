package by.it.sinevich.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Objects[]{};
    private int size=0;
    public T[] getElements() {
        return elements;
    }

    @Override
    public boolean add(T t) {
        if(size==elements.length){
            elements=Arrays.copyOf(elements,(elements.length*3)/2+1);
        }
        elements[size]=t;
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if(size==elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        for (int i = size-1; i >= index; i--) {
            if(i!=index) {
                elements[i] = elements[i + 1];
            }
            else {
                elements[i]=element;
            }
        }
    }

    @Override
    public T remove(int index) {
        T del = elements[index];
        System.arraycopy(elements,index+1,elements, index,size-1-index);
        size--;
        return del;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        elements[index]=element;
        return element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int firstSize = elements.length;
        elements=Arrays.copyOf(elements,size+c.size());
        for (int i = firstSize; i < elements.length; i++) {
            elements[i]=get(i);
        }
        return false;
    }

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0, elementsLength = size; i < elementsLength; i++) {
            T element = elements[i];
            sb.append(element).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.setCharAt(sb.length() - 1, ']');
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
}
