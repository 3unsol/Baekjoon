import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> company = new HashMap<>();
        StringTokenizer st;

        for(int i = 0; i < n; i++){

            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(company.containsKey(name)){
                company.remove(name);
            }else{
                company.put(name, status);
            }
        }

        // keySet() : 해시맵을 순회하면서 key값만 모아놓은 set 만들어준다.
        ArrayList<String> names = new ArrayList<>(company.keySet());
        Collections.sort(names, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < names.size(); i++){
            sb.append(names.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}