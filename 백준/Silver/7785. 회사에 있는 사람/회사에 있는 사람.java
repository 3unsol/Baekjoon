import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> company = new HashSet<>();
        StringTokenizer st;

        for(int i = 0; i < n; i++){

            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")) {
                company.add(name);
            }else{
                company.remove(name);
            }
        }

        // ArrayList 자리 만들어줄 때... 괄호 안에 넣을 집합 써주면 그거대로 해주는 듯
        // 용어 공부하자ㅎ..
        ArrayList<String> names = new ArrayList<>(company);
        Collections.sort(names, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < names.size(); i++){
            sb.append(names.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}