package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        int id_list_length = id_list.length;
        int[] answer = new int[id_list_length];

        // key : id, value: [id index, report count, report status of user1, report status of user2, ...]
        Map<String, int[]> report_info = new HashMap<>();
        for(int i=0; i<id_list_length; i++) {
            int[] report_info_array = new int[id_list_length + 2];
            report_info_array[0] = i;
            report_info.put(id_list[i], report_info_array);
        }

        StringTokenizer st;
        for(int i=0; i<report.length; i++) {
            st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            int[] report_info_array = report_info.get(to);
            int from_index = report_info.get(from)[0];

            // 신고 횟수, 신고자 기록
            if(report_info_array[from_index + 2] == 0) {  // 본인을 신고한 이용자로부터 신고를 또다시 받지 않음
                report_info_array[1]++;
                report_info_array[from_index + 2] = 1;
            }
        }

        // 정지 메일 발송
        for(int i=0; i<id_list_length; i++) {
            int[] report_info_array = report_info.get(id_list[i]);

            if(report_info_array[1] >= k) { // 해당 유저 정지 유무
                for(int j=0; j<id_list_length; j++) { // 메일 보내기
                    if(report_info_array[2 + j] == 1) {
                        answer[j]++;
                    }
                }
            }
        }


        return answer;
    }
}


