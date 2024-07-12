package linked_list.singly_linked_list;

public interface LinkedList<E> {
    void add(int index, E value);

    void addFirst(E value);

    void addLast(E value);

    E remove(int index);

    boolean remove(E value);

    E removeFirst();

    E removeLast();

    E get(int index);

    void set(int index, E value);

    int size();
}
