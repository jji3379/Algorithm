import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_17266 {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minHeight = 1;
        int maxHeight = n;
        int result = 0;

        while (minHeight <= maxHeight) {
            int midHeight = (minHeight + maxHeight) / 2;

            if (possible(midHeight)) {
                result = midHeight;
                maxHeight = midHeight - 1;
            } else {
                minHeight = midHeight + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean possible(int height) {
        int covered = 0;

        for (int light : arr) {
            if (light - height > covered) {
                return false;
            }

            covered = Math.max(covered, light + height);
        }

        return covered >= n;
    }
}
