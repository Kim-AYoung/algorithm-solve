package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1. 아이디어
 * 입력받은 문서의 중요성들을 인덱스와 함께 Document 객체로 저장해 큐에 넣는다.
 * 문서들을 하나씩 꺼내면서 뒤에 중요도가 높은 문서가 있는지 확인한다.
 * * 있다면, 중요도가 높은 문서전에 있는 모든 문서들을 뒤로 보낸다.\
 * * 없고 목표로하는 문서였다면, 반복문을 종료한다.
 * * 없고 목표로하는 문서가 아니면, 다음 문서를 꺼낸다.
 * <p>
 * 2. 자료구조
 * 문서들을 저장할 queue
 *
 * <p>
 * 3. 시간복잡도
 */
public class P1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<Document> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.offer(new Document(importance, i));
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                Document frontDocument = queue.poll();

                boolean isExistGreaterImportance = false;
                for (int i = 0; i < queue.size(); i++) {
                    if (frontDocument.importance < queue.get(i).importance) {
                        queue.offer(frontDocument);
                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        isExistGreaterImportance = true;
                        break;
                    }
                }

                if (!isExistGreaterImportance) {
                    answer++;
                    if (frontDocument.index == M) {
                        break;
                    }
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    static class Document {
        int importance;
        int index;

        public Document(int importance, int index) {
            this.importance = importance;
            this.index = index;
        }
    }
}
