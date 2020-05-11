package by.it.novikov.jd01_11;

import java.util.*;

class SetC<T> implements Set<T> {
    private T[] elems = (T[]) new Object[]{};
    private int size = 0;

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
    public boolean add(T t) {
        if (!contains(t)) {
            if (size == elems.length) {
                elems = Arrays.copyOf(elems, size * 3 / 2 + 1);
            }
            elems[size++] = t;
            return true;
        }
        return false;
    }


    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elems[i] == null) {
                    System.arraycopy(elems, i + 1, elems, i, size - i);
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elems[i] != null && elems[i].equals(o)) {
                    System.arraycopy(elems, i + 1, elems, i, size - i - 1);
                    size--;
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public void clear() {
        elems = null;
        size = 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
           add(t);
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
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elems[i] == null)
                    return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elems[i] != null && o.equals(elems[i])) {
                    return true;
                }
            }
        }
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
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }




    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}