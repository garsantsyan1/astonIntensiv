package org.example.customArrayList;

import org.example.quickSort.QuickSort;

import java.util.Collection;
import java.util.Comparator;


public class ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elementData = new Object[initialCapacity];
        size = 0;
    }

    public void add(E element) {
        if (size == elementData.length) {
            extend();
        }
        elementData[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (size == elementData.length) {
            extend();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] newElementsData = c.toArray();
        int numNewElements = newElementsData.length;
        ensureCapacity(size + numNewElements);
        System.arraycopy(newElementsData, 0, elementData, size, numNewElements);
        size += numNewElements;
        return numNewElements != 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (E) elementData[index];
    }

    public void set(E element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        elementData[index] = element;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        E oldValue = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        size--;
        elementData[size] = null; // Очистка последнего элемента
        return oldValue;
    }

    public boolean remove(Object o) {
        for (int index = 0; index < size; index++) {
            if (o.equals(elementData[index])) {
                remove(index);
                return true;
            }
        }
        return false;
    }

    public void sort(Comparator<? super E> c) {
        QuickSort.sort(elementData, c);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isExists(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(elementData[i])) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void extend() {
        int newCapacity = elementData.length + (elementData.length >> 1); // Увеличение на 50%
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            extend();
        }
    }
}


