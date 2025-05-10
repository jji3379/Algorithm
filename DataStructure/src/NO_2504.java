import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NO_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        char[] chars = input.toCharArray();

        int result = 0;
        int value = 1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
                value *= 2;
            } else if (chars[i] == '[') {
                stack.push(chars[i]);
                value *= 3;
            } else if (chars[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (chars[i - 1] == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if (chars[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (chars[i - 1] == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()) {
            sb.append(0).append("\n");
        } else {
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
