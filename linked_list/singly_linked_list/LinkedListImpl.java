package linked_list.singly_linked_list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedListImpl<E> implements LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(value);
            return;
        } else if (index == size) {
            addLast(value);
            return;
        }

        Node<E> newNode = new Node<>(value);
        Node<E> prevNode = searchNode(index - 1);
        Node<E> nextNode = prevNode.next();

        newNode.linking(nextNode);
        prevNode.linking(newNode);

        size++;
    }

    @Override
    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);

        newNode.linking(head);
        head = newNode;

        size++;
        if (size == 1) {
            tail = newNode;
        }
    }

    @Override
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);

        if (size == 0) {
            addFirst(value);
            return;
        }

        tail.linking(newNode);
        tail = newNode;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeFirst();
        }

        Node<E> prevNode = searchNode(index - 1);
        Node<E> targetNode = prevNode.next();
        Node<E> nextNode = targetNode.next();

        prevNode.linking(nextNode);
        if (index == size - 1) {
            tail = prevNode;
        }

        size--;
        targetNode.setValue(null);
        targetNode.linking(null);
        return targetNode.getValue();
    }

    @Override
    public boolean remove(E value) {
        Node<E> prevNode = head;
        Node<E> currentNode = head;

        while (Objects.nonNull(currentNode)) {
            if (currentNode.getValue().equals(value)) {
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next();
        }

        if (Objects.isNull(currentNode)) {
            return false;
        } else if (currentNode.equals(head)) {
            removeFirst();
            return true;
        } else {
            Node<E> nextNode = currentNode.next();
            prevNode.linking(nextNode);
            if (Objects.isNull(nextNode)) {
                tail = prevNode;
            }

            size--;
            currentNode.linking(null);
            currentNode.setValue(null);
            return true;
        }
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node<E> removedNode = head;
        head = head.next();

        size--;
        if (size == 0) {
            tail = null;
        }
        removedNode.linking(null);
        removedNode.setValue(null);
        return removedNode.getValue();
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return searchNode(index).getValue();
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> targetNode = searchNode(index);
        targetNode.setValue(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");

        Node<E> n = head;
        while (Objects.nonNull(n.next())) {
            result.append(n.getValue())
                    .append(", ");
            n = n.next();
        }
        result.append(n.getValue())
                .append("]");

        return result.toString();
    }

    private Node<E> searchNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next();
        }
        return n;
    }
}
