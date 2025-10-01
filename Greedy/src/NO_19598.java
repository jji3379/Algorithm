import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/19598
 */
public class NO_19598 {
    private static class Meeting implements Comparable<Meeting> {
        private int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.start == m.start) {
                return Integer.compare(this.end, m.end);
            }

            return Integer.compare(this.start, m.start);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.offer(meetings.get(0).end);

        for (int i = 1; i < n; i++) {
            Meeting meeting = meetings.get(i);

            if (ends.peek() <= meeting.start) {
                ends.poll();
            }

            ends.offer(meeting.end);
        }

        System.out.print(ends.size());
    }
}
