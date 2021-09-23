package Model.Part2.MyLinkedList;

public interface MyLinkedListInterface<E> extends Iterable<E>, MyDescendingIteator<E> {
    void addLast(E e);
    void addFirst(E e);
    int size();
    E getElementByIndex(int index);
}
