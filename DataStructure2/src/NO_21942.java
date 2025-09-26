import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class NO_21942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String l = st.nextToken();

        String[] duration = l.split("/");
        int day = Integer.parseInt(duration[0]);
        String[] durationTime = duration[1].split(":");
        int hour = Integer.parseInt(durationTime[0]);
        int minute = Integer.parseInt(durationTime[1]);

        long standardMinutes = Duration.ofDays(day).plusHours(hour).plusMinutes(minute).toMinutes();

        int feePerMinute = Integer.parseInt(st.nextToken());

        Map<String, LocalDateTime> rentalLog = new HashMap<>();
        Map<String, Long> feeLog = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String ymd = st.nextToken();
            String time = st.nextToken();
            String device = st.nextToken();
            String name = st.nextToken();

            String key = name + device;

            String[] ymdStrArr = ymd.split("-");
            String[] timeStrArr = time.split(":");

            LocalDateTime currentTime = LocalDateTime.of(
                    Integer.parseInt(ymdStrArr[0]),
                    Integer.parseInt(ymdStrArr[1]),
                    Integer.parseInt(ymdStrArr[2]),
                    Integer.parseInt(timeStrArr[0]),
                    Integer.parseInt(timeStrArr[1])
            );

            if (rentalLog.containsKey(key)) {
                LocalDateTime rentalTime = rentalLog.remove(key);
                long minutes = Duration.between(rentalTime, currentTime).toMinutes();
                if (minutes > standardMinutes) {
                    long fee = (minutes - standardMinutes) * feePerMinute;
                    feeLog.put(name, feeLog.getOrDefault(name, 0L) + fee);
                }
            } else {
                rentalLog.put(key, currentTime);
            }
        }

        if (feeLog.isEmpty()) {
            System.out.println(-1);
        } else {
            for (Map.Entry<String, Long> entry : feeLog.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

    }
}
