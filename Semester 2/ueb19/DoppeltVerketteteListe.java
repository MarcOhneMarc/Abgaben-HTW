import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoppeltVerketteteListe<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.data = element;
            this.previous = prev;
            this.next = next;
        }
    }

    public DoppeltVerketteteListe() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);

        int index = 0;
        Object[] result = a;
        for (Node<E> node = head; node != null; node = node.next)
            result[index++] = node.data;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.data == null) {
                    unlink(node);
                    return true;
                }
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (o.equals(node.data)) {
                    unlink(node);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public void clear() {
        for (Node<E> node = head; node != null; ) {
            Node<E> next = node.next;
            node.data = null;
            node.next = null;
            node.previous = null;
            node = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return nodeAt(index).data;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = nodeAt(index);
        E oldData = node.data;
        node.data = element;
        return oldData;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size)
            linkLast(element);
        else
            linkBefore(element, nodeAt(index));
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(nodeAt(index));
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.data == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (o.equals(node.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    // Private helper methods

    private void linkLast(E element) {
        Node<E> newNode = new Node<>(element, tail, null);
        if (tail == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        size++;
    }

    private void linkBefore(E element, Node<E> succ) {
        Node<E> pred = succ.previous;
        Node<E> newNode = new Node<>(element, pred, succ);
        succ.previous = newNode;
        if (pred == null)
            head = newNode;
        else
            pred.next = newNode;
        size++;
    }

    private E unlink(Node<E> node) {
        E element = node.data;
        Node<E> prev = node.previous;
        Node<E> next = node.next;

        if (prev == null)
            head = next;
        else {
            prev.next = next;
            node.previous = null;
        }

        if (next == null)
            tail = prev;
        else {
            next.previous = prev;
            node.next = null;
        }

        node.data = null;
        size--;
        return element;
    }

    private Node<E> nodeAt(int index) {
        if (index < (size >> 1)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--)
                node = node.previous;
            return node;
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public Iterator<E> iterator() {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // Not implemented
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // Not implemented
        throw new UnsupportedOperationException();
    }
}
