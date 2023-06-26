import java.util.*;

/**
 * Klasse zur Implementierung eines MinHeap als generische Klasse, welcher Objekte speichern kann, die
 * das Interface java.lang.Comparable implementieren.
 * 
 * @JonasNeu_MarcPerwak
 */
public class MinHeapKlasse<E extends Comparable<E>> implements Queue<E> {

    private E[] heapQueue;
    private int size;

    /**
     * Erzeugt eine neue Instanz der MinHeapKlasse mit der angegebenen Kapazität.
     *
     * @param kapazitaet die maximale Kapazität des Min-Heaps
     */
    public MinHeapKlasse(int kapazitaet) {
        this.heapQueue = (E[]) new Comparable[kapazitaet];
        this.size = 0;
    }

    /**
     * Fügt das angegebene Element in den Min-Heap ein.
     *
     * @param e das einzufügende Element
     * @return true, wenn das Element erfolgreich eingefügt wurde, andernfalls false
     */
    @Override
    public boolean offer(E e) {
        if (size == heapQueue.length)
            return false;
        heapQueue[size] = e;
        // Heap - Eigenschaft wiederherstellen
        int i = size;
        while (i > 0) {
            // Elternknoten bestimmen
            int p = (i - 1) / 2;
    
            // Heap - Eigenschaft verletzt ?
            if (heapQueue[i].compareTo(heapQueue[p]) < 0) {
                E temp = heapQueue[i];
                heapQueue[i] = heapQueue[p];
                heapQueue[p] = temp;
    
                i = p;
            } else {
                break;
            }
        }
        size++;
        return true;
    }
    
    /**
     * Entfernt und gibt das kleinste Element aus dem Min-Heap zurück.
     *
     * @return das kleinste Element im Min-Heap, oder null, wenn der Heap leer ist
     */
    @Override
    public E poll() {
        if (size == 0)
            return null;
    
        E result = heapQueue[0];
    
        // Ersten Wert aus Array entfernen
        E temp = heapQueue[0];
        heapQueue[0] = heapQueue[size - 1];
        heapQueue[size - 1] = null;
        size--;
    
        // Heap - Eigenschaft wiederherstellen
        int i = 0;
        while (i < size / 2 - 1) {
            // Linker Kindknoten
            int l = 2 * i + 1;
    
            // Rechter Kindknoten
            int r = 2 * i + 2;
    
            // Kleinerer Kindknoten
            int c = l;
            if (r < size && heapQueue[r].compareTo(heapQueue[l]) < 0) {
                c = r;
            }
    
            // Heap - Eigenschaft verletzt ?
            if (r < size && heapQueue[c].compareTo(heapQueue[i]) < 0) {
                temp = heapQueue[c];
                heapQueue[c] = heapQueue[i];
                heapQueue[i] = temp;
    
                i = c;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Gibt den Kopf Min-Heap zurück.
     *
     * @return Der Kopf im Min-Heap, oder null, wenn der Heap leer ist
     */
    @Override
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return heapQueue[0];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        throw new java.lang.UnsupportedOperationException();
    }
    
    //ERRORS
    @Override
    public boolean contains(Object o) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public E remove() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public E element() {
        throw new java.lang.UnsupportedOperationException();
    }
}
