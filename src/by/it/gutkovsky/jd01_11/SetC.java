package by.it.gutkovsky.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private List<T> list = new ListB<>();

    @Override
    public boolean add(T element) {
        if (list.contains(element)){
            return false;
        } else list.add(element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean contains(Object o) {
        return (list.contains(o));
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        if (list.size() == 0) return true;
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!list.contains(o)) return false;
        }
        return true;
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
        Iterator<T> it = list.iterator();
        while (it.hasNext()){
            removeAll(list);
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < list.size(); i++) {
            sb.append(delimiter).append(list.get(i));
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

//STUBS

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
