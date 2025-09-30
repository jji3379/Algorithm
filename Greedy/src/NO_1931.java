import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class NO_1931 {
    private static class Meeting implements Comparable<Meeting> {
        private int start, end, time;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
            this.time = end - start;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.end == m.end) {
                return Integer.compare(this.start, m.start);
            }

            return Integer.compare(this.end, m.end);
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

            Meeting meeting = new Meeting(start, end);
            meetings.add(meeting);
        }

        Collections.sort(meetings);

        int result = 0;
        int prevEndTime = 0;

        for (int i = 0; i < n; i++) {
            Meeting meeting = meetings.get(i);

            if (prevEndTime <= meeting.start) {
                prevEndTime = meeting.end;
                result++;
            }
        }

        System.out.print(result);
    }
}
