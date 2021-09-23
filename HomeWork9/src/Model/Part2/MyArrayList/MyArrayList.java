package Model.Part2.MyArrayList;

import Model.Part2.MyIterator;

import java.util.*;

public class MyArrayList<E> implements MyArrayListInterface<E> {

    private E[] array;

    public MyArrayList() {
        array = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = array;
            array = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, array, 0, temp.length);
            array[array.length - 1] = e;
            return true;
        }
        catch(ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
/*        try {
            E[] temp = array;
            array = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, array, 0, index);
            System.arraycopy(temp, index + 1, array, index, temp.length - index - 1);
        }
        catch(ClassCastException ex) {
            ex.printStackTrace();
        }*/
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void update(int index, E e) {
        array[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(array);
    }
}
