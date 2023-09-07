import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int testCase, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++){
            // 종류 당 하나의 옷만 입을 수 있기 때문에 개수를 세어주기 위해 해시맵 사용
            HashMap<String, Integer> hashMap = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 옷 이름은 필요없음
                st.nextToken();
                // 옷 종류
                String category = st.nextToken();
                // 이미 해시맵에 저장된 종류라면 value에 있는 개수 + 1 해주기
                if(hashMap.containsKey(category)){
                    hashMap.put(category, hashMap.get(category) + 1);
                }
                // 해시맵에 없는 종류라면 종류와 함께 1개 등록
                else{
                    hashMap.put(category, 1);
                }
            }
            // 곱셈을 위해 1로 초기화
            int result = 1;
            // 해시맵에 있는 value 하나씩 꺼내며
            for(int v : hashMap.values()){
                // 종류 당 1개만 입을 수 있기 때문에 각 종류 개수만큼 조합을 만들 수 있음
                // 각 종류의 개수를 곱해주면 최종 조합 개수를 구할 수 있음
                result *= (v + 1);
            }
            System.out.println(result - 1);
        }
    }

}