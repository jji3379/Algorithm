import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3151
 */
public class NO_3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            list.add(value);
        }

        Collections.sort(list);

        long result = 0;

        for (int i = 0; i < n - 1; i++) {
            int startValue = list.get(i);
            int lt = i + 1;
            int rt = n - 1;

            while (lt < rt) {
                int leftValue = list.get(lt);
                int rightValue = list.get(rt);
                int sum = startValue + leftValue + rightValue;

                if (sum > 0) {
                    rt--;
                } else if (sum == 0) {
                    if (leftValue == rightValue) {
                        long count = rt - lt + 1L;
                        result += count * (count - 1) / 2;
                        break;
                    } else {
                        long countLt = 1L;
                        long countRt = 1L;

                        while(lt + 1 < rt && leftValue == list.get(lt + 1)) {
                            countLt++;
                            lt++;
                        }

                        while(rt -1 > lt && rightValue == list.get(rt - 1)) {
                            countRt++;
                            rt--;
                        }

                        result += countLt * countRt;

                        lt++;
                        rt--;
                    }
                } else {
                    lt++;
                }
            }
        }

        System.out.println(result);
    }
}
