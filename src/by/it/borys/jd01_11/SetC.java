package by.it.borys.jd01_11;

import java.util.*;

public class SetC<T> extends HashSet<T> {
    private T[] elements= (T[]) new Object[]{};

    private int size = 0;

    @Override
    public boolean add(T t) {
        if (this.contains(t)) return false;
        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[size++] =(T) t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0, elementsLength = elements.length; i < elementsLength; i++) {
           if (Objects.equals(elements[i],o)) {
                System.arraycopy(elements,i+1,elements,i,elementsLength-i-1 );
                size--;
            }
        }
        if (size>0){
        elements = Arrays.copyOf(elements, size);}
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (Objects.equals(element,o)) return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c==null) return false;
        Object[] objects = c.toArray();
        for (Object object : objects) {
            if (!this.contains(object)){
                elements = Arrays.copyOf(elements, elements.length + 1);
                elements[size++] = (T)object;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
           return size ==0;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] objects = c.toArray();
         for (Object object : objects) {
             boolean check = false;
            if (this.contains(object)) check=true;
            if (!check) return false;
        }
        return true;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
       Object[] objects = c.toArray();
        for (Object object : objects) {
             if (this.contains(object)) {
                 this.remove(object);}
        }
        return true;
    }
    @Override
    public void clear() {
        for (T t : elements) {
        t=null;}
        size =0;
    }

   @Override
    public String toString() {
        StringBuilder sb =new StringBuilder("[");
        String delimiter = "";
       for (T t : elements) {
           sb.append(delimiter).append(t);
           delimiter = ", ";
       }
        return sb.append("]").toString();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements,size);
    }

    @Override
    public Iterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public Object clone() {
        return super.clone();
    }
    @Override
    public Spliterator<T> spliterator() {
        return super.spliterator();
    }
}
