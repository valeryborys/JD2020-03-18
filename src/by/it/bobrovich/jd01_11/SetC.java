package by.it.bobrovich.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    int size = 0;

    @Override
    public boolean add(T t) {
        if (!contains(t)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length + 1);
            }
            elements[size++] = t;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (Objects.equals(elements[i], o)) {
                System.arraycopy(elements, i + 1, elements, i, elements.length - i - 1);
                size--;
            }
        }
        if(size > 0)
            elements = Arrays.copyOf(elements, size);
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (Objects.equals(element, o)) return true;
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
    public void clear() {
        removeAll(Arrays.asList(elements));
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null)
            return false;
        Object[] objects = c.toArray();
        for (Object object : objects) {
            if (!contains(object)) {
                elements = Arrays.copyOf(elements, elements.length + 1);
                elements[size++] = (T) object;
            }
        }
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] objects = c.toArray();
        boolean check = true;
        for (Object object : objects) {
            if (!contains(object))
                check = false;
        }
        return check;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        for (Object object : objects) {
            if (this.contains(object))
                this.remove(object);
        }
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

}
