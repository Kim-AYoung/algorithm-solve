package linked_list.singly_linked_list;

import java.util.Objects;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> next() {
        return next;
    }

    public void linking(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> e = (Node<?>) o;
        return Objects.equals(getValue(), e.getValue()) && Objects.equals(next, e.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), next);
    }
}
