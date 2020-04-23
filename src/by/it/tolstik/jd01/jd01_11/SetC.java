package by.it.tolstik.jd01.jd01_11;

import java.util.*;

class SetC<T> implements Set<T> {
    private final HashMap<T,Object> map = new HashMap();
    private static final Object objects = new Object();

    @Override
    public boolean add(T t) {
        return map.put(t, objects)==null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==objects;
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
            map.put(it.next(), objects);
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
        Set<T> set = map.keySet();
        StringBuilder sb = new StringBuilder("[");
        String dilimeter = "";
        for (T t : set) {
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
