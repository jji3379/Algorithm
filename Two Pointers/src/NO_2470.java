import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2470
 */
public class NO_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            list.add(value);
        }

        Collections.sort(list);


        int leftResult = 0;
        int rightResult = 0;

        int min = Integer.MAX_VALUE;

        int lt = 0;
        int rt = n - 1;

        while (lt < rt) {
            int leftValue = list.get(lt);
            int rightValue = list.get(rt);

            int sum = leftValue + rightValue;

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                leftResult = list.get(lt);
                rightResult = list.get(rt);

                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(leftResult + " " + rightResult);
    }
}
