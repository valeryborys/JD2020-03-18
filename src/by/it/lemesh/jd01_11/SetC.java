package by.it.lemesh.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private Map map = new HashMap();
    private static final Object PRESENT = new Object();

    @Override
    public boolean add(T t) {
        map.put(t, PRESENT);
        return false;
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<T> it = (Iterator<T>) collection.iterator();
        while (it.hasNext()) {
            map.put(it.next(), PRESENT);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean flag = true;
        Iterator<T> it = (Iterator<T>) collection.iterator();
        while (it.hasNext()) {
            boolean res = map.containsKey(it.next());
            if (!res) flag = false;
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = false;
        for (Object o : collection) {
            if (map.containsKey(o)) {
                map.remove(o);
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        Set<T> hSet = map.keySet();
        StringBuilder sb = new StringBuilder("[");
        String dilimeter = "";
        for (T t : hSet) {
            sb.append(dilimeter).append(t);
            dilimeter = ", ";
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
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }
}
