import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20207
 */
public class NO_20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[366];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                cnt[j]++;
            }
        }

        int sum = 0;
        int maxHeight = 0;
        int width = 0;

        for (int i = 0; i <= 365; i++) {
            if (cnt[i] == 0) {
                sum += maxHeight * width;

                maxHeight = 0;
                width = 0;
                continue;
            }

            width++;
            maxHeight = Math.max(maxHeight, cnt[i]);
        }

        sum += maxHeight * width;

        System.out.println(sum);
    }
}
