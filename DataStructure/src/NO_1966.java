import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_1966 {
    public static class Node {
        private int index;
        private int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < testCaseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int documentIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Node(j, priority));
                pq.add(priority);
            }

            System.out.println(findPrintCount(documentIndex, queue, pq));

            pq.clear();
            queue.clear();
        }
    }

    private static int findPrintCount(int documentIndex, Queue<Node> queue, PriorityQueue<Integer> pq) {
        int count = 1;
        int maxPriority = pq.poll();

        while (!queue.isEmpty() && maxPriority >= queue.peek().priority) {
            Node findNode = queue.poll();
            if (maxPriority > findNode.priority) {
                queue.add(findNode);
            } else if (findNode.index == documentIndex) {
                return count;
            } else {
                maxPriority = pq.poll();
                count++;
            }
        }

        return count;
    }
}
