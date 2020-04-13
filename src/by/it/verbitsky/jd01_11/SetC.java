package by.it.verbitsky.jd01_11;

import java.util.*;

class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    private void increaseElemetsSize() {
        elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
    }

    @Override
    public boolean contains(Object o) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                T e = elements[i];
                if (Objects.equals(e, o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(Object item) {
        if (!this.contains(item)) {
            if (size == elements.length) {
                increaseElemetsSize();
            }
            elements[size] = (T) item;
            size++;
            return true;
        }
        System.out.printf("Set already contains element < %s > . Add result: ", item.toString());
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            T e = elements[i];
            if (Objects.equals(e, o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
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
    public boolean addAll(Collection c) {
        if (c.size() != 0) {
            for (Object o : c) {
                if (!this.contains(o)) {
                    this.add(o);
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c.size() != 0) {
            for (Object o : c) {
                return this.contains(o);
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (c.size() != 0) {
            for (Object o : c) {
                this.remove(o);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (T e : elements) {
            e = null;
        }
        size = 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (size > 0) {
            for (int i = 0, elementsLength = size; i < elementsLength; i++) {
                T element = elements[i];
                sb.append(element).append(", ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.setCharAt(sb.length() - 1, ']');
        }
        if (size == 0) {
            sb.append("]");
        }
        return sb.toString();
    }

    //--------------------------------------Stubs
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
