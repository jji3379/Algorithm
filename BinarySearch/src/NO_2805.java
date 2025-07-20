import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1000000000;
        int height = 0;

        while (left <= right) {
            long sum = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= m) {
                height = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(height);
    }
}
