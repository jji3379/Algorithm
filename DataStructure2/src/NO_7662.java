import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 테스트 케이스 수
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQueue = new PriorityQueue();
            PriorityQueue<Integer> maxQueue = new PriorityQueue(Collections.reverseOrder());

            Map<Integer, Integer> map = new HashMap<>();

            // 연산 받기
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (operation.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                    minQueue.add(value);
                    maxQueue.add(value);
                } else {
                    if (map.size() == 0) {
                        continue;
                    }

                    if (value == 1) {
                        // 최댓값 삭제
                        remove(maxQueue, map);
                    } else {
                        // 최솟값 삭제
                        remove(minQueue, map);
                    }
                }
            }


            if (map.size() == 0) {
                System.out.println("EMPTY");
            } else {
                int max = remove(maxQueue, map);
                if (map.size() > 0) {
                    int min = remove(minQueue, map);
                    System.out.println(max + " " + min);
                } else {
                    System.out.println(max + " " + max);
                }
            }
        }
    }


    private static int remove(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        int num;
        while(true) {
            num = queue.poll();
            int count = map.getOrDefault(num, 0);

            if (count == 0) {
                continue;
            }

            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }

            break;
        }

        return num;
    }
}
