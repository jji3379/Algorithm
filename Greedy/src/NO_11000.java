import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11000
 */
public class NO_11000 {
    private static class Class implements Comparable<Class>{
        private int start, end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class o) {
            if (this.start == o.start) {
                return Integer.compare(this.end, o.end);
            }

            return Integer.compare(this.start, o.start);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Class> classes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Class c = new Class(start, end);
            classes.add(c);
        }

        Collections.sort(classes);

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (Class c : classes) {
            if (!endTimes.isEmpty() && endTimes.peek() <= c.start) {
                endTimes.poll();
            }

            endTimes.offer(c.end);
        }

        System.out.print(endTimes.size());
    }
}
