import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/8980
 */
public class NO_8980 {
    private static class Box implements Comparable<Box> {
        private int send, receive, count;

        public Box(int send, int receive, int count) {
            this.send = send;
            this.receive = receive;
            this.count = count;
        }

        public int compareTo(Box b) {
            if (this.receive == b.receive) {
                return Integer.compare(this.send, b.send);
            }

            return Integer.compare(this.receive, b.receive);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        List<Box> delivery = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int send = Integer.parseInt(st.nextToken());
            int receive = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            Box box = new Box(send, receive, count);
            delivery.add(box);
        }

        Collections.sort(delivery);

        int[] town = new int[n];
        Arrays.fill(town, c);

        int result = 0;

        // 배송지 순으로 정렬되어 있는 상태
        for (int i = 0; i < m; i++) {
            Box box = delivery.get(i);

            // 구간의 가장 낮은 용량 찾기
            int min = Integer.MAX_VALUE;
            for (int j = box.send; j < box.receive; j++) {
                min = Math.min(min, town[j]);
            }

            // 전부 실을 수 있는 상태면
            if (min >= box.count) {
                for (int j = box.send; j < box.receive; j++) {
                    // 이동지점까지 실을 수 있는 용량 -
                    town[j] -= box.count;
                }
                result += box.count;

            // 전부 실을 수 없으면
            } else {
                for (int j = box.send; j < box.receive; j++) {
                    // 가장 낮은 용량만 적용해서
                    town[j] -= min;
                }

                // 이동
                result += min;
            }
        }

        System.out.print(result);
    }
}
