import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] isUsed = new int[26];

        StringBuilder sb = new StringBuilder();
        String[] origin = new String[N];
        int[] shortcutPositions = new int[N]; // 단축키 위치 저장 (-1이면 단축키 없음)

        for (int i = 0; i < N; i++) {
            origin[i] = br.readLine();
            String[] words = origin[i].split(" ");
            shortcutPositions[i] = -1; // 초기값 설정

            // 첫 글자 단축키 확인
            for (int j = 0; j < words.length; j++) {
                char firstChar = words[j].toUpperCase().charAt(0);
                if (isUsed[firstChar - 'A'] == 0) {
                    isUsed[firstChar - 'A'] = 1; // 사용 처리
                    shortcutPositions[i] = origin[i].indexOf(words[j]); // 첫 글자의 위치 저장
                    break;
                }
            }

            // 첫 글자에서 단축키가 설정되지 않았다면, 나머지 글자 확인
            if (shortcutPositions[i] == -1) {
                for (int j = 0; j < words.length; j++) {
                    String word = words[j];
                    for (int k = 0; k < word.length(); k++) {
                        char currentChar = word.toUpperCase().charAt(k);
                        if (isUsed[currentChar - 'A'] == 0) {
                            isUsed[currentChar - 'A'] = 1; // 사용 처리
                            shortcutPositions[i] = origin[i].indexOf(word) + k; // 해당 글자의 위치 저장
                            break;
                        }
                    }
                    if (shortcutPositions[i] != -1) break; // 단축키 설정 완료
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            String now = origin[i];
            int shortcutPosition = shortcutPositions[i];
            for (int j = 0; j < now.length(); j++) {
                if (j == shortcutPosition) {
                    sb.append("[").append(now.charAt(j)).append("]");
                } else {
                    sb.append(now.charAt(j));
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}