import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22945
 */
public class NO_22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        int result = 0;

        while (left < right) {
            int leftValue = arr[left];
            int rightValue = arr[right];
            int size = right - left - 1;
            int min = Math.min(leftValue, rightValue);

            result = Math.max(result, size * min);

            if (leftValue > rightValue) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(result);
    }
}
