import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20366
 */
public class NO_20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }

        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int snowman = arr[i] + arr[j];

                int left = 0;
                int right = n - 1;

                while (left < right) {
                    if (left == i || left == j) {
                        left++;
                        continue;
                    }

                    if (right == i || right == j) {
                        right--;
                        continue;
                    }

                    int snowman2 = arr[left] + arr[right];

                    result = Math.min(result, Math.abs(snowman2 - snowman));

                    if (snowman > snowman2) {
                        left++;
                    } else if (snowman < snowman2) {
                        right--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
