import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22862
 */
public class NO_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());

            arr[i] = value % 2 == 0;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < n) {
            if (count < k) {
                if (!arr[right]) {
                    count++;
                }

                right++;
                max = Math.max(max, right - left - count);
            } else if (arr[right]) {
                right++;
                max = Math.max(max, right - left - count);
            } else {
                if (!arr[left]) {
                    count--;
                }

                left++;
            }
        }

        System.out.println(max);
    }
}
