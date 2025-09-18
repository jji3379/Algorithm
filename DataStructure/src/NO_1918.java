import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NO_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char[] charArray = expression.toCharArray();

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            char value = charArray[i];
            // 1. 알파벳일 경우 결과에 넣기
            if (Character.isAlphabetic(value)) {
                sb.append(value);

            // 2. 알파벳이 아닐 경우 로직
            } else {
                // 2-1. 여는 괄호일 때 => stack 에 넣기
                if (value == '(') {
                    stack.push(value);

                // 2-2. 닫는 괄호일 때
                } else if (value == ')') {
                    // stack 에 값이 있고, 닫는 괄호가 나오기 전 까지
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        // 결과에 넣기
                        sb.append(stack.pop());
                    }

                    // stack 이 남아있다면 비워주기 ( 꺼내기
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                // 2-3. 연산자일 경우
                } else {
                    // stack 에 값이 있고, stack 에 있는 연산자가 배열의 연산자보다 우선순위가 높을 경우 => 결과에 넣는다.
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(value)) {
                        sb.append(stack.pop());
                    }

                    // 배열의 연산자를 stack 에 넣는다.
                    stack.push(value);
                }
            }
        }

        // 남은 stack 값을 결과에 넣어준다.
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb);
    }

    private static int priority(char value) {
        if (value == '*' || value == '/') {
            return 2;
        } else if (value == '+' || value == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}
