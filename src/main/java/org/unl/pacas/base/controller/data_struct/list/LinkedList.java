package org.unl.pacas.base.controller.data_struct.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * Lista enlazada genérica para el sistema
 * @param <E> Tipo de elemento (Persona, Producto, etc.)
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

    public int getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        return head == null || length == 0;
    }

    private Node<E> getNode(int pos) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List empty");
        } else if (pos < 0 || pos >= length) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        } else if (pos == 0) {
            return head;
        } else if ((length - 1) == pos) {
            return last;
        } else {
            Node<E> search = head;
            int cont = 0;
            while (cont < pos) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    public E get(int pos) {
        return getNode(pos).getData();
    }

    private void addFirst(E data) {
        if (isEmpty()) {
            Node<E> aux = new Node<>(data);
            head = aux;
            last = aux;
        } else {
            Node<E> aux = new Node<>(data, head);
            head = aux;
        }
        length++;
    }

    private void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node<E> aux = new Node<>(data);
            last.setNext(aux);
            last = aux;
            length++;
        }
    }

    public void add(E data, int pos) {
        if (pos == 0) {
            addFirst(data);
        } else if (length == pos) {
            addLast(data);
        } else {
            Node<E> searchPreview = getNode(pos - 1);
            Node<E> search = getNode(pos);
            Node<E> aux = new Node<>(data, search);
            searchPreview.setNext(aux);
            length++;
        }
    }

    public void add(E data) {
        addLast(data);
    }

    public String print() {
        if (isEmpty())
            return "Esta vacía";
        else {
            StringBuilder resp = new StringBuilder();
            Node<E> help = head;
            while (help != null) {
                resp.append(help.getData()).append(" - ");
                help = help.getNext();
            }
            resp.append("\n");
            return resp.toString();
        }
    }

    public void update(E data, int pos) {
        getNode(pos).setData(data);
    }

    public void clear() {
        head = null;
        last = null;
        length = 0;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        if (this.length == 0) return null;
        E[] array = (E[]) java.lang.reflect.Array.newInstance(head.getData().getClass(), this.length);
        Node<E> aux = head;
        for (int i = 0; i < length; i++) {
            array[i] = aux.getData();
            aux = aux.getNext();
        }
        return array;
    }

    public LinkedList<E> toList(E[] array) {
        clear();
        for (E e : array) {
            this.add(e);
        }
        return this;
    }

    protected E deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List empty");
        } else {
            E element = head.getData();
            head = head.getNext();
            if (length == 1)
                last = null;
            length--;
            return element;
        }
    }

    protected E deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("List empty");
        } else if (length == 1) {
            return deleteFirst();
        } else {
            E element = last.getData();
            Node<E> aux = getNode(length - 2);
            last = aux;
            last.setNext(null);
            length--;
            return element;
        }
    }

    public E delete(int pos) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List empty");
        } else if (pos < 0 || pos >= length) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        } else if (pos == 0) {
            return deleteFirst();
        } else if ((length - 1) == pos) {
            return deleteLast();
        } else {
            Node<E> preview = getNode(pos - 1);
            Node<E> actual = getNode(pos);
            E element = actual.getData();
            preview.setNext(actual.getNext());
            length--;
            return element;
        }
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
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    public E find(Function<E, Boolean> predicate) {
        Node<E> current = head;
        while (current != null) {
            if (predicate.apply(current.getData())) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public <R> List<R> map(Function<E, R> mapper) {
        List<R> result = new ArrayList<>();
        for (E item : this) {
            result.add(mapper.apply(item));
        }
        return result;
    }

    public LinkedList<E> filter(Function<E, Boolean> predicate) {
        LinkedList<E> result = new LinkedList<>();
        for (E item : this) {
            if (predicate.apply(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean contains(Function<E, Boolean> predicate) {
        return find(predicate) != null;
    }

    public boolean updateIf(Function<E, Boolean> predicate, E newData) {
        Node<E> current = head;
        int pos = 0;
        while (current != null) {
            if (predicate.apply(current.getData())) {
                update(newData, pos);
                return true;
            }
            current = current.getNext();
            pos++;
        }
        return false;
    }

    public boolean removeIf(Function<E, Boolean> predicate) {
        Node<E> current = head;
        int pos = 0;
        while (current != null) {
            if (predicate.apply(current.getData())) {
                delete(pos);
                return true;
            }
            current = current.getNext();
            pos++;
        }
        return false;
    }

    public int size() {
        return length;
    }

    public Collection<E> toCollection() {
        return toJavaList();
    }

    public List<E> toJavaList() {
        List<E> list = new ArrayList<>();
        Node<E> current = head;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    /**
     * Busca una entidad por su ID (requiere que E tenga un método getId())
     */
    public E findById(Integer id) {
        return find(item -> {
            try {
                return item.getClass().getMethod("getId").invoke(item).equals(id);
            } catch (Exception e) {
                return false;
            }
        });
    }
}