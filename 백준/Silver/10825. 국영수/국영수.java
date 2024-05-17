import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Student[] arr = new Student[N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, korean, english, math);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(Student student : arr) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean, english, math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {

            if(this.korean == o.korean) {
                if(this.english == o.english) {
                    if(this.math == o.math) {
                        return this.name.compareTo(o.name);
                    } else {
                        return o.math - this.math;
                    }
                } else {
                    return this.english - o.english;
                }
            }
            return o.korean - this.korean;
        }
    }
}