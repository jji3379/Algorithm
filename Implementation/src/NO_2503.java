import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] questions = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
            questions[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int num = 123; num <= 987; num++) {
            if (isValidNumber(num)) {
                boolean isPossible = true;

                for (int j = 0; j < n; j++) {
                    int questionNum =  questions[j][0];
                    int expectedStrike = questions[j][1];
                    int expectedBall = questions[j][2];

                    if (!isValidForQuestion(num, questionNum, expectedStrike, expectedBall)) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }


    static int[] convertNumberToArray(int n) {
        int[] arr = new int[3];

        int first = n / 100;
        int second = (n / 10) % 10;
        int third = n % 10;

        arr[0] = first;
        arr[1] = second;
        arr[2] = third;

        return arr;
    }

    static boolean isValidNumber(int n) {
        int[] numberToArray = convertNumberToArray(n);

        int first = numberToArray[0];
        int second = numberToArray[1];
        int third = numberToArray[2];

        return first >= 1 && first <= 9 &&
                second >= 1 && second <= 9 &&
                third >= 1 && third <= 9 &&
                first != second &&
                second != third &&
                first != third;
    }

    static boolean isValidForQuestion(int num, int questionNum, int expectedStrike, int expectedBall) {
        int[] numValueArr = convertNumberToArray(num);
        int[] questionValueArr = convertNumberToArray(questionNum);

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (numValueArr[i] == questionValueArr[i]) {
                strike++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && numValueArr[i] == questionValueArr[j]) {
                    ball++;
                }
            }
        }

        return strike == expectedStrike &&
                ball == expectedBall;
    }
}
