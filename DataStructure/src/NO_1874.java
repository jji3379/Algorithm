import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NO_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(br.readLine());

            for (int j = count; j <= n; j++) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == value) {
                        stack.pop();
                        sb.append("-").append("\n");
                        break;
                    } else {
                        stack.push(j);
                        sb.append("+").append("\n");
                        count++;
                    }
                } else {
                    stack.push(j);
                    sb.append("+").append("\n");
                    count++;
                }
            }

            if (count >= n && stack.peek() == value) {
                stack.pop();
                sb.append("-").append("\n");
            }
        }

        if (stack.isEmpty()) {
            System.out.print(sb);
        } else {
            System.out.print("NO");
        }

    }
}
