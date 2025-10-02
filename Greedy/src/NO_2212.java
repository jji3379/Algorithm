import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2212
 */
public class NO_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            list.add(value);
        }

        Collections.sort(list);

        for (int i = 0; i < n - 1; i++) {
            int distance = Math.abs(list.get(i) - list.get(i + 1));
            if (distance != 0) {
                lengths.add(distance);
            }
        }

        Collections.sort(lengths);

        int result = 0;
        int size = lengths.size() - k;

        for (int i = 0; i <= size; i++) {
            result += lengths.get(i);
        }

        System.out.print(result);
    }
}
