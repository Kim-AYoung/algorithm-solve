package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10814_나이순정렬 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Person[] personArr = new Person[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            personArr[i] = new Person(age, name);
        }

        Arrays.sort(personArr, (p1, p2) -> p1.age - p2.age);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(personArr[i] + "\n");
        }
        System.out.println(sb);
    }

    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
