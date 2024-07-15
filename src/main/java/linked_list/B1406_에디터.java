package linked_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1406
 * 알고리즘
 * * 자바 기본 라이브러리의 LinkedList로 특정 index에 add할 경우, index 탐색 시간이 최악에는 O(N)이 소요되므로 시간초과 발생
 * * 따라서 커스텀 LinkedList를 통해, iterator처럼 최근 index를 기록하도록 함. -> 항상 최근 index에서 다음 작업을 수행하므로, index 탐색 시간은 O(1)로 축소
 * * 물론 커스텀 LinkedList 대신, 자바의 ListIterator를 사용하는 것이 더 편하다.
 * 시간복잡도 = O(N + M), N : 초기 문자열의 길이, M : 명령어의 개수
 */
public class B1406_에디터 {

    static Node cursorLeftNode;
    static Node headNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        if (charArray.length > 0) {
            Node prev = headNode = new Node(charArray[0]);
            for (int i = 1; i < charArray.length; i++) {
                Node newNode = new Node(charArray[i]);
                newNode.setPrev(prev);
                prev.setNext(newNode);
                prev = newNode;
            }
            cursorLeftNode = prev;
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L") && Objects.nonNull(cursorLeftNode)) {
                cursorLeftNode = cursorLeftNode.getPrev();
            } else if (command.equals("D")) {
                if (Objects.isNull(cursorLeftNode)) {
                    cursorLeftNode = headNode;
                } else {
                    Node nextNode = cursorLeftNode.getNext();
                    if (Objects.nonNull(nextNode)) cursorLeftNode = nextNode;
                }
            } else if (command.equals("P")) {
                Node newNode = new Node(st.nextToken().charAt(0));

                if (Objects.isNull(cursorLeftNode)) {
                    newNode.setNext(headNode);
                    if (Objects.nonNull(headNode)) headNode.setPrev(newNode);
                    headNode = newNode;
                } else {
                    Node nextNode = cursorLeftNode.getNext();
                    if (Objects.nonNull(nextNode)) nextNode.setPrev(newNode);
                    cursorLeftNode.setNext(newNode);
                    newNode.setPrev(cursorLeftNode);
                    newNode.setNext(nextNode);
                }
                cursorLeftNode = newNode;
            } else if (command.equals("B") && Objects.nonNull(cursorLeftNode)) {
                Node prevNode = cursorLeftNode.getPrev();
                Node nextNode = cursorLeftNode.getNext();
                if (Objects.nonNull(prevNode)) prevNode.setNext(nextNode);
                if (Objects.nonNull(nextNode)) nextNode.setPrev(prevNode);

                cursorLeftNode = prevNode;
                if (Objects.isNull(prevNode)) headNode = nextNode;
            }
        }

        Node n = headNode;
        StringBuilder sb = new StringBuilder();
        while (Objects.nonNull(n)) {
            sb.append(n.getData());
            n = n.getNext();
        }
        System.out.println(sb);
    }
}

class Node {
    private Node prev;
    private Node next;
    private char data;

    public Node(char data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
}
