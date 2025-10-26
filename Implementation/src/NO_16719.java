import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/16719
 */
public class NO_16719 {
    static String input;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        visited = new boolean[input.length()];

        zoac(0, input.length() - 1);
    }

    private static void zoac(int left, int right) {
        if (left > right) {
            return;
        }

        // 현재 문자열 중 사전식 가장 낮은 글자 찾기
        int idx = left;
        for (int i = left; i <= right; i++) {
            if (input.charAt(idx) > input.charAt(i)) {
                idx = i;
            }
        }

        visited[idx] = true;

        for (int i = 0; i < input.length(); i++) {
            if (visited[i]) {
                System.out.print(input.charAt(i));
            }
        }

        System.out.println();

        // 현재 문자보다 뒤에 있는 문자열 탐색
        zoac(idx + 1, right);

        // 현재 문자보다 앞에 있는 문자열 탐색
        zoac(left, idx - 1);
    }
}
