package org.unl.pacas.base.controller.data_struct.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Lista enlazada simple genérica.
 * @param <E> Tipo de dato almacenado.
 */
public class LinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> last;
    private int length;

    public LinkedList() {
        head = null;
        last = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        length++;
    }

    public E get(int pos) {
        if (pos < 0 || pos >= length) throw new IndexOutOfBoundsException("Índice fuera de rango");
        Node<E> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void update(E data, int pos) {
        if (pos < 0 || pos >= length) throw new IndexOutOfBoundsException("Índice fuera de rango");
        Node<E> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        current.setData(data);
    }

    public E delete(int pos) {
        if (pos < 0 || pos >= length) throw new IndexOutOfBoundsException("Índice fuera de rango");
        Node<E> current = head;
        if (pos == 0) {
            E data = head.getData();
            head = head.getNext();
            if (length == 1) last = null;
            length--;
            return data;
        }
        for (int i = 0; i < pos - 1; i++) {
            current = current.getNext();
        }
        E data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        if (pos == length - 1) last = current;
        length--;
        return data;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] array = (E[]) new Object[length];
        Node<E> current = head;
        for (int i = 0; i < length; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    public void clear() {
        head = null;
        last = null;
        length = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    // Extra: imprimir la lista (opcional)
    public String print() {
        if (isEmpty()) return "Lista vacía";
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}