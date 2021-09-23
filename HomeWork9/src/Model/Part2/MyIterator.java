package Model.Part2;

import java.util.Iterator;

public class MyIterator <E> implements Iterator<E> {

    private E[] array;
    private int index = 0;

    public MyIterator(E[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public E next() {
        return array[index++];
    }

    @Override
    public void remove() {

    }
}
