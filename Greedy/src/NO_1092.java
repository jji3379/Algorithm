import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1092
 */
public class NO_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> limits = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int limit = Integer.parseInt(st.nextToken());
            limits.add(limit);
        }

        Collections.sort(limits, Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());

        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int weight = Integer.parseInt(st.nextToken());
            boxes.add(weight);
        }

        Collections.sort(boxes, Collections.reverseOrder());

        if (boxes.get(0) > limits.get(0)) {
            System.out.print(-1);
            return;
        }

        int result = 0;

        while (!boxes.isEmpty()) {
            int boxIndex = 0;

            for (int limitIndex = 0; limitIndex < n; limitIndex++) {
                if (boxIndex >= boxes.size()) {
                    break;
                }

                int limit = limits.get(limitIndex);

                while (boxIndex < boxes.size()) {
                    if (boxes.get(boxIndex) <= limit) {
                        boxes.remove(boxIndex);
                        break;
                    }
                    boxIndex++;
                }
            }

            result++;
        }

        System.out.println(result);
    }
}
