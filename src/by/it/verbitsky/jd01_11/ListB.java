package by.it.verbitsky.jd01_11;


import java.util.*;

class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};

    public T[] getElements() {
        return elements;
    }

    //хранит точное кол-во элементов ( != размеру массива, т.к. в масиве есть пустые значения (резерв))
    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T replaceble = get(index);
        elements[index] = element;
        return replaceble;
    }

    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            increaseArray();
        }
        elements[size] = element;
        size++;
        return true;//возвращает успех операции вставки
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length) {
            increaseArray();
        }
        //копируем массив от удаляемого элемента до конца в позицию index = позиция удаляемого элемента
        System.arraycopy(elements, index, elements, index + 1, (size - index));
        set(index, element);
        size++;
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        //копируем массив от удаляемого элемента до конца в позицию index = позиция удаляемого элемента
        System.arraycopy(elements, index + 1, elements, index, (size - index - 1));
        size--;
        return deleted;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        System.out.println("add all");
        //По нормальному - нужно реализовать метод toArray и добавить копированием весь массив
        //+реализовать итератор
        //и использовать метод toArray;

        for (T element : collection) {
            this.add(element);
            System.out.println(size);
        }

        return true;
    }

    private void increaseArray() {
        elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
    }

    private void increaseArray(int count) {
        elements = Arrays.copyOf(elements, elements.length + count);
    }

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

    //--------------------------------------------------------------------------------------------
    //Stubs

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
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
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
}
