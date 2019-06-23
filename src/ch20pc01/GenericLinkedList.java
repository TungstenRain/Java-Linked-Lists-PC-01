package ch20pc01;

/**
 * 
 * @author frank
 */
public class GenericLinkedList<E> {

    private class Node {
        Object value;
        Node next;
        
        Node(Object val, Node n) {
            value = val;
            next = n;
        }
        
        Node(Object val) {
            this(val, null);
        }
    }

    private Node first;
    private Node last;
    
    public void clear() {
        // TODO implement
        int index = 0;
        if(first != null) {
            Node temp = first;
            while( temp != null) {
                temp = temp.next;
                remove(index);
            }
        }
    }

    //index starts from 0
    public Object get(int index) {
        // TODO implement
        int i = 0;
        
        if(first != null) {
            Node temp = first;
            while( temp != null) {
                if(i == index) {
                    return temp.value;
                }
                i++;
                temp = temp.next;
            }
        }
        return null;
    }
    
    public Object set(int index, Object element) {
        // TODO implement
        int i = 0;
        if(first != null) {
            Node temp = first;
            while( temp != null) {
                if(i == index) {
                    Object prev = temp.value;
                    temp.value = element;
                    return prev;
                }
                i++;
                temp = temp.next;
            }
        }
        return null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
            // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }
    
    public void add(Object e) {
        if (isEmpty()) {
            first = new Node(e);
            last = first;
        } else {
            // Add to end of existing list
            last.next = new Node(e);
            last = last.next;
        }
    }
    
    public void add(int index, Object e) {
        if (index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        // Index is at least 0
        if (index == 0) {
            // New element goes at beginning
            first = new Node(e, first);
            if (last == null) {
                last = first;
            }
            return;
        }
        // Set a reference pred to point to the node that
        // will be the predecessor of the new node
        Node pred = first;
        for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;
        }
        // Splice in a node containing the new element
        pred.next = new Node(e, pred.next);
        // Is there a new last element ?
        if (pred.next.next == null) {
            last = pred.next;
        }
    }
    
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        // Use p to walk down the linked list
        Node p = first;
        while (p != null) {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }
    
    public Object remove(int index) {
        if (index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        Object element; // The element that will be returned
        if (index == 0) {
            // Removal of first item in the list
            element = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            // To remove an element other than the first,
            // find the predecessor of the element to
            // be removed.
            Node pred = first;
            // Move pred forward index - 1 times
            for (int k = 1; k <= index - 1; k++) {
                pred = pred.next;
            }
            // Store the value to return
            element = pred.next.value;
            // Route link around the node to be removed
            pred.next = pred.next.next;
            // Check if pred is now last
            if (pred.next == null) {
                last = pred;
            }
        }
        return element;
    }
    
    public boolean remove(Object element) {
        if (isEmpty()) {
            return false;
        }
        if (element.equals(first.value)) {
            // Removal of first item in the list
            first = first.next;
            if (first == null)
                last = null;
            return true;
        }
        // Find the predecessor of the element to remove
        Node pred = first;
        while (pred.next != null && !pred.next.value.equals(element)) {
            pred = pred.next;
        }
        // pred.next == null OR pred.next.value is element
        if (pred.next == null) {
            return false;
        }
        // pred.next.value is element
        pred.next = pred.next.next;
        // Check if pred is now last
        if (pred.next == null) {
            last = pred;
        }
        return true;
    }
}
