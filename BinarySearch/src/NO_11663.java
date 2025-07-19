import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO_11663 {
    static int[] points;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        points = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());

            int result = rightCount(endPoint) - leftCount(startPoint);
            System.out.println(result);
        }
    }

    private static int rightCount(int endPoint) {
        int left = 0;
        int right = points.length;

        while (left < right) {
            int midIndex = (left + right) / 2;

            if (points[midIndex] > endPoint) {
                right = midIndex;
            } else {
                left = midIndex + 1;
            }
        }

        return left;
    }

    private static int leftCount(int startPoint) {
        int left = 0;
        int right = points.length;

        while (left < right) {
            int midIndex = (left + right) / 2;

            if (points[midIndex] >= startPoint) {
                right = midIndex;
            } else {
                left = midIndex + 1;
            }
        }

        return left;
    }
}
