import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            int sum = 0;
            for(int j = 0; j < str.length(); j++) {
                if('A' <= str.charAt(j) && str.charAt(j) <= 'Z') {
                    continue;
                }
                sum += (str.charAt(j) - '0');
            }
            arr[i] = new Node(str, sum, str.length());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i].serial);
        }
    }

    static class Node implements Comparable<Node> {
        String serial;
        int sum;
        int length;
        Node (String serial, int sum, int length) {
            this.serial = serial;
            this.sum = sum;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            if(this.length == o.length) {
                if(this.sum == o.sum) {
                    return this.serial.compareTo(o.serial);
                }
                return this.sum - o.sum;
            }
            return this.length - o.length;
        }
    }
}