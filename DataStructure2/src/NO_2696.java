import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());

            // 작은 숫자 넣어야 함.
            PriorityQueue<Integer> smallValues = new PriorityQueue<>(Collections.reverseOrder());

            // 큰 숫자 넣어야 함.
            PriorityQueue<Integer> largeValues = new PriorityQueue<>();

            System.out.println(m / 2 + 1);

            int loopCount = m / 10 + 1;

            int count = 1;
            for (int j = 0; j < loopCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    if (count % 20 == 0) {
                        System.out.println();
                    }

                    int value = Integer.parseInt(st.nextToken());

                    // 일단 작은 값들 모아놓은 큐에 값 넣고, 후 조정
                    if (smallValues.size() == largeValues.size()) {
                        smallValues.offer(value);
                    } else {
                        largeValues.offer(value);
                    }

                    // 사이즈 조정
                    if (!largeValues.isEmpty()) {
                        if (largeValues.peek() < smallValues.peek()) {
                            int largeValue = smallValues.poll();
                            int smallValue = largeValues.poll();

                            smallValues.offer(smallValue);
                            largeValues.offer(largeValue);
                        }
                    }

                    // 홀수일 때 계산 및 출력
                    if (count % 2 == 1) {
                        System.out.print(smallValues.peek() + " ");
                    }

                    count++;
                }
            }

            System.out.println();
        }

    }
}
