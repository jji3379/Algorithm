import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_1450 {
    static int n;
    static int c;
    static int[] weights;
    static List<Long> leftSums = new ArrayList<>();
    static List<Long> rightSums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        weights = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        getSubSums(0, n / 2, 0, leftSums);
        getSubSums(n / 2, n, 0, rightSums);

        Collections.sort(rightSums);

        long count = 0;

        for (long left : leftSums) {
            long remain = c - left;
            int possibleCount = upperBound(rightSums, remain);
            count += possibleCount;
        }

        System.out.println(count);
    }

    static void getSubSums(int start, int end, long sum, List<Long> list) {
        if (sum > c) {
            return;
        }

        if (start == end) {
            list.add(sum);
            return;
        }

        getSubSums(start + 1, end, sum, list);
        getSubSums(start + 1, end, sum + weights[start], list);
    }

    static int upperBound(List<Long> list, long target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (right + left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
