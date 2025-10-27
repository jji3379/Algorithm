import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14719
 */
public class NO_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] grid = new int[w];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());
            grid[i] = height;
        }

        int result = 0;

        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(grid[j], left);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(grid[j], right);
            }

            if (grid[i] < left && grid[i] < right) {
                result += Math.min(left, right) - grid[i];
            }
        }

        System.out.println(result);
    }
}
