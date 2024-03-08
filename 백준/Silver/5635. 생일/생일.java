import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Person[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new Person[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            arr[i] = new Person(name, day, month, year);
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(arr[0].name);
        System.out.println(arr[N - 1].name);
    }

    static class Person implements Comparable<Person>{
        String name;
        int day;
        int month;
        int year;
        Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Person o) {
            if(this.year == o.year) {
                if(this.month == o.month) {
                    return this.day - o.day;
                }
                return this.month - o.month;
            }
            return this.year - o.year;
        }
    }


}