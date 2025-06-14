package org.unl.pacas.base.controller.data_struct.list;

/**
 * Nodo genérico para la lista enlazada.
 * @param <E> Tipo de dato almacenado.
 */
public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data) {
        this(data, null);
    }

    public Node() {
        this(null, null);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}