package by.it.okatov.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private final HashMap<T, Object> map;
    private static final Object IS_PRESENT = new Object();

    public SetC() {
        map = new HashMap<>();
    }

    @Override
    public boolean add(T element) {
        return map.put(element, IS_PRESENT) == null;
    }

    @SuppressWarnings({"unused", "SuspiciousMethodCalls"})
    //Testing method
    public boolean removeHashMapImplementation(Object o) {
        return map.remove(o).equals(IS_PRESENT);
    }

    @Override
    public boolean remove(Object o) {
        Iterator<T> it = this.iterator();
        boolean isRemoved = false;
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    it.remove();
                    isRemoved = true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (it.next().equals(o)) {
                    it.remove();
                    isRemoved = true;
                }
            }
        }

        return isRemoved;
    }

    @SuppressWarnings({"unused", "SuspiciousMethodCalls"})
    //Testing method
    public boolean containsHashMapImplementation(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean contains(Object o) {
        Iterator<T> it = this.iterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] colObject = c.toArray();
        boolean isAdded = false;
        for (Object col : colObject) {
            isAdded = add((T) col);
        }
        return isAdded;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] colObject = c.toArray();
        for (Object col : colObject) {
            if (!this.contains(col)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isRemoved = false;
        Iterator<T> it = this.iterator();
        if (c.size() != 0 /*&& c != null*/) {
            while (it.hasNext()) {
                if (c.contains(it.next())) {
                    it.remove();
                    isRemoved = true;
                }
            }
        }

        return isRemoved;
    }

    @Override
    public void clear() {
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (Map.Entry<T, Object> tObjectEntry : map.entrySet()) {
            sb.append(delimiter).append(tObjectEntry.getKey());
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
    //----------------------------------------------------STUBs---------------------------------------//

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
