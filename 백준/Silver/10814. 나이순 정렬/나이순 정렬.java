import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class User implements Comparable<User> {
		int age;
		String name;
		
		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}

		
		@Override
		public String toString() {
			return age + " " + name;
		}

		@Override
		public int compareTo(User o) {
			return this.age - o.age;
		}
		
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	User[] userArr = new User[n];
	for(int i = 0; i < n; i++) {
		userArr[i] = new User(sc.nextInt(), sc.next());
	}
	Arrays.sort(userArr);
	for(int i = 0; i < n; i++) {
		System.out.println(userArr[i]);
	}
}
}
