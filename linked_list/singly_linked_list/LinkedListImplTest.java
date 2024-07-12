package linked_list.singly_linked_list;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LinkedListTest {

    private static LinkedList<Integer> linkedList;

    @BeforeAll
    static void setUp() {
        linkedList = new LinkedListImpl<>();
    }

    @Test
    @Order(1)
    void testToString() {
        assertThat(linkedList.toString()).isEqualTo("[]");
    }

    @Test
    @Order(2)
    void addLast() {
        linkedList.addLast(1);
        linkedList.addLast(2);

        assertThat(linkedList.toString()).isEqualTo("[1, 2]");
    }

    @Test
    @Order(3)
    void addFirst() {
        linkedList.addFirst(3);
        linkedList.addFirst(4);

        assertThat(linkedList.toString()).isEqualTo("[4, 3, 1, 2]");
    }

    @Test
    @Order(4)
    void size() {
        assertThat(linkedList.size()).isEqualTo(4);
    }

    @Test
    @Order(5)
    void add() {
        linkedList.add(2, 5);
        linkedList.add(linkedList.size(), 6);
        linkedList.add(0, 7);

        assertThat(linkedList.toString()).isEqualTo("[7, 4, 3, 5, 1, 2, 6]");
    }

    @Test
    @Order(6)
    void get() {
        assertThat(linkedList.get(2)).isEqualTo(3);
    }

    @Test
    @Order(7)
    void set() {
        linkedList.set(2, 8);

        assertThat(linkedList.toString()).isEqualTo("[7, 4, 8, 5, 1, 2, 6]");
    }

    @Test
    @Order(8)
    void removeFirst() {
        linkedList.removeFirst();

        assertThat(linkedList.toString()).isEqualTo("[4, 8, 5, 1, 2, 6]");
    }

    @Test
    @Order(9)
    void removeLast() {
        linkedList.removeLast();

        assertThat(linkedList.toString()).isEqualTo("[4, 8, 5, 1, 2]");
    }

    @Test
    @Order(10)
    void removeWithIndex() {
        linkedList.remove(2);
        linkedList.remove(0);
        linkedList.remove(linkedList.size()-1);

        assertThat(linkedList.toString()).isEqualTo("[8, 1]");
    }

    @Test
    @Order(11)
    void removeWithValue() {
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        linkedList.remove(3);

        assertThat(linkedList.toString()).isEqualTo("[8, 1, 2, 4, 5]");
    }
}