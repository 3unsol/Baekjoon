import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] recommendCnt;
    static int[] time;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 사진 틀 수
        m = Integer.parseInt(br.readLine()); // 추천 수
        recommendCnt = new int[101]; // 추천수 배열
        time = new int[101]; // 게시 시점
        list = new ArrayList<>(); // 추천 여부

        StringTokenizer st = new StringTokenizer(br.readLine());
        int candidate;

        for(int i = 1; i <= m; i++) {
            candidate = Integer.parseInt(st.nextToken());

            if(list.size() < n) { // 사진 틀 자리 남음
                if(!list.contains(candidate)) list.add(candidate); // 첫 추천이라면 추가
                recommendCnt[candidate]++; // 추천수 증가
            } else { // 사진 틀 꽉 참
                if(list.contains(candidate)) { // 이미 후보라면
                    recommendCnt[candidate]++; // 추천수 증가 후 넘어감
                    continue;
                }
                // 후보에 넣어야 한다면
                int min = 1001; // 최소 추천수
                int minIdx = 0; // 최소 후보 번호
                int minTime = Integer.MAX_VALUE;
                for(int idx : list) { // 최솟값 찾기
                    if(recommendCnt[idx] < min ||
                            (recommendCnt[idx] == min && time[idx] < minTime)) {
                        min = recommendCnt[idx];
                        minTime = time[idx];
                        minIdx = idx;
                    }
                }
                list.remove(Integer.valueOf(minIdx)); // 최소 후보 지우기
                recommendCnt[minIdx] = 0; // 추천수 리셋
                // 새로운 후보 추가
                list.add(candidate);
                recommendCnt[candidate]++;
            }

        }
        // 출력
        Collections.sort(list);
        for(int idx : list) {
            System.out.print(idx + " ");
        }
    }
}