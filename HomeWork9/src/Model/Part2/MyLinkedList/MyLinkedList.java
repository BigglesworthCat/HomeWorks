package Model.Part2.MyLinkedList;

import java.util.Iterator;

public class MyLinkedList<E> implements MyLinkedListInterface<E> {
    private Node<E> ftsNode;
    private Node<E> lstNode;

    private int size = 0;

    public MyLinkedList() {
        lstNode = new Node<>(null, ftsNode, null);
        ftsNode = new Node<>(null, null, lstNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lstNode;
        prev.setCurrentElem((E) e);
        lstNode = new Node<>(null, prev, null);
        prev.setNextElem(lstNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> fts = ftsNode;
        fts.setCurrentElem((E) e);
        ftsNode = new Node<>(null, null, fts);
        fts.setPrevElem(ftsNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int index) {
        Node<E> target = ftsNode.getNextElem();
        for(int i = 0; i < index; i++)
        {
            target = getNextElement(target);
        }
        return target.getCurrentEle();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElem();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return getElementByIndex(index++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<>() {
            int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(index--);
            }
        };
    }

    private static class Node<E> {
        E currentEle;
        Node<E> nextElem;
        Node<E> prevElem;

        Node(E currentEle, Node<E> prevElem, Node<E> nextElem) {
            this.currentEle = currentEle;
            this.nextElem = nextElem;
            this.prevElem = prevElem;
        }

        public E getCurrentEle() {
            return currentEle;
        }

        public Node<E> getPrevElem() {
            return prevElem;
        }

        public Node<E> getNextElem() {
            return nextElem;
        }

        public void setCurrentElem(E currentEle) {
            this.currentEle = currentEle;
        }

        public void setPrevElem(Node<E> prevElem) {
            this.prevElem = prevElem;
        }

        public void setNextElem(Node<E> nextElem) {
            this.nextElem = nextElem;
        }
    }
}
