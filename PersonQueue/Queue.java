/**
 * Interface for an Queue
 */
public interface Queue {
    public void addLast(Object o); //Objekt hinten anfuegen
    public Object removeFirst(); //erstes Element entferinen und
    //eine Referenz zurueckgeben.
    public Object get(int i); //Das i te Element zurueckgeben
    public boolean empty(); //Testen, ob die Queue leer ist
    public boolean full(); // Testen, ob noch Elemente einfuegbar sind
    public int size(); //Anzahl eingefuegter Elemente
}